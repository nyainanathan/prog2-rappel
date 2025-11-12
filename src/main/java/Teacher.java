import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Teacher extends Person{
    private String speciality;

    public Teacher(int id, String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber, String speciality) {
        super(id, firstName, lastName, dateOfBirth, email, phoneNumber);
        this.speciality = speciality;
    }
}
