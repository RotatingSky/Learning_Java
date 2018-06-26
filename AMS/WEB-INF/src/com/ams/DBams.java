/**
 * FileName:    AmsDB.java
 * Copyright:   All by yourself
 */

package com.ams;

import java.sql.*;
import java.io.*;

/**
 * A class for Java linking MySQL database.
 * In shell, you should use .jar when compiling.
 * $ javac -cp ../lib/mysql-connect-java-8.0.11.jar; *.java
 * @author      Sny
 * @since       2018-06-12
 * @version     1.00
 */
public class DBams {
    // JDBC driver and URL of database
    // Old driver is "com.mysql.jdbc.Driver"
    static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/AMS?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "sn1379los";
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

    // Initialize driver
    public static void init() {
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Fail to initialize SQL JDBC driver!");
            e.printStackTrace();
        }
    }

    // Add, delete and update function
    public static int sqlADU(String sql) {
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            i = ps.executeUpdate();
        } catch (SQLException se) {
            System.out.println("Exception: add, delete or update the SQL datas error!");
            se.printStackTrace();
        }
        return i;
    }

    // Operate assignment_table
    public static int sqlAssignmentADU(String sql, Assignment assignment) {
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, assignment.getSubjectID());
            ps.setString(3, assignment.getTeacherID());
            ps.setString(4, assignment.getTeacherName());
            ps.setString(5, assignment.getFileName());
            ps.setDate(6, assignment.getSubDate());
            i = ps.executeUpdate();
        } catch (SQLException se) {
            System.out.println("Exception: operate assignment_table error!");
            se.printStackTrace();
        }
        return i;
    }

    // Operate submission_table
    public static int sqlSubmissionADU(String sql, Submission submission) {
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, submission.getSubjectID());
            ps.setString(3, submission.getStudentID());
            ps.setString(4, submission.getStudentName());
            ps.setString(5, submission.getFileName());
            ps.setInt(6, submission.getScore());
            ps.setDate(7, submission.getSubDate());
            i = ps.executeUpdate();
        } catch (SQLException se) {
            System.out.println("Exception: operate submission_table error!");
            se.printStackTrace();
        }
        return i;
    }

    // Select function
    public static ResultSet sqlSelect(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
        } catch (SQLException se) {
            System.out.println("Exception: select SQL datas error!");
            se.printStackTrace();
        }
        return rs;
    }

    // Close connection
    public static void closeConn() {
        try {
            conn.close();
        } catch (SQLException se) {
            System.out.println("Exception: close database error!");
            se.printStackTrace();
        }
    }
}