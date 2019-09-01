package com.lanak.derivapp;

import java.lang.Math;   
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.ArrayList;

@Entity
public class Polynomial {
	
	@Id
	ArrayList<Term> termList;
	ArrayList<String> fullTermList;
 	String fullExpression;
	String derivative;
	
	
	/**
	 * Creates an object of type Polynomial 
	 */
	public Polynomial() {
		termList = new ArrayList<Term>();
		populateList(); 
		sortList();
		printList();
		combineLike();
		printList();
		fullExpression = setFullExpression(termList); 
		derivative = findDerivative();
	}
	
	/**
	 * Created an object of type polynomial
	 * @param list an aray list of terms 
	 */
	public Polynomial(ArrayList<Term> list) { 
		termList = list;
		sortList();
		printList();
		combineLike();
		printList();
		fullExpression = setFullExpression(termList); 
		derivative = findDerivative();
	}
	
	/**
	 * Populates an array list with 1-5 terms 
	 */
	private void populateList() { 
		int ran = (int)(Math.random()*5) + 1;
		for(int i = 0; i < ran; i++) { 
			termList.add(new Term());
			if(termList.get(i).getTerm().equals("empty")) {
				termList.remove(i);
				i--;
			}
		}
	}
	
	/**
	 * Prints all the terms in the term list
	 * and their corresponding exponents and coefficients
	 */
	private void printList() { 
		for(int i = 0; i < termList.size(); i++) { 
			System.out.println("term: " + termList.get(i).getTerm());
			System.out.println("ex: " + termList.get(i).getEx());
			System.out.println("co: " + termList.get(i).getCo());
		}
	}
	
	/**
	 * Sorts the list from greatest to least degree
	 */
	private void sortList() {
		boolean sorted = false;
	    Term temp;
	    while(!sorted) {
	        sorted = true;
	        for (int i = 0; i < termList.size() - 1; i++) {
	            if (termList.get(i).getEx() < termList.get(i+1).getEx()) {
	                temp = termList.get(i);
	                termList.set(i, termList.get(i+1));
	                termList.set(i+1, temp);
	                sorted = false;
	            }
	        }
	    }
	}
	
	/**
	 * Combines like terms within the list of terms
	 */
	private void combineLike() { 
		for(int i = 0; i < termList.size(); i++) {
			Term temp = termList.get(i);
			for(int j = 0; j < termList.size(); j++) {
				Term nuevo = termList.get(j);
				if(temp.getEx() == nuevo.getEx() && i != j) {
					temp.setCo(temp.getCo() + nuevo.getCo());
					temp.setTerm(temp.getCo(), temp.getEx());
					termList.remove(j);
				}
			}
		}
	}
	
	/**
	 * Takes in the list of terms and returns that list 
	 * as strings 
	 * @param list an array list of terms 
	 * @return an array list of strings that correspond to 
	 * the original term list 
	 */
	private ArrayList<String> termToStringList(ArrayList<Term> list) { 
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++) {
			temp.add(i, list.get(i).getTerm());
			//System.out.println(termList.get(i).getTerm());
		}
		return temp; 
	}
	
	/**
	 * Returns a s
	 * @param list
	 * @return
	 */
	private String setFullExpression(ArrayList<Term> list) {
		ArrayList<String> temp = termToStringList(list);
		String toReturn = "";
		for(int i = 1; i< temp.size(); i+=2) {
			String delimiter; 
			Random ran = new Random(); 
			Boolean sign = ran.nextBoolean(); 
			if(sign) {
				delimiter = " + ";
			} else { 
				delimiter = " - ";
			}
			temp.add(i, delimiter);
		}
		for(int i = 0; i< temp.size(); i++) {
			toReturn+= temp.get(i);
		}
		fullTermList= temp;
		return toReturn;
	}
	
	/**
	 * @return
	 */
	private String findDerivative() {
		ArrayList<Term> temp = new ArrayList<Term>(fullTermList.size());
		String deriv = "";
		int count = 0;
		for(int i = 0; i < fullTermList.size(); i++) {
			temp.add(i, null);
			if(i % 2 == 0) { 
				Term nuevo = termList.get(count);
				nuevo.deriveTerm();
				temp.set(i, nuevo);
				deriv+= temp.get(i).getTerm();
				count++;
			}
			else {
				deriv+= fullTermList.get(i);
			}
		}
		if(deriv.equals("empty")) {
			deriv = "0";
		} else if(deriv.charAt(deriv.length()-1) == 'y') {
			deriv = deriv.substring(0, deriv.length()-7);
		}
		return deriv;
	}
	
	/**
	 * @return
	 */
	public String getFullExpression() { 
		return fullExpression;
	}
	
	/**
	 * @return
	 */
	public String getDerivative() { 
		return derivative; 
	}
	
	/**
	 * @return
	 */
	public ArrayList<Term> getList() {
		return termList;
	}
	
	public String derivNoSpace() { 
		String der = getDerivative(); 
		String noWhite = der.replaceAll("\\s+", "");
		return noWhite;
	}
	
	public String expressionForHTML() { 
		String result = "";
		for(int i = 0; i < fullTermList.size(); i++) {
			String temp = fullTermList.get(i);
			if(i % 2 == 0 && temp.contains("^")) { 
				if(temp.contains("^2")) {
					temp = temp.replace("^2", "²");
				} else if(temp.contains("^3")) {
					temp = temp.replace("^3", "³");
				} else if(temp.contains("^4")) {
					temp = temp.replace("^4", "⁴");
				}else if(temp.contains("^5")) {
					temp = temp.replace("^5", "⁵");
				}else if(temp.contains("^6")) {
					temp = temp.replace("^6", "⁶");
				}else if(temp.contains("^7")) {
					temp = temp.replace("^7", "⁷");
				}else if(temp.contains("^8")) {
					temp = temp.replace("^8", "⁸");
				}else if(temp.contains("^9")) {
					temp = temp.replace("^9", "⁹");
				}else if(temp.contains("^10")) {
					temp = temp.replace("^10", "¹⁰");
				}
				result+= temp;
			} else { 
				result+= fullTermList.get(i);
			}
		}
		return result; 
	}
}
