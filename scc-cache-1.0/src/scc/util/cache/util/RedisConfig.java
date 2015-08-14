package scc.util.cache.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * dom4j工具类
 * 
 * @author scc
 * 
 */
public class RedisConfig {
	private static final Logger LOGGER=Logger.getLogger(RedisConfig.class);
	private static Document document;
	static {
		try {
			SAXReader reader = new SAXReader();
			reader.setValidation(false);
			reader.setEntityResolver(new IgnoreDTDEntityResolver());
			document = reader.read(RedisConfig.class.getClassLoader().getResourceAsStream("redisconfig.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static RedisConfigVo getRegisters(){
		Element root = document.getRootElement();
		LOGGER.info("加载注册服务");
		@SuppressWarnings("unchecked")
		List<Element> redisConfigVos=root.elements("redis");
		RedisConfigVo rcv=new RedisConfigVo();
		for (Element redisConfigVo : redisConfigVos) {
			rcv.setMaxActive(getAttrValue(redisConfigVo, "MaxActive","value",Integer.class));
			rcv.setMaxIdle(getAttrValue(redisConfigVo, "MaxIdle","value",Integer.class));
			rcv.setMinIdle(getAttrValue(redisConfigVo, "MinIdle","value",Integer.class));
			rcv.setMaxWait(getAttrValue(redisConfigVo, "MaxWait","value",Integer.class));
			rcv.setTestOnBorrow(getAttrValue(redisConfigVo, "TestOnBorrow","value",Boolean.class));
			rcv.setTestWhileIdle(getAttrValue(redisConfigVo, "TestWhileIdle","value",Boolean.class));
			rcv.setKeepAliveTime(getAttrValue(redisConfigVo, "keepAliveTime","value",Integer.class));
			rcv.setCacheOn(getAttrValue(redisConfigVo, "isCacheOn","value",Boolean.class));
			rcv.setTestOnReturn(getAttrValue(redisConfigVo, "TestOnReturn","value",Boolean.class));
			List<Shared> sharedsList=new ArrayList<Shared>();
			@SuppressWarnings("unchecked")
			List<Element> shardses = redisConfigVo.elements("shardses");
			for (Element s : shardses) {
				@SuppressWarnings("unchecked")
				List<Element> ses = s.elements("shards");
				for (Element sharedElement : ses) {
					sharedsList.add(new Shared(getCurrentElementAttrValue(sharedElement,"ip",String.class),
							getCurrentElementAttrValue(sharedElement,"port",Integer.class), 
							getCurrentElementAttrValue(sharedElement,"timeOut",Integer.class)));
				}
			}
			rcv.setShareds(sharedsList);
			LOGGER.debug(rcv);
		}
		return rcv;
	}
	@SuppressWarnings("unchecked")
	private static <T> T getAttrValue(Element element, String tagName,String attrName,Class<T> t) {
		Element e=element.element(tagName);
		if(null==e)
			return null;
		String value=e.attributeValue(attrName);
		if(null==value||"".endsWith(value))
			return null;
		if(t.isAssignableFrom(String.class)){
			return (T) String.valueOf(value);
		}else if(t.isAssignableFrom(Integer.class)){
			return (T) Integer.valueOf(value);
		}else if(t.isAssignableFrom(Boolean.class)){
			return (T) Boolean.valueOf(value);
		}else{
			return (T) value;
		}
	}
	@SuppressWarnings("unchecked")
	private static <T> T getCurrentElementAttrValue(Element currentElement,String attrName,Class<T> t){
		if(null==currentElement||(null==attrName||"".endsWith(attrName)))
			return null;
		String value= currentElement.attributeValue(attrName);
		if(t.isAssignableFrom(String.class)){
			return (T) String.valueOf(value);
		}else if(t.isAssignableFrom(Integer.class)){
			return (T) Integer.valueOf(value);
		}else if(t.isAssignableFrom(Boolean.class)){
			return (T) Boolean.valueOf(value);
		}else{
			return (T) value;
		}
	}
	public static void main(String[] args) {
		RedisConfig.getRegisters();
	}
}
