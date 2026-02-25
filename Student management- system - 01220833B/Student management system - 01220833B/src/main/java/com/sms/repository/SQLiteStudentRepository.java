package com.sms.repository;

import com.sms.domain.student;
import com.sms.util.DatabaseConnection;

import java.sql.*;
import java.util.*;

public class SQLiteStudentRepository extends StudentRepository {
    @Override
    public void addStudent(student s) {
        String sql = "INSERT INTO students VALUES(?,?,?,?,?,?,?,CURRENT_TIMESTAMP,?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getStudentId());
            ps.setString(2, s.getFullName());
            ps.setString(3, s.getProgramme());
            ps.setInt(4, s.getLevel());
            ps.setDouble(5, s.getGpa());
            ps.setString(6, s.getEmail());
            ps.setString(7, s.getPhone());
            ps.setString(8, s.getStatus());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Duplicate ID or DB error");
        }
    }


    public void deleteStudent(String id) {
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps =
                     conn.prepareStatement("DELETE FROM students WHERE student_id=?")) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<student> getAllStudents() {
        List<student> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                list.add(new student(
                        rs.getString("student_id"),
                        rs.getString("full_name"),
                        rs.getString("programme"),
                        rs.getInt("level"),
                        rs.getDouble("gpa"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<student> topPerformers(int limit) {
        List<student> list = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY gpa DESC LIMIT ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, limit);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new student(
                        rs.getString("student_id"),
                        rs.getString("full_name"),
                        rs.getString("programme"),
                        rs.getInt("level"),
                        rs.getDouble("gpa"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



}
