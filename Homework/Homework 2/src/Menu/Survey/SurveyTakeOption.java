package Menu.Survey;

import Serialization.ObjectSerializer;
import Survey.Survey;

public class SurveyTakeOption extends SurveyMenuOption {

    public SurveyTakeOption(SurveyMenu surveyMenu) {
        super("Take the current Survey", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        survey.take();
        ObjectSerializer.serialize(survey, survey.getTitle());
        ObjectSerializer.serialize(survey, String.format("%s - Response %d", survey.getTitle(), survey.getNumberOfResponses()));
        this.consoleOutputDriver.println("Saved response.");
    }
}
