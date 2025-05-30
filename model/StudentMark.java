package com.model;

import java.time.LocalDate;

public class StudentMark {
    private int studentID;
    private String studentName;
    private String subject;
    private int marks;
    private LocalDate examDate;

    // Default constructor
    public StudentMark() {}

    // Parameterized constructor
    public StudentMark(int studentID, String studentName, String subject, int marks, LocalDate examDate) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.subject = subject;
        this.marks = marks;
        this.examDate = examDate;
    }

    // Getters and Setters
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    // Override toString() method for better representation
    @Override
    public String toString() {
        return "StudentMark{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", subject='" + subject + '\'' +
                ", marks=" + marks +
                ", examDate=" + examDate +
                '}';
    }
}

