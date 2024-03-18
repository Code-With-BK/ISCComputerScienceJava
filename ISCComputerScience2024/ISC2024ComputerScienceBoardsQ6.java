import java.util.Scanner;

/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 6 of 
 * ISC 2024 Computer Science Boards Paper
 */

class DeciHex {
	private int num;
	private String hex;
	
	public DeciHex() {
		num = 0;
		hex = "";
	}
	
	public void getNum() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		num = scanner.nextInt();
	}
	
	public void convert(int n) {
		if( n==0 ) {
			// hex = "0" + hex;
			return;
		}
		int remainder = n%16;
		if( remainder<=9 ) {
			hex = remainder + hex;
		}
		else {
			char ch = (char)('A' + (remainder-10));
			hex = ch + hex;
		}
		convert(n/16);
	}
	
	public void display() {
		System.out.println("Integer number: " + num);
		if( num==0 ) {
			hex = "0";
		}
		else {
			convert(num);
		}
		System.out.println("Hexadecimal equivalent: " + hex);
	}
}

public class ISC2024ComputerScienceBoardsQ6 {
	public static void main(String[] args) {
		DeciHex deciHex = new DeciHex();
		deciHex.getNum();
		deciHex.display();
	}
}
