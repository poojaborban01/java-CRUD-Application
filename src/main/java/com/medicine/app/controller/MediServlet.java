package com.medicine.app.controller;

import com.medicine.app.entity.MediEntity;
import com.medicine.app.repository.MediRepo;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/medi")
public class MediServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. data lena form se
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));


        // 2. object banana
        MediEntity medi = new MediEntity(0, name, price, quantity);

        // 3. repo method call
        MediRepo.saveMedi(medi);

        // 4. response dena
        response.getWriter().println("Medicine Added");

    }



protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException
{
response.setContentType("application/json");
PrintWriter out = response.getWriter();

try
{
    int id = Integer.parseInt (request.getParameter("id"));

    MediEntity medi = MediRepo.fetchMedi(id);

    if(medi!=null) {
        out.println("{");
        out.println("\"id\":" + medi.getId() + ",");
        out.println("\"name\":\"" + medi.getName() + "\",");
        out.println("\"price\":" + medi.getPrice() + ",");
        out.println("}");
    }
    else {
        out.println("{\"message\":\"Medicine not found\"}");


    }
}

catch(Exception e)
{
    e.printStackTrace();
}
}
}
