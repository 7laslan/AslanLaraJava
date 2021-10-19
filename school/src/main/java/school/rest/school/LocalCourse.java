package school.rest.school;

public class LocalCourse extends Course{

    // Muuttujien määrittelyt: 

    private String classRoom;
    private static int studentLimit = 25;
    private static int studentCounter = 0;

    public LocalCourse(String teacherName, String courseName, String classRoom) {

        super(teacherName, courseName);
        this.classRoom = classRoom;

    }

    // vaaditut toimenpiteet:

    public String getClassRoom() {
        return this.classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    // Tarkistetaan ettei kurssin opiskelijarajaa pystytä ylittämään:
    
    @Override
    public boolean addStudent(Student s) {
        
        if (studentCounter < studentLimit) {
            super.addStudent(s);
            studentCounter++;
            System.out.println(studentCounter);
            return true;
        } else {
            System.out.println("Course is full!");
            return false;
        }
        
    } 

    @Override
    public String toString() {
        return String.format(getCourseName() + " " + getTeacherName() + " " + getClassRoom());
    }
    
}
