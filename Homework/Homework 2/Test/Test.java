import Menu.Survey.SurveyMenu;
import Question.Essay;
import Question.ShortAnswer;
import Question.TrueFalse;
import Survey.Survey;

public class Test {

    public static void main(String[] args) {
        Survey testSurvey = new Survey("Test Survey");
        testSurvey.addQuestion(new Essay("Write 3 paragraphs.", 3));
        testSurvey.addQuestion(new TrueFalse("The air is visible?"));
        testSurvey.addQuestion(new ShortAnswer("Write three words.", 3));

        SurveyMenu surveyMenu = new SurveyMenu();
        surveyMenu.setLoadedSurvey(testSurvey);
        surveyMenu.start();
    }
}
