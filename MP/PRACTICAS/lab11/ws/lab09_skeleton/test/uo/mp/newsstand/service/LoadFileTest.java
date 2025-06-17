package uo.mp.newsstand.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Magazine.Frequency;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;

class LoadFileTest {
	/**
	 * 1-null en lugar del nombre del fichero->NewsstandException
	 * 2-nombre de fichero cadena de blancos
	 * 3-nombre del fichero menor que 5 caraceteres
	 * 4-El fichero no exista->file not found exception
	 * 5-fichero no contiene nada
	 * 6-fichero con revista y periodico 
	 * 7-fichero con revista y periodico y lineas erroneas
	 * 8-fichero con revista y periodico y revista repetida y periodico repetido
	 * @throws Exception
	 */
	
	Newsstand newsstand;
	Newspaper news;
	Magazine magazine;
	@BeforeEach
	void setUp() throws Exception {
		newsstand=new Newsstand();
		news=new Newspaper("El mundo",4,10);
		magazine=new Magazine("Hola",14,30,Frequency.WEEKLY);
	}

	@Test
	void loadNewspaperAndMagazineTest() throws FileNotFoundException, NewstandException {
		String filename="testForLoading/testLoadFile/2publications.txt";
		//probar metodo
		newsstand.loadFile(filename);
		//comprobamos
		List<Publication>pubs=newsstand.getPublications();
		assertEquals(pubs.size(),2);
		assertTrue(pubs.contains(news)); //redefinir el equals en publication
		assertTrue(pubs.contains(magazine));
		
	}
	@Test
	void fileNotExistTest() {
		String filename="testForLoading/testLoadFile/vinicius.txt";
		//probar metodo
		try {
			newsstand.loadFile(filename);
		} catch (FileNotFoundException e) {
			assertTrue(true);
		} catch (NewstandException e) {
			fail("Lanza newstandException");
		}
		fail("Deberia haber lanzado una exception");
	}
	@Test
	void loadNewspaperAndMagazineWithErrorTest() throws FileNotFoundException, NewstandException {
		String filename="testForLoading/testLoadFile/2publicationsWithErrors.txt";
		//probar metodo
		newsstand.loadFile(filename);
		//comprobamos
		List<Publication>pubs=newsstand.getPublications();
		assertEquals(pubs.size(),2);
		assertTrue(pubs.contains(news)); //redefinir el equals en publication
		assertTrue(pubs.contains(magazine));
		
	}

}
