package Question.Factory;

import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Question.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionFactory {
    private final ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
    private final ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

    public Question createQuestion(QuestionType questionType) {
        String prompt = this.consoleInputDriver.getStringInput("Enter the prompt for the question: ");

        // Ordering of this switch is irrelevant
        return switch (questionType) {
            case TRUE_FALSE -> this.createTrueFalse(prompt);
            case MULTIPLE_CHOICE -> this.createMultipleChoice(prompt);
            case SHORT_ANSWER -> this.createShortAnswer(prompt);
            case ESSAY -> this.createEssay(prompt);
            case VALID_DATE -> this.createValidDate(prompt);
            case MATCHING -> this.createMatching(prompt);
        };
    }

    private boolean setsAreValid(List<String> leftSet, List<String> rightSet){
        return !leftSet.isEmpty() && !rightSet.isEmpty() && leftSet.size() == rightSet.size();
    }

    private List<String> getSet(String set){
        return Arrays.stream(set.trim()
                .replaceAll("\\s+", " ")
                .split(" "))
                .toList();
    }

    private Matching createMatching(String prompt) {
        List<String> leftSet;
        List<String> rightSet;

        while (true){
            leftSet = this.getSet(this.consoleInputDriver.getStringInput("Enter the left set. Separate each with a space: "));
            rightSet = this.getSet(this.consoleInputDriver.getStringInput("Enter the right set. Separate each with a space: "));

            if(setsAreValid(leftSet, rightSet)){
                break;
            }

            this.consoleOutputDriver.println("Invalid left and right sets. Try again.");
        }

        return new Matching(prompt, leftSet, rightSet);
    }

    private int getResponseLimit(String subject) {
        return this.consoleInputDriver.getIntegerInput("Enter max number of " + subject + ": ");
    }

    private ValidDate createValidDate(String prompt){
        return new ValidDate(prompt, this.getResponseLimit("responses"));
    }

    private Essay createEssay(String prompt){
        return new Essay(prompt, this.getResponseLimit("responses"));
    }

    private ShortAnswer createShortAnswer(String prompt){
        return new ShortAnswer(prompt, this.getResponseLimit("words"));
    }

    private MultipleChoice createMultipleChoice(String prompt){
        int numberOfChoices = this.getResponseLimit("choices");
        int numberOfResponses = this.getResponseLimit("responses");

        List<String> choices = new ArrayList<>();

        for(int i = 0; i < numberOfChoices; i++){
            choices.add(this.consoleInputDriver.getStringInput("Enter choice #" + (i+1) + ": "));
        }

        return new MultipleChoice(prompt, choices, numberOfResponses);
    }

    private TrueFalse createTrueFalse(String prompt){
        return new TrueFalse(prompt);
    }
}
