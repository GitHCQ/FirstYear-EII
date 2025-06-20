package uo.mp.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import uo.mp.newsstand.exception.NotYetImplementedException;

/**
 * A utility class to read/write text lines from/to a text file
 */
public class FileUtil {

	/**
	 * Fake method to read lines from a file
	 * 
	 * Read all lines from a file. A line is considered to be terminated by a line feed ('\n'). 
	 * Each item in the list (line) will contain the contents of a line, not including any line-termination characters.
	 * @param pathToTheFile path to a plain text file
	 * @return the lines from the file as a List
	 * @throws IOException
	 * 							TODO
	 */
	public List<String> readLinesfalso(String pathToTheFile) /*throws IOException */ {
		List<String> res = new LinkedList<>();

		res.add("newspaper	La Nueva España	14	30");
		res.add("newspaper	El Mundo	4	10");
		res.add("magazine	Hola	14	30	WEEKLY");
		res.add("magazine	PCWord	14	30	MONTHLY");
		res.add("magazine	Diez Minuntos	4	10	NOTSUNDAY");
		res.add("magazine	El Mueble	4	10	NOTAUGUST");
		res.add("magazine	Muy Interesante	8	20	BIMONTHLY");
		res.add("magazine	Quo	8	10	QUARTERLY");

		return res;
	}
	public List<String> readLines(String inFileName) throws FileNotFoundException /*throws IOException */ {
		List<String> res = new LinkedList<>();
		//Crear el flujo 
		BufferedReader in=new BufferedReader(new FileReader(inFileName));
		//Operacion de lectura
		String line;
		try {
			try {
			while((line=in.readLine()) != null) { 
				res.add(line);
			}
		}
			finally {
			//cerrar el fichero
			in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException("error de lectura"); //Al ser un error de sistema
			
		}
		return res;
	}
	/**
	 * Fake method to write lines to a file
	 * 
	 * Write to a plain text file all strings in the list. Lines will be separated by a line feed ('\n'). 
	 * Each item in the list (line) contains the contents for one line, not including any
	 * line-termination characters.
	 * 
	 * @param pathToTheFile path to a plain text file
	 * @param lines         the List of Strings to be writen to the file
	 * @throws IOException 	
	 * 							TODO
	 */
	public void writeLines(String outFileName, List<String> lines) /* throws IOException */ {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outFileName));
			try {
				for(String line:lines) {
					out.write(line);
					out.newLine();
				}
			}finally {
			//cerrar el fichero
				out.close();
		}
		}catch (IOException e) {
			throw new RuntimeException("error de escritura"); //Al ser un error de sistema
		}
	}
}

