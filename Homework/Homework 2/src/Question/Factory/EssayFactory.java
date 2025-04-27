package Question.Factory;

import Question.*;

public class EssayFactory extends QuestionFactory{
    @Override
    public Question createQuestion(String prompt) {
        return new Essay(prompt, this.getResponseLimit("responses"));
    }
}
