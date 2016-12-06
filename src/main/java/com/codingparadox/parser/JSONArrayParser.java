package com.codingparadox.parser;

import java.util.List;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class JSONArrayParser {
	
	public JSONArrayParser(){}
	
	public List<String> parse(String filename) throws IOException{
		List<String> toReturn = new ArrayList<String>();

		ClassLoader classLoader = getClass().getClassLoader();
		String absolutePath = classLoader.getResource(filename).getPath();
		BufferedReader br = new BufferedReader(new FileReader(absolutePath) );
		
		JSONParser parser = new JSONParser();

		try{
			StringBuilder tempSB = new StringBuilder();

			String line = br.readLine();
			
			int bracketCounter = 0;
			boolean addChar = false;
			
			while(line != null){
			    line = line.trim();

			    // if empty line -> skip
			    if(line.isEmpty()){
				    line = br.readLine();
                    continue;
                }
				
				for(int i=0; i<line.length(); ++i){
					char c = line.charAt(i);

					// start of the array or the comma that separates two JSON
					if((c == '[' || c == ']' || c==',') && bracketCounter == 0){
						addChar = false;
					}
					
					// start of our THE main json
					else if(c == '{' && bracketCounter == 0){
						addChar = true;
						bracketCounter++;
					}
					
					// start of nested json
					else if(c == '{' && bracketCounter>0){
						addChar = true;
						bracketCounter++;
					}
					
					// ending of nested json
					else if(c == '}' && bracketCounter>0){
						addChar = true;
						bracketCounter--;
					}

					else{
						// do nothing
					}
					

					// add character to string builder accordingly
					if(addChar == true){
						tempSB.append(c);
					}

					// end of main json
					if(bracketCounter == 0 ){
						addChar = true;
						String s = tempSB.toString();
						s = s.trim();

						// if string is not empty, add to the list
						if(!s.isEmpty()) toReturn.add(s.trim());
						tempSB = new StringBuilder();
					}
					
				}

				//tempSB.append("\n");
				line = br.readLine();
			}
			
			return toReturn;
		}
		
		finally{
		}
	}
}




