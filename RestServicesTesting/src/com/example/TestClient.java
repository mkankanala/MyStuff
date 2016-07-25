package com.example;



import org.apache.axis.client.Service;
import org.apache.axis.client.Call;
import org.apache.axis.message.SOAPBody;
import org.apache.axis.message.SOAPBodyElement;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.types.Name;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Iterator;

import javax.xml.soap.SOAPElement;


public class TestClient {
   public static String wsURL =
           "http://dp-sita-soa3.tracfone.com:9001/B2B/IVR_API?WSDL";

   public static String  mySoapRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mes=\"http://www.ibm.com/telecom/v8.5.0/businessobject/system/sid-v12.5/messageview\"  xmlns:ret=\"http://TPCRMAI/AIS/RetrieveProductOfferingDetails\" xmlns:com=\"http://www.ibm.com/telecom/v8.5.0/businessobject/system/sid-v12.5/common\">\n   <soapenv:Header xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n      <wsse:Security soap:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n         <wsse:UsernameToken wsu:Id=\"unt_dymtpxyv7NS1BCB4\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n            <wsse:Username>webuser</wsse:Username>\n            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">t!n43p2b</wsse:Password>\n         </wsse:UsernameToken>\n      </wsse:Security>\n   </soapenv:Header>\n    <soapenv:Body>\n         <mes:retrieveProductOfferingDetailsInput>\n            <!--Optional:-->\n            <Header>\n               <!--Optional:-->\n               <com:CorrelationId_T>11111</com:CorrelationId_T>\n               <!--Optional:-->\n               <com:ActivityName_T>ProductOfferingRequest</com:ActivityName_T>\n               <!--Optional:-->\n               <com:MsgType_T>retrieveProductOfferingDetailsInput</com:MsgType_T>\n               <!--Optional:-->\n               <com:Source>IVR</com:Source>\n               <!--Optional:-->\n               <com:MessageId>867423423i4hn238947s</com:MessageId>\n               <!--Optional:-->\n               <com:Timestamp>2015-05-12T19:06:50</com:Timestamp>\n               <!--Zero or more repetitions:-->\n\t\t\t <com:MessageProp_T>\n               <!--Optional:-->\n               <com:name>LANGUAGE</com:name>\n               <!--Optional:-->\n               <com:Value>\n                  <!--Optional:-->\n                  <com:value>ENG</com:value>\n               </com:Value>\n            </com:MessageProp_T>\n\t\t\t     <!--Zero or more repetitions:-->\n               <com:ConsumerInfo>\n                  <com:name>BrandName</com:name>\n                  <com:Value>\n                     <com:value>NET10</com:value>\n                  </com:Value>\n               </com:ConsumerInfo>\n               <com:ConsumerInfo>\n                  <com:name>Channel</com:name>\n                  <com:Value>\n                     <com:value>IVR</com:value>\n                  </com:Value>\n               </com:ConsumerInfo>\n            </Header>\n            <!--Optional:-->\n            <Payload>\n               <!--Optional:-->\n               <com:SearchCriteria>\n                  <!--Zero or more repetitions:-->\n                  <com:Entities>\n                     <!--Optional:-->\n                     <com:ID>\n                        <!--Optional:-->\n                        <com:ID>100000000013428045</com:ID>\n                        <!--Optional:-->\n                        <com:name>ESN</com:name>\n                     </com:ID>\n                  </com:Entities>\n               </com:SearchCriteria>\n            </Payload>\n         </mes:retrieveProductOfferingDetailsInput>\n       </soapenv:Body>\n</soapenv:Envelope>";
   
