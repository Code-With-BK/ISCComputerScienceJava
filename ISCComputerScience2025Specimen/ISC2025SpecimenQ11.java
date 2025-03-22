/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 11
 * ISC 2025 Computer Science Boards Specimen Paper
 */

class Node {
	int n;
	Node link;
}

public class ISC2025SpecimenQ11 {
	
	static Node createLinkedList(int ... arr) {
		Node head = null;
		Node tail = null;
		for( int i : arr ) {
			if( head == null ) {
				head = new Node();
				head.n = i;
				tail = head;
			}
			else {
				Node newNode = new Node();
				newNode.n = i;
				tail.link = newNode;
				tail = newNode;
			}
		}
		return head;
	}
	
	
	static void printLinkedList(Node str) {
		Node curr = str;
		while( curr!=null ) {
			System.out.print(curr.n + " -> ");
			curr = curr.link;
		}
		System.out.print("null");
	}

	// the method to complete
	static void FindNode(Node str, int b) {
		// flag to store true/false
		boolean found = false;
		
		// variable to iterate over the linked list
		Node t = str;
		while( t!=null ) {
			// if this node has the value we are looking for 
			if( t.n == b ) {
				found = true;
				break;
			}
			t = t.link;
		}
		
		// print message if the search value was found or not
		if( found ) {
			System.out.println("Number " + b + " was found in the linked list");
		}
		// else if found is false
		else {
			System.out.println("Number " + b + " was not found in the linked list");
		}
	}
	
	public static void main(String args[]) {
		// create list
		Node str = createLinkedList(1,4,18,90,100,3);
		
		// show list
		System.out.print("List: ");
		printLinkedList(str);
		System.out.println();
		
//		int b = 4;
//		FindNode(str, b);
		
		for( int i=1; i<=20; i++ ) {
			FindNode(str, i);
		}
	}
}
