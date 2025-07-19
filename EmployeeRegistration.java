package com.EmployeeAcess.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeRegistration")
public class EmployeeRegistration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String empId = request.getParameter("empId");
        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        long mobNo = Long.parseLong(phone);
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        int zip = Integer.parseInt(request.getParameter("zip"));
        String dept = request.getParameter("department");
        String designation = request.getParameter("designation");
        String qualification = request.getParameter("qualification");
        int exp = Integer.parseInt(request.getParameter("experience_years"));
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "root");

            PreparedStatement ps = c.prepareStatement(
                "INSERT INTO employees(emp_id, first_name, last_name, email, phone, gender, address, city, state, zip_code, department, designation, qualification, experience_years, password) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, empId);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, email);
            ps.setLong(5, mobNo);
            ps.setString(6, gender);
            ps.setString(7, address);
            ps.setString(8, city);
            ps.setString(9, state);
            ps.setInt(10, zip);
            ps.setString(11, dept);
            ps.setString(12, designation);
            ps.setString(13, qualification);
            ps.setInt(14, exp);
            ps.setString(15, password);

            ps.executeUpdate();
            c.close();

            response.getWriter().println("Employee registered successfully.");

        } catch (Exception e) {
            e.printStackTrace(); // Log the real error
            response.getWriter().println("Registration failed: " + e.getMessage());
        }
    }
}
