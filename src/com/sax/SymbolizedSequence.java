package com.sax;

public class SymbolizedSequence {

	private char[] characterSequence;
	public SymbolizedSequence(char[] characterSequence) {
		this.characterSequence = characterSequence;
	}
	
	public char[] getCharacterSequence() {
		return clone(characterSequence);
	}
	
	private char[] clone(char[] input) {
		char[] output = new char[input.length];
		for(int i = 0; i<input.length; i++) {
			output[i] = input[i];
		}
		return output;
	}
}
