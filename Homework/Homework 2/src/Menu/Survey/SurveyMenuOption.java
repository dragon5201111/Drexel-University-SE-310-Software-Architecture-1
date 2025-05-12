package Menu.Survey;

import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Survey.Survey;

public abstract class SurveyMenuOption {
    private final String optionLabel;

    protected final SurveyMenu surveyMenu;
    protected final ConsoleOutputDriver consoleOutputDriver;
    protected final ConsoleInputDriver consoleInputDriver;

    public SurveyMenuOption(String optionLabel, SurveyMenu surveyMenu) {
        this.optionLabel = optionLabel;
        this.surveyMenu = surveyMenu;
        this.consoleOutputDriver = new ConsoleOutputDriver();
        this.consoleInputDriver = new ConsoleInputDriver();
    }

    public void execute() {
        Survey loadedSurvey = this.surveyMenu.getLoadedSurvey();

        if (loadedSurvey != null) {
            performAction(loadedSurvey);
        } else {
            this.consoleOutputDriver.println("You must load in order to perform this action.");
        }
    }

    protected abstract void performAction(Survey survey);

    public String getOptionLabel() {
        return this.optionLabel;
    }

}
