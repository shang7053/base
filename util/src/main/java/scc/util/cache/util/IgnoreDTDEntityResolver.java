package scc.util.cache.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

class IgnoreDTDEntityResolver implements EntityResolver{
	public InputSource resolveEntity(String publicId, String systemId)
			throws SAXException, IOException
	{
		return new InputSource(new ByteArrayInputStream(
				"<?xml version='1.0' encoding='UTF-8'?>".getBytes()));
	}
}
