package com.lanak.derivapp;

public class Term {
	int coefficient;
	int exponent; 
	String term;;
	
	/**
	 * Constructs a term object 
	 */
	public Term() { 
		coefficient= (int)(Math.random()*21); //gives a random coefficient between 0 and 20
		exponent = (int)(Math.random()*11); //gives a random exponent between 0 and 10
		term = assignTerm(); 
	}
	
	/** 
	 * Constructs a term object
	 * @param co an int representing the coefficient of the term 
	 * @param ex an int representing the exponent of the term
	 */
	public Term(int co, int ex) { 
		coefficient = co;
		exponent = ex; 
		term = assignTerm(); 
	}
	
	/**
	 * Returns the string representation of the term
	 * @return a string representation of the term
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
	 * Finds the derivative of the term
	 */
	public void deriveTerm() { 
		coefficient = getCo() * getEx(); 
		exponent--;
		term = assignTerm();
	}
	
	/**
	 * Returns the coefficient of the term
	 * @return an int representing the coefficient of the term
	 */
	public int getCo() {
		return coefficient; 
	}
	
	/**
	 * Sets the coefficient of the term
	 * @param c an int representing the coefficient of the term
	 */
	public void setCo(int c) { 
		coefficient = c;
	}
	
	/**
	 * Returns the exponent of the term
	 * @return an int representing the exponent of the term
	 */
	public int getEx() { 
		return exponent;
	}
	
	/**
	 * Returns the string representation of the term
	 * @return
	 */
	public String getTerm() {
		return term;
	}
	
	/**
	 * Sets the string representation of the string based
	 * on the term's coefficient and exponent 
	 * @param c an int representing the term's coefficient 
	 * @param e an int representing the term's exponent 
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
