package Menu.Survey;
import Question.*;
import Survey.Survey;
import Test.Test;

import java.util.ArrayList;
import java.util.List;

public class SurveyGradeOption extends SurveyMenuOption{
    public SurveyGradeOption(SurveyMenu surveyMenu) {
        super("Grade", surveyMenu);
    }

    private boolean isNotTest(Survey survey) {
        return !(survey instanceof Test);
    }

    private boolean isEssayQuestion(Question question) {
        return question instanceof Essay && !(question instanceof ShortAnswer);
    }

    private double calculateGrade(Test test, int index, List<Question> questions) {
        double grade = 0;
        int totalQuestions = questions.size();
        double pointsPerQuestion = (double) 100 / totalQuestions;

        for(Question question : questions){
            if(this.isEssayQuestion(question)){
                continue;
            }

            List<String> answersList = test.getAnswerList(question);
            boolean isCorrect = question.grade(index, answersList);

            if(isCorrect){
                grade += pointsPerQuestion;
            }
        }

        return grade;
    }

    private void displayGrade(double grade, int essayQuestionCount, double pointsPerQuestion) {
        this.consoleOutputDriver.println("You received an " + String.format("%.2f", grade) + " on the test.");

        if (essayQuestionCount > 0) {
            double autoGradablePoints = 100 - (essayQuestionCount * pointsPerQuestion);
            this.consoleOutputDriver.println("The test was worth 100 points, but only " +
                    String.format("%.2f", autoGradablePoints) +
                    " of those points could be auto graded because there was at least one essay question.");
        }
    }

    private int getEssayQuestionCount(List<Question> questions){
        int count = 0;
        for (Question question : questions){
            if(this.isEssayQuestion(question)){
                count++;
            }
        }
        return count;
    }

    private List<String> constructResponsePrompt(Test test, int numberOfResponses){
        List<String> prompt = new ArrayList<>();
        for(int i = 0; i < numberOfResponses; i++){
            prompt.add(test.getTitle() + " - Response " + (i + 1));
        }
        return prompt;
    }

    @Override
    protected void performAction(Survey survey) {
        if(isNotTest(survey)) {
            this.consoleOutputDriver.println("Error! You need to select a Test. Please load or create a Test.");
            return;
        }


        Test test = (Test)survey;
        int numberOfResponses = test.getNumberOfResponses();
        if(numberOfResponses == 0){
            this.consoleOutputDriver.println("Cannot grade a test that has not been taken. Please take the test first.");
            return;
        }

        this.consoleOutputDriver.printNumberedLines(this.constructResponsePrompt(test, numberOfResponses), numberOfResponses);
        int responseIndex = this.consoleInputDriver.getIntegerInput("Select an existing response set: ", numberOfResponses);
        this.consoleOutputDriver.println();

        List<Question> questions = test.getQuestions();
        double grade = calculateGrade(test, responseIndex - 1, questions);
        this.displayGrade(grade, this.getEssayQuestionCount(questions), (double) 100 / questions.size());
    }
}
