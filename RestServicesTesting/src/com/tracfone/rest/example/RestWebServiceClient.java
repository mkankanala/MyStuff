package com.tracfone.rest.example;


import javax.net.ssl.*;

import java.net.URI;
import java.net.URLEncoder;
import java.security.*;
import java.security.cert.*;
import java.io.*;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;


public class RestWebServiceClient {

	private static final URI CATALOG_URL = null;
	private String encodeUrl;
	private String orderurl;
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
	
 /**
  * @param args
  */
	
 public static void main(String[] args) {
  RestWebServiceClient client = new RestWebServiceClient();
//  client.generateOauthToken();
//  client.runCurl();


//	client.runCurl1();

  client.sayHello();
// client.sayHello2();
 // client.sayHello3();
 // client.sayHello4();
 // client.getMessage("Welcome");
 // client.getXMLEmployees();
//  client.getXMLEmployee(11111);
//  client.getJSONEmployees();
 // client.getJSONEmployee(11111);
 
 }
 
 private void sayHello() {
	  try {
		  //http://www.webservicex.net/uszip.asmx/GetInfoByCity?USCity=MIAMI
		  //http://weather.yahooapis.com/forecastrss?p=33178
		  //http://api.zippopotam.us/us/90210
	            Client client = Client.create();
	            client.addFilter(new LoggingFilter(System.out));
	     //       client.addFilter(new HTTPBasicAuthFilter("", ""));
	          /*  WebResource webResource = client.resource("https://sitapi.tracfone.com/oauth/cc");
	            String input = "grant_type=client_credentials&client_id=QualityOne_CCU&client_secret=abc123**&sourceSystem=WEB&scope=login&brandName=NET10";*/
	        //   WebResource webResource = client.resource("https://sit-apigateway.tracfone.com/api/sitci/customer-mgmt/oauth/token");
	        //    String input = "grant_type=client_credentials&scope=/customer-mgmt";
	         //   WebResource webResource = client.resource("https://sit-apigateway.tracfone.com/api/sitci/order-mgmt/oauth/token");
	          // String input= "grant_type=client_credentials&scope=/order-mgmt";
	               WebResource webResource = client.resource("https://sit-apigateway.tracfone.com/api/sitci/service-qualification-mgmt/oauth/token");
		          String input= "grant_type=client_credentials&scope=/service-qualification-mgmt";
	        
	            client.addFilter(new HTTPBasicAuthFilter("5071b6b1-e715-4c2a-93e3-a352d81302b8", "K2eI8pQ8bU2xI8aY0eI1fF7iH2yB4cM0dH8oL5pG2sX3yD0tK0"));
	  
	            //   		System.out.println(input);
	         //   customer-mgmt
	            //    HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("user", "superSecretPassword");
	        //    ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	            
	            ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).post(ClientResponse.class, input);
	            if (response.getStatus() != 200) {
	            	System.out.println(response.getStatus());
	                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
	            }
	           				
	            String output = response.getEntity(String.class);
	         //   output = "["+output+"]";
	            System.out.println("\n============getResponse============");
	            System.out.println(output);
	            
	            JSONObject json  = new JSONObject(output);
	       
	            
	        //    JSONArray jsonarr= json.getJSONArray("places");
	       //     String address = jsonarr.getJSONObject(0).getString("place name");
	       //    System.out.println(json.get("post code"));
	       //    System.out.println(json.get("country"));
	           System.out.println(json.get("access_token"));
	           String at= (String) json.get("access_token");
	         encodeUrl =  URLEncoder.encode(at,"UTF-8");
	           
	      
	  response = webResource.accept(MediaType.APPLICATION_XML).post(ClientResponse.class, input);
	         if (response.getStatus() != 200) {
	         	System.out.println(response.getStatus());
	             throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
	         }
	        				
	         output = response.getEntity(String.class);
	      //   output = "["+output+"]";
	         System.out.println("\n============getResponse============");
	         System.out.println(output);
	         
	       json  = new JSONObject(output);
	    
	         
	     //    JSONArray jsonarr= json.getJSONArray("places");
	    //     String address = jsonarr.getJSONObject(0).getString("place name");
	    //    System.out.println(json.get("post code"));
	    //    System.out.println(json.get("country"));
	        System.out.println(json.get("access_token"));
	        String at1= (String) json.get("access_token");
	      orderurl =  URLEncoder.encode(at,"UTF-8");
	          
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
 private void sayHello2() {
     Client client = Client.create();
//       client.addFilter(new HTTPBasicAuthFilter("", ""));
     WebResource webResource = client.resource("https://sit1api.tracfone.com/pep/vouchers/accessToken/");
     String input = "{\"common\": {\"brandName\": \"NET10\",\"language\": \"ENG\",\"sourceSystem\": \"QUALITYONE\"},\"request\": {\"subscriberId\": \"58ed8223-49bf-4aca-91f1-e12c05941b1c\",\"programType\": \"UPGRADE_PLANS\",\"benefitType\": \"UPGRADE_BENEFITS\"}}";
     	//	System.out.println(input);
     	
     		WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON);
     		builder.type(MediaType.APPLICATION_JSON);
     		builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + encodeUrl);
     		 ClientResponse response=	builder.post(ClientResponse.class, input);
 //    ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON)post(ClientResponse.class, input);
     if (response.getStatus() != 200) {
     	System.out.println(response.getStatus());
         throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
     }
    				
