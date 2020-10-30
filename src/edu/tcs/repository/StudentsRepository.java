package edu.tcs.repository;

import edu.tcs.model.Student;
import edu.tcs.utilities.DButilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsRepository {
//This way in order to save the students inside the collection list
    public void createStudentsTable(){
        PreparedStatement ps = null;

        try {
            Connection conn = DButilities.getConnection();
            ps = conn.prepareStatement("CREATE TABLE Students (ID int(50) NOT NULL AUTO_INCREMENT , NAME varchar(50), SUBJECT varchar(20), PRIMARY KEY id_student(ID))");
            //preparestament.setString(1,table_name);  Why can I add an element here?)
            ps.execute();
            System.out.println("Table created!");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                 if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                DButilities.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

//This is my way to consult the users to show them I store them in a list
    public List<Student> consultUsers() {
        List<Student> students = new ArrayList<Student>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = DButilities.getConnection();
            ps = conn.prepareStatement("SELECT  id, name, subject FROM students ORDER BY id ASC");
            rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setSubject(rs.getString("subject"));
                students.add(student);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                DButilities.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }
    public void createUser(Student student)  {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = DButilities.getConnection();
            ps = conn.prepareStatement("INSERT INTO students (name, subject) VALUES (?, ?)");
            ps.setString(1, student.getName());
            ps.setString(2, student.getSubject());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                DButilities.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
