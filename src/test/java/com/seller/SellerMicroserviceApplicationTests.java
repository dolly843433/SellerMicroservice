package com.seller;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.seller.jwt.JwtUtelis;

import io.restassured.http.ContentType;

@SpringBootTest
class SellerMicroserviceApplicationTests {
	
	@Autowired
	JwtUtelis utils;


	@Test
	void contextLoads() {
	}
	
	@Test
	public void sellerSignUpTest() throws Exception {
		
		String jsonBody="{\"email_id\":\"rohan@gmail.com\",\"full_name\":\" rohan\",\"phone_number\":\"9679297493\",\"adress\":\"guma\",\"pin\":\"743704\",\"pan\":\"34556\",\"gst\":\"123\",\"password\":\"123\"}";
		 String status=   given()
		         .header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		         .body(jsonBody)
		         .when()
		         .post("http://localhost:8001/registration").asString();
		       
		 assertEquals(status, "Added");

}
	@Test
	
public void sellerloginTest() throws Exception {
		
		String jsonBody="{\"email_id\":\"rohan@gmail.com\",\"password\":\"123\"}";
		 String status=   given()
		         .header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		         .body(jsonBody)
		         .when()
		         .post("http://localhost:8001/login").asString();
	
		 String actual=utils.extractUsername(status);
		  assertEquals(actual, "rohan@gmail.com");
}

	}


