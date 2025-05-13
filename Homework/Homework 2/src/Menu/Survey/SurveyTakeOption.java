package Menu.Survey;

import Serialization.ObjectSerializer;
import Survey.Survey;

public class SurveyTakeOption extends SurveyMenuOption {

    public SurveyTakeOption(SurveyMenu surveyMenu) {
        super("Take", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        survey.take();
    }
}
