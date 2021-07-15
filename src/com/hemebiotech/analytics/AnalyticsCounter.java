package com.hemebiotech.analytics;

import java.util.List;

/**
 * 
 * Program that reads symptoms data from a source file, counts occurrence of 
 * each one and writes them sorted by alphabetical order into another file 
 * 
 * @author Salomé B.
 *
 */
public class AnalyticsCounter {
	
	public static void main(String args[]) {
		
		// Read source file
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptomsList = reader.getSymptoms();
		
		
		// Count and sort symptoms read from input file above
		SortReadSymptom sorter = new SortReadSymptom(symptomsList);
		
		
		// Write sorted symptoms from above into a new file
		WriteSymptomIntoFile writer = new WriteSymptomIntoFile(sorter, "result.out");
		writer.writeSymptom();
		// Print in console what have been written on output file
		System.out.println(writer.getSymptoms());
		
	}
	
}