package ca.sait.itsd;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Carlos J. Garcia Carmona
 */
public class StudentList implements Serializable {

    // Attributes
    private ArrayList<Student> studentList;

    // Constructors
    public StudentList() {
        studentList = new ArrayList<>();
    }

    // Getters
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    // Setters
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    // Methods
    public void addStudent(String name, String id, String email) {
        Student student = new Student();
        student.setName(name);
        student.setId(id);
        student.setEmail(email);
        studentList.add(student);
    }
    
    public void deleteStudent(int index) {
        studentList.remove(index);
    }
    
    public Student getStudent(int index) {
        return studentList.get(index);
    }
    
    public int getNumberOfStudents() {
        return studentList.size();
    }
}
