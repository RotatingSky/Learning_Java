/**
 * FileName:    Subject.java
 * Copyright:   All by yourself
 */
package com.ams;

/**
 * This class describes the attributes of subject_table.
 * For following development.
 * @author      Sny
 * @since       2018-06-26
 * @version     1.00
 */
public class Subject {
    // Private variables.
    private int subjectID;
    private String subjectName;
    private String teacherID;
    private String teacherName;

    // Constructors
    public Subject() {
        this.subjectID = 0;
        this.subjectName = "";
        this.teacherID = "";
        this.teacherName = "";
    }

    public Subject(int subjectID, String subjectName, String teacherID, String teacherName) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.teacherID = teacherID;
        this.teacherName = teacherName;
    }

    // Get functions
    public int getSubjectID() {
        return this.subjectID;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public String getTeacherID() {
        return this.teacherID;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    // Set functions
    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String toString() {
        String subjectStr =
            Integer.toString(this.subjectID) + ", " +
            this.subjectName + ", " +
            this.teacherID + ", " +
            this.teacherName;
        return subjectStr;
    }
}