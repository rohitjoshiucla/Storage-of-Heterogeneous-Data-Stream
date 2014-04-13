package com.fileoperations;

import java.util.Iterator;

public class MyFileIterator implements Iterator<String> {
	
	private MyFile myFile;
	private String buffer = null;
	private boolean isBufferValid = false;
	
	public MyFileIterator(MyFile myFile) {
		this.myFile = myFile;
	}
	
	@Override
	public boolean hasNext() {
		if(isBufferValid) {
			return true;
		}
		
		if(myFile.isFileClosed()) {
			return false;
		}
		
		buffer = myFile.readNextLine();
		if(buffer == null) {
			isBufferValid = false;
			return false;
		}
		
		isBufferValid = true;
		return true;
	}

	@Override
	public String next() {
		if(isBufferValid) {
			isBufferValid = false;
			return buffer;
		} else {
			isBufferValid = false;
			String line = myFile.readNextLine();
			return line;
		}
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
