package com.tracfone.jsoup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Parse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Parse parse = new Parse();
		parse.parseXml();

	}
	
	
	public void parseXml(){

		
		InputStream is = null;
		try {
			is = new FileInputStream("C://X_Drive//projects//RestServicesTesting//bin//product1.xml");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	//	System.out.println(is.toString());
		InputSource inputSource = new InputSource(is);

		XPath xpath = XPathFactory.newInstance().newXPath();
	
		HashMap<String, String> prefMap = new HashMap<String, String>() {{
		  //  put("ns9", "http://dp-sita-soa3.tracfone.com/IVR_APIWsdl");
		  //  put("ns10", "http://dp-sita-soa3.tracfone.com/IVR_APIWsdl");
		  //  put("", "http://dp-sita-soa3.tracfone.com/IVR_APIWsdl");
		    put("ns9", "http://www.ibm.com/telecom/v8.5.0/businessobject/system/sid-v12.5/systemview");
		 
		    put("ns10", "http://www.ibm.com/telecom/v8.5.0/businessobject/system/sid-v12.5/common");
		}};
		SimpleNamespaceContext namespaces = new SimpleNamespaceContext(prefMap);
		xpath.setNamespaceContext(namespaces);
		
	//	String expression1 = "/country/networks/network/@name";
	//	String expression = "//ns9:ProductPrice/ns9:regularPrice/ns9:amount|//ns9:ProductAttributes/ns10:name|//ns9:ProductAttributes/ns10:Value/ns10:value|//ns9:ProductSpecification/ns10:id";
		String expression = "//ns9:ProductPrice/ns9:regularPrice/ns9:amount | //ns9:ProductAttributes/ns10:name";
		NodeList names = null;
		try {
			names = (NodeList) xpath.evaluate(expression, inputSource, XPathConstants.NODESET);
		//	Node node = 
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < names.getLength(); i++) {
		  System.out.println(names.item(i).getTextContent());
		}
	/*	
		for (int i = 0; i < names.getLength(); i++) {
            Node node = names.item( i );
            String nodeName = node.getNodeName();
            String nodeValue = node.getChildNodes().item( 0 ).getNodeValue();


            if( nodeName.equals( "name" ) ) {
                        System.out.println(nodeValue);
            } 
          
}*/
	}

}
