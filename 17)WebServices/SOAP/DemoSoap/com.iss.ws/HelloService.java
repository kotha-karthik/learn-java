package com.iss.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(
		name="HelloService",
		targetNamespace="https://example.com/hello"
		)
public interface HelloService 
{
	@WebMethod
	String sayHello(String name);

}
