import Menu.Survey.SurveyMenu;
import Question.*;
import Survey.Survey;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static Matching constructMatchingQuestion(){
        List<String> leftSet = new ArrayList<>();
        List<String> rightSet = new ArrayList<>();

        leftSet.add("Minecraft");
        rightSet.add("Video Games");

        leftSet.add("Java");
        rightSet.add("C++");

        leftSet.add("Colors");
        rightSet.add("Vision");

        return new Matching("Match Like Objects", leftSet, rightSet);
    }

    public static void main(String[] args) {
        Survey testSurvey = new Survey("Test Survey");
        testSurvey.addQuestion(new Essay("Write 3 paragraphs.", 3));
        testSurvey.addQuestion(new TrueFalse("The air is visible?"));
        testSurvey.addQuestion(new ShortAnswer("Write three words.", 3));
        testSurvey.addQuestion(new ValidDate("Enter your birthdate."));
        testSurvey.addQuestion(constructMatchingQuestion());

        SurveyMenu surveyMenu = new SurveyMenu();
        surveyMenu.setLoadedSurvey(testSurvey);
        surveyMenu.start();
    }
}
