
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 10 of 2023 ISC Computer Science Specimen Paper 
 * Create a class Interest
 */


class Bank {
	private String name;
	private int acc_no;
	protected double principal;
	
	public Bank(String name, int acc_no, double principal) {
		this.name = name;
		this.acc_no = acc_no;
		this.principal = principal;
	}
	
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Account number: " + acc_no);
		System.out.println("Principal: " + principal);
	}
}

class Interest extends Bank {
    private double rate;
    private double time;

    public Interest(String name, int acc_no, double principal, double rate, double time) {
        super(name, acc_no, principal);
        this.rate = rate;
        this.time = time;
    }

    public double calculate() {
        double term = Math.pow(1 + rate/100, time);
        double compoundInterest = principal*term - principal;
        return compoundInterest;
    }

    public void display() {
        super.display();
        System.out.println("Compound Interest: " + calculate());
    }

}

public class ISC2023ComputerScienceSpecimenPaperQuestion10 {
    public static void main(String args[]) {
		Interest interest = new Interest("Pandit Gangadhar Vidyadhar Mayadhar Omkarnath Shastri", 16161616, 10000, 6, 3);
		interest.display();
	}
}