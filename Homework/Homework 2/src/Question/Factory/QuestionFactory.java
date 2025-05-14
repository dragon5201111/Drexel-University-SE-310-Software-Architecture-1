package Question.Factory;

import Question.Question;
import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public abstract class QuestionFactory {
    protected final ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
    protected final ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

    public abstract Question createQuestion(String prompt);

    protected List<String> getSet(String set){
        return Arrays.stream(set.trim()
                        .replaceAll("\\s+", " ")
                        .split(" "))
                .collect(Collectors.toList());
    }

    protected boolean setsAreValid(List<String> leftSet, List<String> rightSet){
        return !leftSet.isEmpty() && !rightSet.isEmpty() && leftSet.size() == rightSet.size();
    }

    protected int getResponseLimit(String subject) {
        return this.consoleInputDriver.getIntegerInput("Enter the number of " + subject + ": ");
    }
}