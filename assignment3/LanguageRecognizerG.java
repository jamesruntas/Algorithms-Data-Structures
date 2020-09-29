/*
 SYSC2100 Summer 2100 
Assignment 3

James Runtas
101109175
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageRecognizerG {

   private static final String AND = "&"; //initialzation
   private static final String Hash = "#";
   private static final String W = "W";
   private static final String A = "A";
   private static final String EMPTY_STRING = "";
   private static String E = "E";
   private static String V = "V";   

   private String userInput;

   private static List<String> listE = null;

   static {
       listE = getE();
   }
   
   public LanguageRecognizerG(String userInput) {
       this.userInput = userInput; 
   }

   public boolean checkIfWordExists() {

       if (userInput == null) {
           return false;  //no/null input 
       }

       if (userInput.equals("")) {
           return true;    //empty input
       }

       if (userInput.length() == 1) {
           return listE.contains(userInput); //one char input has to be in listE to be in the language
       }

       if (userInput.length() == 2) {
           String keyIndex1 = mapping().get(String.valueOf(userInput.charAt(0))); //first char mapped to key index
           String keyIndex2 = mapping().get(String.valueOf(userInput.charAt(1))); //second char mapped to key index

           if ((keyIndex1.equals(E) && keyIndex2.equals(V)) || keyIndex1.equals(V) && keyIndex2.equals(E)) {
               return true;  //check if first and second char follow language rules
           }
       }
       if (userInput.length() > 2) {
           String key = recursiveRecogG(userInput); //recursivley identify if userInput is in language
           return Boolean.valueOf(key); //return true or false
       }
       return false;
   }

    private static List<String> getE() {
       List<String> list = new ArrayList<>();
       list.add(AND);
       list.add(Hash);
       return list;
   }
   private Map<String, String> mapping() {
       Map<String, String> mapping = new HashMap<>();
       mapping.put(AND, E);
       mapping.put(Hash, E);
       mapping.put(W, V);
       mapping.put(A, V);
       return mapping;

   }
   private String recursiveRecogG(String userInput) {
       char[] charArray = userInput.toCharArray();
       for (int i = 0; i < charArray.length; i++) { //loop through each char in userInput
           if (i == 0) {
               if (mapping().get(String.valueOf(charArray[i])).equals(E)) {
                   continue; //if in language, continue
               }
           } else if (i == 1) {
               return recursiveRecogG(userInput.substring(i , i+1)); //loop again
           } else if (i == 2) {
               if (mapping().get(String.valueOf(charArray[i])).equals(V)) { 
                   Boolean.toString(true); //check if next char is in langauge
               }
           } else {
               return Boolean.toString(false); //else, false
           }
       }
       return Boolean.toString(false);
   }
}
