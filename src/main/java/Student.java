import java.time.LocalDate;

public class Student extends Person{
    private String group;

    public Student(int id, String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber, String group) {
        super(id, firstName, lastName, dateOfBirth, email, phoneNumber);
        this.group = group;
    }
}
