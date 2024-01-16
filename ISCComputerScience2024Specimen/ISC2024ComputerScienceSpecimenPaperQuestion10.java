
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 10 of 
 * ISC 2024 Computer Science Specimen Paper
 */

class Circle {
	protected double radius;
	private double area;
	
	public Circle(double radius) {
		this.radius = radius;
		this.area = 0;
	}
	
	public void cal_area() {
		area = Math.PI * radius * radius;
	}
	
	public void display() {
		System.out.println("Area of circle: " + area);
	}
}

class Volume extends Circle {

	private double height;
	private double volume;

	public Volume(double radius, double hh) {
		super(radius);
		height = hh;
		// this.volume = calculate();
		this.volume = 0;
	}
	
	public double calculate() {
		return Math.PI * (radius * radius) * height;
	}

	public void display() {
		super.cal_area();
		super.display();
		volume = calculate();
		System.out.println("Volume: " + volume);
	}
}

public class ISC2024ComputerScienceSpecimenPaperQuestion10 {
	public static void main(String args[]) {
		Volume volume = new Volume(3, 4);
		volume.display();
	}
}