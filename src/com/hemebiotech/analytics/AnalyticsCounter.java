package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws IOException {
		
		// Take symptoms from symptoms.txt and put them in a list
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		
		
		// Transfer this list above in a map in order to count occurrence and sort by alphabetical order
		Map<String, Integer> mapSymptom = new TreeMap<String, Integer>();
		
		for(String lineContent : reader.GetSymptoms()) {
			lineContent = lineContent.toLowerCase(); // if line from reader contains symptom with capital letter, convert it to lower case
			Integer freq = mapSymptom.get(lineContent);
			mapSymptom.put(lineContent, (freq == null) ? 1 : freq + 1);
		}
		
		
		// Print in console what will be written on output file result.out
		for(Map.Entry<String, Integer> currentSymptom : mapSymptom.entrySet()) {
			System.out.println(currentSymptom.getKey() + ", " + currentSymptom.getValue());
		}
		
		
		// Write on output file result.out
		FileWriter writer = new FileWriter ("result.out");
		
		for(Map.Entry<String, Integer> currentPair : mapSymptom.entrySet()) {
			writer.write(currentPair.getKey() + ", " + currentPair.getValue() + "\n");
		}
		
		writer.close();
		
	}
	
}