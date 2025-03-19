package com.eventmgmt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/api/notifications")
public class NotificationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification("Event reminder: Tomorrow at 6 PM"));
        notifications.add(new Notification("Payment confirmed for Event X"));

        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(notifications));
    }
}

class Notification {
    String message;
    public Notification(String message) {
        this.message = message;
    }
}