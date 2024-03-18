/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 10 of 
 * ISC 2024 Computer Science Boards Paper
 */

class EmpSal {
	private String empnum;
	private int empcode;
	protected double salary;
	
	public EmpSal(String empnum, int empcode, double salary) {
		this.empnum = empnum;
		this.empcode = empcode;
		this.salary = salary;
	}
	
	public void show() {
		System.out.println("Employee name: " + empnum);
		System.out.println("Employee code: " + empcode);
		System.out.println("Employee salary: " + salary);
	}
}

class Overtime extends EmpSal {
	private int hours;
	private double totsal;
	
	public Overtime(String empnum, int empcode, double salary, int hours) {
		super(empnum, empcode, salary);
		this.hours = hours;
	}
	
	public void calSal() {
		totsal = salary;
		if( hours>40 ) {
			totsal += 5000;
		}
		else if( hours>=30 ) {
			totsal += 3000;
		}
	}
	
	public void show() {
		super.show();
		System.out.println("Overtime hours: " + hours);
		calSal();
		System.out.println("Total Salary: " + totsal);
	}
}

public class ISC2024ComputerScienceBoardsQ10 {
	public static void main(String args[]) {
		Overtime overtime = new Overtime("Balkrishna", 161616, 10000, 41);
		overtime.show();
	}
}
