package com.voole.trdpay.util.httputil;

/**
 * @ClassName: RestMediaType
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年9月21日 下午3:49:49
 * 
 */
public enum RestMediaType {
	/**
	 * The media type {@code charset} parameter name.
	 */
	charset {
		@Override
		public String getMediaType() {
			return "charset";
		}
	},
	/**
	 * The value of a type or subtype wildcard {@value #MEDIA_TYPE_WILDCARD}.
	 */
	MEDIA_TYPE_WILDCARD {
		@Override
		public String getMediaType() {
			return "*";
		}
	},
	// Common media type constants
	/**
	 * A {@code String} constant representing wildcard {@value #WILDCARD} media type .
	 */
	WILDCARD {
		@Override
		public String getMediaType() {
			return "*/*";
		}
	},
	/**
	 * A {@code String} constant representing {@value #APPLICATION_XML} media type.
	 */
	APPLICATION_XML {
		@Override
		public String getMediaType() {
			return "application/xml";
		}
	},
	/**
	 * A {@code String} constant representing {@value #APPLICATION_ATOM_XML} media type.
	 */
	APPLICATION_ATOM_XML {
		@Override
		public String getMediaType() {
			return "application/atom+xml";
		}
	},
	/**
	 * A {@code String} constant representing {@value #APPLICATION_XHTML_XML} media type.
	 */
	APPLICATION_XHTML_XML {
		@Override
		public String getMediaType() {
			return "application/xhtml+xml";
		}
	},
	/**
	 * A {@code String} constant representing {@value #APPLICATION_SVG_XML} media type.
	 */
	APPLICATION_SVG_XML {
		@Override
		public String getMediaType() {
			return "application/svg+xml";
		}
	},
	/**
	 * A {@code String} constant representing {@value #APPLICATION_JSON} media type.
	 */
	APPLICATION_JSON {
		@Override
		public String getMediaType() {
			return "application/json";
		}
	},
	/**
	 * A {@code String} constant representing {@value #APPLICATION_FORM_URLENCODED} media type.
	 */
	APPLICATION_FORM_URLENCODED {
		@Override
		public String getMediaType() {
			return "application/x-www-form-urlencoded";
		}
	},
	/**
	 * A {@code String} constant representing {@value #MULTIPART_FORM_DATA} media type.
	 */
	MULTIPART_FORM_DATA {
		@Override
		public String getMediaType() {
			return "multipart/form-data";
		}
	},
	/**
	 * A {@code String} constant representing {@value #APPLICATION_OCTET_STREAM} media type.
	 */
	APPLICATION_OCTET_STREAM {
		@Override
		public String getMediaType() {
			return "application/octet-stream";
		}
	},
	/**
	 * A {@code String} constant representing {@value #TEXT_PLAIN} media type.
	 */
	TEXT_PLAIN {
		@Override
		public String getMediaType() {
			return "text/plain";
		}
	},
	/**
	 * A {@code String} constant representing {@value #TEXT_XML} media type.
	 */
	TEXT_XML {
		@Override
		public String getMediaType() {
			return "text/xml";
		}
	},
	/**
	 * A {@code String} constant representing {@value #TEXT_HTML} media type.
	 */
	TEXT_HTML {
		@Override
		public String getMediaType() {
			return "text/html";
		}
	};
	public abstract String getMediaType();

	public static void main(String[] args) {
		System.out.println(RestMediaType.APPLICATION_JSON.getMediaType());
	}
}
