import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class GradeLog {
    private double Value;
    private Instant date;
    private String description;
}
