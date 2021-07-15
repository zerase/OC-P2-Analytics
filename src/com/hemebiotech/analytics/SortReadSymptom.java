package com.hemebiotech.analytics;

import java.util.Map;
import java.util.TreeMap;


public class SortReadSymptom {
	
	private ReadSymptomDataFromFile listToSort;
	private Map<String, Integer> listCountedAndSorted;
	

	public SortReadSymptom(ReadSymptomDataFromFile listReadFromFile) {
		this.listToSort = listReadFromFile;
	}
	
	
	public Map<String, Integer> sortSymptoms() {
		
		listCountedAndSorted = new TreeMap<String, Integer>();
		
		for(String symptomName : listToSort.getSymptoms()) {
			Integer occurrence = listCountedAndSorted.get(symptomName);
			listCountedAndSorted.put(symptomName, (occurrence == null) ? 1 : occurrence + 1);
		}
		
		return listCountedAndSorted;
		
	}

}