package com.sax;

import java.util.ArrayList;
import java.util.List;

public class Window {

	private List<Pane> panes = new ArrayList<Pane>();
	
	public void addPane(Pane pane) {
		panes.add(pane);
	}
	
	public List<Pane> getPanes() {
		return panes;
	}
	
	public double getWindowMean() {
		double sum = 0;
		for(Pane pane : panes) {
			sum += pane.getApproximateValue();
		}
		return sum/panes.size();
	}
	
	public double getWindowStandardDeviation() {
		double mean = getWindowMean();
		double numerator = 0;
		for(int i = 0; i < panes.size(); i++) {
			double delta = panes.get(i).getApproximateValue() - mean;
			numerator += delta * delta;
		}
		return Math.sqrt(numerator/(panes.size() - 1));
	}
	
}
