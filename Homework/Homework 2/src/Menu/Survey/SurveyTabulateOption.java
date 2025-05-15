package Menu.Survey;

import Question.Question;
import Survey.Survey;


public class SurveyTabulateOption extends SurveyMenuOption{
    public SurveyTabulateOption(SurveyMenu surveyMenu) {
        super("Tabulate a survey", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        survey.displayTabulated();
    }
}
