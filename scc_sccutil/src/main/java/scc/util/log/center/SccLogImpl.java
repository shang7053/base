package scc.util.log.center;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

import scc.util.log.exception.LogException;
import scc.util.log.service.ILog;

/**
 * 
 * @author scc
 * 
 */
public class SccLogImpl implements ILog {
	private static final Logger LOGGER=Logger.getLogger(SccLogImpl.class);
	public static Properties p = new Properties();
	private static boolean iSLOGERRORINFO;
	private static boolean dETAILLOG;
	private static String pATH;
	static {
		try {
			p.load(SccLogImpl.class.getClassLoader().getResourceAsStream("sjwslog.properties"));
			iSLOGERRORINFO = null == p.getProperty("IsLogErrorInfo") ? false : Boolean.valueOf(p.getProperty("IsLogErrorInfo"));
			dETAILLOG = null == p.getProperty("detailLog") ? false : Boolean.valueOf(p.getProperty("detailLog"));
			pATH = p.getProperty("LogPath");
		} catch (IOException e) {
			new SccLogImpl().autoDealException(e);
		}
	}

	/* (non-Javadoc)
	 * @see sjws.soa.log.ILog#autoDealException(java.lang.Exception)
	 */
	@Override
	public void autoDealException(Exception e) {
		if (iSLOGERRORINFO) {

			if (null == pATH)
				try {
					throw new LogException("日志文件目录未指定");
				} catch (LogException e1) {
					LOGGER.error(e1);
				}
			try {
				writeLog(e, pATH);
			} catch (IOException e1) {
				LOGGER.error(e1);
			}
		} else {

			LOGGER.error(e);
		}
	}

	private void writeLog(Exception e, String path) throws IOException {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		File f = new File(path + "\\sjws_log_" + date + ".txt");
		File file=new File(pATH); 
		if (!file.exists()) {
			file.mkdirs();
        }
		if (!f.exists())
			f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
		bw.newLine();
		bw.append(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "=>  " + e.toString());
		StackTraceElement[] element = e.getStackTrace();
		for (StackTraceElement ste : element) {
			bw.newLine();
			bw.append("\t\t\t\t\t\t\t\t\t\t\t\t\tat " + ste.toString());
		}
		bw.flush();
		bw.close();
	}

	/* (non-Javadoc)
	 * @see sjws.soa.log.ILog#autoWritelog(java.lang.String)
	 */
	@Override
	public void autoWritelog(String log) {
		if (dETAILLOG) {
			if (null == pATH)
				try {
					throw new LogException("日志文件目录未指定");
				} catch (LogException e1) {
					LOGGER.error(e1);
				}
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			File file=new File(pATH); 
			if (!file.exists()) {
				file.mkdirs();
	        }
			File f = new File(pATH + "\\sjws_log_" + date + ".txt");
			if (!f.exists())
				try {
					f.createNewFile();
				} catch (IOException e) {
					LOGGER.error(e);
				}
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(f, true));
				bw.newLine();
				bw.append(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "=>  " + log);
				bw.flush();
			} catch (IOException e) {
				LOGGER.error(e);
			} finally {
				if (null != bw)
					try {
						bw.close();
					} catch (IOException e) {
						LOGGER.error(e);
					}
			}
		}
	}
}
