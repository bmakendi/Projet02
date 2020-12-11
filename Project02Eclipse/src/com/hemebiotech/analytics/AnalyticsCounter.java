package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

/*TODO
 * supprimer les doublons et trier les symptomes
 */

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
	
	/**
	 * Writes data from HashMap symptoms in a "result.out" file. 
	 * @throws IOException
	 */
	public void writes() throws IOException {
		StringBuilder string = new StringBuilder();
		FileWriter writer = new FileWriter("results.out");
		for (Entry<String, Integer> symptom : symptoms.entrySet()) {
			string.append(symptom.getKey()).append(", ").append(symptom.getValue()).append("\n");
			writer.write(string.toString());
		}
		writer.close();
	}
	
	/**
	 * Reads symptoms from file "symptoms.txt" then writes them in a file using method AnalyticsCounter.writes().
	 * @throws IOException
	 */
	public void process() throws IOException {
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		for (String s : reader.getSymptoms()) {
			this.increment(s);
		}
		this.writes();
	}
	
	public static void main(String args[]) throws Exception {
		AnalyticsCounter counter = new AnalyticsCounter();
		counter.process();
	}
}
