package school.rest.school;

import java.util.*;

/* MyCourseControllerin rajapinta, tehty ohjeiden mukaan
(tehty silloin kun ohjeissa käytettiin nimitystä CourseController) */

public interface CourseController {
    
    List<Student> getStudents();

    List<Course> getCourses();

    Student getStudentById(long studentId);

    Course getCourseById(long courseId);

    List<Course> getCoursesOfStudent(long studentId);

    boolean addStudentToCourse(long studentId, long courseId);

}
