package Menu.Survey;

import Survey.Survey;

public class SurveyCreateOption extends SurveyActionOption{
    public SurveyCreateOption(SurveyMenu surveyMenu) {
        super("Create a new Survey", surveyMenu);
    }

    @Override
    public void execute() {
        Survey loadedSurvey = this.surveyMenu.getLoadedSurvey();

        if(loadedSurvey == null){
            this.performAction(null);
            return;
        }

        this.consoleOutputDriver.println("This action will overwrite the loaded survey.");

        if(this.consoleInputDriver.userWantsToModify("overwrite", "survey")){
            this.consoleOutputDriver.println();
            this.performAction(null);
        }
    }

    @Override
    protected void performAction(Survey survey) {
        String surveyTitle = consoleInputDriver.getStringInput("Enter a Survey Title: ");
        Survey newSurvey = new Survey(surveyTitle);

        while (this.consoleInputDriver.userWantsToModify("add a question", "survey")) {
            this.consoleOutputDriver.println("Unimplemented operation. Adding question...");
        }

        this.surveyMenu.setLoadedSurvey(newSurvey);
        this.consoleOutputDriver.println("'" + surveyTitle + "' has been created and loaded.");
    }
}
