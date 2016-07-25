package com.tracfone.jsoup;

import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class FirstJsoupExample{  
    public static void main( String[] args ) throws IOException{  
                Document doc = Jsoup.connect("http://www.straighttalk.com/").get();
                String title = doc.title();  
                System.out.println("title is: " + title); 
                Elements links = doc.select("a[href]");  
                for (Element link : links) {  
                    System.out.println("\nlink : " + link.attr("href"));  
                    System.out.println("text : " + link.text());  
                }  
                
              //  Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");  
               /* for (Element image : images) {  
                    System.out.println("src : " + image.attr("src"));  
                    System.out.println("height : " + image.attr("height"));  
                    System.out.println("width : " + image.attr("width"));  
                    System.out.println("alt : " + image.attr("alt"));  
                }  
                */
              //  Elements ifcond = doc.select("if[*.*]");
              //  for(Element ifs : ifcond){
              //  	System.out.println(ifs.attr("if"));
              //  }
               /* 
                Elements forms = doc.getElementsByTag("form");
                for (Element form : forms) {
                    System.out.println(form.id());
                    System.out.println(form.tag());
                    
                    Attributes attributes = form.attributes();
                    for (Attribute attribute : attributes) {
                        System.out.println(attribute.toString());
                    }
                }*/
    }  
}  
