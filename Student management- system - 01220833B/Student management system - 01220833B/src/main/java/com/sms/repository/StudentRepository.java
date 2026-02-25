package com.sms.repository;

import com.sms.domain.student;
import com.sms.util.DatabaseConnection;
import java.sql.*;


public class StudentRepository {

    public void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS students (
                    student_id TEXT PRIMARY KEY,
                    full_name TEXT NOT NULL,
                    programme TEXT NOT NULL,
                    level INTEGER CHECK(level IN (100,200,300,400,500,600,700)),
                    gpa REAL CHECK(gpa BETWEEN 0.0 AND 4.0),
                    email TEXT,
                    phone TEXT,
                    date_added TEXT,
                    status TEXT
                );
                """;

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent(student student) {

        String sql = "INSERT INTO students VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getStudentId());
            ps.setString(2, student.getFullName());
            ps.setString(3, student.getProgramme());
            ps.setInt(4, student.getLevel());
            ps.setDouble(5, student.getGpa());
            ps.setString(6, student.getEmail());
            ps.setString(7, student.getPhone());
            ps.setString(8, student.getStatus());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
