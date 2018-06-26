/**
 * FileName:    User.java
 * Copyright:   All by yourself
 */

package com.ams;

/**
 * This class describes the attributes of an user.
 * @author      Sny
 * @since       2018-06-19
 * @version     1.00
 */
public class User {
    // Private variables
    private int userID;
    private String userName;
    private String userPassWord;
    private int occupation;
    private String idNumber;
    private String realName;

    // Constructors
    public User() {
        this.userID = 0;
        this.userName = "";
        this.userPassWord = "";
        this.occupation = 0;
        this.idNumber = "";
        this.realName = "";
    }

    public User(int id, String userName, String password, int occupation, String idNum, String realName) {
        this.userID = id;
        this.userName = userName;
        this.userPassWord = password;
        this.occupation = occupation;
        this.idNumber = idNum;
        this.realName = realName;
    }

    // Get functions
    public int getID() {
        return this.userID;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassWord() {
        return this.userPassWord;
    }

    public int getOccupation() {
        return this.occupation;
    }

    public String getIDNum() {
        return this.idNumber;
    }

    public String getRealName() {
        return this.realName;
    }

    // Set functions
    public void setID(int id) {
        this.userID = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String password) {
        this.userPassWord = password;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

    public void setIDNum(String idNum) {
        this.idNumber = idNum;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String toString() {
        String userStr =
            Integer.toString(this.userID) + ", " +
            this.userName + ", " +
            this.userPassWord + ", " +
            Integer.toString(this.occupation) + ", " +
            this.idNumber + ", " +
            this.realName;
        return userStr;
    }
}