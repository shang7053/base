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
	private Logger logger=Logger.getLogger(SccLogImpl.class);
	public static Properties p = new Properties();
	private static boolean ISLOGERRORINFO;
	private static boolean DETAILLOG;
	private static String PATH;
	static {
		try {
			p.load(SccLogImpl.class.getClassLoader().getResourceAsStream("sjwslog.properties"));
			ISLOGERRORINFO = null == p.getProperty("IsLogErrorInfo") ? false : Boolean.valueOf(p.getProperty("IsLogErrorInfo"));
			DETAILLOG = null == p.getProperty("detailLog") ? false : Boolean.valueOf(p.getProperty("detailLog"));
			PATH = p.getProperty("LogPath");
		} catch (IOException e) {
			new SccLogImpl().autoDealException(e);
		}
	}

	/* (non-Javadoc)
	 * @see sjws.soa.log.ILog#autoDealException(java.lang.Exception)
	 */
	@Override
	public void autoDealException(Exception e) {
		if (ISLOGERRORINFO) {

			if (null == PATH)
				try {
					throw new LogException("日志文件目录未指定");
				} catch (LogException e1) {
					logger.error(e1);
				}
			try {
				writeLog(e, PATH);
			} catch (IOException e1) {
				logger.error(e1);
			}
		} else {

			logger.error(e);
		}
	}

	private void writeLog(Exception e, String path) throws IOException {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		File f = new File(path + "\\sjws_log_" + date + ".txt");
		File file=new File(PATH); 
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
		if (DETAILLOG) {
			if (null == PATH)
				try {
					throw new LogException("日志文件目录未指定");
				} catch (LogException e1) {
					logger.error(e1);
				}
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			File file=new File(PATH); 
			if (!file.exists()) {
				file.mkdirs();
	        }
			File f = new File(PATH + "\\sjws_log_" + date + ".txt");
			if (!f.exists())
				try {
					f.createNewFile();
				} catch (IOException e) {
					logger.error(e);
				}
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(f, true));
				bw.newLine();
				bw.append(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "=>  " + log);
				bw.flush();
			} catch (IOException e) {
				logger.error(e);
			} finally {
				if (null != bw)
					try {
						bw.close();
					} catch (IOException e) {
						logger.error(e);
					}
			}
		}
	}
}