     String output = response.getEntity(String.class);
     System.out.println("\n============getResponse============");
     System.out.println(output);
     
	
}

 
 private void sayHello3() {
     Client client = Client.create();
//       client.addFilter(new HTTPBasicAuthFilter("", ""));
     WebResource webResource = client.resource("https://sit-apigateway.tracfone.com/api/sitci/customer-mgmt/v1/customer?client_id=5071b6b1-e715-4c2a-93e3-a352d81302b8");
		String input = "{\n  \"relatedParties\" : [ {\n      \"party\" : {\n        \"individual\" : {\n          \"firstName\" : \"James\",\n          \"lastName\" : \"Mathews\"\n        }\n      },\n      \"roleType\" : \"customer\"\n  }, {\n      \"party\" : {\n        \"partyID\" : \"WALMART\",\n        \"partyExtension\" : [ {\n          \"name\" : \"partyTransactionID\",\n          \"value\" : \"1231234234424\"\n        } ]\n      },\n      \"roleType\" : \"partner\"\n  } ],\n  \"customerAccounts\" : [ {\n    \"customerProducts\" : [ {\n      \"product\" : {\n        \"productSerialNumber\" : \"100000000013247522\",\n        \"productCategory\" : \"HANDSET\",\n        \"productSpecification\" : {\n          \"brand\" : \"TOTAL_WIRELESS\"\n        }\n      }\n    } ],\n    \"customerAccountExtension\" : [ {\n      \"name\" : \"partySecret\",\n      \"value\" : \"1234\"\n    },\n    {\n      \"name\" : \"sourceSystem\",\n      \"value\" : \"WARP\"\n    },\n    \n    \n    {\n      \"name\" : \"password\",\n      \"value\" : \"myPassword\"\n    }, {\n      \"name\" : \"What was the name of your first boyfriend/girlfriend?\",\n      \"value\" : \"John\",\n      \"type\" : \"securityQuestion\"\n    }, {\n      \"name\" : \"canTracfonePartnersContactYou\",\n      \"value\" : \"true\"\n    } ]\n  } ],\n  \"contactMedium\" : [ {\n    \"contactDetails\" : [ {\n      \"city\" : \"Miami\",\n      \"country\" : \"USA\",\n      \"emailAddress\" : \"d6mail124@gmail.com\",\n      \"stateOrProvince\" : \"FL\",\n      \"street1\" : \"Street Address Line 1\",\n      \"street2\" : \"Street Address Line 2\",\n      \"postcode\" : \"33178\"\n    } ],\n    \"telephoneNumber\" : [ \"5689713334\" ]\n  } ]\n}\n";
		// System.out.println(input);
		
     		WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON);
     		builder.type(MediaType.APPLICATION_JSON);
     		builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + encodeUrl);
     		 ClientResponse response=	builder.post(ClientResponse.class, input);
     		
 //    ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON)post(ClientResponse.class, input);
     if (response.getStatus() != 200) {
     	System.out.println(response.getStatus());
         throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
     }
    				
     String output = response.getEntity(String.class);
     System.out.println("\n============getResponse============");
     System.out.println(output);
     
	
}
 
 
 private void sayHello4() {
     Client client = Client.create();
//       client.addFilter(new HTTPBasicAuthFilter("", ""));
     WebResource webResource = client.resource("https://sit-apigateway.tracfone.com/api/sitci/customer-mgmt/v1/customer?client_id=5071b6b1-e715-4c2a-93e3-a352d81302b8");
		String input = "{\n  \"relatedParties\" : [ {\n      \"party\" : {\n        \"individual\" : {\n          \"firstName\" : \"James\",\n          \"lastName\" : \"Mathews\"\n        }\n      },\n      \"roleType\" : \"customer\"\n  }, {\n      \"party\" : {\n        \"partyID\" : \"WALMART\",\n        \"partyExtension\" : [ {\n          \"name\" : \"partyTransactionID\",\n          \"value\" : \"1231234234424\"\n        } ]\n      },\n      \"roleType\" : \"partner\"\n  } ],\n  \"customerAccounts\" : [ {\n    \"customerProducts\" : [ {\n      \"product\" : {\n        \"productSerialNumber\" : \"100000000013247522\",\n        \"productCategory\" : \"HANDSET\",\n        \"productSpecification\" : {\n          \"brand\" : \"TOTAL_WIRELESS\"\n        }\n      }\n    } ],\n    \"customerAccountExtension\" : [ {\n      \"name\" : \"partySecret\",\n      \"value\" : \"1234\"\n    },\n    {\n      \"name\" : \"sourceSystem\",\n      \"value\" : \"WARP\"\n    },\n    \n    \n    {\n      \"name\" : \"password\",\n      \"value\" : \"myPassword\"\n    }, {\n      \"name\" : \"What was the name of your first boyfriend/girlfriend?\",\n      \"value\" : \"John\",\n      \"type\" : \"securityQuestion\"\n    }, {\n      \"name\" : \"canTracfonePartnersContactYou\",\n      \"value\" : \"true\"\n    } ]\n  } ],\n  \"contactMedium\" : [ {\n    \"contactDetails\" : [ {\n      \"city\" : \"Miami\",\n      \"country\" : \"USA\",\n      \"emailAddress\" : \"d6mail124@gmail.com\",\n      \"stateOrProvince\" : \"FL\",\n      \"street1\" : \"Street Address Line 1\",\n      \"street2\" : \"Street Address Line 2\",\n      \"postcode\" : \"33178\"\n    } ],\n    \"telephoneNumber\" : [ \"5689713334\" ]\n  } ]\n}\n";
		// System.out.println(input);
		
     		WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON);
     		builder.type(MediaType.APPLICATION_JSON);
     		builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + encodeUrl);
     		 ClientResponse response=	builder.post(ClientResponse.class, input);
     		
 //    ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON)post(ClientResponse.class, input);
     if (response.getStatus() != 200) {
     	System.out.println(response.getStatus());
         throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
     }
    				
     String output = response.getEntity(String.class);
     System.out.println("\n============getResponse============");
     System.out.println(output);
     
	
}




