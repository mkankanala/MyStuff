package org.springframework.gs_rest_service;

import org.springframework.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.customer.dao.CustomerDAO;
import com.mkyong.customer.model.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
        		new ClassPathXmlApplicationContext("./Spring-Customer.xml");
        	 
            CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
      //      Customer customer = new Customer(1, "mkyong",28);
     //       customerDAO.insert(customer);
        	
            Customer customer1 = customerDAO.findByCustomerId(2143829775);
            System.out.println(customer1);
    }
}
