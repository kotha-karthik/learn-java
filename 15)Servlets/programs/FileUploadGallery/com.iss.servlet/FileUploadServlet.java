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
import java.io.PrintWriter;

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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>Upload Result</title>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("</head><body class='p-4'>");
		out.println("<div class='container'>");
		out.println("<h2>Image Uploaded Successfully</h2>");
		out.println("<h3 class='mt-4'>Image Gallery</h3>");
		out.println("<div class='row'>");

		File[] files = file.listFiles();
		if (files != null) {
			for (File img : files) {
				String name = img.getName();
				out.println("<div class='col-md-3 mb-3'>");
				out.println("<div class='card'>");
				out.println("<img src='images/" + name + "' class='card-img-top img-fluid' style='max-height:200px; object-fit:contain;'>");
				out.println("</div></div>");
			}
		}

		out.println("</div></div>");
		out.println("</body></html>");
	}
}
	
