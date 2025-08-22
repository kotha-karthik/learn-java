package com.iss.client;

import com.example.client.stub.HelloService;
import com.example.client.stub.HelloService_Service;

public class StubClient 
{
	public static void main(String args[])
	{
		HelloService_Service service=new HelloService_Service();
		HelloService port=service.getHelloPort();
		String response=port.sayHello("karthik");
		System.out.println(response);
	}
	
}
