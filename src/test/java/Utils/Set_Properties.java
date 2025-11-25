package Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Set_Properties {
	
	
	public Object set(String key,String value) throws IOException {
	FileOutputStream o=new FileOutputStream("./PropertyFile/output.properties",true);
	Properties p=new Properties();
	Object k = p.setProperty(key, value);
	p.store(o, "data is been stored");
	return k;
	}
}
