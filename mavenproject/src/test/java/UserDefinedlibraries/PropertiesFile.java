package UserDefinedlibraries;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	
	
	public static String browser,url;
	

	public static void readpropertiesfile() {
	    Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("C:\\Users\\NISHANTH\\eclipse-workspace1\\Alpha\\src\\test\\java\\TestData\\PropData.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			url = prop.getProperty("URL");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
