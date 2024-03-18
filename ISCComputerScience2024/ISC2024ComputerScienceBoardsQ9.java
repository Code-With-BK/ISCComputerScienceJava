
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 6 of 
 * ISC 2024 Computer Science Boards Paper
 */

class CardGame {
	private int cards[];
	private int cap;
	private int top;
	
	public CardGame(int cc) {
		cap = cc;
		top = -1;
		cards = new int[cap];
	}
	
	public void addCard(int v) {
		if( (top+1)==cap ) {
			System.out.println("CARD PILE IS FULL");
			return;
		}
		cards[++top] = v;
	}
	
	public int drawCard() {
		if( top==-1 ) {
			return -9999;
		}
		int topCard = cards[top];
		top--;
		return topCard;
	}
	
	public void display() {
		if( top!=-1 ) {
			System.out.println("Cards on the pile: ");
			System.out.print("Top ==> ");
			System.out.println(cards[top]);
			for( int i=top-1; i>=0; i-- ) {
				System.out.println("        " + cards[i]);
			}
		}
		else {
			System.out.println("Card Pile is empty!");
		}
	}
}


public class ISC2024ComputerScienceBoardsQ9 {
	public static void main(String args[]) {
		CardGame cardGame = new CardGame(5);
		
		// display - empty
		cardGame.display();
		System.out.println();
		
		// add 3 cards
		cardGame.addCard(12);
		cardGame.addCard(4);
		cardGame.addCard(7);
		
		// display 
		cardGame.display();
		System.out.println();
		
		// draw card
		System.out.println("Top card drawn: " + cardGame.drawCard());
		System.out.println();
		
		// display 
		cardGame.display();
		System.out.println();	
		
		// draw card
		System.out.println("Top card drawn: " + cardGame.drawCard());
		System.out.println();
		
		// display 
		cardGame.display();
		System.out.println();
		
		cardGame.addCard(12);
		cardGame.addCard(4);
		cardGame.addCard(7);
		cardGame.addCard(12);
		cardGame.addCard(4);
		cardGame.addCard(7);
	}
}
