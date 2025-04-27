package Question.Factory;

import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Question.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleQuestionFactory {
    private static final ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
    private static final ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

    public static Question createQuestion(QuestionType questionType) {
        String prompt = SimpleQuestionFactory.consoleInputDriver.getStringInput("Enter the prompt for the question: ");

        // Ordering of this switch is irrelevant
        switch (questionType) {
            case TRUE_FALSE:
                return SimpleQuestionFactory.createTrueFalse(prompt);
            case MULTIPLE_CHOICE:
                return SimpleQuestionFactory.createMultipleChoice(prompt);
            case SHORT_ANSWER:
                return SimpleQuestionFactory.createShortAnswer(prompt);
            case ESSAY:
                return SimpleQuestionFactory.createEssay(prompt);
            case VALID_DATE:
                return SimpleQuestionFactory.createValidDate(prompt);
            case MATCHING:
                return SimpleQuestionFactory.createMatching(prompt);
        }

        throw new IllegalArgumentException("Unrecognized question type! How did you get here?" + questionType);
    }

    private static boolean setsAreValid(List<String> leftSet, List<String> rightSet){
        return !leftSet.isEmpty() && !rightSet.isEmpty() && leftSet.size() == rightSet.size();
    }

    private static List<String> getSet(String set){
        return Arrays.stream(set.trim()
                .replaceAll("\\s+", " ")
                .split(" "))
                .collect(Collectors.toList());
    }

    private static Matching createMatching(String prompt) {
        List<String> leftSet;
        List<String> rightSet;

        while (true){
            leftSet = SimpleQuestionFactory.getSet(SimpleQuestionFactory.consoleInputDriver.getStringInput("Enter the left set. Separate each with a space: "));
            rightSet = SimpleQuestionFactory.getSet(SimpleQuestionFactory.consoleInputDriver.getStringInput("Enter the right set. Separate each with a space: "));

            if(setsAreValid(leftSet, rightSet)){
                break;
            }

            SimpleQuestionFactory.consoleOutputDriver.println("Invalid left and right sets. Try again.");
        }

        return new Matching(prompt, leftSet, rightSet);
    }

    private static int getResponseLimit(String subject) {
        return SimpleQuestionFactory.consoleInputDriver.getIntegerInput("Enter max number of " + subject + ": ");
    }

    private static ValidDate createValidDate(String prompt){
        return new ValidDate(prompt, SimpleQuestionFactory.getResponseLimit("responses"));
    }

    private static Essay createEssay(String prompt){
        return new Essay(prompt, SimpleQuestionFactory.getResponseLimit("responses"));
    }

    private static ShortAnswer createShortAnswer(String prompt){
        return new ShortAnswer(prompt, SimpleQuestionFactory.getResponseLimit("words"));
    }

    private static MultipleChoice createMultipleChoice(String prompt){
        int numberOfChoices = SimpleQuestionFactory.getResponseLimit("choices");
        int numberOfResponses = SimpleQuestionFactory.getResponseLimit("responses");

        List<String> choices = new ArrayList<>();

        for(int i = 0; i < numberOfChoices; i++){
            choices.add(SimpleQuestionFactory.consoleInputDriver.getStringInput("Enter choice #" + (i+1) + ": "));
        }

        return new MultipleChoice(prompt, choices, numberOfResponses);
    }

    private static TrueFalse createTrueFalse(String prompt){
        return new TrueFalse(prompt);
    }
}
