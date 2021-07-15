package com.hemebiotech.analytics;

public class AnalyticsCounter {
	
	public static void main(String args[]) {
		
		SortReadSymptom mySymptomFile = new SortReadSymptom("symptoms.txt");
		mySymptomFile.sortedSymptom();
		
	}
	
}