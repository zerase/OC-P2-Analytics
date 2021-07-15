package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * Take a map of symptoms sorted from {@link SortReadSymptom} and write each 
 * entry in an output file
 * 
 * @author Salomé B.
 *
 */
public class WriteSymptomIntoFile implements ISymptomReader{
	
	private SortReadSymptom listToWrite;
	private String filepath;
	private FileWriter writer;
	
	
	/**
	 * 
	 * Constructor of WriteSymptomIntoFile
	 * 
	 * @param sortedSymptoms 
	 * 		a map of sorted symptoms with number of occurrences
	 * @param outputFilepath 
	 * 		a path to write into an output file
	 * 
	 */
	public WriteSymptomIntoFile(SortReadSymptom sortedSymptoms, String outputFilepath) {
		this.listToWrite = sortedSymptoms;
		this.filepath = outputFilepath;
	}
	
	
	/**
	 * 
	 * Create a file and write each entry of a TreeMap (key-value) into it
	 * 
	 */
	public void writeSymptom() {
		
		try {
			writer = new FileWriter(filepath);
			for(Map.Entry<String, Integer> currentPair : listToWrite.sortSymptoms().entrySet()) {
				writer.write(currentPair.getKey() + " = " + currentPair.getValue() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public List<String> getSymptoms() {
		
		ArrayList<String> symptomsWritten = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					symptomsWritten.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
		
		return symptomsWritten;
	}

}