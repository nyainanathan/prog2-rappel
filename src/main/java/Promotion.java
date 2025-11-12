import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Promotion {
    private char name; // 'K', 'J', 'N'
    private List<String> groups;

    public Promotion(char name){
        this.name = name;
    }
}
