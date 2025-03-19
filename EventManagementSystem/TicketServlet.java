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

@WebServlet("/buy-ticket")
public class TicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventId = request.getParameter("eventId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String userId = "1"; // Simplified

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmgmt", "root", "password");
            String sql = "INSERT INTO tickets (user_id, event_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userId);
            stmt.setString(2, eventId);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();
            conn.close();
            response.sendRedirect("ticket.html"); // Redirect to confirmation
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Purchase failed!");
        }
    }
}