/**
 * 
 */
package uo.mp.lab04.dome.ui;

import uo.mp.lab04.dome.model.Book;
import uo.mp.lab04.dome.model.Cd;
import uo.mp.lab04.dome.model.Dvd;
import uo.mp.lab04.dome.model.Platform;
import uo.mp.lab04.dome.model.VideoGame;
import uo.mp.lab04.dome.service.MediaLibrery;

/**
 * @author UO300798
 *
 */
public class MediaPlayer {

    public void run() {
	Cd cd = new Cd("Album CD", "David Bisbal", 10, 60, 100);
	Dvd dvd = new Dvd("Movie DVD", "Silvester Stalone", 120, 300);
	VideoGame videogame = new VideoGame("Call of Duty", "Ubisoft", "Carlos", Platform.XBOX, 3, 100);
	Book book = new Book("Hugo", "Santillana", "p.e. 978-0130449290", "La vida de Hugo", 33);

	MediaLibrery mediaLibrary = new MediaLibrery();
	mediaLibrary.add(videogame);
	mediaLibrary.add(cd);
	mediaLibrary.add(dvd);
	mediaLibrary.add(book);

	System.out.println("Number of items owned: " + mediaLibrary.numberOfItemsOwned() + "\n");
	System.out.println("Items responsables: " + mediaLibrary.getResponsables() + "\n");
	System.out.println("Price of the items: " + mediaLibrary.getTotalPrice() + " €");
	System.out.println("---------------Codigo generado por los items: ");
	System.out.println(mediaLibrary.generateCodes());
	System.out.println("List of items: ");
	mediaLibrary.list(System.out);
	System.out.println("List of borrowable items: ");
	mediaLibrary.getBorrowables(System.out);
	System.out.println("List of availeable items: ");
	mediaLibrary.getAvaileables(System.out);

    }

}
