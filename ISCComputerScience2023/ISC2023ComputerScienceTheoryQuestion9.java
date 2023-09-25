
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 9 of 2023 ISC Computer Science Theory Paper  
 */

//          r
//  f
// [0,0,0,0,0]

//  r
//  f
// [0,0,0,0,0,0,0,0,0,0]

// add 10 to rear
//     r
//  f
// [10,0,0,0,0,0,0,0,0,0]

// add 20 to rear
//        r
//  f
// [10,20,0,0,0,0,0,0,0,0]

// add 30 to rear
//           r
//  f
// [10,20,30,0,0,0,0,0,0,0]

// add 40 to front
// i) making a space at front - and adding to the front
//              r
//  f
// [40,10,20,30,0,0,0,0,0,0]

// add 40 to front
// ii) I cannot add to front if front cannot move left
//           r
//  f
// [10,20,30,0,0,0,0,0,0,0]

// remove from front
//           r
//     f
// [10,20,30,0,0,0,0,0,0,0]

// add 40 to front
//           r
//  f
// [40,20,30,0,0,0,0,0,0,0]

// remove front
//           r
//     f
// [40,20,30,0,0,0,0,0,0,0]

// remove front
//           r
//        f
// [40,20,30,0,0,0,0,0,0,0]

// remove front
//           r
//           f
// [40,20,30,0,0,0,0,0,0,0]


class deQueue {
	
	private int Qrr[];
	private int lim;
	private int front;
	private int rear;
	
	public deQueue(int I) {
		lim = I;
		front = 0;
		rear = 0;
		Qrr = new int[lim];
	}
	
	public void addFront(int v) {
		// approach ii
        if( front==0 ) {
            System.out.println("OVERFLOW FROM FRONT");
            return;
        }
        Qrr[front-1] = v;
        front--;
	}
	
	public void addRear(int v) {
		// considering the right end as the rear
		if( rear == lim ) {
			System.out.println("OVERFLOW FROM REAR");
			return;
		}
		Qrr[rear] = v;
		rear++;
	}
	
	public int popRear() {
		// if rear is at front
		if( front==rear ) {
			return -999;
		}
		int v = Qrr[rear-1];
		rear--;
		return v;
	}
	
	public int popFront() {
        // approach ii
        // if there is nothing to remove from front
        if( front==rear ) {
            return -999;
        }
        int v = Qrr[front];
        front++;
        return v;
	}
	
	public void show() {
		System.out.print("Front[ ");
		for( int i=front; i<rear; i++ ) {
			System.out.print(Qrr[i] + " ");
		}
		System.out.println("]Rear");
	}
}

public class ISC2023ComputerScienceTheoryQuestion9 {
    public static void main(String args[]) {
        deQueue dequeue = new deQueue(10);
		dequeue.show();

        // System.out.println("front: " + dequeue.front);
        // dequeue.addFront(71);
		
		dequeue.addRear(5);
		dequeue.show();
		dequeue.addRear(6);
		dequeue.show();
		dequeue.addRear(7);
		dequeue.show();	

        // remove from front
        System.out.println("Removed from front: " + dequeue.popFront());
        dequeue.show();	
        System.out.println("Removed from front: " + dequeue.popFront());
        dequeue.show();	

        // add to front
        dequeue.addFront(29);
        dequeue.show();	
        dequeue.addFront(39);
        dequeue.show();	

        // System.out.println("front: " + dequeue.front);
        // dequeue.addFront(71);
        // dequeue.show();	

        System.out.println("Removed from rear: " + dequeue.popRear());
        dequeue.show();	
        System.out.println("Removed from rear: " + dequeue.popRear());
        dequeue.show();
        System.out.println("Removed from rear: " + dequeue.popRear());
        dequeue.show();

        System.out.println("Removed from rear: " + dequeue.popRear());
        dequeue.show();
        System.out.println("Removed from front: " + dequeue.popFront());
        dequeue.show();	
    }
}