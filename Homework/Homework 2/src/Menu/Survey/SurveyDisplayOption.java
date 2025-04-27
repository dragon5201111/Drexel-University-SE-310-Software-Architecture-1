package Menu.Survey;

import Survey.Survey;

public class SurveyDisplayOption extends SurveyMenuOption {

    public SurveyDisplayOption(SurveyMenu surveyMenu) {
        super("Display an existing Survey", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        survey.displaySurvey();
    }
}
