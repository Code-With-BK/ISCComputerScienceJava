
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2023. All rights reserved.
 * 
 * Important Java codes (for questions on integers) for 
 * ISC 2024 Computer Science Practical Boards Paper
 */


public class ISC2024ComputerSciencePracticalImpCodes1 {
	
	/*
	 * To check if an integer is a prime number or not 
	 */
	static boolean isPrime(int n) {
		for( int i=2; i<n; i++ ) {
			if( n%i==0 ) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * To check if an integer is a composite number or not 
	 */
	static boolean isComposite(int n) {
		for( int i=2; i<n; i++ ) {
			if( n%i==0 ) {
				return true;
			}
		}
		return false;
		// or
		// return !isPrime(n);
	}
	
	/*
	 * To find the factorial of a given integer n
	 * n! = 1 x 2 x 3 .... (n-1) x n
	 */
	static int factorial(int n) {
		int product = 1;
		for( int i=1; i<=n; i++ ) {
			product *= i;
		}
		return product;
	}
	
	/*
	 * To check if an integer is an armstrong number or not
	 */
	static boolean isArmstrongNumber(int n) {
        String nStr = "" + n;
        int l = nStr.length();
        int s = 0;
        for( int i=0; i<l; i++ ) {
            int digit = nStr.charAt(i) - '0';
            s = s + (int)Math.pow(digit,l);
        }
        return s==n;
    }
	
	/*
	 * To check if an integer is a krishnamurthy number or not 
	 */
	static boolean isKrishnamurthyNumber(int n) {
		int sum = 0;
        String nStr = "" + n;
        for( int i=0; i<nStr.length(); i++ ) {
            int digit = nStr.charAt(i)-'0';
            int digitFactorial = factorial(digit);
            sum += digitFactorial;
        }
        return sum==n;
	}
	
	/*
	 * To check if an integer is a fascinating number or not 
	 */
	static boolean isFascinatingNumber(int n) {
        String nStr = "" + n;
        int numDigits = nStr.length();
        if( numDigits<3 ) {
            return false;
        }
        int n2 = 2*n;
        int n3 = 3*n;
        String concatenated = "" + n + n2 + n3;
        boolean contains[] = {false, false, false, false, false, false, false, false, false, false};
        for( int i=0; i<concatenated.length(); i++ ) {
            char c = concatenated.charAt(i);
            int digit = c - '0';
            if( digit == 0 )   
                continue;
            if( contains[digit] == false ) {
                contains[digit] = true;
            }
            else {
                return false;
            }
        }
        for( int j=1; j<=9; j++ ) {
            if( contains[j] == false ) {
                return false;
            }
        }
        return true;
    }

	/*
	 * To check if an integer is a palindrome number or not 
	 */
	static boolean isPalindromeNumber(int n) {
		String nStr = "" + n;
		String nStrReverse = "";
		for(int i=nStr.length()-1; i>=0; i-- ) {
			nStrReverse += nStr.charAt(i);
		}
		return nStr.equals(nStrReverse);
	}
	
	/**
	 * To check if year is leap year
	 * 
	 * @param yyyy - a valid year
	 * @return true/false if the year is leap/non-leap respectively
	 */
	static boolean isLeapYear(int yyyy) {
		if( yyyy%400==0 ) {
			return true;
		}
		if( yyyy%100==0 ) {
			return false;
		}
		if( yyyy%4==0 ) {
			return true;
		}
		return false;
	}
	
	static int getNumDaysInYear(int yyyy) {
		if( isLeapYear(yyyy) ) {
			return 366;
		}
		else {
			return 365;
		}
	}
	
	/**
	 * To find the number of days in a month
	 * 
	 * @param mm - a month between 1 to 12
	 * @param yyyy - a valid year
	 * @return the number of days in the given month for the given year
	 */
	static int getNumDaysInMonth(int mm, int yyyy) { 
		int days[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if( isLeapYear(yyyy) ) {
			days[2]++;
		}
		return days[mm];
	}
	
	/**
	 * To get the month name for the given month number
	 * 
	 * @param mm - month number between 1-12
	 * @return the name of the month for the given month number mm 
	 */
	static String getMonthName(int mm) {
		String monthNames[] = {
			"",
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
		};
		return monthNames[mm];
	}
	
	/**
	 * To print the date in the format "15th August, 1947"
	 * 
	 * @param dd - the of the given date
	 * @param mm - the month number between 1 to 12
	 * @param yyyy - a valid year
	 */
	static void printDate(int dd, int mm, int yyyy) {
		System.out.print(dd);
		switch(dd) {
		case 1:
		case 21:
		case 31:
			System.out.print("st");
			break;
		case 2:
		case 22:
			System.out.print("nd");
			break;
		case 3:
		case 23:
			System.out.print("rd");
			break;
		default:
			System.out.print("th");
			break;
		}
		System.out.print(" ");
		System.out.print(getMonthName(mm) + ", ");
		System.out.print(yyyy);
	}
	
	/**
	 * To find the day number from the given date
	 * For ex: 
	 * dd=1, mm=1 & yyyy=2023 would return 1 as the day number of year 2023
	 * dd=1, mm=2 & yyyy=2023 would return 32 as the day number of year 2023
	 * 
	 * 
	 * @param dd - the of the given date
	 * @param mm - the month number between 1 to 12
	 * @param yyyy - a valid year
	 * @return the day number of year for the given date
	 */
	static int findDayNumber(int dd, int mm, int yyyy) {
		int dn = 0;
		int month = 1;
		while( month<mm ) {
			dn += getNumDaysInMonth(month, yyyy);
			month++;
		}
		dn += dd;
		return dn;
	}
	
	/**
	 * To find the date for the given day number of year
	 * 
	 * @param dn valid day number (1<=dn<=365 for a non-leap year, 1<=dn<=365 for a leap year)
	 * @param yyyy the year
	 */
	static void findDateGivenDayNumber(int dn, int yyyy) {
		int mm = 1;
		while( dn>getNumDaysInMonth(mm, yyyy) ) {
			dn -= getNumDaysInMonth(mm, yyyy);
			mm++;
		}
		int dd = dn; 
		// we have dd, mm, yyyy now 
		printDate(dd, mm, yyyy);
	}
	
	/**
	 * To find the date n days after the given date. Print the final date. 
	 * 
	 * @param dd - the of the given date
	 * @param mm - the month number between 1 to 12
	 * @param yyyy - a valid year
	 * @param n - the number of days after which the final date is to be found
	 */
	static void findDateAfterNDays(int dd, int mm, int yyyy, int n) {
		int dn1 = findDayNumber(dd, mm, yyyy);
		int dn2 = dn1 + n;
		while( dn2>getNumDaysInYear(yyyy) ) {
			dn2 -= getNumDaysInYear(yyyy);
			yyyy++;
		}
		findDateGivenDayNumber(dn2, yyyy);
	}
	
	public static void main(String[] args) {
		
		int n = 11;
		int copyN = n;
		
		// check even/odd integer
		// check positive/negative integer
		
		// 1. Count the number of digits in an integer
		String nStr = "" + n;
		int numDigits = nStr.length();
		System.out.println(n + " has " + numDigits + " digits!");
		
		// 2. Sum the digits in an integer
		// 2.1 Using while loops
		int digitsSum = 0;
		int temp = n;		// make sure to save the value of n in a temp variable, n becomes 0 after the while loop
		while( n!=0 ) {
			int digit = n%10;
			digitsSum += digit;
			n/=10;
		}
		n = temp;			// set back the value of n to temp, otherwise n will be 0
		System.out.println("Sum of digits in " + n + ": " + digitsSum);
		
		// 2.2 Use strings 
		n = copyN;
		digitsSum = 0;
		for( int i=0; i<nStr.length(); i++ ) {	// using nStr from 1.
			int digit = nStr.charAt(i) - '0';
			digitsSum += digit;
		}
		System.out.println("Sum of digits in " + n + ": " + digitsSum);
		
		// 3. Extract digits of an integer
		// 3.1 Using while loops (in reverse order)
		n = copyN;
		System.out.print("Digits of " + n + ": ");
		temp = n;		// make sure to save the value of n in a temp variable, n becomes 0 after the while loop
		while( n!=0 ) {
			int digit = n%10;
			System.out.print(digit + " ");
			n/=10;
		}
		n = temp;		// set back the value of n to temp, otherwise n will be 0
		System.out.println();
		
		
		// 3.2 Using Strings (in original order)
		n = copyN;
		System.out.print("Digits of " + n + ": ");
		for( int i=0; i<nStr.length(); i++ ) {	// using nStr from 1.
			int digit = nStr.charAt(i) - '0';
			System.out.print(digit + " ");
		}
		System.out.println();
		
		// 4. check prime number
		System.out.println("Is " + n + " a prime number? " + (isPrime(n)?"YES":"NO"));
		
		// 5. Check composite number
		System.out.println("Is " + n + " a composite number? " + (isComposite(n)?"YES":"NO"));
		
		// 6. Factorial of a number
		System.out.println(n + "! = " + factorial(n));
		
		// 7. Armstorng number
		System.out.println("Is " + n + " Armstrong Number? " + (isArmstrongNumber(n)?"YES":"NO"));
		
		// 8. Krishnamurthy Number
		System.out.println("Is " + n + " Krishnamurthy Number? " + (isKrishnamurthyNumber(n)?"YES":"NO"));
	
		// 9. Fascinating Number
		System.out.println("Is " + n + " Fascinating Number? " + (isFascinatingNumber(n)?"YES":"NO"));
	
		// 10. Palindrome Number
		System.out.println("Is " + n + " Palindrome Number? " + (isPalindromeNumber(n)?"YES":"NO"));
		
		// 11. check leap year
		int yyyy = 2023;
		int mm = 2;
		int dd = 18;
		
		System.out.println("Is " + yyyy + " a leap year? " + isLeapYear(yyyy));
		
		// 12. print the date
		System.out.print("The date is ");
		printDate(dd, mm, yyyy);
		System.out.println();
		
		// 13. number of days
		System.out.println("Number of days in " + yyyy + " are " + getNumDaysInYear(yyyy));
		
		// 14. find day number of year
		printDate(dd, mm, yyyy);
		System.out.println(" is day number " + findDayNumber(dd, mm, yyyy) + " of year " + yyyy);
		
		// 15. date after n days
		n = 100;
		System.out.print(n + " days after ");
		printDate(dd, mm, yyyy);
		System.out.print(" is ");
		findDateAfterNDays(dd, mm, yyyy, n);
		System.out.println();
		
		n = 200;
		System.out.print(n + " days after ");
		printDate(dd, mm, yyyy);
		System.out.print(" is ");
		findDateAfterNDays(dd, mm, yyyy, n);
		System.out.println();
		
		n = 300;
		System.out.print(n + " days after ");
		printDate(dd, mm, yyyy);
		System.out.print(" is ");
		findDateAfterNDays(dd, mm, yyyy, n);
		System.out.println();
		
		n = 400;
		System.out.print(n + " days after ");
		printDate(dd, mm, yyyy);
		System.out.print(" is ");
		findDateAfterNDays(dd, mm, yyyy, n);
		System.out.println();
		
	}
}
