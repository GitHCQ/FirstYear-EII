package uo.mp.lab06.greenhouse.controllers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.greenhouse.actuators.irriegator.Irriegator;
import uo.mp.greenhouse.actuators.irriegator.LevelOfWater;
import uo.mp.lab06.greenhouse.sensors.HumiditySensor;

public class HumidityControler {
	public static final double MIN_HUMIDITY=40;
	public static final double MAX_HUMIDITY=60;
	private Irriegator ir=new Irriegator();
	
	private List<HumiditySensor>humiditySensors=new ArrayList<HumiditySensor>();
	
	/**
	 * Añade sistemas de regadio a la lista
	 * @param irrigeator sistema de regadio
	 */
	/**
	 * Añade sistemas de regadio a la lista
	 * @param irrigeator sistema de regadio
	 */
	public void add(HumiditySensor humiditySensor) {
		this.humiditySensors.add(humiditySensor);
	}
	
	public List<String>monitor(){
		List<String> messages =new ArrayList<String>();
		double humidity=getAverageHumidity();
		if(humidity>MAX_HUMIDITY*1.2) {
			messages.addAll(setOffLevelOfWater(humidity));
		}else if(humidity>MAX_HUMIDITY) {
			messages.addAll(setUpLevelOfWater(humidity));
		}else if(humidity<MIN_HUMIDITY*0.8) {
			messages.addAll(setHighLevelOfWater(humidity));
		}else if(humidity<MIN_HUMIDITY) {
			messages.addAll(setDownLevelOfWater(humidity));
		}else
			messages.addAll(rightHumidity(humidity));
		return messages;
	}
	
	
	
	private List<String>setDownLevelOfWater(double humidity){
		List<String>message=new ArrayList<String>();
		message.add(actualHumidity(humidity));
		message.add("It is a bit too damp "+LevelOfWater.LOW);
		message.add(ir.changeSystemOfIrrigation(LevelOfWater.LOW));
		return message;
	}
	private List<String>setUpLevelOfWater(double humidity){
		List<String>message=new ArrayList<String>();
		message.add(actualHumidity(humidity));
		message.add("It is a bit too dry "+LevelOfWater.MEDIUM);
		message.add(ir.changeSystemOfIrrigation(LevelOfWater.MEDIUM));
		return message;
	}
	
	private List<String>setHighLevelOfWater(double humidity){
		List<String>message=new ArrayList<String>();
		message.add(actualHumidity(humidity));
		message.add("It is too dry ");
		message.add(ir.changeSystemOfIrrigation(LevelOfWater.HIGH));
		return message;
	}
	private List<String> setOffLevelOfWater(double humidity) {
		List<String>message=new ArrayList<String>();
		message.add(actualHumidity(humidity));
		message.add("It is too damp ");
		message.add(ir.changeSystemOfIrrigation(LevelOfWater.OFF));
	    return message;
	}
	private List<String> rightHumidity(double humidity) {
		List<String>message=new ArrayList<String>();
		message.add(actualHumidity(humidity));
		message.add("Humidity is right ");
	    return message;
	}
	
	
	/**
	 * Informa al jardinero sobre los valores de la humedad
	 * @param humidity
	 * @return Valor de la humedad actual
	 */
    private String actualHumidity(double humidity) {
		return "Current humidity: " + humidity;
    	
    }	
	
	//Calcula el nivel medio de humedad
	private double getAverageHumidity() {
		double addition=0;
		for(HumiditySensor hs:humiditySensors) {
			addition+=hs.getHumidity();
		}
		return addition/humiditySensors.size();
	}
	

}
