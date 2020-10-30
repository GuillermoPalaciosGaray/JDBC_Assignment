package JDBC_Excercise;


import edu.tcs.model.Student;
import edu.tcs.repository.StudentsRepository;
import edu.tcs.utilities.ReadConfiguration;

import java.io.IOException;
import java.util.List;

public class        Main {



    public static void main(String[] args) throws IOException {

//        ReadConfiguration properties = new ReadConfiguration();
//        try {
//            properties.getDriver();
//            properties.getURL();
//            properties.getUser();
//            properties.getPassword();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        StudentsRepository studentsRepository = new StudentsRepository();
//        Create Table
//        studentsRepository.createStudentsTable();
        List<Student> students = studentsRepository.consultUsers();

           for (Student stdnt : students) {
            System.out.println("id: " + stdnt.getId() + " - name: " + stdnt.getName() + " - subject: " + stdnt.getSubject());
        }


//        Create User
        Student student = new Student();
        student.setName("Guillermo");
        student.setSubject("HTML");
        studentsRepository.createUser(student);
//        Consult users
        System.out.println("\n");
            students=studentsRepository.consultUsers();
          for (Student stdnt : students) {
            System.out.println("id: " + stdnt.getId() + " - Name: " + stdnt.getName() + " - Subject: " + stdnt.getSubject());
        }

    }
}
