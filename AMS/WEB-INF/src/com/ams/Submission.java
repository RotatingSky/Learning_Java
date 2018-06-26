/**
 * FileName:    Submission.java
 * Copyright:   All by yourself
 */

package com.ams;

import java.sql.*;

/**
 * Submission file attributes that can be operated by database.
 * It includes toString() method for debug.
 * @author      Sny
 * @since       2018-06-19
 * @version     1.00
 */
public class Submission {
    // Private variables
    private int submissionID;
    private int subjectID;
    private String studentID;
    private String studentName;
    private String fileName;
    private int score;
    private Date subDate;

    // Constructors
    public Submission() {
        this.submissionID = 0;
        this.subjectID = 0;
        this.studentID = "";
        this.studentName = "";
        this.fileName = "";
        this.score = -1;
        this.subDate = new Date(System.currentTimeMillis());
    }

    public Submission(int submissionID, int subjectID, String studentID, String studentName, String fileName, int score, Date subDate) {
        this.submissionID = submissionID;
        this.subjectID = subjectID;
        this.studentID = studentID;
        this.studentName = studentName;
        this.fileName = fileName;
        this.score = score;
        this.subDate = subDate;
    }

    // Get functions
    public int getSubmissionID() {
        return this.submissionID;
    }

    public int getSubjectID() {
        return this.subjectID;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getScore() {
        return this.score;
    }

    public Date getSubDate() {
        return this.subDate;
    }

    // Set functions
    public void setSubmissionID(int submissionID) {
        this.submissionID = submissionID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

    public String toString() {
        String subStr =
            Integer.toString(this.submissionID) + ", " +
            Integer.toString(this.subjectID) + ", " +
            this.studentID + ", " +
            this.studentName + ", " +
            this.fileName + ", " +
            Integer.toString(this.score) + ", " +
            this.subDate.toString();
        return subStr;
    }
}