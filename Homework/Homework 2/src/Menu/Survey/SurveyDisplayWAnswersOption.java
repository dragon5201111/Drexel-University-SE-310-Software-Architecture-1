package Menu.Survey;

import Question.Question;
import Survey.Survey;
import Test.Test;

import java.util.List;

public class SurveyDisplayWAnswersOption extends SurveyMenuOption{

    public SurveyDisplayWAnswersOption(SurveyMenu surveyMenu) {
        super("Display an existing Test with correct answers ", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        if(!(survey instanceof Test)){
            this.consoleOutputDriver.println("Error! You need to select a Test. Please load or create a Test.");
            return;
        }

        Test test = (Test)survey;

        for(Question question : test.getQuestions()){
            List<String> answerList = test.getAnswerList(question);
            question.displayQuestion();
            this.consoleOutputDriver.println("The correct answer(s) are:");
            this.consoleOutputDriver.printLines(answerList);
            this.consoleOutputDriver.println();
        }
    }
}