 //mySoapRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mes=\"http://www.ibm.com/telecom/v8.5.0/businessobject/system/sid-v12.5/messageview\" xmlns:com=\"http://www.ibm.com/telecom/v8.5.0/businessobject/system/sid-v12.5/common\">\n   <soapenv:Header xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n      <wsse:Security soap:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n         <wsse:UsernameToken wsu:Id=\"unt_dymtpxyv7NS1BCB4\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n            <wsse:Username>webuser</wsse:Username>\n            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">t!n43p2b</wsse:Password>\n         </wsse:UsernameToken>\n      </wsse:Security>\n   </soapenv:Header>\n   <soapenv:Body>\n      <mes:ruleEngineRequest>\n         <!--Optional:-->\n         <Header>\n            <!--Optional:-->\n            <com:CorrelationId_T>12345678</com:CorrelationId_T>\n            <!--Optional:-->\n            <com:ActivityName_T>CheckESNValidation</com:ActivityName_T>\n            <!--Optional:-->\n            <com:MsgType_T>checkValidationRequest</com:MsgType_T>\n            <!--Optional:-->\n            <com:Source>IVR</com:Source>\n            <!--Optional:-->\n            <com:MessageId>867423423i4hn238947s</com:MessageId>\n            <!--Optional:-->\n            <com:Timestamp>2015-05-12T19:06:50</com:Timestamp>\n            <!--Zero or more repetitions:-->\n            <com:MessageProp_T>\n               <!--Optional:-->\n               <com:name>LANGUAGE</com:name>\n               <!--Optional:-->\n               <com:Value>\n                  <!--Optional:-->\n                  <com:value>ENG</com:value>\n               </com:Value>\n            </com:MessageProp_T>\n            <!--Zero or more repetitions:-->\n            <com:ConsumerInfo>\n               <!--Optional:-->\n               <com:name>BrandName</com:name>\n               <!--Optional:-->\n               <com:Value>\n                  <!--Optional:-->\n                  <com:value>NET10</com:value>\n               </com:Value>\n            </com:ConsumerInfo>\n            <!--Zero or more repetitions:-->\n            <com:ConsumerInfo>\n               <!--Optional:-->\n               <com:name>Channel</com:name>\n               <!--Optional:-->\n               <com:Value>\n                  <!--Optional:-->\n                  <com:value>IVR</com:value>\n               </com:Value>\n            </com:ConsumerInfo>\n         </Header>\n         <!--Optional:-->\n         <Payload>\n            <!--Optional:-->\n            <com:SearchCriteria>\n               <!--Zero or more repetitions:-->\n               <com:Entities>\n                  <!--Optional:-->\n                  <com:ID>\n                     <!--Optional:-->\n                     <com:ID>ESNVALIDATION</com:ID>\n                     <!--Optional:-->\n                     <com:name>RULESCENARIO</com:name>\n                  </com:ID>\n                  <!--Zero or more repetitions:-->\n                  <com:CharacteristicSpecification>\n                     <!--Optional:-->\n                     <com:name>VALIDATIONRULE</com:name>\n                     <!--Optional:-->\n                     <com:Value>\n                        <!--Optional:-->\n                        <com:value>IVRPURCHASE</com:value>\n                     </com:Value>\n                  </com:CharacteristicSpecification>\n               </com:Entities>\n            </com:SearchCriteria>\n            <!--Optional:-->\n            <com:FilterCriteria>\n               <!--Zero or more repetitions:-->\n               <com:Entities>\n                  <!--Optional:-->\n                  <com:ID>\n                     <!--Optional:-->\n                     <com:ID>3053426879</com:ID>\n                     <!--Optional:-->\n                     <com:name>MIN</com:name>\n                  </com:ID>\n               </com:Entities>\n            </com:FilterCriteria>\n         </Payload>\n      </mes:ruleEngineRequest>\n   </soapenv:Body>\n</soapenv:Envelope>";
   
  public static void test() throws Exception {
       InputStream input = new ByteArrayInputStream(mySoapRequest.getBytes());
       Service service = new Service();
       Call call = (Call)service.createCall();
       
       SOAPEnvelope soapEnvelope = new SOAPEnvelope(input);
       call.setTargetEndpointAddress(new URL(wsURL));
       call.setUseSOAPAction(true);
       System.out.println("Request:\n"+ mySoapRequest);
       soapEnvelope = call.invoke(soapEnvelope);

      
    SOAPBody soabody = (SOAPBody) soapEnvelope.getBody();
  //  System.out.println(soabody.toString());
    
 
    
       System.out.println("Response:\n" + soapEnvelope.toString());
   }

   public static void main(String args[]) throws Exception {
       TestClient callClient = new TestClient();
       callClient.test();
   }
}