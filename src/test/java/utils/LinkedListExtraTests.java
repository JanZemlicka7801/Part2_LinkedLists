package utils;

import business.Song;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author michelle
 */
public class LinkedListExtraTests {

    public LinkedListExtraTests() {
    }

    @Test
    public void testRemove_SingleSong(){
        Song song = new Song("Jan", "Title1");
        LinkedList linkedList = new LinkedList();

        linkedList.add(song);
        linkedList.remove(song);

        assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemove_MiddleSong(){
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("Artist1", "Title2");
        Song song3 = new Song("Artist1", "Title3");
        LinkedList linkedList = new LinkedList();

        linkedList.add(song1);
        linkedList.add(song2);
        linkedList.add(song3);

        linkedList.remove(song2);

        assertEquals(2, linkedList.size());
    }

    @Test
    public void testRemove_LastSong(){
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("Artist1", "Title2");
        LinkedList linkedList = new LinkedList();

        linkedList.add(song1);
        linkedList.add(song2);

        linkedList.remove(song2);

        assertEquals(1, linkedList.size());
    }

    @Test
    public void testRemove_EmptyList(){
        Song song = new Song("Artist1", "Title1");
        LinkedList linkedList = new LinkedList();

        assertThrows(IllegalStateException.class, () -> {
            linkedList.remove(song);
        });
    }
}
