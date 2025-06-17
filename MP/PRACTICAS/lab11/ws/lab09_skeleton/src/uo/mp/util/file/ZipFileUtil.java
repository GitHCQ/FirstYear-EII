package uo.mp.util.file;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import uo.mp.newsstand.exception.NotYetImplementedException;

/**
 * A utility class to read/write text lines 
 * from/to a compressed text file (.txt.gz) 
 */
public class ZipFileUtil {

	/**
	 * Fake method to read lines from a .gz file
	 * 
	 * Read all lines from a .gz file. A line is considered to be terminated by a line feed ('\n'). 
	 * Each item in the list (line) will contain the contents of a line, not including any line-termination characters.
	 * 
	 * @param pathToZippedFileName path to a compressed file 
	 * @return the lines from the file as a List
	 * @throws IOException
	 */
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
		}catch (FileNotFoundException e) {
			throw new RuntimeException("error de lectura"); //Al ser un error de sistema
			
		} catch (IOException e) {
			throw new RuntimeException("error de lectura"); //Al ser un error de sistema
			
		}
		return res;
	}
	
	/**
	 * Fake method to write lines to a .gz file
	 * 
	 * Write to a .gz file all strings in the list. Lines must be terminated by a line feed ('\n'). 
	 * Each item in the list (line) contains the contents for one line, not including any
	 * line-termination characters.
	 * @param pathToZippedFileName 	path to a compressed file 
	 * @param lines         		the List of strings to the written to the file 
	 * @throws IOException
	 */
	public void writeLines(String outZippedFileName, List<String> lines) throws FileNotFoundException{
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter
					(new GZIPOutputStream(new FileOutputStream(outZippedFileName))));
			try {
				for(String line:lines) {
					out.write(line);
					out.newLine();
				}
			}finally {
			//cerrar el fichero
				out.close();
			}
		}catch (FileNotFoundException e) {
			throw new RuntimeException("error de escritura"); //Al ser un error de sistema
			
		}catch (IOException e) {
			throw new RuntimeException("error de escritura"); //Al ser un error de sistema
		}
	}
}
