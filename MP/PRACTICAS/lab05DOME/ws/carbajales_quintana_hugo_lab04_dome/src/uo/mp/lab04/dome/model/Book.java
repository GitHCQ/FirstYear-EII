/**
 * 
 */
package uo.mp.lab04.dome.model;

import java.util.Objects;

import uo.mp.lab05.dome.interfazrepository.Borrowable;

/**
 * @author usuario
 *
 */
public class Book extends Item implements Borrowable {
    private String author;
    private String publisher;
    private String ISBN;
    private boolean isAvaileable = false;

    public Book(String author, String publisher, String ISBN, String title, int price) {
	super(title, price);
	setAuthor(author);
	setPublisher(publisher);
	setISBN(ISBN);
    }

    public String getAuthor() {
	return author;
    }

    public String getPublisher() {
	return publisher;
    }

    public String getISBN() {
	return ISBN;
    }

    private void setAuthor(String author) {
	this.author = author;
    }

    private void setPublisher(String publisher) {
	this.publisher = publisher;
    }

    private void setISBN(String iSBN) {
	this.ISBN = iSBN;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Book: " + getTitle() + "\n");
	sb.append("Author: " + getAuthor() + "\n");
	if (getOwn()) {
	    sb.append("You own it" + "\n");
	} else {
	    sb.append("You do not own it" + "\n");
	}
	sb.append("Comment: " + getComment() + "\n");
	return sb.toString();
    }

    @Override
    public String getResponsable() {
	return this.author;
    }

    @Override
    public double getPrice() {
	return this.price * 1.04;
    }

    @Override
    public String getCode() {
	return this.getTitle()
	    .substring(0, Math.min(3, getTitle().length()));
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(ISBN, this.getTitle());
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
	Book other = (Book) obj;
	return Objects.equals(ISBN, other.ISBN) && Objects.equals(getTitle(), other.getTitle());
    }

    @Override
    public void giveback() {
	this.isAvaileable = true;
    }

    @Override
    public void borrow() {
	this.isAvaileable = false;
    }

    @Override
    public boolean isAvaileable() {
	return this.getOwn() && this.isAvaileable;
    }

}
