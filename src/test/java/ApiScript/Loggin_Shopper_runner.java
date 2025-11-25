package ApiScript;

import java.io.IOException;
import java.lang.runtime.ObjectMethods;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import Generic.Spec_Bulider_class;
import POJO.Shopper_login_pojo;
import Utils.Get_properties;
import Utils.Set_Properties;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Loggin_Shopper_runner {
	
	@Test
	public void login() throws IOException {
		
		Get_properties gp=new Get_properties();
		 String baseurl = gp.get_propety("base_url");
		 String content_type = gp.get_propety("content_type");
		 String create_statusline = gp.get_propety("get_statusline");
		 String endpoint = gp.get_propety("Shopper_Login_endpoint");
		 String email=gp.get_output_propety("email");
		 
		 Shopper_login_pojo s=new Shopper_login_pojo();
		 s.setEmail(email);
		 s.setPassword("rsp@123");
		 s.setRole("SHOPPER");
		 
		 ObjectMapper obj=new ObjectMapper();
		 String jsonbody= obj.writeValueAsString(s);
		 
		 Spec_Bulider_class sc=new Spec_Bulider_class();
		 RequestSpecification request = sc.request(jsonbody, content_type);
		 ResponseSpecification response=sc.response(200, create_statusline, 3000l, "message", "OK");
		 
		 Response res = RestAssured.given().spec(request).when().post(baseurl+endpoint).then().spec(response).extract().response();
		 JsonPath j=new JsonPath(res.asPrettyString());
		 Object token=j.get("data.jwtToken");
		 
		 Set_Properties sp = new Set_Properties();// to store the data into set property class
		  sp.set("bearerToken", ""+token+"");
		 
	}

}