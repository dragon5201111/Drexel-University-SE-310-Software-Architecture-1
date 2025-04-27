package Question.Factory;

import Question.*;

import java.util.List;

public class MatchingFactory extends QuestionFactory{
    @Override
    public Question createQuestion(String prompt) {
        List<String> leftSet;
        List<String> rightSet;

        while (true){
            leftSet = this.getSet(this.consoleInputDriver.getStringInput("Enter the left set. Separate each with a space: "));
            rightSet = this.getSet(this.consoleInputDriver.getStringInput("Enter the right set. Separate each with a space: "));

            if(this.setsAreValid(leftSet, rightSet)){
                break;
            }

            this.consoleOutputDriver.println("Invalid left and right sets. Try again.");
        }

        return new Matching(prompt, leftSet, rightSet);
    }
}
