import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Tutor extends  Person{
    private String relationshipWithStudent;

    public Tutor(int id, String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber, String relationshipWithStudent) {
        super(id, firstName, lastName, dateOfBirth, email, phoneNumber);
        this.relationshipWithStudent = relationshipWithStudent;
    }
}
