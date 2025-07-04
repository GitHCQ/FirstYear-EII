/**
 * 
 */
package uo.mp.lab03.dome.ui;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.model.VideoGame;
import uo.mp.lab03.dome.service.MediaLibrery;

/**
 * @author UO300798
 *
 */
public class MediaPlayer {

    public void run() {
	Cd cd = new Cd("Album CD", "Artist", 10, 60);
	Dvd dvd = new Dvd("Movie DVD", "Director", 120);
	VideoGame videogame = new VideoGame("Call of Duty", "Ubisoft", "Carlos", VideoGame.Platform.XBOX, 3);

	MediaLibrery mediaLibrary = new MediaLibrery();
	mediaLibrary.add(videogame);
	mediaLibrary.add(cd);
	mediaLibrary.add(dvd);
	System.out.println("Number of items owned: " + mediaLibrary.numberOfItemsOwned());
	System.out.println("Items responsables: " + mediaLibrary.getResponsables());
	System.out.println("List of items: ");
	mediaLibrary.list(System.out);

    }

}
