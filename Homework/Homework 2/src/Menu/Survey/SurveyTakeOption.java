package Menu.Survey;

import Survey.Survey;
import Test.Test;

public class SurveyTakeOption extends SurveyMenuOption {

    public SurveyTakeOption(SurveyMenu surveyMenu) {
        super("Take", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        survey.take();
    }
}
