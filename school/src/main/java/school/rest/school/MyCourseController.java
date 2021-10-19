package school.rest.school;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Service;

// CourseControllerin toteutus, sisältää myös toteutuksen tiedostohallinnalle:

@Service
public class MyCourseController implements CourseController, CourseFileController{

    CourseFileController coursefController;
    MyCourseController myController;

    // Tarvittavat muuttujien määrittelyt:

    File courseList = new File("C:\\Users\\Bulbashenko\\javaprojektit\\school\\courses.TXT");
    File studentList = new File("C:\\Users\\Bulbashenko\\javaprojektit\\school\\students.TXT");
    
    String fp1 = "C:\\Users\\Bulbashenko\\javaprojektit\\school\\courses.TXT";
    String fp2 = "C:\\Users\\Bulbashenko\\javaprojektit\\school\\students.TXT";
    
    public static List<Student> students = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>();
    public static List<Course> onlinecourses = new ArrayList<>();
    public static List<Course> coursesOfStudent = new ArrayList<>();

    // Lukee oppilaiden tiedot tekstitiedostosta:
    @Override
    public List<Student> readStudentsFromFile(String fp2) throws FileNotFoundException{

        Scanner sc1 = new Scanner(studentList);

        if(students.size() == 0){
            while(sc1.hasNext()) {
                String fn = sc1.next();
                String sn = sc1.next();
                Student student = new Student(fn, sn);
                students.add(student);
            }
            System.out.println(students);
            sc1.close();
        }
        return students;
    }

    // Lukee kurssien tiedot tekstitiedostosta:
    @Override
    public List<Course> readCoursesFromFile(String fp1) throws FileNotFoundException{

        Scanner sc2 = new Scanner(courseList);

        if(courses.size() == 0){
            while(sc2.hasNext()) {
                String course = sc2.nextLine();
                String[] arr = course.split("--");
                // Erottelee kurssit sen mukaan onko online vai local:
                boolean contains = Arrays.stream(arr).anyMatch("online"::equals);
                if(contains) {
                    OnlineCourse onlineCourse = new OnlineCourse(arr[0], arr[1], arr[2]);
                    courses.add(onlineCourse);
                    onlinecourses.add(onlineCourse);
                } else {
                    LocalCourse localCourse = new LocalCourse(arr[0], arr[1], arr[2]);
                    System.out.println(localCourse);
                    courses.add(localCourse);
                }
            }
            sc2.close();
        }
        return courses;
    }

    public List<Student> getStudents() {

        return students;
    }

    public List<Course> getCourses() {

        return courses;
    }

    public List<Course> getOnlineCourses() {

        return onlinecourses;
    }

    // Hakee opiskelijat id:n mukaan:

    public Student getStudentById(long studentId) {

        for(Student s : MyCourseController.students){
            if(s.getId()== studentId){
                return s;
            }
        }
        return null;
    }

    // Hakee kurssit id:n mukaan:

    public Course getCourseById(long courseId) {

        for(Course c : MyCourseController.courses){
            if(c.getId()== courseId){
                return c;
            }
        }
        return null;
    }

    // Hakee listan kursseista, joihin opiskelija on ilmottautunut:

    public List<Course> getCoursesOfStudent(long id) {

        // Tyhjentää listan joka kerta, kun hakee samaa id:tä uudestaan
        coursesOfStudent.removeAll(coursesOfStudent);

        for(Course c : MyCourseController.courses){
            for(Student s : MyCourseController.students){
                if(s.getId()== id){
                    if(c.studentList.contains(s)){
                        coursesOfStudent.add(c);
                    }
                }
            }
        }
        return coursesOfStudent;
    }

    /* Lisää opiskelijan kurssille, tarkistaen ensin id:n perusteella
    löytyykö kurssia ja/tai oppilasta: */ 

    public boolean addStudentToCourse(long studentId, long courseId){

        boolean f = false;

        for(Course c : MyCourseController.courses){
            if(c.getId()== courseId){
                for(Student s : MyCourseController.students){
                    if(s.getId()== studentId){
                        if(!c.studentList.contains(s)){
                            f = c.addStudent(s);
                        } else {
                            f = false;
                        }
                    }
                } 
            }
        }
        return f; 
    }
}
