/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © 2023 Balkrishna Srivastava. All rights reserved.
 * 
 * Solution to Question 1 of 2019 ISC Computer Science Practical Paper  
 */
import java.util.Scanner;

public class ISCComputerScience2019PracticalPaperQuestion1 {
    
    static boolean isLeapYear(int year) {
		if( year%400 == 0 )
			return true;
		
		if( year%100 == 0 )
			return false;
		
		if( year%4==0 )
			return true;
		
		return false;
	}

	static int getNumDaysInYear(int year){
        if( isLeapYear(year) )
            return 366;
        else
            return 365;
    }
	
	static int getNumDaysInMonth(int month, int year) {
		int days[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if( isLeapYear(year) )
			days[2]++;
		return days[month];
 	}
	
	static String getMonthName(int month) {
		switch(month) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";	
		}
		return "";
	}
	
	static void printDate(int day, int month, int year) {
		System.out.print(day);
        switch(day) {
            case 1:
            case 21:
            case 31:
                System.out.print("ST");
                break;
            case 2:
            case 22:
                System.out.print("ND");
                break;
            case 3:
            case 23:
                System.out.print("RD");
                break;
            default:
                System.out.print("TH");
        }
		System.out.print(" ");
		System.out.print(getMonthName(month).toUpperCase() + ",");
		System.out.println(year);
	}
	
	static void printDateFromDayNumber(int dayNumber, int year) {
        int month = 1;
        while( dayNumber > getNumDaysInMonth(month,year) ) {
            dayNumber -= getNumDaysInMonth(month,year);
            month++;
        }
        int day = dayNumber;
        printDate(day, month, year);
    }

    static int getNumDigits(int n){
        return ("" + n).length();
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("DAY NUMBER:         ");
        int dayNumber = scanner.nextInt();

        System.out.print("YEAR:               ");
        int year = scanner.nextInt();

        System.out.print("DATE AFTER(N DAYS): ");
        int N = scanner.nextInt();

        scanner.close();
		
		if( N<1 || N >100 ) {
			System.out.println("DATE AFTER(N DAYS) OUT OF RANGE.");
			return;
		}

        if( getNumDigits(year) != 4 ) {
            System.out.println("YEAR NOT OF 4 DIGITS.");
			return;
        }
        
        if( dayNumber < 1 || dayNumber > getNumDaysInYear(year)) {
            System.out.println("DAY NUMBER OUT OF RANGE.");
			return;
        }
		
        System.out.print("DATE:               ");
		printDateFromDayNumber(dayNumber, year);
		
		dayNumber += N;
        while( dayNumber > getNumDaysInYear(year) ) {
            dayNumber -= getNumDaysInYear(year);
            year++;
        }
		
		System.out.printf("%-20s", "DATE AFTER " + N + " DAYS:");
		printDateFromDayNumber(dayNumber, year);
    }
}
