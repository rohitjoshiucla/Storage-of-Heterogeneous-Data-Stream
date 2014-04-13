package test.data;

import java.io.FileNotFoundException;
import java.util.Iterator;

import com.fileoperations.MyFile;
import com.sax.Pane;
import com.sax.Window;

public class MITDataIterator implements Iterator<Window> {

	private String fileName;
	private int paneLength;
	private int totalWindowPans;
	private Iterator<String> myIterator;
	
	public MITDataIterator(String fileName, int paneLength, int totalWindowPans) {
		this.fileName = fileName;
		this.paneLength = paneLength;
		this.totalWindowPans = totalWindowPans;
		init();
	}
	
	private void init() {
		try {
			MyFile myFile = new MyFile(fileName);
			myIterator = myFile.iterator();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean hasNext() {
		return myIterator.hasNext();
	}

	@Override
	public Window next() {
		Window window = new Window();
		for(int i = 0; i< totalWindowPans; i++) {
			Pane pane = readPane();
			window.addPane(pane);
		}
		return window;
	}

	private Pane readPane() {
		double[] inputValues = new double[paneLength];
		for(int i = 0; i< paneLength; i++) {
			String line = myIterator.next();
			String[] tokens = line.split(",");
			inputValues[i] = Double.parseDouble(tokens[1]);
		}
		
		Pane pane = new Pane(inputValues);
		return pane;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
