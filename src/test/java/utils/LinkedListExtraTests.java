package utils;

import business.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * should also be comparing size and what has been removed
 * @author michelle
 */
public class LinkedListExtraTests {

    public LinkedListExtraTests() {
    }

    /**
     * Test to remove first song in the list.
     */
    @Test
    public void testRemove_SingleSong(){
        Song song = new Song("Jan", "Title1");
        LinkedList linkedList = new LinkedList();

        linkedList.add(song);

        assertEquals(song, linkedList.remove(song));
    }

    /**
     * Test to remove middle song from the list.
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

        assertEquals(song2, linkedList.remove(song2));
    }

    @Test
    public void testRemove_LastSong(){
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("Artist1", "Title2");
        LinkedList linkedList = new LinkedList();

        linkedList.add(song1);
        linkedList.add(song2);

        assertEquals(song2, linkedList.remove(song2));
    }

    @Test
    public void testRemove_EmptyList(){
        Song song = new Song("Artist1", "Title1");
        LinkedList linkedList = new LinkedList();

        assertThrows(IllegalStateException.class, () -> {
            linkedList.remove(song);
        });
    }

    @Test
    public void testRemove_NullFromList(){
        Song song = new Song("Artist1", "Title1");
        LinkedList linkedList = new LinkedList();

        assertThrows(IllegalArgumentException.class, () -> {
            linkedList.remove(null);
        });
    }

    @Test
    public void testCheck_SingleArtist(){
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("Artist1", "Title2");
        Song song3 = new Song("Artist1", "Title3");
        LinkedList linkedList = new LinkedList();

        linkedList.add(song1);
        linkedList.add(song2);
        linkedList.add(song3);

        assertTrue(linkedList.check());
    }

    @Test
    public void testCheck_MixedArtist(){
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("Artist2", "Title1");
        LinkedList linkedList = new LinkedList();

        linkedList.add(song2);
        linkedList.add(song1);

        assertFalse(linkedList.check());
    }

    @Test
    public void testCheck_EmptyList(){
        LinkedList linkedList = new LinkedList();

        assertThrows(IllegalArgumentException.class, linkedList::check);
    }
}
