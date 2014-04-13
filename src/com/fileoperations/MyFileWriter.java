package com.fileoperations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriter {

	private String fileName;
	private BufferedWriter bufferedWriter;
	
	public MyFileWriter(String fileName) throws IOException {
		this.fileName = fileName;
		init();
	}
	
	private void init() throws IOException {
		bufferedWriter = new BufferedWriter(new FileWriter(fileName));
	}
	
	public void writeLine(String line) throws IOException {
		bufferedWriter.write("\n" + line);
	}
	
	public void close() throws IOException {
		bufferedWriter.close();
	}
	
	public static void writeContentToFile(String fileName, List<String> content) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
		boolean isFirst = true;
		for(String string: content) {
			if(isFirst) {
				bufferedWriter.write(string);
				isFirst = false;
			} else {
				bufferedWriter.write("\n" + string);
			}
		}
		
		bufferedWriter.close();
	}
}
