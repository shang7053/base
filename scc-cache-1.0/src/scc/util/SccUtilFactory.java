package scc.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import scc.util.cache.ICache;
import scc.util.cache.data.CacheData;
import scc.util.cache.util.Dom4jUtil;

/**
 * 
 * @ClassName: SccStringUtilFactory
 * @Description:
 * @author scc
 * @date 2014年11月17日 上午11:31:07
 * 
 */
public class SccUtilFactory {
	/**
	 * 构建缓存对象
	 * 
	 * @return 缓存对象
	 */
	public static ICache instanceCache() {
		return new CacheImpl();
	}

	public static void main(String[] args) throws IOException {
		ICache cache=SccUtilFactory.instanceCache();
		cache.addCacheData("aaa", new CacheData("bbb"));
		System.out.println(cache.getCacheData("aaa"));
	}

	private final static class CacheImpl implements ICache {

		private static Logger logger = Logger.getLogger(CacheImpl.class);
		// private static Map<String, CacheData> datas = new Hashtable<String,
		// CacheData>();
		private static final ConcurrentHashMap<String, CacheData> datas = new ConcurrentHashMap<String, CacheData>();
		private static final Integer setTime;// 缓存时间
		private static boolean isStartCache;// 是否开启缓存
		private static boolean isStartTimer;// 是否开始定时器
		private static final Integer delay;// 定时器延迟启动时间
		private static final Integer period;// 定时器启动间隔

		static {
			logger.info("初始化缓存器");
			String temp = Dom4jUtil.getAttribute("data", "time");
			setTime = ("").equals(temp) ? 0 : Integer.valueOf(temp);
			logger.debug("设置缓存时长" + setTime);
			isStartCache = ("").equals(temp) || ("0").equals(temp) ? false
					: true;
			logger.debug("是否启动缓存器" + isStartCache);
			String delaystr = Dom4jUtil.getAttribute("clearOverdueCacheTimer",
					"delay");
			logger.debug("设置缓存器垃圾清理器启动延迟" + delaystr);
			String periodstr = Dom4jUtil.getAttribute("clearOverdueCacheTimer",
					"period");
			logger.debug("设置缓存器垃圾清理器任务间隔" + periodstr);
			if (null != periodstr && !"".equals(periodstr.trim())) {
				delay = null == delaystr ? 0 : Integer.valueOf(delaystr);
				period = Integer.valueOf(periodstr.trim());
				isStartTimer = true;
			} else {
				isStartTimer = false;
				delay = 0;
				period = 12;
			}
			logger.info("初始化缓存器完毕，是否开启缓存：" + isStartCache + "是否启动垃圾清理器"
					+ isStartTimer + "垃圾清理其启动延迟" + delay + "，任务间隔" + period);
		}

		public CacheImpl() {
			if (isStartTimer) {
				isStartTimer = false;
				startTimer();
			}
		}

		@Override
		public void addCacheData(Date loadDate, String queryArgs, Object data) {
			addOrUpdate(loadDate, queryArgs, data);
		}

		@Override
		public void addCacheData(String queryArgs, CacheData data) {
			addOrUpdate(data.getLoadDate(), queryArgs, data.getData());
		}

		@SuppressWarnings("deprecation")
		@Override
		public void addOrUpdate(Date loadDate, String queryArgs, Object data) {
			logger.info("当前缓存数量"+datas.size()+"添加缓存，loadDate" + loadDate.toLocaleString() + "参数"
					+ queryArgs + "数据" + data);
			if (isStartCache && validateArgs(loadDate, queryArgs, data)) {
				datas.putIfAbsent(queryArgs, new CacheData(loadDate, data));
			}
		}

		@Override
		public void addOrUpdate(String queryArgs, CacheData data) {
			addOrUpdate(data.getLoadDate(), queryArgs, data.getData());
		}

		@SuppressWarnings("deprecation")
		@Override
		public void updateCacheData(Date loadDate, String queryArgs, Object data) {
			logger.info("当前缓存数量"+datas.size()+"修改缓存，loadDate" + loadDate.toLocaleString() + "参数"
					+ queryArgs + "数据" + data);
			if (isStartCache && validateArgs(loadDate, queryArgs, data)) {
				datas.put(queryArgs, new CacheData(loadDate, data));
			}
		}

		@Override
		public void updateCacheData(String queryArgs, CacheData data) {
			updateCacheData(data.getLoadDate(), queryArgs, data.getData());
		}

		@Override
		public Object getCacheData(String queryArgs) {
			logger.info("当前缓存数量"+datas.size()+"获取缓存，参数" + queryArgs);
			if (isStartCache) {
				return datas.get(queryArgs) == null ? null : datas.get(
						queryArgs).getData();
			}
			return null;
		}

		@Override
		@Deprecated
		public boolean hasCacheData(String queryArgs) {
			logger.info("当前缓存数量"+datas.size()+"验证是否包换缓存，参数" + queryArgs);
			if (isStartCache) {
				CacheData cacheData = datas.get(queryArgs);
				if (null != cacheData) {
					Date loadDate = cacheData.getLoadDate();
					long time = (new Date().getTime() - loadDate.getTime());
					if (time > Long.valueOf(setTime)) {
						return false;
					}
					return true;
				}
			}
			return false;
		}

		/**
		 * 验证参数
		 * 
		 * @param loadDate
		 *            加载时间
		 * @param queryArgs
		 *            查询参数
		 * @param data
		 *            缓存数据对
		 */
		protected boolean validateArgs(Date loadDate, String queryArgs,
				Object data) {
			if (null == loadDate)
				return false;
			if (null == queryArgs || "".equals(queryArgs))
				return false;
			if (null == data)
				return false;
			return true;
		}

		private void startTimer() {
			logger.debug("垃圾清理器启动");
			ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
			ses.scheduleAtFixedRate(new Runnable() {

				@Override
				public void run() {
					logger.debug("垃圾清理器开始清理");
					clearOverdueCache();
					logger.debug("垃圾清理器结束清理");
				}
			}, delay, period, TimeUnit.HOURS);
			logger.debug("垃圾清理器结束");
		}

		@Override
		public void clearOverdueCache() {
			logger.info(Thread.currentThread().getName() + "正在收集缓存脏数据");
			List<String> temp = new ArrayList<String>();
			for (Entry<String, CacheData> cachedata : datas.entrySet()) {
				long time = new Date().getTime()
						- cachedata.getValue().getLoadDate().getTime();
				if (time > Long.valueOf(setTime)) {
					temp.add(cachedata.getKey());
				}
			}
			logger.debug(Thread.currentThread().getName() + "收集缓存脏数据完毕，收集到"
					+ temp.size() + "条数据:"
					+ Arrays.toString(temp.toArray(new String[temp.size()]))
					+ "");
			for (String s : temp) {
				logger.debug(Thread.currentThread().getName() + "开始清除：" + s);
				datas.remove(s);
				logger.debug(Thread.currentThread().getName() + "清除" + s
						+ "完毕！");
			}
		}
	}
}
