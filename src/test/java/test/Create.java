package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;

public class Create {
	@Test
	public void create() {
		RestAssured.given().header("x-api-key", "reqres-free-v1").body("{\r\n"
				+ "    \"name\": \"Lebron\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").contentType(ContentType.JSON).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	}

}

 class Get_user {
	@Test
	public void get() {
		RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
	}

}
 
 class Get_user1 {
	@Test
	public void get() {
		RestAssured.given().header("x-api-key", "reqres-free-v1").when().get("http://reqres.in/api/users/2").then().statusCode(200).log().all();
	}

}
 

