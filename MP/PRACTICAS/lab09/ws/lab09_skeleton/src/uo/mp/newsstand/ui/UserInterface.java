package uo.mp.newsstand.ui;

import java.io.FileNotFoundException;
import java.util.List;

import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.service.NewstandException;
import uo.mp.util.console.Console;
import uo.mp.util.log.Logger;

/**
 * It is in charge of interacting with the user:
 * 	- Shows the menu of options
 *  - Process the option chosen by the user
 *  	- For that it asks the user the necessary data to fulfill the request
 *  	- Shows the result of the request
 *  - In case of error shows an explaining message
 *  
 *  Note: This is the unique class allowed to show information to the user
 *  @version 2023
 */
public class UserInterface {
	private static final int EXIT = 0;

	private Menu menu = new Menu();
	private Newsstand newsStand = new Newsstand();
	
	public void show()  {
		int option = EXIT;
		do {
			try {
			menu.show();
			option = Console.readInt("Option  ");		
			processOption(option);
			}catch(RuntimeException e) {
				handleSystemError(e);
				return;
			}catch(NewstandException  | FileNotFoundException e) {
				handleUserError(e);
			}
		} while (option != EXIT);
	}

	private void handleUserError(Exception e) {
		Console.println("Error del usuario: " + e.getMessage()
		+"\n por favor elija otra opcion");
		
	}

	private void handleSystemError(RuntimeException e) {
		Logger.log("Error del sistema o de programacion: "+ e.getMessage()+
				"\n por favor pongase en contacto con el administrador");
	}

	private void processOption(int option) throws NewstandException, FileNotFoundException {
		switch( option ) {
			case EXIT: return;
			case 1: loadFile(); break;
			case 2: showPublications(); break;				
			case 3: addPublication(); break;
			case 4: removePublication(); break;				
			case 5: createOrders(); break; 				
			case 6: saveOrdersToFile(); break;
			case 7: importFromZip(); break;
			case 8: exportToZip(); break;
		}
	}

	private void loadFile() throws NewstandException, FileNotFoundException {
		boolean wrongName=true;
		do {
			String fileName=Console.readString("File name?");
		try {
			newsStand.loadFile(fileName);
			wrongName=false;
		}catch(NewstandException e) {
			Console.println(e.getMessage());
			wrongName=true;
			}
		}while(wrongName);
	}
	
	private void addPublication() throws NewstandException {
		Publication p = new PublicationForm().askForPublication();
		newsStand.addPublication( p );
	}

	private void removePublication() throws NewstandException {
		String name = Console.readString("publication name?");
		newsStand.removePublication( name );
	}
	
	private void showPublications() {
		List<Publication> publications = newsStand.getPublications();
		listPublications( publications );
	}

	private void createOrders() {
		newsStand.createOrders();
	}

	private void listPublications(List<Publication> publications) {
		Console.print("\nList of publications\n");
		Console.print("------------------\n");
		for (Publication p: publications) {
			Console.print(String.format("%s\n", p ) );
		}
	
		Console.print("------------------\n");
   }	
	
	private void saveOrdersToFile() {
		String fileName = Console.readString("output file name?");
		newsStand.saveOrdersToFile( fileName );
	}
	
	private void importFromZip() {
		String fileName = Console.readString("input zip file name?");
		newsStand.importPublicationsFromZipFile( fileName );
	}
	
	private void exportToZip() {
		String fileName = Console.readString("output file name?");
		newsStand.exportPublicationsToZipFile( fileName );
	}

}
