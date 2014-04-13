package com.sax.impl;

import java.util.List;

import org.apache.commons.math3.distribution.NormalDistribution;

import com.sax.Pane;
import com.sax.SAX;
import com.sax.SymbolizedSequence;
import com.sax.Window;

public class SAXImpl implements SAX{

	private char[] characterList;
	private double bandSize;
	private long totalElementsSeen = 0;
	private double sigmaSum = 0;
	private double sigmaSquare = 0;
	
	public SAXImpl(char[] symbolArray) {
		this.characterList = symbolArray;
		this.bandSize = (double)1/symbolArray.length;
	}
	
	@Override
	public SymbolizedSequence createSymbolString(Window input) {
		List<Pane> panes = input.getPanes();
		char[] symbols = new char[panes.size()];
		updateInvariants(input);
		double mean = getMean();
		double standardDeviation = getStandardDeviation();
		//System.out.println("Mean: " + mean + ", standard deviation: " + standardDeviation);
		NormalDistribution normalDistribution = new NormalDistribution(mean, standardDeviation);
		for(int i = 0; i < panes.size(); i++) {
			Pane currentPane = panes.get(i);			
			//System.out.println("Pane Approx Value: " + currentPane.getApproximateValue());
			double probability = normalDistribution.cumulativeProbability(currentPane.getApproximateValue());
			int symbolIndex = (int)(probability/bandSize);
			symbols[i] = characterList[symbolIndex];
		}
		return new SymbolizedSequence(symbols);
	}

	private void updateInvariants(Window input) {
		for(Pane pane : input.getPanes()) {
			double[] inputValues = pane.getInputValue();
			for(int i = 0; i < inputValues.length; i++) {
				sigmaSum = sigmaSum + inputValues[i];
				sigmaSquare += Math.pow(inputValues[i], 2);
				totalElementsSeen += 1;
			}
		}
		
	}
	
	public double getMean() {
		return sigmaSum/totalElementsSeen;
	}
	
	public double getStandardDeviation() {
		return Math.sqrt((totalElementsSeen * sigmaSquare - Math.pow(sigmaSum, 2))/(totalElementsSeen * (totalElementsSeen - 1)));
	}

}
