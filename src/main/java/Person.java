import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    public LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
}
