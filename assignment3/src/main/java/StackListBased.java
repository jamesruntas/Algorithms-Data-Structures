/*
 SYSC2100 Summer 2100 
Assignment 3

James Runtas
101109175
 */
import java.util.LinkedList;

public class StackListBased {
    private LinkedList<Integer> items;
    private int top;

    public void createStack() {    //create new stack adt using linked list
        items = new LinkedList<>();
        top = -1;
    }

    public boolean isEmpty() { //check whether a stack is empty or not.
        return top == -1;
    }

    public void popAll() {
        while (!isEmpty()) {
            items.remove(top--); //while stack is not empty, remove top item
        }
    }

    public void push(int elem) {
        items.add(elem);
        top ++;   //add element to top of stack
}

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!!");
        } else {
            System.out.println("Popping : " + items.remove(top --)); //if items in list, remove top item 
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!!");
            return -1;
        } else {
            System.out.println("Popping : " + items.get(top));
            return items.get(top); //return top item without any operation or effect.
        }
    }
}

