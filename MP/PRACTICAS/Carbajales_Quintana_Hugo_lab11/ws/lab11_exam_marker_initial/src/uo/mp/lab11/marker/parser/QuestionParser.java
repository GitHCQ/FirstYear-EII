package uo.mp.lab11.marker.parser;

import java.util.LinkedList;
import java.util.List;

import uo.mp.lab11.marker.model.question.ChoiceQuestion;
import uo.mp.lab11.marker.model.question.GapQuestion;
import uo.mp.lab11.marker.model.question.Question;
import uo.mp.lab11.marker.model.question.ValueQuestion;
import uo.mp.util.log.Logger;

public class QuestionParser {

	/**
	 * 
	 * @param lines
	 * @return
	 * @throws IllegalArgumentException if lines is null
	 */
	public List<Question> parse(List<String> lines) {
		List<Question> res = new LinkedList<>();
		int lineNumber=0;
		for(String line:lines) {
			Question question;
			try {
				lineNumber++;
				if(line.isBlank()) {
					continue;
				}
				question=parseLine(line);
				res.add(question);
			}catch(InvalidLineFormatException e) {
				Logger.log(String.format("Eror en la linea %d: %s",lineNumber, e.getMessage()));
				
			}
		}
		return res;
	}
		//res.add(new ChoiceQuestion(1, 1.0, "a"));
		//res.add(new ChoiceQuestion(2, 1.0, "b"));
		//res.add(new GapQuestion(3, 0.5, "stuff"));
		//res.add(new GapQuestion(4, 0.5, "computer"));
		//res.add(new ValueQuestion(5, 1.5, 12.5));
		//res.add(new ValueQuestion(6, 1.5, 100.0));
		//res.add(new GapQuestion(7, 1.0, "polymorphism"));
		//res.add(new ValueQuestion(8, 1.0, 256.0));
		//res.add(new ChoiceQuestion(9, 0.5, "c"));
		//res.add(new GapQuestion(10, 1.5, "abstract"));
	
	private Question parseLine(String line) throws InvalidLineFormatException{
		String [] token=line.split("\t");
		String type=token[0];
		if(type.equals("choice")){
			return parseChoice(token);
		}else if(type.equals("gap")){
			return parseGap(token);
		}else if(type.equals("value")){
			return parseValue(token);
		}else {
			throw new InvalidLineFormatException("INVALID LINE");
		}
	}
		private Question parseValue(String[] token) throws InvalidLineFormatException {
		checkParts(token,3);
		int number=toInteger(token[1]);
		double weight=toInteger(token[2]);
		double rightAnswer=toInteger(token[3]);
		return new ValueQuestion(number,weight,rightAnswer);
	}

		private Question parseGap(String[] token) throws InvalidLineFormatException {
		checkParts(token,3);
		int number=toInteger(token[1]);
		double weight=toInteger(token[2]);
		String rightAnswer=token[3];
		return new GapQuestion(number,weight,rightAnswer);
	}

		private Question parseChoice(String[] token) throws InvalidLineFormatException {
		checkParts(token,3);
		int number=toInteger(token[1]);
		double weight=toInteger(token[2]);
		String rightAnswer=token[3];
		return new ChoiceQuestion(number,weight,rightAnswer);
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
