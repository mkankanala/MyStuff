package com.applet;

import javax.swing.*;





import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class AuthApplet extends Applet implements ActionListener {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
TextField input,output;
   Label label1,label2;
   Button b1;
   JLabel lbl;
   int num, sum = 0;
   private JTextArea t1, t2;
   Choice authType,appName;
 /*  private ServiceUtil serviceUtil;
   public void setServiceUtil(ServiceUtil ServiceUtil) {
		this.serviceUtil = ServiceUtil;
	}*/
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
      add(lbl);
       t1 = new JTextArea("");
       add(t1);
       
      setBackground(Color.yellow);
   }
  
   public void actionPerformed(ActionEvent ae){
      try{
         String sType = authType.getSelectedItem();
         String aName = appName.getSelectedItem();
         System.out.println(sType);
         
    //    String access_token = serviceUtil.genAuthfor(aName, sType);
		//	lbl.setText(access_token);
		//	t1.setText(access_token);
		
      }
      catch(Exception e){
    	  e.printStackTrace();
         lbl.setForeground(Color.red);
         lbl.setText("Invalid Entry!");
      }
   }  
   
   
   
}
