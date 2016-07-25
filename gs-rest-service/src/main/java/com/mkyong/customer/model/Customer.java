package com.mkyong.customer.model;

public class Customer {

	public Customer(int custId, String name,int age){
	this.custId=custId;
	this.name=name;
	this.age=age;
	}
		
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	int custId;
	String name;
	int age;
	//getter and setter methods
}
