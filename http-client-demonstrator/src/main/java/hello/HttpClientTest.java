package hello;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpClientTest {

 public static void main(String args[]) throws Exception {
      HttpClient client = new HttpClient();
      //GetMethod method = new GetMethod("http://localhost:8080/rest/employee");
      GetMethod method = new GetMethod("http://localhost:8080/greeting?name=Some_Spring_MVC");
      int returnCode = client.executeMethod(method);
      System.err.println(method.getResponseBodyAsString());
      method.releaseConnection();
 }
}
           
    