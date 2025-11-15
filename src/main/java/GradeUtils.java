import java.time.Instant;

public class GradeUtils {

    double getExamGrades(Exam exam , Student student, Instant t){
        for(Grade grade : exam.getGrade()){
            if(grade.getStudent().equals(student)){
                return grade.getGrade(t);
            }
        }
        return 0d;
    }
}
