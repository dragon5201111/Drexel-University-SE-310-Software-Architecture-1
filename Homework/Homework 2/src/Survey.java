import IO.ConsoleInputDriver;
import IO.ConsoleOutputDriver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Survey implements Serializable {
    private final ConsoleOutputDriver consoleOutputDriver;
    private final ConsoleInputDriver consoleInputDriver;
    private final List<Question> questions;


    private String surveyTitle;
    private static final long serialVersionUID = 1L;

    public Survey(String surveyTitle) {
        this.surveyTitle = surveyTitle;
        this.questions = new ArrayList<>();
        this.consoleOutputDriver = new ConsoleOutputDriver();
        this.consoleInputDriver = new ConsoleInputDriver();
    }

    public void addQuestion(Question question){
        this.questions.add(question);
    }

    public Question getQuestion(int index){
        return this.questions.get(index);
    }

    public void removeQuestion(int questionIndex){
        this.questions.remove(questionIndex);
    }

    public void setSurveyTitle(String surveyTitle){
        this.surveyTitle = surveyTitle;
    }

    public void modifySurvey(){
        if(!this.consoleInputDriver.userWantsToModify("modify","survey")){
            return;
        }

        if(this.consoleInputDriver.userWantsToModify("modify", "survey title")){
            this.setSurveyTitle(this.consoleInputDriver.getStringInput("Enter survey title: "));
        }

        this.displaySurvey();

        int questionIndex = consoleInputDriver.getIntegerInput("Enter a corresponding question number: ", questions.size()) - 1;
        Question question = this.getQuestion(questionIndex);

        if(!consoleInputDriver.userWantsToModify("delete", "question")){
            question.modifyQuestion();
            return;
        }

        this.removeQuestion(questionIndex);
        consoleOutputDriver.println("Question deleted.");
    }

    public void takeSurvey(){
        this.displaySurveyTitle();

        int questionNumber = 1;
        for(Question question : questions){
            consoleOutputDriver.print(questionNumber + ") ");
            question.answerQuestion();
            consoleOutputDriver.println();
            questionNumber++;
        }
    }


    public void displaySurvey(){
        this.displaySurveyTitle();

        int questionNumber = 1;
        for(Question question : questions){
            consoleOutputDriver.print(questionNumber + ") ");
            question.displayQuestion();
            question.displayResponse();
            consoleOutputDriver.println();
            questionNumber++;
        }
    }


    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void displaySurveyTitle(){
        consoleOutputDriver.println("Survey Name: "+this.getSurveyTitle());
    }

}
