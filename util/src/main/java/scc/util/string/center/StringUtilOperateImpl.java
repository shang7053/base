package scc.util.string.center;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import scc.util.string.service.IString;

/**
 * 
 * @ClassName: StringUtilOperateImpl
 * @Description: 字符串常用操作接口实现类
 * @author scc
 * @date 2014年11月17日 上午11:32:00
 *
 */
public class StringUtilOperateImpl implements IString {
	private static final Logger LOGGER = Logger.getLogger(StringUtilOperateImpl.class);

	@Override
	public boolean isNull(String str) {
		return null == str;
	}

	@Override
	public boolean emptyString(String str) {
		return null == str || "".equals(str) ? true : false;
	}

	@Override
	public boolean isNullOrEmpty(String str) {
		return null == str || "".equals(str) ? true : false;
	}

	@Override
	public Integer toInt(String str) {
		return isNull(str) ? null : Integer.valueOf(str);
	}

	@Override
	public Long toLong(String str) {
		return isNull(str) ? null : Long.valueOf(str);
	}

	@Override
	public Short toShort(String str) {
		return isNull(str) ? null : Short.valueOf(str);
	}

	@Override
	public Byte toByte(String str) {
		return isNull(str) ? null : Byte.valueOf(str);
	}

	@Override
	public Double toDouble(String str) {
		return isNull(str) ? null : Double.valueOf(str);
	}

	@Override
	public Float toFloat(String str) {
		return isNull(str) ? null : Float.valueOf(str);
	}

	@Override
	public Character toChar(String str) {
		return isNull(str) || "".equals(str) ? null : Character.valueOf(str.toCharArray()[0]);
	}

	@Override
	public Boolean toBoolean(String str) {
		return isNull(str) ? null : Boolean.valueOf(str);
	}

	@Override
	public BigDecimal toBigDecimal(String str) {
		return isNull(str) ? null : new BigDecimal(str);
	}

	@Override
	public String toUpperCaseFirst(String str) {
		char c = str.toCharArray()[0];
		if (c >= 'a' && c <= 'z') {
			c -= 32;
			return c + str.substring(1, str.length());
		} else {
			return str;
		}
	}

	@Override
	public String toLowerCaseFirst(String str) {
		char c = str.toCharArray()[0];
		if (c >= 'A' && c <= 'Z') {
			c += 32;
			return c + str.substring(1, str.length());
		} else {
			return str;
		}
	}

	@Override
	public Date toDate(String date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public String toDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	@Override
	public String simpleEncryption(String str) {
		try {
			byte[] _ssoToken = str.getBytes("UTF-8");
			String name=null;
			for (int i = 0; i < _ssoToken.length; i++) {
				int asc = _ssoToken[i];
				_ssoToken[i] = (byte) (asc + 27);
				name = name + (asc + 27) + "%";
			}
			return name;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public String simpleDecryption(String str) {
		try {
			String name = null;
			java.util.StringTokenizer st = new java.util.StringTokenizer(str, "%");
			while (st.hasMoreElements()) {
				int asc = Integer.parseInt((String) st.nextElement()) - 27;
				name = name + (char) asc;
			}
			return name;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public Map<String, String> getParameterFromUri(URI requestURI) {
		Map<String, String> result = new HashMap<String, String>();
		String requestURIString = requestURI.toString();
		if (!requestURIString.contains("?"))
			return result;
		String paratotal = requestURIString.split("\\?")[1];
		String[] parameteritems = paratotal.split("&");
		for (String p : parameteritems) {
			String[] pi = p.split("=");
			try {
				result.put(pi[0], URLDecoder.decode(pi[1],"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e);
			}
		}
		return result;
	}
	@Override
	public String toStringHex(String hexString) {
		byte[] baKeyword = new byte[hexString.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(hexString.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			hexString = new String(baKeyword, "utf-8");// UTF-16le:Not
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return hexString;
	}
}
