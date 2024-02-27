package utils;

import business.Song;
import org.w3c.dom.Node;

import java.util.InputMismatchException;
import java.util.Objects;

/**
 * The LinkedList class represents a singly linked list of songs.
 * Each Node represents a song in playlist.
 *
 * @author JanZemlicka7801
 */
public class LinkedList {
    private Song head;
    private Song tail;
    private int size;

    /**
     * Constructor of an empty LinkedList.
     */
    // No argument constructor
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Returns the number of songs in the LinkedList (size).
     *
     * @return The size of the LinkedList.
     */
    // Size method to return number of songs stored in the list
    public int size(){
        return this.size;
    }

    /**
     * Retrieves a position of a specified song in the LinkedList.
     *
     * @param pos The position of the song.
     * @return The song on specified positions passed as a parameter.
     * @throws IndexOutOfBoundsException If the position is outside the bonds.
     * @throws IllegalStateException If the LinkedList is empty.
     */
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

    /**
     * Retries a first occurred position in LinkedList of passed Song.
     *
     * @param input A song to find in the LinkedList.
     * @return The position of a passed song.
     * @throws IllegalArgumentException If passed song is null.
     */
    // Method to find the index of a specific Song
    public int indexOf(Song input){
        if (input == null) {
            throw new IllegalArgumentException("Cannot get index of a null Song.");
        }
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

    /**
     * Adds a Song to a LinkedList at the end.
     *
     * @param passed A song that needs to be added.
     * @throws IllegalArgumentException If passed Song is null.
     */
    // Method to add a Song to the end of the list
    public void add(Song passed){
        if (passed == null) {
            throw new IllegalArgumentException("Cannot add a null Song.");
        }
        if (isEmpty()){
            head = passed;
            tail = passed;
        } else {
            this.tail.setNext(passed);
            tail = passed;
        }
        size++;
    }

    /**
     * Checks if the LinkedList is empty.
     *
     * @return True if its empty and false otherwise.
     */
    // Method to check if the list is empty
    public boolean isEmpty(){
        return this.size==0;
    }

    /**
     * Retrieves the last element from LinkedList (tail).
     *
     * @return The last song in the LinkedList.
     * @throws IllegalStateException If the LinkedList is empty.
     */
    // Method to get the last element in the list
    public Song tail(){
        if (isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }
        return this.tail;
    }

    /**
     * Removes a supplied song from the LinkedList.
     *
     * @param toRemove A song that needs to be removed.
     * @throws IllegalStateException If the LinkedList is empty.
     * @throws IllegalArgumentException If the passed song is null.
     */

    //should be a boolean instead of Song
    public boolean remove(Song toRemove){
        if (toRemove == null) {
            throw new IllegalArgumentException("Cannot remove a null Song.");
        }
        Song removed = null;
        if (this.isEmpty()){
            throw new IllegalStateException("List is empty.");
        }

        if (toRemove.equals(head)){
            removed = head;
            this.head = this.head.getNext();
            size--;
            // If list becomes empty tail needs to be also set to null
            if (this.isEmpty()){
                this.tail = null;
            }
            // Succesfully removed
            return true;
        } else {

            Song current = head;
            //loop through the list until it finds match or reach the end
            while (current.getNext() != null && !current.getNext().equals(toRemove)) {
                current = current.getNext();
            }

            //check if the element to be removed is either in the middle or at the end
            if (current.getNext() != null) {
                removed = current.getNext();
                current.setNext(current.getNext().getNext());
                size--;
                if (current.getNext() == null) {
                    //if the element to be removed was at the end tail needs to be update
                    tail = current;
                }
                // Succesfully removed
                return true;
            }
        }
        // Was not removed
        return false;
    }

    /**
     * Checks if the LinkedList contains song from only one artist or from many.
     *
     * @return True if the LinkedList is only having one artist.
     * @throws IllegalArgumentException If the LinkedList is empty.
     */
    //this method checks if LinkedList contains only one artist
    public boolean check(){
        if (isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }

        Song current = head;

        while (current!=null){
            if (!(current.getArtist().equalsIgnoreCase(current.getNext().getArtist()))){
                return false;
            } else {
                current = current.getNext();
            }
        }

        return true;
    }
}
