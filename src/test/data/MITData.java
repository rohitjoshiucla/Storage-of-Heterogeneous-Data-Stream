package test.data;

import java.util.Iterator;

import com.sax.Window;

public class MITData implements Iterable<Window>{

	private String fileName;
	private int paneRecords;
	private int totalPansInWindows;
	
	public MITData(String fileName, int paneRecords, int totalPansInWindow) {
		this.fileName = fileName;
		this.paneRecords = paneRecords;
		this.totalPansInWindows = totalPansInWindow;
	}
	
	@Override
	public Iterator<Window> iterator() {
		return new MITDataIterator(fileName, paneRecords, totalPansInWindows);
	}

}
