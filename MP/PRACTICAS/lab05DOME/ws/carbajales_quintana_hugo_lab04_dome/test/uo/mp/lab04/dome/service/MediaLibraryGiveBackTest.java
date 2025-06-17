package uo.mp.lab04.dome.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.dome.model.Book;
import uo.mp.lab04.dome.model.Cd;
import uo.mp.lab04.dome.model.Dvd;
import uo.mp.lab04.dome.model.Item;
import uo.mp.lab04.dome.model.Platform;
import uo.mp.lab04.dome.model.VideoGame;
import uo.mp.lab05.dome.interfazrepository.Borrowable;

class MediaLibraryGiveBackTest {

    /*
     * Escenarios:
     * Caso 1: Recibe para prestar un item que es null.
     * Caso 2: Recibe un item, lo busca y se puede prestar, por lo que se devuelve.
     * Caso 3: Recibe un item, lo busca y no se puede prestar, por lo que devuelve null.
     */
    private Item aCD;
    private Item Dvd;
    private Item game;
    private Item book;
    private String theTitle;
    private String theArtist;
    private String theDirector;
    private int theTime;
    private int theTracks;
    private double price;
    private MediaLibrery ml;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
	theTitle = "Come Together";
	theArtist = "Beatles";
	theTime = 70;
	theTracks = 4;
	theDirector = "Tarantino";
	aCD = new Cd(theTitle, theArtist, theTracks, theTime, price);
	Dvd = new Dvd(theTitle, theDirector, theTime, price);
	game = new VideoGame("Call of Duty", "Ubisoft", "Carlos", Platform.XBOX, 3, price);
	book = new Book("Hugo", "Santillana", "p.e. 978-0130449290", "La vida de Hugo", 3);
	ml = new MediaLibrery();

    }

    @Test
    void giveNotBackItem() {
	ml.add(Dvd);
	ml.add(aCD);
	ml.add(book);
	ml.add(game);
	ArrayList<Item> items = ml.getItems();
	ArrayList<Borrowable> itemsToBorrow = ml.getBorrowableItems();
	assertEquals(4, items.size());
	assertEquals(2, itemsToBorrow.size());
	assertFalse(ml.giveBack((Borrowable) aCD));
    }

}
