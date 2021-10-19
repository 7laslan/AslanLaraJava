package school.rest.school;

import java.util.*;

public class Course {

    // Muuttujien määrittelyt course luokkaan:

    public String courseName;
    public String teacherName;
    private long id;
    List<Student> studentList = new ArrayList<Student>();

    private static long idCounter = 0;

    /* Käytetään protected metodeja, ettei tehtävänannon mukaan
    tästä luokasta pysty tekemään olioita suoraan*/

    protected Course(String courseName, String teacherName) {
        this.id = idCounter++;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }

    // Vaaditut toimenpiteet:

    protected String getTeacherName() {
        return this.teacherName;
    }

    protected void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    protected String getCourseName() {
        return this.courseName;
    }

    protected void setCourseName( String courseName) {
        this.courseName = courseName;
    }

    protected long getId() {
        return this.id;
    }

    protected boolean addStudent(Student s) {
            studentList.add(s);
            return true;     
    }

    protected void deleteStudent(Student s) {
        studentList.remove(s);
    }

    protected void getStudents() {
        List<Student> copy = new ArrayList<Student>(studentList);
        System.out.println(copy);
    }
}