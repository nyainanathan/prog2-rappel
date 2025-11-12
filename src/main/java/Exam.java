import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Exam {
    private int id;
    private String title;
    private Course course;
    private Instant date;
    private int coefficient;
    private List<Grade> grade;

    public Exam(int id, String title, Course course, Instant date, int coefficient) {
        this.id = id;
        this.title = title;
        this.course = course;
        this.date = date;
        this.coefficient = coefficient;
    }
}
