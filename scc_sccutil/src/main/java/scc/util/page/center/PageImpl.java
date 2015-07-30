package scc.util.page.center;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import scc.util.page.service.Ipage;

public class PageImpl implements Ipage{

	@Override
	public void writeHtml(String filePath, String info, boolean isFlush) {
		PrintWriter pw = null;  
		try {
            File writeFile = new File(filePath);  
            boolean isExit = writeFile.exists();  
            if (!isExit) {  
					writeFile.createNewFile();
            } else {  
                if (isFlush) {  
                    writeFile.delete();  
                    writeFile.createNewFile();  
                }  
            }  
            pw = new PrintWriter(new FileOutputStream(filePath, true));  
            pw.println(info);  
		} catch (IOException e) {
			e.printStackTrace();
		}finally{  
			if (pw!=null) {
				pw.close();  
			}
        }   
	}
	public String readHtmlFromFlie(String filePath,String charsetName) {
		try {
			return readHtmlFromFlie(new FileInputStream(new File(filePath)),charsetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}
	public String readHtmlFromFlie(InputStream is,String charsetName) {
		StringBuffer htmlCode = new StringBuffer();  
		BufferedReader breader = null;
		try {
			breader = new BufferedReader(new InputStreamReader(is , charsetName));
			String currentLine;  
            while((currentLine=breader.readLine())!=null){  
                htmlCode.append(currentLine);  
            }
		} catch (IOException e) {
			e.printStackTrace();
		}finally{ 
			if(null!=breader)
				try {
					breader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	if(null!=is)
	        	try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	
        }  
		return htmlCode.toString();
	}
	public static void main(String[] args) {
//		System.out.println(new PageImpl().getHtmlCode("http://127.0.0.1:8080/sjws_soa_product/bulidingpandect/CdeBuildingInfoController/toBulidingpandect.do", "UTF8", "JSESSIONID=E5B4DECBA8B5BF59B98AE967E51A9B3D"));
	}
	@Override
	public String getHtmlCode(String httpUrl,String charsetName,String cookie) {
		StringBuffer htmlCode = new StringBuffer();  
		InputStream in = null;  
		BufferedReader breader=null;
        try {  
            URL url = new java.net.URL(httpUrl);  
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();  
            connection = (HttpURLConnection) url.openConnection();  
            connection.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");  
            connection.setRequestProperty("Accept-Encoding","gzip, deflate, sdch");  
            connection.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8");  
            connection.setRequestProperty("Connection","Connection");  
            connection.setRequestProperty("Cookie",cookie);  
            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.101 Safari/537.36");  
            connection.connect();  
            in = connection.getInputStream();  
            breader = new BufferedReader(new InputStreamReader(in , charsetName));  
            String currentLine;  
            while((currentLine=breader.readLine())!=null){  
                htmlCode.append(currentLine);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{ 
        	if(null!=breader)
				try {
					breader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	if(null!=in)
	        	try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	
        }  
        return htmlCode.toString(); 
	}

}
