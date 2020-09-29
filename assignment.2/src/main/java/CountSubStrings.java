/*
SYSC2100 Summer 2020
Assignment 2
James Runtas 101109175
 */

import java.util.Random;

public class CountSubStrings {
    
    public static void main(String args[]) {
        Random rand = new Random();
        int counter1 = 0,counter2 = 0 ,counter3 = 0,counter4 = 0,counter5 = 0,counter6 = 0;
        for (int i = 0; i <=1000; i++){
            double randdub = Math.random();
            
            if (randdub > 0 && randdub <=0.166666){
                counter1 = counter1 + 1;
            }
            else if (randdub > 0.166666 && randdub <=0.333333){
                counter2 = counter2 + 1;
            }
            else if (randdub > 0.333333 && randdub <=0.5){
                counter3 = counter3 + 1;
            }
            else if (randdub > 0.5 && randdub <=0.666666){
                counter4 = counter4 + 1;
            }
            else if (randdub > 0.666666 && randdub <=0.833333){
                counter5 = counter5 + 1;
            }
            else if (randdub > 0.833333 && randdub <=1){
                counter6 = counter6 + 1;
            }
        }
        System.out.println("Face 1 = " + (counter1/1000.0)*100.0 + "%");    
        System.out.println("Face 2 = " + (counter2/1000.0)*100.0 + "%"); 
        System.out.println("Face 3 = " + (counter3/1000.0)*100.0 + "%");    
        System.out.println("Face 4 = " + (counter4/1000.0)*100.0 + "%");
        System.out.println("Face 5 = " + (counter5/1000.0)*100.0 + "%");    
        System.out.println("Face 6 = " + (counter6/1000.0)*100.0 + "%");
    }
}
