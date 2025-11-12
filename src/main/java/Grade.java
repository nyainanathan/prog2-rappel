import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLOutput;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void addGrade(GradeLog grade) {
        this.grades.add(grade);
    }

    public double getGrade(Instant t){
        List<GradeLog> grades = this.getGrades();

        Instant[] gradesInstant = grades.stream().map(GradeLog::getDate).toArray(Instant[]::new);
        Instant date = gradesInstant[0];
        Arrays.sort(gradesInstant);

        for(int i = 0 ; i < gradesInstant.length; i++){
            if( i < gradesInstant.length - 1 &&  gradesInstant[i].isBefore(t) && gradesInstant[i+1].isAfter(t)){
                date = gradesInstant[i];
                break;
            }
            if (i == gradesInstant.length - 1 && t.isAfter(gradesInstant[i]) && date == gradesInstant[0]) {
                date = gradesInstant[i];
                break;
            }
        }
        for(GradeLog grade : grades){
            if(grade.getDate() == date){
                return grade.getValue();
            }
        }
        return 0d;
    }
}
