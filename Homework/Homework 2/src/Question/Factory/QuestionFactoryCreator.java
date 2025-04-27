package Question.Factory;

import Question.QuestionType;

public class QuestionFactoryCreator {
    public static QuestionFactory getQuestionFactory(QuestionType type) {
        QuestionFactory factory;

        switch (type) {
            case TRUE_FALSE:
                factory = new TrueFalseFactory();
                break;
            case MULTIPLE_CHOICE:
                factory = new MultipleChoiceFactory();
                break;
            case SHORT_ANSWER:
                factory = new ShortAnswerFactory();
                break;
            case ESSAY:
                factory = new EssayFactory();
                break;
            case VALID_DATE:
                factory = new ValidDateFactory();
                break;
            case MATCHING:
                factory = new MatchingFactory();
                break;
            default:
                throw new IllegalArgumentException("Unrecognized question type: " + type);
        }

        return factory;
    }
}