private void runCurl1() throws IOException, InterruptedException  {
	// String username="myusername";
	//    String password="mypassword";
	//    String url="https://www.example.com/xyz/abc";
	       String command ="curl -v -u 84059b0e-3394-4435-ba16-48ad6bb71579:I8bI5rT7bM4oC2aY4kF5cD0cY4rP7bB6yN7jC3iE0fE2pS1tR5 -k -X POST -d {} \"https://sit-apigateway.tracfone.com/api/dev/v1/orderManagement/oauth/token?grant_type=client_credentials&scope=/v1/orderManagement";
	        ProcessBuilder process = new ProcessBuilder(command); 
	        process.redirectErrorStream(true);
	        Process p;
	        try
	        {
	            p = process.start();
	             BufferedReader reader =  new BufferedReader(new InputStreamReader(p.getInputStream()));
	                StringBuilder builder = new StringBuilder();
	                String line = null;
	                while ( (line = reader.readLine()) != null) {
	                        builder.append(line);
	                        builder.append(System.getProperty("line.separator"));
	                }
	                String result = builder.toString();
	                System.out.print(result);
	                

	        }
	        catch (IOException e)
	        {   System.out.print("error");
	            e.printStackTrace();
	        }
	        
	      /*  Runtime rt = Runtime.getRuntime();
	        Process pr = rt.exec(command);*/
	      
 }

