/**
 * FileName:    Transaction.java
 * Copyright:   All by yourself
 */

package com.ams;

import java.sql.*;

/**
 * Transaction of JSP operations.
 * It can operate user_table in AMS database.
 * @author      Sny
 * @since       2018-06-20
 * @version     1.00
 */
public class Transaction {
    public boolean signin(User curUser) {
        boolean flag = false;
        try {
            DBams.init();
            String selectSQL = "SELECT * FROM user_table" +
                " WHERE user_name = '" + curUser.getUserName() +
                "' AND user_password = '" + curUser.getPassWord() + "'";
            ResultSet rs = DBams.sqlSelect(selectSQL);
            if(rs.next()) {
                System.out.println("Exists!");
                curUser.setUserName(curUser.getUserName());
                curUser.setPassWord(curUser.getPassWord());
                curUser.setID(rs.getInt("user_id"));
                curUser.setOccupation(rs.getShort("occupation"));
                curUser.setIDNum(rs.getString("id_number"));
                curUser.setRealName(rs.getString("real_name"));
                System.out.println(curUser.toString());
                flag = true;
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return flag;
    }

    public boolean signup(User newUser) {
        boolean flag = false;
        DBams.init();
        String insertSQL = "INSERT INTO user_table" +
            "(user_id, user_name, user_password, occupation, id_number, real_name)" +
            "VALUES (0, '" +
            newUser.getUserName() + "', '" +
            newUser.getPassWord() + "', " +
            Integer.toString(newUser.getOccupation()) + ", '" +
            newUser.getIDNum() + "', '" +
            newUser.getRealName() + "')";
        int rows = DBams.sqlADU(insertSQL);
        if(rows > 0) {
            System.out.println("Insert succeed!");
            flag = true;
        }
        return flag;
    }
}