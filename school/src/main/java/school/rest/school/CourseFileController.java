package school.rest.school;

import java.io.FileNotFoundException;
import java.util.*;

// Rajapinta tiedostohallintatoteutukselle:

public interface CourseFileController {

    List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException;

    List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException;

}
