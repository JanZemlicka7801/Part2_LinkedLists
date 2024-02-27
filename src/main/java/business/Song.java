package business;

import java.util.Objects;

/**
 *
 * @author michelle
 */
public class Song {
    private String artist;
    private String title;
    private Song next;

    /**
     * Default constructor that sets the artist to "Joe Bloggs" and the title to "Mmmbop".
     */
    // Default constructor
    public Song() {
        this.artist = "Joe Bloggs";
        this.title = "Mmmbop";
    }

    /**
     * Constructor with values for artist and title.
     *
     * @param artist The artist of the song.
     * @param title  The title of the song.
     */
    // Constructor with values
    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    /**
     * Get the artist of the song.
     *
     * @return The artist of the song.
     */
    // Getters and Setters for artists and titles
    public String getArtist() {
        return artist;
    }

    /**
     * Set the artist of the song.
     *
     * @param artist The new artist of the song.
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Get the title of the song.
     *
     * @return The title of the song.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the song.
     *
     * @param title The new title of the song.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the next song in the sequence.
     *
     * @return The next song in the sequence.
     */
    public Song getNext() {
        return next;
    }

    /**
     * Set the next song in the sequence.
     *
     * @param next The next song in the sequence.
     */
    public void setNext(Song next) {
        this.next = next;
    }

    /**
     * Compares this song to the specified object. The result is true if the
     * argument is a Song object with the same artist and title.
     *
     * @param o The object to compare with.
     * @return True if the objects are equal; false otherwise.
     */
    // Equals method based on artist and title
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song song)) return false;
        return Objects.equals(getArtist(), song.getArtist()) && Objects.equals(getTitle(), song.getTitle());
    }

    /**
     * Calculates a hash code based on the artist and title of the song.
     *
     * @return The hash code for the song.
     */
    // HashCode method based on artist and title
    @Override
    public int hashCode() {
        return Objects.hash(getArtist(), getTitle());
    }

    /**
     * Returns a well-formatted string of the song.
     *
     * @return A string representing the song.
     */
    // ToString method for well-formatted output
    @Override
    public String toString() {
        return "Song{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
