/**
 * FileName:    DownloadServlet.java
 * Copyright:   All by yourself
 */

package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.io.FileInputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * For download file from database.
 * @author      Sny
 * @since       2018-06-13
 * @version     1.00
 */
public class DownloadServlet extends HttpServlet {
    // Download parameters
    private static final long SERIAL_ID = 1L;
    private static final String DOWNLOAD_DIR = "WEB-INF/datas";

    // Download the file
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fileName = request.getParameter("file_name");
        String filePath = this.getServletContext().getRealPath(DOWNLOAD_DIR);
        File file = new File(filePath, fileName);
        if(!file.exists()) {
            request.setAttribute("message", "The file has been delete!");
            return;
        }
        System.out.println(fileName);
        response.setHeader("content-disposition", "attachment; filename = " +
            URLEncoder.encode(fileName, "UTF-8"));
        FileInputStream fileIS = new FileInputStream(file);
        OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = fileIS.read(buffer)) > 0) {
            outStream.write(buffer, 0, len);
        }
        fileIS.close();
        outStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}