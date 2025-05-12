package Menu.Survey;

import Serialization.ObjectSerializer;
import Survey.Survey;

public class SurveyTakeOption extends SurveyMenuOption {

    public SurveyTakeOption(SurveyMenu surveyMenu) {
        super("Take", surveyMenu);
    }

    private String getResponseSaveName(Survey survey) {
        return survey.getTitle() + "Response";
    }

    @Override
    protected void performAction(Survey survey) {
        survey.take();
        String responseSaveName = this.getResponseSaveName(survey);
        ObjectSerializer.serialize(survey, responseSaveName);
        this.consoleOutputDriver.println("Survey response saved as " + responseSaveName + ". Load the survey to view your responses!");
    }
}
