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
//		System.out.println(cache.getCacheData("aaa"));
	}

	private final static class CacheImpl implements ICache {

		private static final Logger LOGGER = Logger.getLogger(CacheImpl.class);
		// private static Map<String, CacheData> datas = new Hashtable<String,
		// CacheData>();
		private static final ConcurrentHashMap<String, CacheData> DATAS = new ConcurrentHashMap<String, CacheData>();
		private static final Integer SETTIME;// 缓存时间
		private static boolean isStartCache;// 是否开启缓存
		private static boolean isStartTimer;// 是否开始定时器
		private static final Integer DELAY;// 定时器延迟启动时间
		private static final Integer PERIOD;// 定时器启动间隔

		static {
			LOGGER.info("初始化缓存器");
			String temp = Dom4jUtil.getAttribute("data", "time");
			SETTIME = ("").equals(temp) ? 0 : Integer.valueOf(temp);
			LOGGER.debug("设置缓存时长" + SETTIME);
			isStartCache = ("").equals(temp) || ("0").equals(temp) ? false
					: true;
			LOGGER.debug("是否启动缓存器" + isStartCache);
			String delaystr = Dom4jUtil.getAttribute("clearOverdueCacheTimer",
					"delay");
			LOGGER.debug("设置缓存器垃圾清理器启动延迟" + delaystr);
			String periodstr = Dom4jUtil.getAttribute("clearOverdueCacheTimer",
					"period");
			LOGGER.debug("设置缓存器垃圾清理器任务间隔" + periodstr);
			if (null != periodstr && !"".equals(periodstr.trim())) {
				DELAY = null == delaystr ? 0 : Integer.valueOf(delaystr);
				PERIOD = Integer.valueOf(periodstr.trim());
				isStartTimer = true;
			} else {
				isStartTimer = false;
				DELAY = 0;
				PERIOD = 12;
			}
			LOGGER.info("初始化缓存器完毕，是否开启缓存：" + isStartCache + "是否启动垃圾清理器"
					+ isStartTimer + "垃圾清理其启动延迟" + DELAY + "，任务间隔" + PERIOD);
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
			LOGGER.info("当前缓存数量"+DATAS.size()+"添加缓存，loadDate" + loadDate.toLocaleString() + "参数"
					+ queryArgs + "数据" + data);
			if (isStartCache && validateArgs(loadDate, queryArgs, data)) {
				DATAS.putIfAbsent(queryArgs, new CacheData(loadDate, data));
			}
		}

		@Override
		public void addOrUpdate(String queryArgs, CacheData data) {
			addOrUpdate(data.getLoadDate(), queryArgs, data.getData());
		}

		@SuppressWarnings("deprecation")
		@Override
		public void updateCacheData(Date loadDate, String queryArgs, Object data) {
			LOGGER.info("当前缓存数量"+DATAS.size()+"修改缓存，loadDate" + loadDate.toLocaleString() + "参数"
					+ queryArgs + "数据" + data);
			if (isStartCache && validateArgs(loadDate, queryArgs, data)) {
				DATAS.put(queryArgs, new CacheData(loadDate, data));
			}
		}

		@Override
		public void updateCacheData(String queryArgs, CacheData data) {
			updateCacheData(data.getLoadDate(), queryArgs, data.getData());
		}

		@Override
		public Object getCacheData(String queryArgs) {
			LOGGER.info("当前缓存数量"+DATAS.size()+"获取缓存，参数" + queryArgs);
			if (isStartCache) {
				return DATAS.get(queryArgs) == null ? null : DATAS.get(
						queryArgs).getData();
			}
			return null;
		}

		@Override
		@Deprecated
		public boolean hasCacheData(String queryArgs) {
			LOGGER.info("当前缓存数量"+DATAS.size()+"验证是否包换缓存，参数" + queryArgs);
			if (isStartCache) {
				CacheData cacheData = DATAS.get(queryArgs);
				if (null != cacheData) {
					Date loadDate = cacheData.getLoadDate();
					long time = (new Date().getTime() - loadDate.getTime());
					if (time > Long.valueOf(SETTIME)) {
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
			LOGGER.debug("垃圾清理器启动");
			ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
			ses.scheduleAtFixedRate(new Runnable() {

				@Override
				public void run() {
					LOGGER.debug("垃圾清理器开始清理");
					clearOverdueCache();
					LOGGER.debug("垃圾清理器结束清理");
				}
			}, DELAY, PERIOD, TimeUnit.HOURS);
			LOGGER.debug("垃圾清理器结束");
		}

		@Override
		public void clearOverdueCache() {
			LOGGER.info(Thread.currentThread().getName() + "正在收集缓存脏数据");
			List<String> temp = new ArrayList<String>();
			for (Entry<String, CacheData> cachedata : DATAS.entrySet()) {
				long time = new Date().getTime()
						- cachedata.getValue().getLoadDate().getTime();
				if (time > Long.valueOf(SETTIME)) {
					temp.add(cachedata.getKey());
				}
			}
			LOGGER.debug(Thread.currentThread().getName() + "收集缓存脏数据完毕，收集到"
					+ temp.size() + "条数据:"
					+ Arrays.toString(temp.toArray(new String[temp.size()]))
					+ "");
			for (String s : temp) {
				LOGGER.debug(Thread.currentThread().getName() + "开始清除：" + s);
				DATAS.remove(s);
				LOGGER.debug(Thread.currentThread().getName() + "清除" + s
						+ "完毕！");
			}
		}
	}
}
