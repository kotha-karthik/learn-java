package com.iss.ws;

import jakarta.xml.ws.Endpoint;

public class HelloPublisher {

	public static void main(String[] args) {
		String url="http://localhost:8888/ws/hello";
		Endpoint.publish(url, new HelloServiceImpl());
		System.out.println("SOAP service running at"+ url +"?wsdl");
		System.out.println("Press ctrl+c to Stop");

	}

}
