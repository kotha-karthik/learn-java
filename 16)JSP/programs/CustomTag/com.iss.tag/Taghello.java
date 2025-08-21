package com.iss.tag;


import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class Taghello extends TagSupport{
	private String sname;
	public void setName(String sname)
	{
		this.sname=sname;
	}
	
	public int doStartTag() throws JspException {  
		JspWriter out=pageContext.getOut();  
		try{  
				out.print("Hello welcome to custom tag   "+sname);
				
		}catch(Exception e){System.out.println(e);}  
		return SKIP_BODY; 
	} 

}
