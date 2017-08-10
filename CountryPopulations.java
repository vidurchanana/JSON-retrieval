package org.HackerRank.Token;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CountryPopulations {
	JSONParser parser = new JSONParser();

	public int noOfCountries(String str, int p){
		
		int count = 0;
	       
	    try {
	    	String s = "http://restcountries.eu/rest/v1";
	        URL token = new URL(s); 					// URL to Parse
	        URLConnection conn = token.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	       
	        String inputLine;
	        while ((inputLine = in.readLine()) != null) {               
	            JSONArray countriesArray = (JSONArray) parser.parse(inputLine);
	            
	            // Loop through each item
	            for (Object country : countriesArray) {
	                JSONObject selectedCountry = (JSONObject) country;
	
	                String name = (String) selectedCountry.get("name");
	                name = name.toLowerCase();						//Important
	                
	                long population = (long) selectedCountry.get("population");
	                
	                if(name.contains(str) && population > p){
	                	System.out.println("Name of the country : " + name);
	                	System.out.println("Population : " + population);
	                	count++;
	                }
	            }
	        }
	        in.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return count;
	}
	
	public static void main(String[] args){
		CountryPopulations cp = new CountryPopulations();
		String str = "un";
		System.out.println(cp.noOfCountries(str, 0));
	}
}