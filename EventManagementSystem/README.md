# Event Management System

## Overview
A web-based application for managing events, user registrations, tickets, payments, notifications, and search functionality.

## Folder Structure
- `src/main/java/com/eventmgmt/`: Java servlets for backend logic.
- `webapp/`: HTML and CSS files for the frontend.
- `lib/`: External libraries (MySQL Connector, Gson).
- `sql/`: Database setup script.

## Setup Instructions
1. Install Apache Tomcat (e.g., version 9.x).
2. Set up MySQL and run `sql/database.sql` to create the database.
3. Copy `lib/` JAR files to Tomcat's `lib/` folder or include in project classpath.
4. Deploy the project to Tomcat by placing the folder in `webapps/`.
5. Access via `http://localhost:8080/EventManagementSystem/register.html`.

## Dependencies
- Java 8+
- MySQL 8.0+
- Apache Tomcat 9+
- MySQL Connector/J
- Gson

## Notes
- Update database credentials in servlet files (`root`, `password`).
- Ensure Tomcat is running on port 8080 (default).

Run `sql/database.sql` in MySQL to set up the database:
mysql -u root -p < sql/database.sql

Ensure `lib/gson-2.10.1.jar` is in the classpath or copied to Tomcat’s `lib/` folder.