package Test;

import Question.Question;
import Survey.Survey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test extends Survey {
    private final Map<Question, List<String>> correctAnswers;

    public Test(String title) {
        super(title);
        this.correctAnswers = new HashMap<>();
    }

    public List<String> getAnswerList(Question question) {
        return this.correctAnswers.computeIfAbsent(question, q -> new ArrayList<>());
    }

    public void addAnswer(Question question, String answer){
        this.correctAnswers
                .computeIfAbsent(question, q -> new ArrayList<>())
                .add(answer);
    }
}
