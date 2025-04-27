package Question.Factory;

import Question.*;

public class ValidDateFactory extends QuestionFactory{
    @Override
    public Question createQuestion(String prompt) {
        return new ValidDate(prompt, this.getResponseLimit("responses"));
    }
}
