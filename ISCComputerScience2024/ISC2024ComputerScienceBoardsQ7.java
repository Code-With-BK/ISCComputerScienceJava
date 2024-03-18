import java.util.Scanner;

/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 7 of 
 * ISC 2024 Computer Science Boards Paper
 */

class InsSort{
	private int arr[];
	private int size;
	
	public InsSort(int s) {
		size = s;
		arr = new int[s];
	}
	
	public void getArray() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter " + size + " integers: ");
		for( int i=0; i<size; i++ ) {
			arr[i] = scanner.nextInt();
		}
	}
	
	public void insertionSort() {
		for( int i=1; i<size; i++ ) {
			int j = i-1;
			int temp = arr[i];
			while( j>=0 && arr[j]<temp ) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	public double find() {
		double total = 0;
		int numOdd = 0;
		for( int i=0; i<size; i++ ) {
			if( arr[i]%2!=0 ) {
				total += arr[i];
				numOdd++;
			}
		}
		double average = total/numOdd;
		return average;
	}
	
	public void display() {
		insertionSort();
		System.out.print("Sorted elements: ");
		for( int i=0; i<size; i++ ) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("Average of all odd numbers: " + find());
	}
}

public class ISC2024ComputerScienceBoardsQ7 {

	public static void main(String[] args) {
		InsSort insSort = new InsSort(10);
		insSort.getArray();
		insSort.display();
	}

}
