package school.rest.school;

public class Student {

    // Muuttujien määrittelyä student luokkaan:

    private long id;
    private String firstName, surname;

    private static long idCounter = 0;


    public Student(String firstName, String surname) {
        this.id = idCounter++; 
        this.firstName = firstName;
        this.surname = surname;
    }

    // Vaaditut toimenpiteet luokkaa varten:

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return this.surname;
    }

    public long getId() {
        return this.id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Palauttaa oppilaiden nimet halutussa muodossa:

    @Override
    public String toString() {
        return String.format(surname + " " + firstName);
    }

}

