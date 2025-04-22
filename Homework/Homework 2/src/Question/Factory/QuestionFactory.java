package Question.Factory;

import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Question.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionFactory {
    private final ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
    private final ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

    public Question createQuestion(QuestionType questionType) {
        String prompt = this.consoleInputDriver.getStringInput("Enter the prompt for the question: ");

        // Ordering of this switch is irrelevant
        switch (questionType) {
            case TRUE_FALSE:
                return this.createTrueFalse(prompt);
            case MULTIPLE_CHOICE:
                return this.createMultipleChoice(prompt);
            case SHORT_ANSWER:
                return this.createShortAnswer(prompt);
            case ESSAY:
                return this.createEssay(prompt);
            case VALID_DATE:
                return this.createValidDate(prompt);
            case MATCHING:
                return this.createMatching(prompt);
        }

        throw new IllegalArgumentException("Unrecognized question type! How did you get here?" + questionType);
    }

    private boolean setsAreValid(List<String> leftSet, List<String> rightSet){
        return !leftSet.isEmpty() && !rightSet.isEmpty() && leftSet.size() == rightSet.size();
    }

    private List<String> getSet(String set){
        return Arrays.stream(set.trim()
                .replaceAll("\\s+", " ")
                .split(" "))
                .collect(Collectors.toList());
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
