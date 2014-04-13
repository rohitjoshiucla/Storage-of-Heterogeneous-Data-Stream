package mytest;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import test.data.MITData;

import com.sax.Pane;
import com.sax.SAX;
import com.sax.SAXFactory;
import com.sax.SymbolizedSequence;
import com.sax.Window;

public class SAXTest {

	private SAX sax;
	//private final char[] symbols = {'a','b','c','d','e','f','g','h'};
	private final char[] symbols = {'a','b','c','d'};
	
	@Before
	public void setUp() {
		sax = SAXFactory.getSAXInstance(symbols);
	}
	
	@Ignore
	@Test
	public void testSax() {
		Window window = createWindow();
		SymbolizedSequence sequence = sax.createSymbolString(window);
		char[] charSequence = sequence.getCharacterSequence();
		System.out.println(new String(charSequence));
	}
	
	private Window createWindow() {
		double[] pane1Values = {0,2,4};
		Pane pane1 = new Pane(pane1Values);
		
		double[] pane2Values = {1,3,5};
		Pane pane2 = new Pane(pane2Values);
		
		double[] pane3Values = {1,2,2};
		Pane pane3 = new Pane(pane3Values);
		
		double[] pane4Values = {3,4,5,11,14};
		Pane pane4 = new Pane(pane4Values);
		
		Window window = new Window();
		window.addPane(pane1);
		window.addPane(pane2);
		window.addPane(pane3);
		window.addPane(pane4);
		
		return window;
	}
	
	@Test
	public void testStream2() {
		int paneRecords = 50;
		int totalPaneInWindow = 5;
		String filePath = "C:\\Users\\Rohit\\Desktop\\Fall 2013\\CS 219\\SAX\\SAX - Copy\\stream1.txt";
		MITData mitData = new MITData(filePath, paneRecords, totalPaneInWindow);
		Iterator<Window> iterator = mitData.iterator();
		while(iterator.hasNext()) {
			Window window = iterator.next();
			SymbolizedSequence sequence = sax.createSymbolString(window);
			char[] charSequence = sequence.getCharacterSequence();
			System.out.println(new String(charSequence));
		}
	}
	
}
