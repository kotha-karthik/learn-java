package com.iss.SoapStudent;

import jakarta.xml.ws.Endpoint;

public class StudentPublisher {
	public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/studentservice", new StudentServiceImpl());
        System.out.println("Student SOAP Service is running at http://localhost:8888/studentservice?wsdl");
    }
}
