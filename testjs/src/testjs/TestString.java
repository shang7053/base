package testjs;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class TestString {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str="%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CCDO%3E%3CSTRF+N%3D%22strServiceName%22+V%3D%22easy_loan_CustomerService%22%2F%3E%3CSTRF+N%3D%22strTransName%22+V%3D%22getTableData%22%2F%3E%3CSTRF+N%3D%22ctel%22+V%3D%2213343285888%22%2F%3E%3CSTRF+N%3D%22ccardType%22+V%3D%2201%22%2F%3E%3CSTRF+N%3D%22cname%22+V%3D%22%E5%BE%90%E7%A7%80%E6%A2%85%22%2F%3E%3CSTRF+N%3D%22%24strRoutePath%24%22+V%3D%22SupCCCenter%22%2F%3E%3C%2FCDO%3E HTTP/1.1[\r][\n]";
		System.out.println(URLDecoder.decode(str,"utf-8"));
	}
	 public static String hexString2binaryString(String hexString)  
	    {  
	        if (hexString == null || hexString.length() % 2 != 0)  
	            return null;  
	        String bString = "", tmp;  
	        for (int i = 0; i < hexString.length(); i++)  
	        {  
	            tmp = "0000"  
	                    + Integer.toBinaryString(Integer.parseInt(hexString  
	                            .substring(i, i + 1), 16));  
	            bString += tmp.substring(tmp.length() - 4);  
	        }  
	        return bString;  
	    }  
}
