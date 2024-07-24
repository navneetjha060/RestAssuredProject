package Tests;

import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class SOAP_API_Testing {

	@Test
	public void validateSoapAPI() throws IOException {

		File file = new File("C:\\Eclipse Workspace\\Rest_Assured_Demo\\src\\test\\resources\\Add.xml");

		if (file.exists()) {
			System.out.println("File is Present");
		}

		else {
			System.out.println("File is Not Present");
		}
		FileInputStream fis = new FileInputStream(file);

		String requestBody = org.apache.commons.io.IOUtils.toString(fis);

		System.out.println(requestBody);

		given().contentType("text/xml").accept(ContentType.XML).body(requestBody).when()
				.post("http://www.dneonline.com/calculator.asmx").then().statusCode(200).and()
				.body("//*[local-name()='AddResult'].text()", equalTo("5")).log().all();

	}

}
