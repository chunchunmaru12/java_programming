/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dav.edu.servletdemo.example;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author DELL
 */
public class FirstServlet implements Servlet {
    ServletConfig sc;
    @Override
    public void init(ServletConfig sc) throws ServletException {
        System.out.println("Servlet is running");
        this.sc=sc;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.sc;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        PrintWriter out=res.getWriter();
        res.setContentType("text/html");
        out.println("<!DOCTYPE html><head><title>Servlet Demo</title></head>"
                + "<body><h1>Hello World</h1></body></html>");
        out.close();
    }

    @Override
    public String getServletInfo() {
        return "First Servlet Program";
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
