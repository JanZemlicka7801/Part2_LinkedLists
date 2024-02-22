package business;

import java.util.Objects;

/**
 *
 * @author michelle
 */
public class Song {
    private String artist;
    private String title;

    // Default constructor
    public Song() {
        this.artist = "Joe Bloggs";
        this.title = "Mmmbop";
    }

    // Constructor with values
    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    // Getters and Setters for artists and titles
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song song)) return false;
        return Objects.equals(getArtist(), song.getArtist()) && Objects.equals(getTitle(), song.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArtist(), getTitle());
    }

    @Override
    public String toString() {
        return "Song{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
