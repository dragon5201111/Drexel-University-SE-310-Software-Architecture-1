import java.io.Serializable;
import java.util.List;

public class Survey implements Serializable {
    protected String name;
    protected List<Question> questions;

    public void addQuestion(Question question) {

    }

    public void removeQuestion(Question question) {

    }
}
