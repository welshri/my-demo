package org.welshri.acceptance;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.junit.Assert;
import org.junit.Test;

/**
 * Some smoke testing functionality intended to be executed against a running environment.
 * @author richard
 *
 */
public class EmployeeRestControllerTest {
	
	public static final String LOCAL_URL = "http://localhost:8080/employee/";
	
	@Test
	public void addEmployee() {
		
		try {
			String uri = "addEmployee?firstName=Elizabeth&lastName=Regina&employeeNumber=1&jobDescription=Queen";
			Content content = Request.Get(LOCAL_URL + uri).execute().returnContent();
			String response = content.asString();
			//String expect = "{\"firstName\":\"Elizabeth\",\"lastName\":\"Regina\",\"employeeNumber\":1,\"jobDescription\":\"Queen\"}";
			Assert.assertEquals("1", response);
			System.out.println(response);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Assert.fail(e.toString());
		}
	}
	
	/**
	 *  Assumes that the first test has run successfully thus adding the Queen
	 */
	@Test
	public void getEmployee() {
		try {
			String uri = "1";
			Content content = Request.Get(LOCAL_URL + uri).execute().returnContent();
			String response = content.asString();
			String expect = "{\"firstName\":\"Elizabeth\",\"lastName\":\"Regina\",\"employeeNumber\":1,\"jobDescription\":\"Queen\"}";
			Assert.assertEquals(expect, response);
			System.out.println(response);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Assert.fail(e.toString());
		}
	}
	
	/**
	 *  Assumes that the first test has run successfully thus adding the Queen
	 */
	@Test
	public void getEmployeeCount() {
		try {
			String uri = "count?firstName=Elizabeth";
			Content content = Request.Get(LOCAL_URL + uri).execute().returnContent();
			String response = content.asString();
			String expect = "1";
			Assert.assertEquals(expect, response);
			System.out.println(response);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Assert.fail(e.toString());
		}
		
		try {
			String uri = "count?firstName=SuchANameThatNoOneWouldEverUse";
			Content content = Request.Get(LOCAL_URL + uri).execute().returnContent();
			String response = content.asString();
			String expect = "0";
			Assert.assertEquals(expect, response);
			System.out.println(response);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Assert.fail(e.toString());
		}
	}

}
