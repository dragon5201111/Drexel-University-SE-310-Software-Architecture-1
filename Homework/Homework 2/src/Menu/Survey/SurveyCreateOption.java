package Menu.Survey;

import Question.Factory.QuestionFactory;
import Question.Question;
import Question.QuestionType;
import Survey.Survey;
import java.util.List;

public class SurveyCreateOption extends SurveyActionOption{
    private final QuestionFactory questionFactory;

    public SurveyCreateOption(SurveyMenu surveyMenu) {
        super("Create a new Survey", surveyMenu);
        this.questionFactory = new QuestionFactory();
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
            // TODO: fix this
            List<String> displayNames = QuestionType.getDisplayNames();
            this.consoleOutputDriver.printNumberedLines(displayNames, displayNames.size());

            int choice = this.consoleInputDriver.getIntegerInput("Enter Question Type: ", displayNames.size());
            QuestionType questionType = QuestionType.fromValue(choice);

            Question newQuestion = questionFactory.createQuestion(questionType);
            newSurvey.addQuestion(newQuestion);
        }

        this.surveyMenu.setLoadedSurvey(newSurvey);
        this.consoleOutputDriver.println("'" + surveyTitle + "' has been created and loaded.");
    }
}
