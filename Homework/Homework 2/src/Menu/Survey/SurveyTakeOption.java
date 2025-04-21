package Menu.Survey;

import Survey.Survey;

public class SurveyTakeOption extends SurveyActionOption {

    public SurveyTakeOption(SurveyMenu surveyMenu) {
        super("Take the current Survey", surveyMenu);
    }

    private String getResponseSaveName(Survey survey) {
        return survey.getSurveyTitle() + "Response";
    }

    @Override
    protected void performAction(Survey survey) {
        survey.takeSurvey();
        String responseSaveName = this.getResponseSaveName(survey);
        this.objectSerializer.serialize(survey, responseSaveName);
        this.consoleOutputDriver.println("Survey response saved as " + responseSaveName + ".");
    }
}
