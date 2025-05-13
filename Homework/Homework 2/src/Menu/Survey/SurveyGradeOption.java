package Menu.Survey;
import Question.*;
import Survey.Survey;
import Test.Test;

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

    private double calculateGrade(Test test, List<Question> questions) {
        double grade = 0;
        int totalQuestions = questions.size();
        double pointsPerQuestion = (double) 100 / totalQuestions;

        for(Question question : questions){
            if(this.isEssayQuestion(question)){
                continue;
            }

            List<String> answersList = test.getAnswerList(question);
            boolean isCorrect = question.grade(answersList);

            if(isCorrect){
                grade += pointsPerQuestion;
            }
        }

        return grade;
    }

    private void displayGrade(double grade, int essayQuestionCount, double pointsPerQuestion) {
        this.consoleOutputDriver.println("You received an " + grade + " on the test.");

        if(essayQuestionCount > 0){
            this.consoleOutputDriver.println("The test was worth 100 points, but only " + (100 - (essayQuestionCount * pointsPerQuestion)) +
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

    @Override
    protected void performAction(Survey survey) {
        if(isNotTest(survey)) {
            this.consoleOutputDriver.println("Error! You need to select a Test. Please load or create a Test.");
            return;
        }

        Test test = (Test)survey;
        List<Question> questions = test.getQuestions();

        double grade = calculateGrade(test, questions);
        this.displayGrade(grade, this.getEssayQuestionCount(questions), (double) 100 / questions.size());
    }
}
