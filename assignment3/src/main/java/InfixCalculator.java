/*
 SYSC2100 Summer 2100 
Assignment 3

James Runtas
101109175
 */
import java.util.*;
import java.util.Stack; 
import java.util.ArrayList;
import java.lang.*;
public class InfixCalculator {
    

    private static int getPreference(char c){        
        if(c == '+'|| c == '-') {
            return 1;   //lesser priority operators
        }else if(c == '*' || c == '/'){
            return 2;  //higher prioity operators
        }else {
            return -1;
        }
    }
    
    private static int calculatePostFix(List<String> postFixList){        
        Stack<Integer> newStack = new Stack<>(); //create new stack adt
        for(int i = 0; i < postFixList.size(); i++){ //loop through the postfix expression characters
            
            String curr = postFixList.get(i);   //grab current character
            
            if(curr.length() == 1 && (curr.charAt(0)== '+' ||curr.charAt(0) == '-' ||curr.charAt(0) == '*' || curr.charAt(0) == '/')){ //check if curr is operator 
                int operand2 = newStack.pop();  //pop number
                int operand1 = newStack.pop();  //pop number
                if(curr.charAt(0)== '+'){
                    newStack.push(operand1 + operand2); //add and push on stack
                }else if(curr.charAt(0) == '-'){
                    newStack.push(operand1 - operand2); //subtract and push on stack
                }else if(curr.charAt(0)== '*'){
                    newStack.push(operand1 * operand2);  //multiply and push on stack
                }else{
                    newStack.push(operand1 / operand2); // divide and push on stack
                }
            }else{
                newStack.push(Integer.parseInt(curr));//convert ascii char to integer and push on list
            }
        }
        return newStack.peek();
    }
    
    private static List<String> convertPostFix(String s){
        Stack<Character> newStack = new Stack<>();
        List<String> postFixList = new ArrayList<>();
        
        boolean flag = false;
        for(int i = 0; i < s.length(); i++){ //loop through expression 
            char curr = s.charAt(i); //grab current character in expression
            if(curr == ' '){
                continue;   //reiterate if char is a space
            }
            if(curr == '('){
                newStack.push(curr); //push open bracket on stack 
                flag = false;
            }else if(curr == ')'){
                flag = false;
                while(!newStack.isEmpty()){
                    if(newStack.peek() == '('){
                        newStack.pop(); //pop from stack if closed bracket is reached and stack is not empty
                        break;
                    }else{
                        postFixList.add(newStack.pop() + "");//if no corresponding bracket, pop closed bracket and add to postfix list
                    }
                }
            }else if(curr == '+' || curr == '-' || curr == '*' || curr == '/'){  // if operator
                flag = false;
                if(newStack.isEmpty()){ 
                    newStack.push(curr); //if stack is empty, push operator onto it
                }
                else{
                    while(!newStack.isEmpty() && getPreference(newStack.peek())>= getPreference(curr)){
                        postFixList.add(newStack.pop() + "");
                    }
                    newStack.push(curr); //if stack isnt empty and stack operator has higher precedence, add operator to postfixlist and pop from other stack
                }
            }else{
                if(flag){
                    String lastNumber = postFixList.get(postFixList.size()-1);
                    lastNumber+=curr;
                    postFixList.set(postFixList.size() - 1, lastNumber); //replace integers in postfix expression
                }else
                postFixList.add(curr + "");
                flag = true;
            }
        }
        while(!newStack.isEmpty()){
            postFixList.add(newStack.pop() + ""); //if stack is still not empty, add elements to postfixlist
        }
        return postFixList;
    }
    
    public static void evaluateInfix(String s) {
        List<String> postFixString = convertPostFix(s);
        System.out.println("Postfix: " + postFixString);
        System.out.println("Answer is: " +  calculatePostFix(postFixString));

    }   
}
