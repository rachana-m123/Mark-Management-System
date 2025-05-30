package com.dao;

import com.model.StudentMark;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarkDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // Establishing a connection to the database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add a new student mark record
    public boolean addMark(StudentMark studentMark) {
        String sql = "INSERT INTO StudentMarks (StudentID, StudentName, Subject, Marks, ExamDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentMark.getStudentID());
            stmt.setString(2, studentMark.getStudentName());
            stmt.setString(3, studentMark.getSubject());
            stmt.setInt(4, studentMark.getMarks());
            stmt.setDate(5, Date.valueOf(studentMark.getExamDate()));
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update an existing student mark record
    public boolean updateMark(StudentMark studentMark) {
        String sql = "UPDATE StudentMarks SET StudentName = ?, Subject = ?, Marks = ?, ExamDate = ? WHERE StudentID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentMark.getStudentName());
            stmt.setString(2, studentMark.getSubject());
            stmt.setInt(3, studentMark.getMarks());
            stmt.setDate(4, Date.valueOf(studentMark.getExamDate()));
            stmt.setInt(5, studentMark.getStudentID());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a student mark record by StudentID
    public boolean deleteMark(int studentID) {
        String sql = "DELETE FROM StudentMarks WHERE StudentID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentID);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve all student mark records
    public List<StudentMark> getAllMarks() {
        List<StudentMark> marksList = new ArrayList<>();
        String sql = "SELECT * FROM StudentMarks";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StudentMark studentMark = new StudentMark(
                        rs.getInt("StudentID"),
                        rs.getString("StudentName"),
                        rs.getString("Subject"),
                        rs.getInt("Marks"),
                        rs.getDate("ExamDate").toLocalDate()
                );
                marksList.add(studentMark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    // Retrieve student mark records by StudentID
    public List<StudentMark> getMarksByStudentID(int studentID) {
        List<StudentMark> marksList = new ArrayList<>();
        String sql = "SELECT * FROM StudentMarks WHERE StudentID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentID);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    StudentMark studentMark = new StudentMark(
                            rs.getInt("StudentID"),
                            rs.getString("StudentName"),
                            rs.getString("Subject"),
                            rs.getInt("Marks"),
                            rs.getDate("ExamDate").toLocalDate()
                    );
                    marksList.add(studentMark);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    // Retrieve students with marks above a specified threshold
    public List<StudentMark> getStudentsAboveThreshold(int threshold) {
        List<StudentMark> marksList = new ArrayList<>();
        String sql = "SELECT * FROM StudentMarks WHERE Marks > ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, threshold);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    StudentMark studentMark = new StudentMark(
                            rs.getInt("StudentID"),
                            rs.getString("StudentName"),
                            rs.getString("Subject"),
                            rs.getInt("Marks"),
                            rs.getDate("ExamDate").toLocalDate()
                    );
                    marksList.add(studentMark);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    // Retrieve students who scored in a specific subject
    public List<StudentMark> getStudentsBySubject(String subject) {
        List<StudentMark> marksList = new ArrayList<>();
        String sql = "SELECT * FROM StudentMarks WHERE Subject = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, subject);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    StudentMark studentMark = new StudentMark(
                            rs.getInt("StudentID"),
                            rs.getString("StudentName"),
                            rs.getString("Subject"),
                            rs.getInt("Marks"),
                            rs.getDate("ExamDate").toLocalDate()
                    );
                    marksList.add(studentMark);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    // Retrieve top N students based on marks
    public List<StudentMark> getTopNStudents(int n) {
        List<StudentMark> marksList = new ArrayList<>();
        String sql = "SELECT * FROM StudentMarks ORDER BY Marks DESC LIMIT ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, n);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    StudentMark studentMark = new StudentMark(
                            rs.getInt("StudentID"),
                            rs.getString("StudentName"),
                            rs.getString("Subject"),
                            rs.getInt("Marks"),
                            rs.getDate("ExamDate").toLocalDate()
                    );
                    marksList.add(studentMark);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }
}
