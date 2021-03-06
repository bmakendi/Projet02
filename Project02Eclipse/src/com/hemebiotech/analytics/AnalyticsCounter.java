package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

public class AnalyticsCounter {
	private final TreeMap<String, Integer> symptoms;
	
	public AnalyticsCounter() {
		this.symptoms = new TreeMap<String, Integer>();
	}
	
	/**
	 * Writes data from TreeMap symptoms in a "result.out" file. 
	 * @throws IOException
	 */
	public void writes() throws IOException {
		StringBuilder string = new StringBuilder();
		FileWriter writer = new FileWriter("results.out");
		for (Entry<String, Integer> symptom : symptoms.entrySet()) {
			string.append(symptom.getKey()).append(", ").append(symptom.getValue()).append("\n");
		}
		writer.write(string.toString());
		writer.close();
	}
	
	/**
	 * Reads symptoms from file "symptoms.txt" then writes them in a file using method AnalyticsCounter.writes().
	 * @throws IOException
	 */
	public void process() throws IOException {
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		for (String s : reader.getSymptoms()) {
			symptoms.putIfAbsent(s, 0);
			symptoms.put(s, symptoms.get(s) + 1);
		}
		this.writes();
	}
	
	public static void main(String args[]) throws Exception {
		AnalyticsCounter counter = new AnalyticsCounter();
		counter.process();
	}
}
