package com.applet;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.*;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class SApplet extends Applet implements ActionListener {
   TextField input,output;
   Label label1,label2;
   Button b1;
   JLabel lbl;
   int num, sum = 0;
   private JTextArea t1, t2;
   Choice authType,appName;
   static {
		disableSslVerification();
	}

	public static void disableSslVerification() {
		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs,
						String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs,
						String authType) {
				}
			} };

			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());

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
   public void init(){
      label1 = new Label("What type of Auth token you want : ");
      add(label1);
      label1.setBackground(Color.yellow);
      label1.setForeground(Color.magenta);
      
     authType = new Choice();
      authType.add("Order Management");
      authType.add("Customer Management");
      authType.add("Service Management");
      
      appName = new Choice();
      appName.add("WARP");
      appName.add("ETAILER");
    
      
      add(authType);
     add(appName);
      b1 = new Button("Add");
      add(b1);
      b1.addActionListener(this);
      lbl = new JLabel("");
      lbl.setEnabled(true);
   //   add(lbl);
       t1 = new JTextArea("");
       add(t1);
       
      setBackground(Color.yellow);
   }
   public void actionPerformed(ActionEvent ae){
      try{
         String sType = authType.getSelectedItem();
         System.out.println(sType);
         Client client = Client.create();
 		client.addFilter(new HTTPBasicAuthFilter("5071b6b1-e715-4c2a-93e3-a352d81302b8", "K2eI8pQ8bU2xI8aY0eI1fF7iH2yB4cM0dH8oL5pG2sX3yD0tK0"));
 		client.addFilter(new LoggingFilter(System.out));
 		WebResource webResource = client.resource("https://sit-apigateway.tracfone.com/api/sitci/order-mgmt/oauth/token");

 		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class,"grant_type=client_credentials&scope=/order-mgmt");
 		if (response.getStatus() != 200) {
			System.out.println(response.getStatus());
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);

		JSONObject json;
		try {
			json = new JSONObject(output);
			String access_token = (String) json.get("access_token");
		//	lbl.setText(access_token);
			t1.setText(access_token);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      }
      catch(NumberFormatException e){
         lbl.setForeground(Color.red);
         lbl.setText("Invalid Entry!");
      }
   }  
   
   
   
}