private void runCurl()  {
	 
	 OAuthClientRequest request;
	 String scope= "/v1/customerManagement";
	
	 System.out.println(scope);
	 
	 
	try {
		request = OAuthClientRequest
		         .tokenLocation("https://sit-apigateway.tracfone.com/api/dev/v1/customerManagement/oauth/token")
		         .setScope(scope)
		         .setGrantType(GrantType.CLIENT_CREDENTIALS)
		      //   .setUsername("84059b0e-3394-4435-ba16-48ad6bb71579")
			//	.setPassword("I8bI5rT7bM4oC2aY4kF5cD0cY4rP7bB6yN7jC3iE0fE2pS1tR5")
		    //     .setClientId("84059b0e-3394-4435-ba16-48ad6bb71579")
		     //  .setClientSecret("I8bI5rT7bM4oC2aY4kF5cD0cY4rP7bB6yN7jC3iE0fE2pS1tR5")
		         
		        // .buildBodyMessage();
		        .buildQueryMessage();
		
		System.out.println(request.getLocationUri());
		request.addHeader(OAuth.OAUTH_GRANT_TYPE, "client_credentials");
		 request.addHeader("Accept", "application/json");
     //   request.addHeader("Content-Type", "application/x-www-form-urlencoded");
	//	 request.addHeader(OAuth.OAUTH_USERNAME, "84059b0e-3394-4435-ba16-48ad6bb71579");
	//	 request.addHeader(OAuth.OAUTH_PASSWORD, "I8bI5rT7bM4oC2aY4kF5cD0cY4rP7bB6yN7jC3iE0fE2pS1tR5");
        request.addHeader(OAuth.OAUTH_CLIENT_ID, "84059b0e-3394-4435-ba16-48ad6bb71579");
         request.addHeader(OAuth.OAUTH_CLIENT_SECRET, "I8bI5rT7bM4oC2aY4kF5cD0cY4rP7bB6yN7jC3iE0fE2pS1tR5");
         //create OAuth client that uses custom http client under the hood
         OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

         //Facebook is not fully compatible with OAuth 2.0 draft 10, access token response is
         //application/x-www-form-urlencoded, not json encoded so we use dedicated response class for that
         //Custom response classes are an easy way to deal with oauth providers that introduce modifications to
         //OAuth 2.0 specification
         OAuthJSONAccessTokenResponse  oAuthResponse = null;
		try {
			oAuthResponse = oAuthClient.accessToken(request, OAuth.HttpMethod.POST);
		} catch (OAuthProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         String accessToken = oAuthResponse.getAccessToken();
        // String expiresIn = oAuthResponse.getExpiresIn();
	} catch (OAuthSystemException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 }
	private void generateOauthToken() {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("https://sit-apigateway.tracfone.com/api/dev/v1/orderManagement/oauth/token");
			String input = "grant_type=client_credentials&client_id=84059b0e-3394-4435-ba16-48ad6bb71579&client_secret=I8bI5rT7bM4oC2aY4kF5cD0cY4rP7bB6yN7jC3iE0fE2pS1tR5&scope=/v1/customerManagement";

			ClientResponse response = webResource.accept(
					MediaType.APPLICATION_XML)
					.post(ClientResponse.class, input);
			if (response.getStatus() != 200) {
				System.out.println(response.getStatus());
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}

			String output = response.getEntity(String.class);
			// output = "["+output+"]";
			System.out.println("\n============getResponse============");
			System.out.println(output);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

 private void getMessage(String msg) {
  try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8181/sdnext/doj/webservice/message/"+msg);
            ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
 
            String output = response.getEntity(String.class);
            System.out.println("\n============getCResponse============");
            System.out.println(output);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
 private void getXMLEmployees() {
  try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8181/sdnext/doj/webservice/employees");
            ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
 
            String output = response.getEntity(String.class);
            System.out.println("\n============getCResponse============");
            System.out.println(output);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 private void getXMLEmployee(int empid) {
  try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8181/sdnext/doj/webservice/employee/"+empid);
            ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
 
            String output = response.getEntity(String.class);
            System.out.println("\n============getCResponse============");
            System.out.println(output);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 private void getJSONEmployees() {
  try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8181/sdnext/doj/webservice/json/employees/");
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
 
            String output = response.getEntity(String.class);
            System.out.println("\n============getCResponse============");
            System.out.println(output);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 private void getJSONEmployee(int empid) {
  try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8181/sdnext/doj/webservice/json/employee/"+empid);
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
 
            String output = response.getEntity(String.class);
            System.out.println("\n============getCResponse============");
            System.out.println(output);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

