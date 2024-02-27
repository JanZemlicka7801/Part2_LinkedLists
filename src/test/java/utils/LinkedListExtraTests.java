package utils;

import business.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author michelle
 */
public class LinkedListExtraTests {

    public LinkedListExtraTests() {
    }

    /**
     * Test to remove a LinkedList with one song.
     */
    @Test
    public void testRemove_SingleSong(){
        Song song = new Song("Jan", "Title1");
        LinkedList linkedList = new LinkedList();

        linkedList.add(song);

        assertTrue(linkedList.remove(song));
    }

    /**
     * Test to remove first song from the LinkedList.
     */
    @Test
    public void testRemove_FirstSong(){
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("Artist1", "Title2");
        Song song3 = new Song("Artist1", "Title3");
        LinkedList linkedList = new LinkedList();

        linkedList.add(song1);
        linkedList.add(song2);
        linkedList.add(song3);

        assertTrue(linkedList.remove(song1));
    }

    /**
     * Test to remove last song from the LinkedList.
     */
    @Test
    public void testRemove_LastSong(){
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("Artist1", "Title2");
        Song song3 = new Song("Artist1", "Title3");
        LinkedList linkedList = new LinkedList();

        linkedList.add(song1);
        linkedList.add(song2);
        linkedList.add(song3);

        assertTrue(linkedList.remove(song3));
    }

    /**
     * Test to remove a song from the middle of the LinkedList.
     */
    @Test
    public void testRemove_MiddleSong(){
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("Artist1", "Title2");
        Song song3 = new Song("Artist1", "Title3");
        LinkedList linkedList = new LinkedList();

        linkedList.add(song1);
        linkedList.add(song2);
        linkedList.add(song3);

        assertTrue(linkedList.remove(song3));
    }

    /**
     * Test case to remove song from empty LinkedList.
     */
    @Test
    public void testRemove_EmptyList(){
        Song song = new Song("Artist1", "Title1");
        LinkedList linkedList = new LinkedList();

        assertThrows(IllegalStateException.class, () -> {
            linkedList.remove(song);
        });
    }

    /**
     * Test to remove non-existing song from the LinkedList.
     */
    @Test
    public void testRemove_SomeSong(){
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("Artist1", "Title2");
        Song song3 = new Song("Artist1", "Title3");
        LinkedList linkedList = new LinkedList();

        linkedList.add(song1);
        linkedList.add(song2);
        linkedList.add(song3);

        assertFalse(linkedList.remove(new Song("Artist2", "Title4")));
    }

    /**
     * Test to remove null value from the LinkedList.
     */
    @Test
    public void testRemove_NullFromList(){
        Song song = new Song("Artist1", "Title1");
        LinkedList linkedList = new LinkedList();

        assertThrows(IllegalArgumentException.class, () -> {
            linkedList.remove(null);
        });
    }

    /**
     * To check an empty LinkedList.
     */
    @Test
    public void testCheck_Empty(){
        LinkedList linkedList = new LinkedList();

        assertFalse(linkedList.check());
    }

    /**
     * To check LinkedList with one element.
     */
    @Test
    public void testCheck_One(){
        LinkedList linkedList = new LinkedList();
        Song song1 = new Song("Artist1", "Title1");

        linkedList.add(song1);

        assertTrue(linkedList.check());
    }

    /**
     * To check LinkedList with many songs having same artist.
     */
    @Test
    public void testCheck_Same(){
        LinkedList linkedList = new LinkedList();
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("Artist1", "Title2");
        Song song3 = new Song("Artist1", "Title3");

        linkedList.add(song1);
        linkedList.add(song2);
        linkedList.add(song3);

        assertTrue(linkedList.check());
    }

    /**
     * To check LinkedList of different artists.
     */
    @Test
    public void testCheck_Diff(){
        LinkedList linkedList = new LinkedList();
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("Artist2", "Title2");
        Song song3 = new Song("Artist1", "Title3");

        linkedList.add(song1);
        linkedList.add(song2);
        linkedList.add(song3);

        assertFalse(linkedList.check());
    }

    /**
     * To check LinkedList with case-insensitive matching artists.
     */
    @Test
    public void testCheck_Case(){
        LinkedList linkedList = new LinkedList();
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("artist1", "Title2");
        Song song3 = new Song("Artist1", "Title3");

        linkedList.add(song1);
        linkedList.add(song2);
        linkedList.add(song3);

        assertTrue(linkedList.check());
    }
}
