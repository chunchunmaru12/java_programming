/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dav.edu.servletdemo.example;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author DELL
 */
public class GenericServletExample extends GenericServlet {
    

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out=res.getWriter();
        res.setContentType("text/html");
        out.println("<!DOCTYPE html ><head><title>Generic Servlet Demo</title></head>"
                + "<body><h1>Hello World</h1></body></html>");
        out.close();
    
    }    
}
