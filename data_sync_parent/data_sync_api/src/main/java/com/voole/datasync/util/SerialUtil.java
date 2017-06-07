package com.voole.datasync.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialUtil {

	

	public static byte[] serialObject(Object o) throws IOException {
		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(obj);
		out.writeObject(o);
		return obj.toByteArray();
	}

	public static Object deserialObject(byte[] b) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bin = new ByteArrayInputStream(b);
		ObjectInputStream obin = new ObjectInputStream(bin);
		return obin.readObject();
	}
}
