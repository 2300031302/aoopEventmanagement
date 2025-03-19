package com.eventmgmt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/process-payment")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String card = request.getParameter("card");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String userId = "1"; // Simplified

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmgmt", "root", "password");
            String sql = "INSERT INTO payments (user_id, card, amount) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userId);
            stmt.setString(2, card);
            stmt.setDouble(3, amount);
            stmt.executeUpdate();
            conn.close();
            response.sendRedirect("dashboard.html");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Payment failed!");
        }
    }
}