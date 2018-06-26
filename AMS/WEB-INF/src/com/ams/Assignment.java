/**
 * FileName:    Assignment.java
 * Copyright:   All by yourself
 */

package com.ams;

import java.sql.*;

/**
 * Assignment file attributes that can be operated by database.
 * It includes toString() method for debug.
 * @author      Sny
 * @since       2018-06-19
 * @version     1.00
 */
public class Assignment {
    // Private variables
    private int assignmentID;
    private int subjectID;
    private String teacherID;
    private String teacherName;
    private String fileName;
    private Date subDate;

    // Constructors
    public Assignment() {
        this.assignmentID = 0;
        this.subjectID = 0;
        this.teacherID = "";
        this.teacherName = "";
        this.fileName = "";
		this.subDate = new Date(System.currentTimeMillis());
    }

    public Assignment(int assignmentID, int subjectID, String teacherID, String teacherName, String fileName, Date subDate) {
        this.assignmentID = assignmentID;
        this.subjectID = subjectID;
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.fileName = fileName;
        this.subDate = subDate;
    }

    // Get functions
    public int getAssignmentID() {
        return this.assignmentID;
    }

    public int getSubjectID() {
        return this.subjectID;
    }

    public String getTeacherID() {
        return this.teacherID;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public Date getSubDate() {
        return this.subDate;
    }

    // Set functions
    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

    public String toString() {
        String subStr =
            Integer.toString(this.assignmentID) + ", " +
            Integer.toString(this.subjectID) + ", " +
            this.teacherID + ", " +
            this.teacherName + ", " +
            this.fileName + ", " +
            this.subDate.toString();
        return subStr;
    }
}