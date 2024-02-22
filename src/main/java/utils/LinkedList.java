package utils;

import business.Song;
import org.w3c.dom.Node;

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
}
