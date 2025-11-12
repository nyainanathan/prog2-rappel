import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Grade {
    private Student student;
    private double initialValue;
    private List<GradeLog> grades;

    public Grade(Student student, double initialValue) {
        this.student = student;
        this.initialValue = initialValue;
        this.grades = new ArrayList<>();
        grades.add(new GradeLog(initialValue, Instant.now(), "Initial value"));
    }

    public Grade(Student student, double initialValue, Instant date) {
        this.student = student;
        this.initialValue = initialValue;
        this.grades = new ArrayList<>();
        grades.add(new GradeLog(initialValue, date, "Initial value"));
    }

    public Grade(Student student, double initialValue, Instant date,  List<GradeLog> grades) {
        this.student = student;
        this.initialValue = initialValue;
        this.grades = grades;
    }
}
