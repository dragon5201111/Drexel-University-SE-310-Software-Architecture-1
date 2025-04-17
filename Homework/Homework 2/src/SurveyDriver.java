import java.util.ArrayList;
import java.util.List;

public class SurveyDriver {
    public static void test(Question question){
        System.out.println("Question Test:");

        System.out.println("Displaying Question:");
        question.displayQuestion();
        System.out.println();

        System.out.println("Modifying Question:");
        question.modifyQuestion();
        System.out.println();

        System.out.println("Answering Question:");
        question.answerQuestion();
        System.out.println();

        System.out.println("Displaying Question Response:");
        question.displayResponse();
        System.out.println();
    }

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
//        questions.add(new Essay("In two parts explain ...", 2));
//        questions.add(new ShortAnswer("Give two letter word ...", 2));
//
//        List<String> choices = new ArrayList<>();
//        choices.add("Star Wars");
//        choices.add("Benz");
//        choices.add("Brazilian");
//
//
//        questions.add(new MultipleChoice("Select three", choices, 3));
//        questions.add(new ValidDate("Enter birthday"));
//        questions.add(new TrueFalse("Batman is cool T/F?"));

        List<String> leftSet = new ArrayList<>();
        List<String> rightSet = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            leftSet.add(String.valueOf(i));
            rightSet.add(String.valueOf((char)(i + 65)));
        }

        questions.add(new Matching("Who let the dogs out?", leftSet, rightSet));


        for(Question question : questions){
            test(question);
        }

    }
}
