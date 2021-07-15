package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Generate a file that listing all symptoms
 */
public class WriteSymptomIntoFile {
	
	FileWriter writer;
	String filepath;
	
	
	public WriteSymptomIntoFile(String outputfilepath) {
		this.filepath = outputfilepath;
	}
	
	
	public void writeOutputFileSymptom(Map<String, Integer> mapSymptoms) {
			
		try {
			writer = new FileWriter(filepath);
			for(Entry<String, Integer> currentPair : mapSymptoms.entrySet()) {
				writer.write(currentPair.getKey() + ":" + currentPair.getValue() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		System.out.println("There is " + mapSymptoms.size() + " symptoms written.");
			
	}

}