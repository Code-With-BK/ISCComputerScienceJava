
/**
 * 
 * @author Balkrishna Srivastava
 * Copyright © CodeWithBK 2024. All rights reserved.
 * 
 * Java code solution for Question 7 of 
 * ISC 2024 Computer Science Specimen Paper
 */

class Composite {
    private int arr[][];
    private int m;
    private int n;

    public Composite(int mm, int nn) {
        // check for valid m and n here? 
        if( m>20 || n>20 ) {
            /* something */
        }
        m = mm;
        n = nn;
        arr = new int[m][n];
    }

    public int isComposite(int p) {
        if( p==1 ) {
            // 1 is neither prime nor composite
            return 0;
        }

        for( int i=2; i<p; i++ ) {
            if( p%i==0 ) {
                return 1;
            }
        }
        return 0;
    }

    public void fill() {
        int cn = 4;
        int count = 0;
        
        int i = 0;
        int j = 0;
        while( count<(m*n) ) {
            if( isComposite(cn)==1 ) {
                arr[i][j] = cn;
                count++;

                // move to the next row
                i++;
                if( i==m ) {
                    // move to the next column
                    j++;
                    // start with first row of the next column
                    i = 0;
                }
            }
            cn++;
        }
    }

    public void display() {
        for( int i=0; i<m; i++ ) {
            for( int j=0; j<n; j++ ) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }
}

public class ISC2024ComputerScienceSpecimenPaperQuestion7 {
    public static void main(String args[]) {
        Composite composite = new Composite(3,2);
        composite.fill();
        composite.display();
    }
}