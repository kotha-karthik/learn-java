package com.iss;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUpload")
@MultipartConfig()
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FileUploadServlet() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=getServletContext().getRealPath("")+File.separator+"images";
		System.out.println(path);
		File file=new File(path);
    	if(!file.exists())
    	{
    		file.mkdir();
    	}
    	
		Part filePart=request.getPart("file");
		InputStream fin=filePart.getInputStream();
		FileOutputStream fout=new FileOutputStream(path+"\\"+filePart.getSubmittedFileName());
		fout.write(fin.readAllBytes());
		fout.close();
		fin.close();
	}

}
