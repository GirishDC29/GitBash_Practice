package Generic;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Spec_Bulider_class {

	@BeforeMethod
	public RequestSpecification request(String body,String content)
	{
		RequestSpecBuilder s = new RequestSpecBuilder();
		
		RequestSpecification req = s.setRelaxedHTTPSValidation().setBody(body).
		setContentType(content).build();
		 return req;
	}	

		@AfterMethod
		public ResponseSpecification response(int code,String line,long time,String key,String value)
		{	
			ResponseSpecBuilder s = new ResponseSpecBuilder();
			ResponseSpecification res = s.expectStatusCode(code).expectStatusLine(line).
			expectResponseTime(Matchers.lessThanOrEqualTo(time)).
			expectBody(key,Matchers.equalTo(value)).build();
			return res;
		}
}
