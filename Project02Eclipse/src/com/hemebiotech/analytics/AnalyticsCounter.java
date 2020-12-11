package com.hemebiotech.analytics;


import java.util.HashMap;

public class AnalyticsCounter {
	private final HashMap<String, Integer> symptoms;
	
	public AnalyticsCounter() {
		this.symptoms = new HashMap<String, Integer>();
	}
	
	/**
	 * 
	 * @param symptoms
	 * @param s
	 */
	public void increment(String s) {
		int value = 0;
		if(!(this.symptoms.containsKey(s))) {
			value = 1;
		}
		else {
			value += this.symptoms.get(s) + 1;
		}
		this.symptoms.put(s, value);
	}
	
	/*TODO
	 * méthode process qui call les méthodes getSymptoms etc
	 */
	
	public void process() {
		
	}
	
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		reader.getSymptoms();
	}
}
