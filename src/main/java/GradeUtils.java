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

    double getCourseGrade(Course course, Student student, Instant t){
        Instant[] examInstant = course.getExams().stream()
                .map(Exam::getDate)
                .toArray(Instant[]::new);
        Instant date = examInstant[0];
        for(int i = 0 ; i < examInstant.length ; i++){
            if(i < examInstant.length-1 && examInstant[i].isBefore(t) && examInstant[i+1].isAfter(t)){
                date = examInstant[i];
                break;
            }
            if(i == examInstant.length - 1 && t.isAfter(examInstant[i]) && date == examInstant[0]){
                date = examInstant[i];
                break;
            }
        }
        for(Exam  exam : course.getExams()){
            if(exam.getDate().equals(date)){
                return getExamGrades(exam, student, t);
            }
        }
        return 0d;
    }
}
