import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RetrieveDataJSON {
	JSONParser parser = new JSONParser();

	public int yourMethod(String str, int p){		//With your required parameters
		
		int count = 0;
	       
	    try {
	    	String s = "http://restcountries.eu/rest/v1";
	        URL token = new URL(s); 					// URL to Parse
	        URLConnection conn = token.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	       
	        String inputLine;
	        while ((inputLine = in.readLine()) != null) {               
	            JSONArray yourArray = (JSONArray) parser.parse(inputLine);
	            
	            // Loop through each item
	            for (Object eacjJSONObject : yourArray) {
	                JSONObject selectedJSONObject = (JSONObject) country;
	
	                String name = (String) selectedJSONObject.get("name");
	                name = name.toLowerCase();						//Important
	                
	                long population = (long) selectedJSONObject.get("population");
	                
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
		String str = "un";
		System.out.println(new CountryPopulations().noOfCountries(str, 0));
	}
}
