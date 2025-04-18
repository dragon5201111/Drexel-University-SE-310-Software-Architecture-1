import java.util.ArrayList;
import java.util.List;

public class SurveyDriver {
   public static MultipleChoice constructMC(){
       List<String> choices = new ArrayList<>();
       choices.add("Fantasy");
       choices.add("Math");
       choices.add("Science");
       return new MultipleChoice("Select 3", choices, 3);
   }

   public static Matching constructMatching(){
       List<String> leftSet  = new ArrayList<>();
       List<String> rightSet = new ArrayList<>();

       leftSet.add("Java");
       leftSet.add("C");
       leftSet.add("C++");
       leftSet.add("GO");
       leftSet.add("Assembly");

       rightSet.add("Rust");
       rightSet.add("Lua");
       rightSet.add("C#");
       rightSet.add("Python");
       rightSet.add("Bash");

       return new Matching("Match like languages", leftSet, rightSet);
   }

    public static void main(String[] args) {
        Survey survey = new Survey("Foo bar");

        survey.addQuestion(new TrueFalse("The sky is blue?"));
        survey.addQuestion(new ShortAnswer("Enter a five letter word.", 5));
        survey.addQuestion(new Essay("List two of the best movies.", 2));
//        survey.addQuestion(constructMC());
//        survey.addQuestion(constructMatching());
//        survey.addQuestion(new ValidDate("Enter a valid date."));

        survey.displaySurvey();
        survey.modifySurvey();
        survey.takeSurvey();
        survey.displaySurvey();
    }
}
