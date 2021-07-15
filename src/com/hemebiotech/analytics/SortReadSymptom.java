package com.hemebiotech.analytics;

import java.util.Map;
import java.util.TreeMap;

public class SortReadSymptom extends ReadSymptomDataFromFile {

	WriteSymptomIntoFile writerOnFile;
	Map<String, Integer> symptoms = new TreeMap<String, Integer>();

	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public SortReadSymptom(String filepath) {
		super(filepath);
			
		writerOnFile = new WriteSymptomIntoFile("result.out");
		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(filepath);
			
		for(String symptomName : reader.getSymptoms()) {
			Integer frequency = symptoms.get(symptomName);
			symptoms.put(symptomName, (frequency == null) ? 1 : frequency + 1);
		}
			
		System.out.println("There is " + symptoms.size() + " distinct symptoms.");
		System.out.println("Here they are : " + symptoms);
			
	}
		
	public void sortedSymptom() {
		writerOnFile.writeOutputFileSymptom(symptoms);
	}
		
}