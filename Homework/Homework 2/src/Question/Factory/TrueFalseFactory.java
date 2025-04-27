package Question.Factory;

import Question.*;

public class TrueFalseFactory extends QuestionFactory{
    @Override
    public Question createQuestion(String prompt) {
        return new TrueFalse(prompt);
    }
}
