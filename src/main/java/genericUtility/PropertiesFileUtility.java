package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility 
{
	public String togetDataFromPropertiesFile(String key) throws IOException {
		
   FileInputStream fiss= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
  Properties prp =new Properties();
    prp.load(fiss);
   String value=prp.getProperty(key);
   
  return value;
   
	}
	
}
