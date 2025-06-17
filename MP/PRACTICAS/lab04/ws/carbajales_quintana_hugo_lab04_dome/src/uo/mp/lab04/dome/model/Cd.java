package uo.mp.lab04.dome.model;

import java.util.Objects;

import uo.mp.util.check.ArgumentChecks;

/**
 *
 */
public class Cd extends Item {

    private String artist;
    private int numberOfTracks;
    private int playingTime;

    /**
     * Creates a new Cd with default values for gotIt and comment
     * 
     * @param theTitle  String for title
     * @param theArtist String for artist
     * @param tracks    integer for tracks
     * @param time      integer for time
     */
    public Cd(String theTitle, String theArtist, int tracks, int time, double price) {
	super(theTitle, price);
	setArtist(theArtist);
	setPlayingTime(time);
	setNumberOfTracks(tracks);
    }

    /**
     * 
     * @param arg String with the new artist name
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setArtist(String arg) {
	ArgumentChecks.isNotNull(arg);
	ArgumentChecks.isNotEmpty(arg);
	ArgumentChecks.isNotBlank(arg);

	this.artist = arg;
    }

    /**
     * 
     * @param arg integer with the number of tracks in the CD
     * @throws IllegalArgumentException if the argument is is lower or equal zero
     */
    private void setNumberOfTracks(int arg) {
	ArgumentChecks.isTrue(arg > 0, "Invalid number of tracks");
	this.numberOfTracks = arg;
    }

    /**
     * @return artist's name
     */
    public String getArtist() {
	return this.artist;
    }

    /**
     * @return number of tracks
     */
    public int getNumberOfTracks() {
	return this.numberOfTracks;
    }

    /**
     * 
     * @param arg integer with the playing time in the CD
     * @throws IllegalArgumentException if the argument is is lower or equal zero
     */
    protected void setPlayingTime(int arg) {
	ArgumentChecks.isTrue(arg > 0, "Invalid playing time");
	this.playingTime = arg;
    }

    /**
     * @return playing time
     */
    public int getPlayingTime() {
	return this.playingTime;
    }

    /**
     * @param out a PrintStream to flush output
     */
    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("CD: " + getTitle() + " (" + getPlayingTime() + " mins)" + "\n");
	sb.append("Artist: " + getArtist() + "\n");
	sb.append("Tracks: " + getNumberOfTracks() + "\n");
	if (getOwn()) {
	    sb.append("You own it");
	} else {
	    sb.append("You do not own it");
	}
	sb.append("Comment: " + getComment() + "\n");
	return sb.toString();
    }

    public String getResponsable() {
	return this.getArtist();
    }

    @Override
    /**
     * @return Devuelve el precio del Cd mas una tasa de 2 euros
     */
    public double getPrice() {
	return this.price + 2;
    }

    public String getCode() {
	return this.getTitle()
	    .substring(0, Math.min(3, getTitle().length() - 1));
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(artist, numberOfTracks, playingTime);
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Cd other = (Cd) obj;
	return Objects.equals(artist, other.artist) && numberOfTracks == other.numberOfTracks
		&& playingTime == other.playingTime;
    }

}