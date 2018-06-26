/**
 * FileName:    Student.java
 * Copyright:   All by yourself
 */

package com.ams;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * An interface for student to operate database.
 * It includes the information of students.
 * 1. Students can download files from assignment_table.(select)
 * 2. Students can upload files to submission_table.(insert)
 * 3. Students can see their uploaded files.
 * @author      Sny
 * @since       2018-06-19
 * @version     1.00
 */
public class Student extends User {
    // Get all assignments of a subject from database
    public List<Assignment> getAssignmentsAll(int subjectID) {
        List<Assignment> assignmentList = new ArrayList<Assignment>();
        try {
            DBams.init();
            String selectSQL = "SELECT * FROM assignment_table" +
                " WHERE subject_id = " + Integer.toString(subjectID);
            ResultSet rs = DBams.sqlSelect(selectSQL);
            while(rs.next()) {
                Assignment temp = new Assignment();
                temp.setAssignmentID(rs.getInt("assignment_id"));
                temp.setSubjectID(subjectID);
                temp.setTeacherID(rs.getString("teacher_id"));
                temp.setTeacherName(rs.getString("teacher_name"));
                temp.setFileName(rs.getString("file_name"));
                temp.setSubDate(rs.getDate("submission_date"));
                assignmentList.add(temp);
            }
            DBams.closeConn();
            return assignmentList;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    // Get an assignments from database in random
    public Assignment getAssignment(int subjectID) {
        List<Assignment> assignmentList = getAssignmentsAll(subjectID);
        if(!assignmentList.isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(assignmentList.size());
            return assignmentList.get(index);
        }
        else {
            System.out.println("Error: fail to get the assignment!");
            return null;
        }
    }

    // Get all assignments of a subject by a teacher from database
    public List<Submission> getSubmissionsAll(int subjectID, String studentID) {
        List<Submission> subList = new ArrayList<Submission>();
        try {
            DBams.init();
            String selectSQL = "SELECT * FROM submission_table" +
                " WHERE subject_id = " + Integer.toString(subjectID) +
                " AND student_id = '" + studentID + "'";
            ResultSet rs = DBams.sqlSelect(selectSQL);
            while(rs.next()) {
                Submission temp = new Submission();
                temp.setSubmissionID(rs.getInt("submission_id"));
                temp.setSubjectID(subjectID);
                temp.setStudentID(studentID);
                temp.setStudentName(rs.getString("student_name"));
                temp.setFileName(rs.getString("file_name"));
                temp.setScore(rs.getInt("score"));
                temp.setSubDate(rs.getDate("submission_date"));
                subList.add(temp);
            }
            DBams.closeConn();
            return subList;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    // Record the upload information into database
    public boolean upload(Submission submission) {
        boolean flag = false;
        DBams.init();
        String insertSQL = "REPLACE INTO submission_table" +
            "(submission_id, subject_id, student_id, student_name, file_name, score, submission_date)" +
            "VALUES(?, ?, ?, ?, ?, ?, ?)";
        int rows = DBams.sqlSubmissionADU(insertSQL, submission);
        if(rows > 0) {
            System.out.println("Insert succeed!");
            flag = true;
        }
        return flag;
    }

    // Get subject_id by select subject_name
    public int getSubjectID(String subjectName) {
        int subjectID = -1;
        try {
            DBams.init();
            String selectSQL = "SELECT subject_id FROM subject_table" +
                " WHERE subject_name = '" + subjectName + "'";
            ResultSet rs = DBams.sqlSelect(selectSQL);
            if(rs.next()) {
                subjectID = rs.getInt("subject_id");
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return subjectID;
    }
    
    // Get all subject_name
    // It can be changed when adding student_subject_table
    public List<String> getSubjectNamesAll() {
        List<String> subjectNameList = new ArrayList<String>();
        try {
            DBams.init();
            String selectSQL = "SELECT subject_name FROM subject_table";
            ResultSet rs = DBams.sqlSelect(selectSQL);
            while(rs.next()) {
                String temp = rs.getString("subject_name");
                subjectNameList.add(temp);
            }
            DBams.closeConn();
            return subjectNameList;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }
}