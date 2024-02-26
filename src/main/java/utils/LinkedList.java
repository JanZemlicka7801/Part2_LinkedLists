package utils;

import business.Song;
import org.w3c.dom.Node;

import java.util.InputMismatchException;
import java.util.Objects;

/**
 *
 * @author JanZemlicka7801
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

        if (head == null) {
            throw new IllegalStateException("List is empty.");
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
        if (isEmpty()){
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

    // Method to get the last element in the list
    public Song tail(){
        if (isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }
        return this.tail;
    }

    public void remove(Song toRemove){
        if (this.isEmpty()){
            throw new IllegalStateException("List is empty.");
        }

        if (toRemove.equals(head)){
            this.head = this.head.getNext();
            size--;
            // If list becomes empty tail needs to be also set to null
            if (head == null){
                this.tail = null;
            }
        } else {

            Song current = head;
            //loop through the list until it finds match or reach the end
            while (current.getNext() != null && !current.getNext().equals(toRemove)) {
                current = current.getNext();
            }

            //check if the element to be removed is either in the middle or at the end
            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
                size--;
                if (current.getNext() == null) {
                    //if the element to be removed was at the end tail needs to be update
                    tail = current;
                }
            }
        }
    }

    //this method checks if LinkedList contains only one artist
    public boolean check(){
        if (isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }

        Song current = head;

        while (current!=null){
            if (!Objects.equals(current.getArtist(), head.getArtist())){
                return false;
            } else {
                current = current.getNext();
            }
        }

        return true;
    }
}
