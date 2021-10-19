package school.rest.school;

public class OnlineCourse extends Course {

    // Tarvittavat määrittelyt ja toimenpiteet:
    
    private String address;

    public OnlineCourse(String teacherName, String courseName, String address) {

        super(teacherName, courseName);
        this.address = address;

    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return String.format(getCourseName() + " " + getTeacherName() + " " + getAddress());
    }
    
}
