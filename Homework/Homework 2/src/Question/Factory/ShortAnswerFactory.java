package Question.Factory;

import Question.*;

public class ShortAnswerFactory extends QuestionFactory {
    @Override
    public Question createQuestion(String prompt) {
        return new ShortAnswer(prompt, this.getResponseLimit("words"));
    }
}
