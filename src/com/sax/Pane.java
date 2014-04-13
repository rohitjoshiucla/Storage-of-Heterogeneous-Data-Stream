package com.sax;

public class Pane {

	private double[] inputValue;
	private double approximateValue = Double.MIN_VALUE;
	public Pane(double[] inputValue) {
		this.inputValue = inputValue;
	}
	
	public double getApproximateValue() {
		if(approximateValue == Double.MIN_VALUE) {
			approximateValue = getMean();
		}
		return approximateValue;
	}
	
	public double getMean() {
		double sum = sum(inputValue);
		return sum/inputValue.length;
	}
	
	public double getStandardDeviation() {
		double mean = getApproximateValue();
		double numerator = 0;
		for(int i = 0; i < inputValue.length; i++) {
			double delta = inputValue[i] - mean;
			numerator += delta * delta;
		}
		return Math.sqrt(numerator/(inputValue.length - 1));
	}
	
	private double sum(double[] input) {
		double sum = 0;
		for(int i = 0; i< input.length; i++) {
			sum += input[i];
		}
		return sum;
	}
	
	public double[] getInputValue() {
		return inputValue;
	}
	
}
