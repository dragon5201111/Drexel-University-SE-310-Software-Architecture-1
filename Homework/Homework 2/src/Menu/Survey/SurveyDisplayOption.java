package Menu.Survey;

import Survey.Survey;

public class SurveyDisplayOption extends SurveyMenuOption {

    public SurveyDisplayOption(SurveyMenu surveyMenu) {
        super("Display", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        survey.display();
    }
}
