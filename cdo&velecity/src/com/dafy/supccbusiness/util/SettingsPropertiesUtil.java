package com.dafy.supccbusiness.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.dafy.supccbusiness.web.listener.CDOListerner;
/**
 * Settings文件工具类
 * @author scc
 *
 */
public class SettingsPropertiesUtil {
	private static Logger logger=Logger.getLogger(SettingsPropertiesUtil.class);
	private static Properties p=new Properties();
	static{
		try {
			logger.info("加载配置文件settings.properties");
			InputStream is=CDOListerner.class.getClassLoader().getResourceAsStream("config/settings.properties");
			if(null!=is){
				p.load(is);
			}else{
				logger.error("src下的config文件夹内未找到settings.properties");
			}
		} catch (IOException e) {
			logger.error("配置文件加载失败", e);
			e.printStackTrace();
		}
	}
	public static String getProperties(String key){
		logger.info("加载配置文件settings.properties中的属性："+key+",值："+p.get(key));
		if(null!=p.get(key))
			return (String) p.get(key);
		return null;
	}
}
