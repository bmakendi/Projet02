package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

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
	
	public void process() throws IOException {
		StringBuilder string = new StringBuilder();
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		FileWriter writer = new FileWriter("results.out");
		for (String s : reader.getSymptoms()) {
			this.increment(s);
		}
		for (Entry<String, Integer> symptom : symptoms.entrySet()) {
			string.append(symptom.getKey()).append(", ").append(symptom.getValue()).append("\n");
			writer.write(string.toString());
		}
		writer.close();
	}
	
	public static void main(String args[]) throws Exception {
		
	}
}
