package com.iss.ws;

import jakarta.jws.WebService;

@WebService(
		serviceName="HelloService",
		portName="HelloPort",
		endpointInterface="com.iss.ws.HelloService",
		targetNamespace="https://example.com/hello"
		)
public class HelloServiceImpl implements HelloService
{
	
	public String sayHello(String name)
	{
		return "Hello "+(name==null? "Stranger":name);
		
	}

}
