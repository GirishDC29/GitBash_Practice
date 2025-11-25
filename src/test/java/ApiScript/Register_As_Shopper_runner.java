package ApiScript;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import Generic.Spec_Bulider_class;
import POJO.Register_As_Shopper_pojo;
import Utils.Get_properties;
import Utils.Set_Properties;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Register_As_Shopper_runner {

	
	@Test
	public void create() throws IOException
	{
		String email = RandomStringUtils.randomAlphanumeric(5)+"@gmail.com";//1
		
		Register_As_Shopper_pojo rp = new Register_As_Shopper_pojo();//pojo class
		rp.setCity("tumkur");
		rp.setCountry("india");
		rp.setEmail(email);
		rp.setFirstName("Alivin");
		rp.setGender("MALE");
		rp.setLastName("chathwik");
		rp.setPassword("rsp@123");
		rp.setPhone(9874589547l);
		rp.setState("karnataka");
		rp.setZoneId("ALPHA");
		
		ObjectMapper obj = new ObjectMapper();    //convert from java to json
		 String jsonbody = obj.writeValueAsString(rp);
		 
		 Get_properties gp = new Get_properties();   //Implementation of property file
		 String baseurl = gp.get_propety("base_url");
		 String content_type = gp.get_propety("content_type");
		 String create_statusline = gp.get_propety("create_statusline");
		 String endpoint = gp.get_propety("Register_as_shopper_enpoint");
		 
		 Spec_Bulider_class s = new Spec_Bulider_class();  //Spec_builder_class
		 RequestSpecification req = s.request(jsonbody, content_type);
		 ResponseSpecification res = s.response(201, create_statusline, 6000l, "data.role", "SHOPPER");
		 
		  Response reponse = RestAssured.given().spec(req).when().post(baseurl+endpoint).
				 then().spec(res).extract().response();
		  
		  JsonPath jp = new   JsonPath(reponse.asPrettyString());//to fetch response data
		  Object id = jp.get("data.userId");
		  Object emailid = jp.get("data.email");
		  
		  Set_Properties sp = new Set_Properties();// to store the data into set property class
		  sp.set("shopperId", ""+id+"");
		  sp.set("email", ""+emailid+"");
		   
	    }
	
}
