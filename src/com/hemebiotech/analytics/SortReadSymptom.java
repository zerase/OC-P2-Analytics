package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * Take a list of symptoms read from a file {@link ReadSymptomDataFromFile} and
 * put it in a TreeMap in order to identify the occurrences in alphabetical
 * order
 * 
 * @author Salomé B.
 *
 */
public class SortReadSymptom {
	
	private List<String> listToSort;
	private Map<String, Integer> listCountedAndSorted;
	

	/**
	 * 
	 * Constructor of SortReadSymptom
	 * 
	 * @param listReadFromFile 
	 * 		an array of symptom strings
	 * 
	 */
	public SortReadSymptom(List<String> listReadFromFile) {
		this.listToSort = listReadFromFile;
	}
	
	
	/**
	 * 
	 * If a symptom name shows from the first time then set its occurrence to 1
	 * if it already listed then increment by 1 each time it shows up
	 * 
	 * @return listCountedAndSorted sorted list of symptoms with the number of
	 * occurrences of each
	 * 
	 */
	public Map<String, Integer> sortSymptoms() {
		
		listCountedAndSorted = new TreeMap<String, Integer>();
		
		for(String symptomName : listToSort) {
			Integer occurrence = listCountedAndSorted.get(symptomName);
			listCountedAndSorted.put(symptomName, (occurrence == null) ? 1 : occurrence + 1);
		}
		
		return listCountedAndSorted;
		
	}

}