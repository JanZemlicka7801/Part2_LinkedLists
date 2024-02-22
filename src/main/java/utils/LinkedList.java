package utils;

import business.Song;
import org.w3c.dom.Node;

import java.util.InputMismatchException;

/**
 *
 * @author michelle
 */
public class LinkedList {
    private Song head;
    private Song tail;
    private int size;

    // No argument constructor
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Size method to return number of songs stored in the list
    public int size(){
        return this.size;
    }

    // Get method to get data at a specific position
    public Song get(int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException("Entered position is out of bound.");
        }

        Song current = head;

        for(int i = 0; i < pos; i++){
            current = current.getNext();
        }

        return current;
    }

    // Method to find the index of a specific Song
    public int indexOf(Song input){
        Song current = head;
        int index = 0;

        while(current != null){
            if(input.equals(current)) {
                return index;
            }

            current = current.getNext();
            index++;
        }

        return -1;
    }

    // Method to add a Song to the end of the list
    public void add(Song passed){
        if (tail == null){
            head = passed;
            tail = passed;
        } else {
            this.tail.setNext(passed);
            tail = passed;
        }
        size++;
    }

    // Method to check if the list is empty
    public boolean isEmpty(){
        return this.size==0;
    }
}
