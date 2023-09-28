
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 10 of 2023 ISC Computer Science Theory Paper  
 */

class Demand {
	protected String pid;
	protected String pname;
	// pdemand has to be protected - so that it can be accessed by the sub class 
	protected int pdemand;	
	
	public Demand(String pid, String pname, int pdemand) {
		this.pid = pid;
		this.pname = pname;
		this.pdemand = pdemand;
	}
	
	public void display() {
		System.out.println("Product id: " + pid);
		System.out.println("Product name: " + pname);
		System.out.println("Product demand: " + pdemand);
	}
}

class Supply extends Demand {
	private int pproduced;
	private double prate;
	public Supply(String pid, String pname, int pdemand, int pproduced, double prate) {
		// call to super class constructor - must be the first line of code in the sub class constructor
		super(pid, pname, pdemand);
		this.pproduced = pproduced;
		this.prate = prate;
	}

	public double calculation() {
		double amountOfDemand = prate * pdemand;
		double amountProduced = prate * pproduced;
		return amountOfDemand - amountProduced;
	}

	public void display() {
		super.display();
		System.out.println("Quantity produced: " + pproduced);
		System.out.println("Rate: " + prate);
		System.out.println("Difference in amount of demand and amount of supply: " + calculation());
	}
}

public class ISC2023ComputerScienceTheoryQuestion10 {
    public static void main(String args[]) {
		Supply supply = new Supply("ID", "Name", 100, 80, 3.4);
		supply.display();
    }
}