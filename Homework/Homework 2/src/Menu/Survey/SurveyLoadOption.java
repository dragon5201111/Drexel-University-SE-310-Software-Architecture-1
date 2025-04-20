package Menu.Survey;

import Serialization.ObjectSerializer;
import Survey.Survey;

import java.util.List;

public class SurveyLoadOption extends SurveyActionOption{
    private final ObjectSerializer objectSerializer = new ObjectSerializer();

    public SurveyLoadOption(SurveyMenu surveyMenu) {
        super("Load an existing Survey", surveyMenu);
    }

    @Override
    public void execute() {
        this.performAction(null);
    }

    @Override
    protected void performAction(Survey survey) {
        List<String> serializedFiles = this.objectSerializer.getSerializedFiles();

        if(serializedFiles.isEmpty()){
            this.consoleOutputDriver.println("There are no survey files to load.");
            return;
        }

        this.consoleOutputDriver.printNumberedLines(serializedFiles, serializedFiles.size());
        int selection = this.consoleInputDriver.getIntegerInput("Select a survey to load by number: ", serializedFiles.size());

        String surveyName = serializedFiles.get(selection - 1);
        Survey surveyToLoad = (Survey) objectSerializer.deserialize(surveyName);

        this.surveyMenu.setLoadedSurvey(surveyToLoad, surveyName);
        this.consoleOutputDriver.println("Load success! Loaded Survey: " + surveyName);
    }
}
