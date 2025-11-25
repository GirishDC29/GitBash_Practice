package ApiScript;

import java.io.IOException;

import org.testng.annotations.Test;

import Generic.Spec_Bulider_class;
import Utils.Get_properties;
import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;

public class Get_shopper_runner {

	@Test
	public void get() throws IOException {
		
		Get_properties gp=new Get_properties();
		 String baseurl = gp.get_propety("base_url");
		 String content_type = gp.get_propety("content_type");
		 String statusline = gp.get_propety("get_statusline");
		 String endpoint = gp.get_propety("fetch_shopper_data");
		 String token=gp.get_output_propety("bearerToken");
		 String shopperId=gp.get_output_propety("shopperId");
		 
		 Spec_Bulider_class sc=new Spec_Bulider_class();
		 ResponseSpecification response=sc.response(200, statusline, 3000l, "message", "Success");

		 
		 RestAssured.given().relaxedHTTPSValidation().auth().oauth2(token).pathParam("shopperId", shopperId).when().get(baseurl+endpoint).then().
		 spec(response).log().all();
		 
		
	}
}
