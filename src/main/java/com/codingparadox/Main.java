package com.codingparadox;

import java.util.ArrayList;
import java.util.List;


import com.codingparadox.parser.JSONArrayParser;
import com.codingparadox.parser.JSONParser;

public class Main {
	
	public static void main(String[] args){
		System.out.println("I am paradox.");
		try{
		    JSONArrayParser jsonArrayParser = new JSONArrayParser();
			List<String> strings = jsonArrayParser.parse("data/newdata.json");
			System.out.println(strings.size());
			for(String s : strings){
				//if(s.trim().isEmpty()) continue;
				System.out.println("===================");
				System.out.println(s);
			}
			System.out.println(strings.size());
		}
		catch(Exception e){
			//e.printStackTrace();
		}
	}
}
