package Menu.Survey;
import Question.Question;
import Serialization.ObjectSerializer;
import Survey.Survey;
import Test.Test;

import java.util.List;

public class SurveyGradeOption extends SurveyMenuOption{
    public SurveyGradeOption(SurveyMenu surveyMenu) {
        super("Grade", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        if(!(survey instanceof Test)){
            this.consoleOutputDriver.println("Error! You need to select a Test. Please load or create a Test.");
            return;
        }

        this.consoleOutputDriver.println("Not implemented.");
    }
}
