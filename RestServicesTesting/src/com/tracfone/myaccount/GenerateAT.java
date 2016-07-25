package com.tracfone.myaccount;

import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;


public class GenerateAT {

	/**
	 * @param args
	 */
	
	private String at;
	private String encodeurl;
	private String encodeurl_loggedin;
	  Client client = Client.create();
	static {
	    disableSslVerification();
	}

	private static void disableSslVerification() {
	    try
	    {
	        // Create a trust manager that does not validate certificate chains
	        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
	            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }
	            public void checkClientTrusted(X509Certificate[] certs, String authType) {
	            }
	            public void checkServerTrusted(X509Certificate[] certs, String authType) {
	            }
	        }
	        };

	        // Install the all-trusting trust manager
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	        // Create all-trusting host name verifier
	        HostnameVerifier allHostsValid = new HostnameVerifier() {
	            public boolean verify(String hostname, SSLSession session) {
	                return true;
	            }
	        };

	        // Install the all-trusting host verifier
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (KeyManagementException e) {
	        e.printStackTrace();
	    }
	}
	public static void main(String[] args) {
	
		
		
		GenerateAT client = new GenerateAT();	

client.generateToken();

client.generateTokenforRegisteredUser();
//client.createAccount();
//client.locationService();
//client.getAccountDetails();
client.getSecurityQuestions();


	}
	
	private void getSecurityQuestions() {
		WebResource webResource = client
				.resource("https://sit1api.tracfone.com/pep/getSecurityQuestions/?brandName=SIMPLE_MOBILE&clientAppName=IOS&clientAppVersion=1.0&deviceModel=IOS&OSVersion=8&language=ENG");
		String input = "";
		WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON);
 		builder.type(MediaType.APPLICATION_JSON);
 		builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + encodeurl_loggedin);
 		 ClientResponse response=	builder.get(ClientResponse.class);
 		 if (response.getStatus() != 200) {
           	System.out.println(response.getStatus());
               throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
           }
          				
           String output = response.getEntity(String.class);
     
           System.out.println("\n============getResponse============");
           System.out.println(output);
		
	}
	private void getAccountDetails() {
		WebResource webResource = client
				.resource("https://sit1api.tracfone.com/pep/getAccountDetails/581034742?brandName=SIMPLE_MOBILE&clientAppName=IOS&clientAppVersion=1.0&deviceModel=IOS&OSVersion=8&language=ENG");
		String input = "";
		WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON);
 		builder.type(MediaType.APPLICATION_JSON);
 		builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + encodeurl_loggedin);
 		 ClientResponse response=	builder.get(ClientResponse.class);
 		 if (response.getStatus() != 200) {
           	System.out.println(response.getStatus());
               throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
           }
          				
           String output = response.getEntity(String.class);
     
           System.out.println("\n============getResponse============");
           System.out.println(output);
		
	}
	private void locationService() {
		WebResource webResource = client
				.resource("https://sit1api.tracfone.com/pep/getAccountDetails/581034742?brandName=SIMPLE_MOBILE&clientAppName=IOS&clientAppVersion=1.0&deviceModel=IOS&OSVersion=8&language=ENG");
		String input = "";
		WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON);
 		builder.type(MediaType.APPLICATION_JSON);
 		builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + encodeurl_loggedin);
 		 ClientResponse response=	builder.get(ClientResponse.class);
 		 if (response.getStatus() != 200) {
           	System.out.println(response.getStatus());
               throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
           }
          				
           String output = response.getEntity(String.class);
     
           System.out.println("\n============getResponse============");
           System.out.println(output);
		
	}
	private void createAccount() {
		WebResource webResource = client
				.resource("https://sit1api.tracfone.com/pep/validateUserDevice/esn/100000004082235?brandName=NET10&clientAppName=IOS&clientAppVersion=1&deviceModel=IOS&OSVersion=8&language=ENG&sourceSystems=APP");
		String input = "";
		WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON);
 		builder.type(MediaType.APPLICATION_JSON);
 		builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + encodeurl);
 		 ClientResponse response=	builder.get(ClientResponse.class);
 		 if (response.getStatus() != 200) {
           	System.out.println(response.getStatus());
               throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
           }
          				
           String output = response.getEntity(String.class);
     
           System.out.println("\n============getResponse============");
           System.out.println(output);
	}
	private void generateToken() {
		
		  WebResource webResource = client.resource("https://sit1api.tracfone.com/oauth/cc");
          String input = "grant_type=client_credentials&scope=createNewAccount&client_id=NET10AppMyAcct_CCU&client_secret=abc123**&brandName=NET10&sourceSystem=WEB";
       //   client.addFilter(new HTTPBasicAuthFilter("5071b6b1-e715-4c2a-93e3-a352d81302b8", "X3oH5jW4cY1sC1nO6yO4aB3oA8oK8aT1cS0vT7cW7cB2dO1hG4"));
          ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).post(ClientResponse.class, input);
          if (response.getStatus() != 200) {
          	System.out.println(response.getStatus());
              throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
          }
         				
          String output = response.getEntity(String.class);
    
          System.out.println("\n============getResponse============");
    //      System.out.println(output);
         try{ 
          JSONObject json  = new JSONObject(output);
 
         System.out.println(json.get("access_token"));
         this.at= (String) json.get("access_token");
         encodeurl= URLEncoder.encode(at, "UTF-8");
         System.out.println("ENCODED: "+ encodeurl);
         }catch(Exception e){
        	 e.printStackTrace();
         }
	}
	
	private void generateTokenforRegisteredUser() {
		  WebResource webResource = client.resource("https://sit1api.tracfone.com/oauth/ro");
          String input = "grant_type=password&username=SM5142015131221@SM.com&password=123456&scope=calculatePurchaseTax&client_id=SMAppMyAcct_RO&client_secret=abc123**&brandName=SIMPLE_MOBILE&sourceSystem=APP";
      //    client.addFilter(new HTTPBasicAuthFilter("abc@nt.com", "PjJ2eKFf"));
          ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
          if (response.getStatus() != 200) {
          	System.out.println(response.getStatus());
              throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
             
          }
         				
          String output = response.getEntity(String.class);
    
          System.out.println("\n============getResponse============");
    //      System.out.println(output);
         try{ 
          JSONObject json  = new JSONObject(output);
 
         System.out.println(json.get("access_token"));
         this.at= (String) json.get("access_token");
         encodeurl_loggedin= URLEncoder.encode(at, "UTF-8");
         System.out.println("ENCODED: "+ encodeurl_loggedin);
         }catch(Exception e){
        	 e.printStackTrace();
         }
		
	}

}
