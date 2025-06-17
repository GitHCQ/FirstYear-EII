/**
 * 
 */
package uo.mp.lab04.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;

import uo.mp.lab04.dome.model.Item;
import uo.mp.lab05.dome.interfazrepository.Borrowable;
import uo.mp.util.check.ArgumentChecks;

/**
 * @author UO300798
 *
 */
public class MediaLibrery {
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Borrowable> borrowableItems = new ArrayList<>();

//    public MediaLibrery() {
//	items = new ArrayList<>();
//	
//    }

    /**
     * Añade un item a la lista de items
     * Si recibe null salta excepción
     * 
     * @param item a añadir
     * @throws IllegarArgumentException si recibe null
     */
    public void add(Item theItem) {
	ArgumentChecks.isNotNull(theItem);
	items.add(theItem);
	if (theItem instanceof Borrowable) {
	    borrowableItems.add((Borrowable) theItem);
	}
    }

    protected ArrayList<Item> getItems() {
	return new ArrayList<>(items);

    }

    protected ArrayList<Borrowable> getBorrowableItems() {
	return new ArrayList<>(borrowableItems);
    }

    /**
     * Devuelve el numero de items con propietario
     * 
     * @return numero de items con propietario
     */
    public int numberOfItemsOwned() {
	int numberOfItems = 0;
	for (Item itemToCheck : items) {
	    if (itemToCheck.getOwn()) {
		numberOfItems++;
	    }
	}
	return numberOfItems;
    }

    /**
     * Busca en la librería el ítem recibido como parámetro (el mismo
     * ítem, no otro ítem con el mismo contenido).
     * 
     * @return item encontrado en la libreria, si lo encunetra,
     *         null si el parametro es null o no lo encuentra
     */
    public Item search(Item theItem) {
	if (theItem == null) {
	    return null;
	}
	for (Item it : items) {
	    if (it.equals(theItem)) {
		return it;
	    }
	}
	return null;
    }

    /**
     * Busca en la libretia las personas responsables de todos los ítems existentes,
     * separadas por comas. En el caso de los CDs, el responsable es el artista.
     * En el caso de los DVDs el responsable es el director
     * 
     * @return String (posiblemente vacío si no hay datos)
     *         que contenga lo dicho anteriormente.
     */
    public String getResponsables() {
	StringBuilder result = new StringBuilder();
	for (Item it : items) {
	    result.append(it.getResponsable() + " ");
	}

	return result.toString();
    }

    /**
     * Imprime en el objeto out los datos de todos los items de la libreria
     * 
     * @param out, objeto de tipo PrintStream en el que se imprimen los datos
     * 
     */
    public void list(PrintStream out) {
	ArgumentChecks.isNotNull(out);
	for (Item itemToPrint : items) {
	    // itemToPrint.print(out);
	    out.println(itemToPrint.toString());
	}
    }

    /**
     * Imprime una lista de items que pueden ser prestados.
     * 
     * @param out
     */
    public void getBorrowables(PrintStream out) {
	for (Borrowable item : borrowableItems) {
	    out.println(item);
	}
    }

    /**
     * Imprime una lista con los items que pueden ser prestados y estan disponibles
     * 
     * @param out
     */
    public void getAvaileables(PrintStream out) {
	for (Borrowable item : borrowableItems) {
	    if (item.isAvaileable()) {
		out.print(item);
	    }
	}
    }

    /**
     * Presta un item
     * 
     * @param recibe un item prestable (diferente de null), busca uno en la lista y
     * @return devuelve este ya prestado o null si no se ha podido prestar
     */
    public Borrowable borrow(Borrowable theItem) {
	ArgumentChecks.isNotNull(theItem);

	Borrowable item = searchBorrowable(theItem);

	if (item != null && item.isAvaileable()) {
	    item.borrow();
	    return item;
	} else {
	    return null;
	}
    }

    /**
     * Busca si hay en la coleccion de items prestables un item igual al introducido como parametro
     * 
     * @param theItem
     * @return el item igual si existe, null si no.
     */
    private Borrowable searchBorrowable(Borrowable theItem) {
	for (Borrowable it : borrowableItems) {
	    if (it.equals(theItem)) {
		return it;
	    }
	}
	return null;
    }

    /**
     * Devuelve un item, recibe uno igual al que existia y lo deja disponible
     * 
     * @param theItem igual a uno que existia
     * @return true si se ha devuelo, false si no se ha encontrado o ya esta disponible
     */
    public boolean giveBack(Borrowable theItem) {
	Borrowable item = searchBorrowable(theItem);
	if (item == null)
	    return false; // no encontrado
	if (item.isAvaileable()) {
	    return false; // Ya disponible
	}
	item.giveback();
	return true;
    }

    /**
     * Devuelve el precio de todos los elementos de la coleccion
     * 
     * @return suma de dinero, de tipo double, que cuestan los elementos de la coleccion
     */
    public double getTotalPrice() {
	double total = 0.0;
	for (Item it : items) {
	    total += it.getPrice();
	}
	return total;
    }

    public String generateCodes() {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < items.size(); i++) {
	    if (i != items.size() - 1) {
		sb.append(items.get(i)
		    .getCode() + i + "-");
	    } else {
		sb.append(items.get(i)
		    .getCode() + i);
	    }
	}
	return sb.toString();
    }
}
