/**
 * 
 */
package uo.mp.lab11.util.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author usuario
 *
 */
public class FileUtil {
	/**
	 * Metodo capaz de leer cada línea de un fichero 
	 * de texto en una lista de String.
	 */
	public List<String>readLines(String filename) throws FileNotFoundException{
		List<String>res=new LinkedList<String>();
		BufferedReader br=new BufferedReader(new FileReader(filename));
		//Operacion de lectura
		String line;
		try {
			try {
			while((line=br.readLine())!=null) {
				res.add(line);
			}
		    }finally {
				br.close();
		    }
		}catch(IOException e) {
			throw new RuntimeException("Error de lectura");
		}
		return res;
	}
}
