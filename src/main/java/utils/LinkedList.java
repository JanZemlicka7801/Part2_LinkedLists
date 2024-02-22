package utils;

import business.Song;

import java.util.*;
import java.io.*;

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
}
