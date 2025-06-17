package uo.mp.newsstand.service.parsers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Magazine.Frequency;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.util.log.Logger;

public class PublicationParser {

	/**
	 * Transforms a list of Strings in a list of instances of Publication.
	 * Any of the following are invalid lines in the input file: 
	 * 		- incorrect type of publication, 
	 * 		- wrong number of fields in a line, and 
	 * 		- incorrect data format in numeric fields.
	 * Invalid lines will not produce a Publication instance but will throw an InvalidLineFormatException instead.
	 * As a result of processing this exception, a message will be written to a log (use Log) 
	 * @param lines non-null list of strings, probably empty
	 * 		One by each publication
	 * 				type_of_publication \t name_of_publication \t sales \t stock \t frequency
	 * 
	 * @return a list of publications
	 */
	public List<Publication> parse(List<String> lines) {
		List<Publication>publications=new ArrayList<Publication>();
		int lineNumber=0;
		for (String line :lines) {
			Publication publication;
			try {
				lineNumber++;
				if(line.isBlank()) {
					continue;
				}
				publication=parseLine(line);
				publications.add(publication);
			}catch(InvalidLineFormatException e) {
				Logger.log(String.format("Eror en la linea %d: %s",lineNumber, e.getMessage()));
			}
		}
		return publications;
	}

	private Publication parseLine(String line) throws InvalidLineFormatException {
		String [] token=line.split("\t");
		String type=token[0];
		if(type.equals("newspaper")){
			return parseNewsPaper(token);
		}else if(type.equals("magazine")){
			return parseMagazine(token);
		}else {
			throw new InvalidLineFormatException("Formato desconocido");
		}
	}

	private Publication parseMagazine(String[] token) throws InvalidLineFormatException{
		checkParts(token,5);
		String name=token[1];
		int stock=toInteger(token[2]);
		int sales=toInteger(token[3]);
		Frequency frequency=toFrequency(token[4]);
		return new Magazine(name,stock,sales,frequency);
	}
	private Publication parseNewsPaper(String[] token) throws InvalidLineFormatException{
		checkParts(token,4);
		String name=token[1];
		int stock=toInteger(token[2]);
		int sales=toInteger(token[3]);
		
		return new Newspaper(name,stock,sales);
	}
	
	private Frequency toFrequency(String string) throws InvalidLineFormatException {
		try {
		return Frequency.valueOf(string);
		}catch (IllegalArgumentException e) {
			throw new InvalidLineFormatException("Formato de frecuencia incorrecto");
		
	}
}
	private int toInteger(String string) throws InvalidLineFormatException {
	try{
		return Integer.parseInt(string);
	}catch(NumberFormatException e) {
		throw new InvalidLineFormatException("Formato de numero incorrecto");
	}
	}
	private void checkParts(String[] token, int i) throws InvalidLineFormatException {
		if(token.length!=i) {
			throw new InvalidLineFormatException("Numero de campos incorrecto");
		}
		
	}

}