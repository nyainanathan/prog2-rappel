import java.time.Instant;
import java.util.List;

public class GradeUtils {

    double getExamGrades(Exam exam , Student student, Instant t){
        for(Grade grade : exam.getGrade()){
            if(grade.getStudent().equals(student)){
                return grade.getGrade(t);
            }
        }
        return 0d;
    }

    double getCourseGrade(Course course, Student student, Instant t){
        List<Exam> exams =  course.getExams().stream()
                .filter(exam -> exam.getDate().isBefore(t))
                .toList();
        double finalNote = 0;
        int coefficient = 0;
        for(Exam exam : exams){
            coefficient += exam.getCoefficient();
            finalNote += getExamGrades(exam, student, t) * exam.getCoefficient();
        }
        return  finalNote / coefficient;
    }
}
