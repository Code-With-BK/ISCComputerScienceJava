/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 10
 * ISC 2025 Computer Science Boards Specimen Paper
 */

class Library {
	private String name;
	private String author;
	protected double p;
	
	public Library(String name, String author, double p) {
		this.name = name;
		this.author = author;
		this.p = p;
	}
	
	public void show() {
		System.out.println("Name: " + name);
		System.out.println("Author: " + author);
		System.out.println("Price: Rs. " + p);
	}
}

class Compute extends Library {
	private int d;
	private double f;
	
	public Compute(String name, String author, double price, int numDays) {
		super(name, author, price);
		d = numDays;
		f = 0;
	}
	
	public void fine() {
		int numExcessDays = d - 7;
		if( numExcessDays<=0 ) {
			f = 0;
		}
		else if( numExcessDays<=5 ) {
			f = 2.0 * numExcessDays;
		}
		else if( numExcessDays<=10 ) {
			f = 3.0 * numExcessDays;
		}
		else {
			f = 5.0 * numExcessDays;
		}
	}
	
	public void show() {
		// display book details
		super.show();
		
		// calculate total amount 
		// calculate rent
		double rent = 0.02 * p * d;
		// calculate fine
		fine();
		
		double total = rent + f;
		
		// display number of days, fine and total amount
		System.out.println("Number of days: " + d);
		System.out.println("Fine: Rs. " + f);
		System.out.println("Total: Rs. " + total);
	}
}

public class ISC2025SpecimenQ10 {
	public static void main(String args[]) {
		Compute compute = new Compute("ANSI C", "Dennis M. Ritchie", 400, 18);
		compute.show();
	}
}
