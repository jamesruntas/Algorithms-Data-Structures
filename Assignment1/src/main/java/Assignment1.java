/*
SYSC2100 Summer 2020
James Runtas
101109175
Assignment 1 
 */
public class Assignment1 {
        static int c(int k, int n){
                if (k ==0 || k==n) {
                        return 1;    //one group of all planets OR one group of zero planets
                } else if (k>n) {
                        return 0;   // there is no time to reach any planet
                } else if (k ==1){
                        return n;    //there is only time to reach one planet, that can be any one of the N planets                
                } else {
                        return c(n-1,k-1) + c(n-1,k); // call c method to recursively add groups of k planets that include planet x + groups that dont
                }       
        }
    
        static int P(int n){
                if (n ==1){
                        return 2;   // parade of one can either be float or band.
                } else if (n==2 ){
                        return 3;    //parade of two can be F-F, B-F, or F-B
                }
                else {
                        return P(n-1) +P(n-2);  //if larger than 2, recursivley call method to seperate parade into groups of one or two until end value is reached.
                }                
        }
    
        public static void writeLine(char ch, int n) { //void function because no values need to be returned.
                if(n <= 0) {
                        System.out.println();   //print nothing if n is zero
                } else { 
                        System.out.print(ch); // print character if n is above zero
                        writeLine(ch, n - 1);   //call method with a decrease in n by one
                } 
        }
        
        public static void writeBlock(char ch, int m, int n) { 
                if(m > 0) {   //check if block is larger than zero
                        writeLine(ch, n);    //call writeLine and print line of n characters
                        writeBlock(ch, m - 1, n);   //essentially calls writeLine with a decrease in m by one, resulting in another block of characters
                }
        }
    
        public static void reverseDigits(int number) {
                if (number < 10) {
                        System.out.println(number);   //print number if less than ten
                        return;                                //end
                }
                else {
                        System.out.println(number % 10);    // print number remainder
                        reverseDigits(number/10);               //  call method with number divided by ten
                }
        }

        int binarySearch(String [] anArray, int first,int last, String value) { 
                if (last >= first) {                         
                        int mid = first + (last - 1) / 2; 
                        if (anArray[mid] == value){  // If the element is present at the middle 
                                return mid; 
                        }
                        if (anArray[mid] > value) { // If element is smaller than mid, then it can only be iin left subarray 
                                return binarySearch(anArray, first, mid - 1, value); 
                        }        
                        return binarySearch(anArray, mid + 1, last, value);  // Else the element can only be present in right 
                }
                return -1; //return -1 if element is not present
        } 
}
