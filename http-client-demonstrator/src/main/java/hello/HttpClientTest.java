package hello;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpClientTest {

 public static void main(String args[]) throws Exception {
	 HttpClientTest httpClientTest = new HttpClientTest();
	 //httpClientTest.hitBasicRestDemonstrator();
 }
 
 private void hitBasicRestDemonstrator() throws HttpException, IOException {
     HttpClient client = new HttpClient();
     //GetMethod method = new GetMethod("http://localhost:8080/rest/employee");
     GetMethod method = new GetMethod("http://localhost:8080/greeting?name=Some_Spring_MVC");
     int returnCode = client.executeMethod(method);
     System.err.println(method.getResponseBodyAsString());
     method.releaseConnection();
 }
 
 private void hitOverClockers() throws HttpException, IOException {
     HttpClient client = new HttpClient();
     //GetMethod method = new GetMethod("http://localhost:8080/rest/employee");
     GetMethod method = new GetMethod("https://www.overclockers.co.uk/pc-components/processors/intel/socket-1151-kaby-lake?sPage=1&sSort=3");
     int returnCode = client.executeMethod(method);
     System.err.println(method.getResponseBodyAsString());
     method.releaseConnection();
 }
 
}
           
    