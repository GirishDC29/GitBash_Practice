package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Get_properties {
	
	public String get_propety(String key) throws IOException

	{
		FileInputStream fis = new FileInputStream("./propertyFile/Data.properties");
		Properties p = new Properties();
		p.load(fis);
		String k = p.getProperty(key);
		return k;
		 
		
		
	}
		
		public String get_output_propety(String key) throws IOException

		{
			FileInputStream fis = new FileInputStream("./propertyFile/Output.properties");
			Properties p = new Properties();
			p.load(fis);
			String k = p.getProperty(key);
			return k;

			
		}
}
	

