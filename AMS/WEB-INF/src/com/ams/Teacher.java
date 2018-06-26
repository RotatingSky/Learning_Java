/**
 * FileName:    Teacher.java
 * Copyright:   All by yourself
 */

package com.ams;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * An interface for teacher to operate database.
 * It includes the information of teachers.
 * 1. Teachers can upload assignments to assignment_table.(insert)
 * 2. Teachers can download files from submission_table.(select)
 * 3. Teachers can also see assignments of themselves.(select)
 * @author      Sny
 * @since       2018-06-19
 * @version     1.00
 */
public class Teacher extends User {
    // Get all assignments of a subject by a teacher from database
    public List<Submission> getSubmissionsAll(int subjectID) {
        List<Submission> subList = new ArrayList<Submission>();
        try {
            DBams.init();
            String selectSQL = "SELECT * FROM submission_table" +
                " WHERE subject_id = " + Integer.toString(subjectID);
            ResultSet rs = DBams.sqlSelect(selectSQL);
            while(rs.next()) {
                Submission temp = new Submission();
                temp.setSubmissionID(rs.getInt("submission_id"));
                temp.setSubjectID(subjectID);
                temp.setStudentID(rs.getString("student_id"));
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

    // Get assignment_table information
    public List<Assignment> getAssignmentsAll(int subjectID, String teacherID) {
        List<Assignment> assignmentList = new ArrayList<Assignment>();
        try {
            DBams.init();
            String selectSQL = "SELECT * FROM assignment_table" +
                " WHERE subject_id = " + Integer.toString(subjectID) +
                " AND teacher_id = '" + teacherID + "'";
            ResultSet rs = DBams.sqlSelect(selectSQL);
            while(rs.next()) {
                Assignment temp = new Assignment();
                temp.setAssignmentID(rs.getInt("assignment_id"));
                temp.setSubjectID(subjectID);
                temp.setTeacherID(teacherID);
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

    // Record the upload information into database
    public boolean upload(Assignment assignment) {
        boolean flag = false;
        DBams.init();
        String insertSQL = "REPLACE INTO assignment_table" +
            "(assignment_id, subject_id, teacher_id, teacher_name, file_name, submission_date)" +
            "VALUES(?, ?, ?, ?, ?, ?)";
        int rows = DBams.sqlAssignmentADU(insertSQL, assignment);
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

    // Get subject_name by select teacher_id
    public List<String> getSubjectNameList(String teacherID) {
        List<String> subjectNameList = new ArrayList<String>();
        try {
            DBams.init();
            String selectSQL = "SELECT subject_name FROM subject_table" +
                " WHERE teacher_id = '" + teacherID + "'";
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

    // Given score of the submission
    public boolean updateScore(int submissionID, int score) {
        boolean flag = false;
        DBams.init();
        String updateSQL = "UPDATE submission_table SET" +
            " score = " + Integer.toString(score) +
            " WHERE submission_id = " + Integer.toString(submissionID);
        int rows = DBams.sqlADU(updateSQL);
        if(rows > 0) {
            System.out.println("Update succeed!");
            flag = true;
        }
        return flag;
    }
}