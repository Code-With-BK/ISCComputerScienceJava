
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 9 of 2023 ISC Computer Science Specimen Paper 
 * Create a class Holder
 */

//  r
//  f
// [0,0,0,0,0]


// add 10
//     r
//  f
// [10,0,0,0,0]

// add 20
//        r
//  f
// [10,20,0,0,0]

// add 30
//           r
//  f
// [10,20,30,0,0]

// add 40
//              r
//  f
// [10,20,30,40,0]

// add 50
//                  r=5
//  f
//  0  1  2  3  4
// [10,20,30,40,50]


// remove => removed 10
//           r
//     f
//  0  1  2  3 4
// [10,20,30,0,0]

// remove => removed 20
//           r
//        f
//  0  1  2  3 4
// [10,20,30,0,0]

// remove => removed 30
//           r
//           f
//  0  1  2  3 4
// [10,20,30,0,0]




class Holder {
	private int Q[];
	private int cap;
	private int front;
	private int rear;
	
	public Holder(int n) {
		cap = n;
		Q = new int[cap];
		front = 0;
		rear = 0;
	}
	
	public void addint(int v) {
        if( rear==cap ) {
            System.out.println("HOLDER IS FULL");
            return;
        }
        Q[rear] = v;
        rear++;
	}
	
	public int removeint() {
        if( rear==front ) {
            return -999;
        }
        int removedElement = Q[front];
        front++;
        return removedElement;
	}
	
	public void show() {
		System.out.print("Front[ ");
		for( int i=front; i<rear; i++ ) {
			System.out.print(Q[i] + " ");
		}
		System.out.println("]Rear");
	}
}


public class ISC2023ComputerScienceSpecimenPaperQuestion9 {

    public static void main(String args[]) {
		Holder holder = new Holder(10);
		holder.show();

        System.out.println("Removed element: " + holder.removeint());
        holder.show();
		
		holder.addint(18);
		holder.show();
		
		holder.addint(3);
		holder.show();
		
		holder.addint(12);
		holder.show();

        System.out.println("Removed element: " + holder.removeint());
        holder.show();

        System.out.println("Removed element: " + holder.removeint());
        holder.show();

        holder.addint(27);
		holder.show();
		
		holder.addint(1);
		holder.show();

        System.out.println("Removed element: " + holder.removeint());
        holder.show();

        System.out.println("Removed element: " + holder.removeint());
        holder.show();

        System.out.println("Removed element: " + holder.removeint());
        holder.show();

        System.out.println("Removed element: " + holder.removeint());
        holder.show();

        holder.addint(10);
        holder.addint(20);
        holder.addint(30);
        holder.addint(40);
        holder.show();

        holder.addint(50);
        holder.show();

        holder.addint(60);
        holder.show();
	}
}