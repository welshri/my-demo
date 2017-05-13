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
public class BasicControllerTest {
	
	public static final String LOCAL_URL = "http://localhost:8080/basic/";
	
	@Test
	public void helloWorld() {
		
		try {
			Content content = Request.Get(LOCAL_URL).execute().returnContent();
			Assert.assertTrue(content.asString().equals("Hello World!"));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Assert.fail(e.toString());
		}
	}
	
	@Test
	public void helloPersonal() {
		
		try {
			Content content = Request.Get(LOCAL_URL + "personal?firstName=Bob").execute().returnContent();
			Assert.assertTrue(content.asString().equals("Hello Bob!"));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Assert.fail(e.toString());
		}
	}
	
	@Test
	public void helloPet() {
		
		try {
			Content content = Request.Get(LOCAL_URL + "pet/5555").execute().returnContent();
			Assert.assertTrue(content.asString().equals("Hello valued pet 5555!"));
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
