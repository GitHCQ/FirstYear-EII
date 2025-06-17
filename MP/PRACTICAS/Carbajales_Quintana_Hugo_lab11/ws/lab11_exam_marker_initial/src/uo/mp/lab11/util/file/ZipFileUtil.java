/**
 * 
 */
package uo.mp.lab11.util.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * @author usuario
 *
 */
public class ZipFileUtil {
	/**
	 * Metodo que permite leer caracteres de un fichero comprimido
	 */
	public List<String>readLines(String filename) throws FileNotFoundException{
		List<String>res=new LinkedList<>();
		try {
			BufferedReader bf=new BufferedReader
					(new InputStreamReader(new GZIPInputStream
							(new FileInputStream(filename))));
			String line;
			try {
				try {
					while((line=bf.readLine())!=null) {
						res.add(line);
					}
				}
				finally {
					bf.close();
				   }
		} catch (FileNotFoundException e) {
			throw new RuntimeException("error de lectura");
	}
		}catch (IOException e) {
			throw new RuntimeException("error de lectura");
	}
		return res;
	}

}
