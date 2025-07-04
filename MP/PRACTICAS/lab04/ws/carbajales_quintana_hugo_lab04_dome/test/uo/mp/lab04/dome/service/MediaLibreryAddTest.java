/**
 * 
 */
package uo.mp.lab04.dome.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.dome.model.Cd;
import uo.mp.lab04.dome.model.Dvd;
import uo.mp.lab04.dome.model.Item;

/**
 * @author UO300798
 *
 */
class MediaLibreryAddTest {
    /*
     * Escenarios:
     * Caso 1: Añadir null
     * Caso 2: Añadir cd en libreria con lista vacía
     * Caso 3: Añadir dvd en librería con lista vacía
     * Caso 4: Añadir cd en libreria con lista con varios elementos
     * Caso 5: Añadir dvd en libreria con lista con varios elementos
     */
    private Item aCD;
    private Item Dvd;
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
	price = 100.0;
	theDirector = "Tarantino";
	aCD = new Cd(theTitle, theArtist, theTracks, theTime, price);
	Dvd = new Dvd(theTitle, theDirector, theTime, price);
	ml = new MediaLibrery();

    }

    /**
     * GIVEN dada una libreria con lista vacía
     * WHEN se añade un item null
     * THEN salta una excepcion
     */
    @Test
    void itemNull() {
	try {
	    ml.add(null);
	} catch (RuntimeException e) {
	    assertEquals("null is an invalid value for the argument.", e.getMessage());
	}

    }

    /**
     * GIVEN dada una libreria con lista vacía
     * WHEN se añade un CD
     * THEN la librería lo añade a la lista
     */
    @Test
    void cdEmptyList() {
	ml.add(aCD);
	ArrayList<Item> itemsResult = ml.getItems();
	assertEquals(1, itemsResult.size());
	assertTrue(itemsResult.contains(aCD));
    }

    /**
     * GIVEN dada una libreria con lista vacía
     * WHEN se añade un DVD
     * THEN la librería lo añade a la lista
     */
    @Test
    void dvdEmptyList() {
	ml.add(Dvd);
	ArrayList<Item> itemsResult = ml.getItems();
	assertEquals(1, itemsResult.size());
	assertTrue(itemsResult.contains(Dvd));
    }

    /**
     * GIVEN dada una libreria con lista con varios elementos
     * WHEN se añade un CD
     * THEN la librería lo añade a la lista
     */
    @Test
    void cdNoEmptyList() {
	ml.add(new Cd("Suavemente", "Elvis", 3, 2, price));
	ml.add(new Cd("Cayo la Noche", "Quevedo", 1, 3, price));
	ml.add(aCD);
	ArrayList<Item> itemsResult = ml.getItems();
	assertEquals(3, itemsResult.size());
	assertTrue(itemsResult.contains(aCD));
    }

    /**
     * GIVEN dada una libreria con lista con varios elementos
     * WHEN se añade un CD
     * THEN la librería lo añade a la lista
     */
    @Test
    void dvdNoEmptyList() {
	ml.add(new Cd("Suavemente", "Elvis", 3, 2, price));
	ml.add(new Cd("Cayo la Noche", "Quevedo", 1, 3, price));
	ml.add(Dvd);
	ArrayList<Item> itemsResult = ml.getItems();
	assertEquals(3, itemsResult.size());
	assertTrue(itemsResult.contains(Dvd));
    }

}
