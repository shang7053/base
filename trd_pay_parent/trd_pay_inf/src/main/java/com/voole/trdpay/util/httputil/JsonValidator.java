package com.voole.trdpay.util.httputil;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * @ClassName: JsonValidator
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年8月30日 下午3:14:04
 * 
 */
public class JsonValidator {
	private CharacterIterator it;
	private char c;
	private int col;

	public JsonValidator() {
	}

	/**
	 * 验证一个字符串是否是合法的JSON串
	 *
	 * @param input 要验证的字符串
	 * @return true-合法 ，false-非法
	 */
	public boolean validate(String input) {
		String input2 = input.trim();
		boolean ret = this.valid(input2);
		return ret;
	}

	private boolean valid(String input) {
		if ("".equals(input)) {
			return true;
		}

		boolean ret = true;
		this.it = new StringCharacterIterator(input);
		this.c = this.it.first();
		this.col = 1;
		if (!this.value()) {
			ret = this.error("value", 1);
		} else {
			this.skipWhiteSpace();
			if (this.c != CharacterIterator.DONE) {
				ret = this.error("end", this.col);
			}
		}

		return ret;
	}

	private boolean value() {
		return this.literal("true") || this.literal("false") || this.literal("null") || this.string() || this.number()
				|| this.object() || this.array();
	}

	private boolean literal(String text) {
		CharacterIterator ci = new StringCharacterIterator(text);
		char t = ci.first();
		if (this.c != t) {
			return false;
		}

		int start = this.col;
		boolean ret = true;
		for (t = ci.next(); t != CharacterIterator.DONE; t = ci.next()) {
			if (t != this.nextCharacter()) {
				ret = false;
				break;
			}
		}
		this.nextCharacter();
		if (!ret) {
			this.error("literal " + text, start);
		}
		return ret;
	}

	private boolean array() {
		return this.aggregate('[', ']', false);
	}

	private boolean object() {
		return this.aggregate('{', '}', true);
	}

	private boolean aggregate(char entryCharacter, char exitCharacter, boolean prefix) {
		if (this.c != entryCharacter) {
			return false;
		}
		this.nextCharacter();
		this.skipWhiteSpace();
		if (this.c == exitCharacter) {
			this.nextCharacter();
			return true;
		}

		for (;;) {
			if (prefix) {
				int start = this.col;
				if (!this.string()) {
					return this.error("string", start);
				}
				this.skipWhiteSpace();
				if (this.c != ':') {
					return this.error("colon", this.col);
				}
				this.nextCharacter();
				this.skipWhiteSpace();
			}
			if (this.value()) {
				this.skipWhiteSpace();
				if (this.c == ',') {
					this.nextCharacter();
				} else if (this.c == exitCharacter) {
					break;
				} else {
					return this.error("comma or " + exitCharacter, this.col);
				}
			} else {
				return this.error("value", this.col);
			}
			this.skipWhiteSpace();
		}

		this.nextCharacter();
		return true;
	}

	private boolean number() {
		if (!Character.isDigit(this.c) && this.c != '-') {
			return false;
		}
		int start = this.col;
		if (this.c == '-') {
			this.nextCharacter();
		}
		if (this.c == '0') {
			this.nextCharacter();
		} else if (Character.isDigit(this.c)) {
			while (Character.isDigit(this.c)) {
				this.nextCharacter();
			}
		} else {
			return this.error("number", start);
		}
		if (this.c == '.') {
			this.nextCharacter();
			if (Character.isDigit(this.c)) {
				while (Character.isDigit(this.c)) {
					this.nextCharacter();
				}
			} else {
				return this.error("number", start);
			}
		}
		if (this.c == 'e' || this.c == 'E') {
			this.nextCharacter();
			if (this.c == '+' || this.c == '-') {
				this.nextCharacter();
			}
			if (Character.isDigit(this.c)) {
				while (Character.isDigit(this.c)) {
					this.nextCharacter();
				}
			} else {
				return this.error("number", start);
			}
		}
		return true;
	}

	private boolean string() {
		if (this.c != '"') {
			return false;
		}

		int start = this.col;
		boolean escaped = false;
		for (this.nextCharacter(); this.c != CharacterIterator.DONE; this.nextCharacter()) {
			if (!escaped && this.c == '\\') {
				escaped = true;
			} else if (escaped) {
				if (!this.escape()) {
					return false;
				}
				escaped = false;
			} else if (this.c == '"') {
				this.nextCharacter();
				return true;
			}
		}
		return this.error("quoted string", start);
	}

	private boolean escape() {
		int start = this.col - 1;
		if (" \\\"/bfnrtu".indexOf(this.c) < 0) {
			return this.error("escape sequence  \\\",\\\\,\\/,\\b,\\f,\\n,\\r,\\t  or  \\uxxxx ", start);
		}
		if (this.c == 'u') {
			if (!this.ishex(this.nextCharacter()) || !this.ishex(this.nextCharacter())
					|| !this.ishex(this.nextCharacter()) || !this.ishex(this.nextCharacter())) {
				return this.error("unicode escape sequence  \\uxxxx ", start);
			}
		}
		return true;
	}

	private boolean ishex(char d) {
		return "0123456789abcdefABCDEF".indexOf(d) >= 0;
	}

	private char nextCharacter() {
		this.c = this.it.next();
		++this.col;
		return this.c;
	}

	private void skipWhiteSpace() {
		while (Character.isWhitespace(this.c)) {
			this.nextCharacter();
		}
	}

	private boolean error(String type, int col1) {
		System.out.println(type + col1 * 2);
		return false;
	}

	public static void main(String[] args) {
		String[] strings = new String[2];
		strings[0] = "{\"website\":\"oschina.net\"}";
		strings[1] = "{\"website\"::\"oschina.net\"}";
		for (int i = 0; i < 100; i++) {
			System.out.println((i % 2) + ":" + new JsonValidator().validate(strings[i % 2]));
		}
	}
}
