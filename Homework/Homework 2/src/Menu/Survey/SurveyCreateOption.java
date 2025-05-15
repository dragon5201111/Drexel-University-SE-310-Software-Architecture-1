package Menu.Survey;

import Question.Factory.QuestionFactory;
import Question.Factory.QuestionFactoryCreator;
import Question.Question;
import Question.QuestionType;
import Serialization.ObjectSerializer;
import Survey.Survey;
import Test.Test;

import java.util.List;

public class SurveyCreateOption extends SurveyMenuOption {
    private final boolean createTest;
    public SurveyCreateOption(SurveyMenu surveyMenu, boolean createTest) {
        super("Create a new Survey", surveyMenu);
        this.createTest = createTest;
    }

    @Override
    public void execute() {
        this.performAction(null);
    }

    private void displayOptions() {
        for(QuestionType questionType : QuestionType.values()){
            this.consoleOutputDriver.println(questionType.getValue() + ") Add a new " + questionType.getDisplayName());
        }
    }

    private Question createQuestionFromQuestionType(QuestionType questionType) {
        this.consoleOutputDriver.println("Creating a new question of type " + questionType.getDisplayName() + ".");
        QuestionFactory questionFactory = QuestionFactoryCreator.getQuestionFactory(questionType);
        String prompt = this.consoleInputDriver.getStringInput("Enter the prompt for the question: ");
        return questionFactory.createQuestion(prompt);
    }

    @Override
    protected void performAction(Survey survey) {
        String surveyTitle = consoleInputDriver.getStringInput("Enter a Title: ");
        Survey newSurvey;

        if(this.createTest){
            newSurvey = new Test(surveyTitle);
        }else{
            newSurvey = new Survey(surveyTitle);
        }

        while (this.consoleInputDriver.userWantsToModify("add a question")) {

            this.consoleOutputDriver.println();
            this.displayOptions();
            this.consoleOutputDriver.println();

            int choice = this.consoleInputDriver.getIntegerInput("Enter question type (select corresponding number): ");
            this.consoleOutputDriver.println();

            if(!QuestionType.isValidValue(choice)){
                this.consoleOutputDriver.println("Invalid question type. Try again.");
                continue;
            }

            QuestionType questionType = QuestionType.fromValue(choice);
            Question newQuestion = this.createQuestionFromQuestionType(questionType);
            newSurvey.addQuestion(newQuestion);

            if(this.createTest && this.consoleInputDriver.userWantsToModify("add a correct answer")) {
               List<String> correctAnswers = newQuestion.getCorrectAnswers();
               ((Test)newSurvey).addAnswer(newQuestion, correctAnswers);
            }
        }

        this.surveyMenu.setLoadedSurvey(newSurvey);
        ObjectSerializer.serialize(newSurvey, surveyTitle);
        this.consoleOutputDriver.println();
        this.consoleOutputDriver.println("'" + surveyTitle + "' has been created, saved, and loaded.");
    }
}
