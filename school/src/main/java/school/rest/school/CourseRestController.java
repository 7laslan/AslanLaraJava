package school.rest.school;

import java.util.List;
import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Toimiva RESTP API controller, toimintoja testattu Thunder Clientillä

@RestController
public class CourseRestController {
    
    String fp1 = "C:\\Users\\Bulbashenko\\javaprojektit\\school\\courses.TXT";
    String fp2 = "C:\\Users\\Bulbashenko\\javaprojektit\\school\\students.TXT";

    @Autowired
    MyCourseController myCourseController;

    @GetMapping("/students")
    public List<Student> getStudents() throws FileNotFoundException {
         myCourseController.readStudentsFromFile(fp2);
         return myCourseController.getStudents();
    }

    @GetMapping("/courses")
    public List<Course> getCourses() throws FileNotFoundException {
        myCourseController.readCoursesFromFile(fp1);
        return myCourseController.getCourses();
    }

    @GetMapping("/onlinecourses")
    public List<Course> getOnlineCourses() throws FileNotFoundException {
        myCourseController.readCoursesFromFile(fp1);
        return myCourseController.getOnlineCourses();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable long id) throws FileNotFoundException {
        myCourseController.readStudentsFromFile(fp2);
        return myCourseController.getStudentById(id);
    }

    @GetMapping("/courses/{id}")
    public Course getCoursesById(@PathVariable long id) throws FileNotFoundException {
        myCourseController.readCoursesFromFile(fp1);
        return myCourseController.getCourseById(id);
    }

    @GetMapping("/coursesOfStudent/{id}")
    public List<Course> getCoursesOfStudent(@PathVariable long id) throws FileNotFoundException {
        myCourseController.readCoursesFromFile(fp1);
        myCourseController.readStudentsFromFile(fp2);
        return myCourseController.getCoursesOfStudent(id);
    }

    @PostMapping("/add")
    public boolean addStudentToCourse(@RequestParam long studentId, @RequestParam long courseId) throws FileNotFoundException{
        myCourseController.readCoursesFromFile(fp1);
        myCourseController.readStudentsFromFile(fp2);
        return myCourseController.addStudentToCourse(studentId, courseId);
    }
}
