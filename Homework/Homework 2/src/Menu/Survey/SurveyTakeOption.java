package Menu.Survey;

import Survey.Survey;

public class SurveyTakeOption extends SurveyMenuOption {

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
        this.consoleOutputDriver.println("Survey response saved as " + responseSaveName + ". Load the survey to view your responses!");

        // Don't keep responses on survey. They are stored in a file.
        survey.clearSurveyResponses();
    }
}
