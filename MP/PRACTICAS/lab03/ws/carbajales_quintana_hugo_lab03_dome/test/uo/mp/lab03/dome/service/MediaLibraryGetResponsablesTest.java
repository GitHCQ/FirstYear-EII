package uo.mp.lab03.dome.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.model.Item;
import uo.mp.lab03.dome.model.VideoGame;

class MediaLibraryGetResponsablesTest {

    /*
     * Escenarios:
     * Caso 1: Imprime un artista
     * Caso 2: Imprime un artista y director
     * Caso 3: Imprime dos artistas y un director
     * Caso 4: No hay datos e imprime vacio
     */
    private Item aCD;
    private Item Dvd;
    private Item game;
    private String theTitle;
    private String theArtist;
    private String theDirector;
    private int theTime;
    private int theTracks;
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
	aCD = new Cd(theTitle, theArtist, theTracks, theTime);
	Dvd = new Dvd(theTitle, theDirector, theTime);
	game = new VideoGame("Call of Duty", "Ubisoft", "Carlos", VideoGame.Platform.XBOX, 3);
	ml = new MediaLibrery();

    }

    @Test
    void getCdResponsable() {
	ml.add(aCD);
	ArrayList<Item> itemsResult = ml.getItems();
	assertEquals(1, itemsResult.size());
	assertTrue(itemsResult.contains(aCD));
	assertEquals("Beatles", ml.getResponsables());
    }

    @Test
    void getCdAndDvdResponsables() {
	ml.add(Dvd);
	ml.add(aCD);
	ArrayList<Item> itemsResult = ml.getItems();
	assertEquals(2, itemsResult.size());
	assertTrue(itemsResult.contains(aCD));
	assertTrue(itemsResult.contains(Dvd));
	assertEquals("Tarantino, Beatles", ml.getResponsables());
    }

    @Test
    void getCdAnd2DvdResponsables() {
	ml.add(Dvd);
	ml.add(aCD);
	Dvd dvd = new Dvd("Casanova", "Hugo", 120);
	ml.add(dvd);
	ml.add(game);
	ArrayList<Item> itemsResult = ml.getItems();
	assertEquals(4, itemsResult.size());
	assertTrue(itemsResult.contains(aCD));
	assertTrue(itemsResult.contains(Dvd));
	assertTrue(itemsResult.contains(game));
	assertEquals("Tarantino, Beatles, Hugo, Carlos", ml.getResponsables());
    }

    @Test
    void getResponsablesNoDatos() {
	ArrayList<Item> itemsResult = ml.getItems();
	assertEquals(0, itemsResult.size());
	assertEquals("", ml.getResponsables());
    }
}
