package com.lanak.derivapp;

public class Term {
	int coefficient;
	int exponent; 
	String term;;
	
	/**
	 * 
	 */
	public Term() { 
		coefficient= (int)(Math.random()*21); //gives a random coefficient between 0 and 20
		exponent = (int)(Math.random()*11); //gives a random exponent between 0 and 10
		term = assignTerm(); 
	}
	
	public Term(int co, int ex) { 
		coefficient = co;
		exponent = ex; 
		term = assignTerm(); 
	}
	
	/**
	 * @return
	 */
	private String assignTerm() { 
		if(coefficient == 0) {
			return "empty";
		} else if(exponent == 0) {
			return String.valueOf(coefficient);
		} else if(exponent == 1) {
			return String.valueOf(coefficient) + "x";
		} else if(coefficient == 1) {
			return "x^" + String.valueOf(exponent);
		} else {
			return String.valueOf(coefficient) + "x^" + String.valueOf(exponent);
		}
	}
	
	/**
	 * 
	 */
	public void deriveTerm() { 
		coefficient = getCo() * getEx(); 
		exponent--;
		term = assignTerm();
	}
	
	/**
	 * @return
	 */
	public int getCo() {
		return coefficient; 
	}
	
	/**
	 * @param c
	 */
	public void setCo(int c) { 
		coefficient = c;
	}
	
	/**
	 * @return
	 */
	public int getEx() { 
		return exponent;
	}
	
	/**
	 * @return
	 */
	public String getTerm() {
		return term;
	}
	
	/**
	 * @param c
	 * @param e
	 */
	public void setTerm(int c, int e) { 
		if(e == 1) {
			term = String.valueOf(c) + "x";
		}else if(e == 0) {
			term = String.valueOf(coefficient);
		} else if(c == 1) {
			term= "x^" + String.valueOf(e);
		} else {
			term =  String.valueOf(c) + "x^" + String.valueOf(e);
		}
	}
}
