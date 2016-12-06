package com.codingparadox.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

public class JSONParser {
	
	public JSONParser(){}
	
	public String parse(String filename) throws Exception{
		ClassLoader classLoader = getClass().getClassLoader();
		String absolutePath = classLoader.getResource(filename).getPath();
		BufferedReader br = new BufferedReader(new FileReader(absolutePath) );
		try{
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while(line != null){
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		}
		finally{
			br.close();
		}
	}
}
