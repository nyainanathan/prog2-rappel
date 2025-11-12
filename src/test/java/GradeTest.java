import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GradeTest {

    private Student student1;
    private Teacher teacher1;
    private Course course1;
    private Exam exam1;
    private Grade grade1;
    @BeforeEach
    public void setUp(){
        student1 = new Student(1, "John" , "Doe", LocalDate.of(2026,03,16),"hei.johndoe.1@gmail.com", "034 01 234 56", "K2");
        teacher1 = new Teacher(1, "Teacher", "Test", LocalDate.of(1990, 02, 12), "hei.mpampianatra@gmail.com", "032 78 910 11","Backend");
        course1 = new Course(1, "PROG2", 5, teacher1);
        exam1 = new Exam(1, "Exam de passage", course1, Instant.parse("2025-11-01T13:26:01.00Z"), 3);
        grade1 = new Grade(student1, 12, Instant.parse("2025-11-01T13:26:01.00Z"));
        grade1.addGrade(new GradeLog(13, Instant.parse("2025-11-12T13:26:01.00Z"), "Student got better somehow"));
        grade1.addGrade(new GradeLog(9, Instant.parse("2025-11-09T13:26:01.00Z"), "Bro cheated in face"));
        grade1.addGrade(new GradeLog(18, Instant.parse("2025-11-07T08:26:01.00Z"), "Really good boyyyy"));
    }

    @Test
    void getGrade() {
        assertEquals(13,grade1.getGrade(Instant.parse("2025-11-15T13:26:01.00Z")));
        assertEquals(9, grade1.getGrade(Instant.parse("2025-11-10T13:26:01.00Z")));
        assertEquals(18, grade1.getGrade(Instant.parse("2025-11-08T13:26:01.00Z")));
        assertEquals(12, grade1.getGrade(Instant.parse("2025-11-05T13:26:01.00Z")));
    }
}