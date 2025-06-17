package uo.mp.util.log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

/**
 * A very basic implementation of a logger utility.
 * For this the date are sent to the System.err standard output.
 * The format of every lines is: <timestamp> <message>
 */
public class Logger {

	private static PrintStream out = System.err;
	private static String FILE = "log.txt";
	private static boolean APPEND = true;

	/**
	 * Sends the string received as message to the log, prefixing it with 
	 * a timestamp 
	 * @param message
	 */
	public static void log(String message) {
		try {
			out=new PrintStream(new FileOutputStream(FILE,APPEND));
		} catch (FileNotFoundException e) {
			out=System.err;
		}
		out.print( new Date()  + " ");
		out.println( message );
	}

	/**
	 * Sends the full stack trace of the exception received to the log
	 * prefixing it with a timestamp 
	 * @param t, the exception to be logged
	 */
	public static void log(Throwable t) {
		out.print( new Date()  + " ");
		t.printStackTrace( out );
	}
}
