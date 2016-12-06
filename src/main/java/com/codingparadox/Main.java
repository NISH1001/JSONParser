package com.codingparadox;

import java.util.List;


import com.codingparadox.parser.JSONArrayParser;
import com.codingparadox.parser.JSONParser;

public class Main {
	
	public static void main(String[] args){
		System.out.println("I am paradox.");
		try{
		    JSONArrayParser jsonArrayParser = new JSONArrayParser();
			List<String> strings = jsonArrayParser.parse("data/suggest.json");

			for(String s : strings){
				System.out.println(s);
			}
		}
		catch(Exception e){
			//e.printStackTrace();
		}
	}
}
