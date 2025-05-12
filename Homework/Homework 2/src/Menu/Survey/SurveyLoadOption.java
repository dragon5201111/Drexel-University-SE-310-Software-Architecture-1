package Menu.Survey;

import Serialization.ObjectSerializer;
import Survey.Survey;

import java.util.List;

public class SurveyLoadOption extends SurveyMenuOption {

    public SurveyLoadOption(SurveyMenu surveyMenu) {
        super("Load", surveyMenu);
    }

    @Override
    public void execute() {
        this.performAction(null);
    }

    @Override
    protected void performAction(Survey survey) {
        List<String> serializedFiles = ObjectSerializer.getSerializedFileNames();

        if(serializedFiles.isEmpty()){
            this.consoleOutputDriver.println("There are no survey files to load.");
            return;
        }

        this.consoleOutputDriver.printNumberedLines(serializedFiles, serializedFiles.size());
        int selection = this.consoleInputDriver.getIntegerInput("Please select a file to load: ", serializedFiles.size());

        String surveyName = serializedFiles.get(selection - 1);
        Survey surveyToLoad = (Survey) ObjectSerializer.deserialize(surveyName);

        this.surveyMenu.setLoadedSurvey(surveyToLoad);
        this.consoleOutputDriver.println("Load success! Loaded survey: " + surveyName);
    }
}
