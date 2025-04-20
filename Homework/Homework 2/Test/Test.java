import Menu.Survey.SurveyMenu;
import Question.*;
import Serialization.ObjectSerializer;
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
        leftSet.add("Sound");
        rightSet.add("Whistling");
        return new Matching("Match Like Objects", leftSet, rightSet);
    }

    public static MultipleChoice constructMultipleChoiceQuestion(){
        List<String> choices = new ArrayList<>();
        choices.add("Star Wars");
        choices.add("Video Games");
        choices.add("C");
        choices.add("Vision");
        choices.add("Cars");
        choices.add("Life is cool");
        return new MultipleChoice("Select 4", choices, 4);
    }

    public static void serializeTestSurvey(){
        ObjectSerializer serializer = new ObjectSerializer();
        Survey testSurvey = new Survey("Test Survey");
        testSurvey.addQuestion(constructMatchingQuestion());
        testSurvey.addQuestion(constructMultipleChoiceQuestion());
        testSurvey.addQuestion(new Essay("List two movies", 2));
        testSurvey.addQuestion(new ShortAnswer("List a three letter word", 3));
        testSurvey.addQuestion(new TrueFalse("Batman is evil"));
        testSurvey.addQuestion(new ValidDate("Enter your birthdate"));
        serializer.serialize(testSurvey, "sampleAllQs");
    }

    public static void main(String[] args) {
        SurveyMenu surveyMenu = new SurveyMenu();
        surveyMenu.start();
    }
}
