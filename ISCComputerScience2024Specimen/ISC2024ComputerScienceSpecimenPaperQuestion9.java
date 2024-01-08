
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 9 of 
 * ISC 2024 Computer Science Specimen Paper
 */

class Shelf {
    private double ele[];
	private int lim;
	private int front;
	private int rear;
	
	public Shelf(int n) {
		lim = n;
		front = 0;
		rear = 0;
		ele = new double[lim];
	}
	
	public void pushVal(double v) {
		// complete

        // the shelf is full, if rear is equal to lim
        if( rear == lim ) {
            System.out.println("SHELF IS FULL");
            return;
        }

        ele[rear] = v;
        rear++;
	}
	
	public double popVal() {
		// complete

        // if the shelf is empty
        if( front == rear) {
            return -999.99;
        }

        // front<rear, if the shelf is not empty
        double poppedValue = ele[front];
        front++;
        return poppedValue;
	}
	
	public void display() {
		System.out.println("Shelf elements (front on left and rear on right): ");
		System.out.print("[ ");
		for( int i=front; i<rear; i++ ) {
			System.out.print(ele[i] + " ");
		}
		System.out.println("]");
	}
}

public class ISC2024ComputerScienceSpecimenPaperQuestion9 {
    public static void main(String args[]) {
		Shelf shelf = new Shelf(5);
		System.out.println("Popped value: " + shelf.popVal());
		shelf.display();
		
		// push 3.5
		System.out.println("Push 3.5");
		shelf.pushVal(3.5);
		shelf.display();
		
		// push 19.46
		System.out.println("Push 19.46");
		shelf.pushVal(19.46);
		shelf.display();
		
		// push 2.67
		System.out.println("Push 2.67");
		shelf.pushVal(2.67);
		shelf.display();
		
		System.out.println("Popped value: " + shelf.popVal());
		shelf.display();
		
		
		System.out.println("Popped value: " + shelf.popVal());	
		shelf.display();
		
		// push 7.43
		System.out.println("Push 7.43");
		shelf.pushVal(7.43);
		shelf.display();
		
		System.out.println("Popped value: " + shelf.popVal());
		shelf.display();
		
		System.out.println("Popped value: " + shelf.popVal());
		shelf.display();

        // push 8.1
		System.out.println("Push 8.1");
		shelf.pushVal(8.1);
		shelf.display();

        // push 87.13
		System.out.println("Push 87.13");
		shelf.pushVal(87.13);
		shelf.display();
	}
}