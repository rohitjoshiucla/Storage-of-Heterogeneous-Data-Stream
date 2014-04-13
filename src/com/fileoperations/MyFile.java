package com.fileoperations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyFile implements Iterable<String>{

	private String fileName;
	private BufferedReader bufferedReader;
	private boolean isFileClosed = false;
	
	public MyFile(String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		init();
	}

	private void init() throws FileNotFoundException {
		bufferedReader = new BufferedReader(new FileReader(fileName));
		isFileClosed = false;
	}
	
	public String readNextLine() {
		String line = null;
		try {
			line = bufferedReader.readLine();
			if(line == null) {
				isFileClosed = true;
				closeFile();
			}
		} catch (IOException e) {
			isFileClosed = true;
			closeFile();
			throw new NoSuchElementException("File is closed");
		}
		return line;
	}
	
	private void closeFile() {
		try {
			bufferedReader.close();
		} catch (IOException e) {
			
		}
		isFileClosed = true;
	}

	public boolean isFileClosed() {
		return isFileClosed;
	}
	
	@Override
	public Iterator<String> iterator() {
		return new MyFileIterator(this);
	}

}
