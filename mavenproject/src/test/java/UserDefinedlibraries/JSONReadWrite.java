package UserDefinedlibraries;

import java.io.FileNotFoundException;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import testScenarios.Cab_Selection;
import testScenarios.Giftcard_Application;
import testScenarios.Hotel_Application;



public class JSONReadWrite {
	String n;
	public static String From,To,TravelMonth,Traveldate,PickUpTime,CabType;
	public String readJSONData(String keyword){
		JSONParser parser=new JSONParser();
		FileReader reader;
		try {
			reader=new FileReader("C:\\Users\\NISHANTH\\eclipse-workspace1\\Alpha\\src\\test\\java\\TestData\\ReadData.json");
			JSONArray jsonArr=(JSONArray)parser.parse(reader);
			for(Object obj : jsonArr){
				JSONObject jo = (JSONObject)obj;			
				n = (String)jo.get(keyword);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(ParseException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return n;

	}
	public static void read(){
		JSONReadWrite e=new JSONReadWrite();
		
		From=e.readJSONData("From");
		To=e.readJSONData("To");
		TravelMonth=e.readJSONData("TravelMonth");
		Traveldate=e.readJSONData("TravelDate");
		PickUpTime=e.readJSONData("PickUpTime");
		CabType=e.readJSONData("CabType");
	}
	
	@SuppressWarnings("unchecked")
	public static void writejson(){
		JSONObject obj=new JSONObject();
		obj.put("Budget",Cab_Selection.Budget);
		obj.put("Error Message", Giftcard_Application.error);
		obj.put("Adult(+12yrs)",Hotel_Application.list);
		
		JSONObject classobj = new JSONObject(); 
        classobj.put("Write", obj);
        
		try{
			@SuppressWarnings("resource")
			FileWriter file = new FileWriter("C:\\Users\\NISHANTH\\eclipse-workspace1\\Alpha\\src\\test\\java\\TestData\\WriteData.json");
			file.write(classobj.toJSONString());
			file.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}