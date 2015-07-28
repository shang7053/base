package scc.util.propeties.center;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import scc.util.propeties.service.IProperties;

public class PropertiesImpl implements IProperties{
	private static Properties props = new Properties();
	private static Logger logger=Logger.getLogger(PropertiesImpl.class);
	
	private boolean load(String fileName){
		try {
			props.load(PropertiesImpl.class.getClassLoader().getResourceAsStream(fileName));
		} catch (IOException e) {
			logger.error(e);
			return false;
		}
		return true;
	}
	/* (非 Javadoc) 
	 * <p>Title: readValue</p> 
	 * <p>Description: </p> 
	 * @param fileName
	 * @param key
	 * @return 
	 * @see scc.util.propeties.IProperties#readValue(java.lang.String, java.lang.String) 
	*/
	@Override
	public String readValue(String fileName, String key) {
		if(isFileExist(fileName)){
			return props.getProperty(key);
		}
		return null;
	}
	/* (非 Javadoc) 
	 * <p>Title: writeProperties</p> 
	 * <p>Description: </p> 
	 * @param fileName
	 * @param parameterName
	 * @param parameterValue 
	 * @see scc.util.propeties.IProperties#writeProperties(java.lang.String, java.lang.String, java.lang.String) 
	*/
	@Override
	public void writeProperties(String fileName, String parameterName, String parameterValue) {
		if(isFileExist(fileName)){
			OutputStream fos=null;
			try {
				fos = new FileOutputStream(PropertiesImpl.class.getResource("/").getPath()+fileName);
				props.setProperty(parameterName, parameterValue);
				props.store(fos,"");
			} catch (IOException e) {
				logger.error(e);
			}finally{
				if(null!=fos){
					try {
						fos.close();
					} catch (IOException e) {
						logger.error(e);
					}
				}
			}
		}
	}
	/* (非 Javadoc) 
	 * <p>Title: isFileExist</p> 
	 * <p>Description: </p> 
	 * @param fileName
	 * @return 
	 * @see scc.util.propeties.IProperties#isFileExist(java.lang.String) 
	*/
	@Override
	public boolean isFileExist(String fileName){
		return load(fileName);
	}
	/* (非 Javadoc) 
	 * <p>Title: isPrepertiesExist</p> 
	 * <p>Description: </p> 
	 * @param fileName
	 * @param key
	 * @return 
	 * @see scc.util.propeties.IProperties#isPrepertiesExist(java.lang.String, java.lang.String) 
	*/
	@Override
	public boolean isPrepertiesExist(String fileName,String key){
		if(isFileExist(fileName)){
			return null==props.get(key)?false:true;
		}
		return false;
	}
	@Override
	public Properties getProperties(String fileName) {
		if(isFileExist(fileName)){
			return props;
		}
		return new Properties();
	}
}
