package Menu.Survey;

import Survey.Survey;

import java.util.List;

public class SurveyLoadOption extends SurveyActionOption{

    public SurveyLoadOption(SurveyMenu surveyMenu) {
        super("Load an existing Survey", surveyMenu);
    }

    @Override
    public void execute() {
        this.performAction(null);
    }

    @Override
    protected void performAction(Survey survey) {
        List<String> serializedFiles = this.objectSerializer.getSerializedFileNames();

        if(serializedFiles.isEmpty()){
            this.consoleOutputDriver.println("There are no survey files to load.");
            return;
        }

        this.consoleOutputDriver.printNumberedLines(serializedFiles, serializedFiles.size());
        int selection = this.consoleInputDriver.getIntegerInput("Please select a file to load: ", serializedFiles.size());

        String surveyName = serializedFiles.get(selection - 1);
        Survey surveyToLoad = (Survey) objectSerializer.deserialize(surveyName);

        this.surveyMenu.setLoadedSurvey(surveyToLoad);
        this.consoleOutputDriver.println("Load success! Loaded survey: " + surveyName);
    }
}
