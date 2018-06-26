/**
 * FileName:    UploadServlet.java
 * Copyright:   All by yourself
 */

package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ams.*;

/**
 * For upload file to database.
 * Save files in the given path.
 * @author      Sny
 * @since       2018-06-13
 * @version     1.00
 */
public class UploadServlet extends HttpServlet {
    // Upload parameters
    private static final long SERIAL_ID = 1L;
    private static final String UPLOAD_DIR = "WEB-INF/datas";
    private static final String TEMP_DIR = "WEB-INF/temp";
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 1;
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 10;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 10;

    // Upload and save the file
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check whether it is media uploading
        if(!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Error: the form must contain enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // Path for saving files
        String savePath = this.getServletContext().getRealPath(UPLOAD_DIR);
        File saveDir = new File(savePath);
        if(!saveDir.exists()) {
            saveDir.mkdirs();
        }

        int occupation = -1;
        try {
            // Configuration upload parameters
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            fileUpload.setFileSizeMax(MAX_FILE_SIZE);
            fileUpload.setSizeMax(MAX_REQUEST_SIZE);
            fileUpload.setHeaderEncoding("UTF-8");

            // Get file datas
            String subjectName = "";
            String teacherID = "";
            String teacherName = "";
            String studentID = "";
            String studentName = "";
            String fileName = "";
            List<FileItem> formItems = fileUpload.parseRequest(request);
            if(formItems != null && formItems.size() > 0) {
                for(FileItem item : formItems) {
                    if(!item.isFormField()) {
                        fileName = new File(item.getName()).getName();
                        String filePath = savePath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        System.out.println(filePath);
                        item.write(storeFile);
                        request.setAttribute("message", "Success to upload the file!");
                    }
                    else {
                        // Record information to the database
                        String name = item.getFieldName();
                        if(name.equals("subject_combo")) {
                            subjectName = item.getString("UTF-8");
                            System.out.println(subjectName);
                        }
                        else if(name.equals("occupation")) {
                            occupation = Integer.valueOf(item.getString("UTF-8"));
                            System.out.println(occupation);
                        }
                        else if(name.equals("teacher_id")) {
                            teacherID = item.getString("UTF-8");
                            System.out.println(teacherID);
                        }
                        else if(name.equals("teacher_name")) {
                            teacherName = item.getString("UTF-8");
                            System.out.println(teacherName);
                        }
                        else if(name.equals("student_id")) {
                            studentID = item.getString("UTF-8");
                            System.out.println(studentID);
                        }
                        else if(name.equals("student_name")) {
                            studentName = item.getString("UTF-8");
                            System.out.println(studentName);
                        }
                    }
                }
            }
            if(occupation == 1) {
                // Insert new assignment information
                Teacher curTeacher = new Teacher();
                int subjectID = curTeacher.getSubjectID(subjectName);
                Date subDate = new Date(System.currentTimeMillis());
                Assignment assignment = new Assignment(0, subjectID, teacherID, teacherName, fileName, subDate);
                curTeacher.upload(assignment);
                // Select all assignments
                List<Assignment> assignmentList = curTeacher.getAssignmentsAll(subjectID, teacherID);
                HttpSession session = request.getSession();
                session.setAttribute("current_subject_name", subjectName);
                session.setAttribute("assignments", assignmentList);
            }
            else if(occupation == 0) {
                // Insert new submission information
                Student curStudent = new Student();
                int subjectID = curStudent.getSubjectID(subjectName);
                Date subDate = new Date(System.currentTimeMillis());
                Submission submission = new Submission(0, subjectID, studentID, studentName, fileName, -1, subDate);
                curStudent.upload(submission);
                // Select all submissions
                List<Submission> submissionList = curStudent.getSubmissionsAll(subjectID, studentID);
                HttpSession session = request.getSession();
                session.setAttribute("current_subject_name", subjectName);
                session.setAttribute("submissions", submissionList);
            }
        } catch (Exception e) {
            request.setAttribute("message", "Error: " + e.getMessage());
        }

        // Jump to upload_assignments.jsp
        if(occupation == 1) {
            response.sendRedirect("/ams/web/jsp/upload_assignments.jsp");
        }
        else if(occupation == 0) {
            response.sendRedirect("/ams/web/jsp/manage_self.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}