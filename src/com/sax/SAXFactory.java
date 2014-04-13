package com.sax;

import com.sax.impl.SAXImpl;

public class SAXFactory {

	public static SAX getSAXInstance(char[] symbolArray) {
		return new SAXImpl(symbolArray);
	}
}
