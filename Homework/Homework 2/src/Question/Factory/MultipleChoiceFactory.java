package Question.Factory;

import Question.*;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceFactory extends QuestionFactory{
    @Override
    public Question createQuestion(String prompt) {
        int numberOfChoices = this.getResponseLimit("choices for your multiple-choice question");
        int numberOfResponses = this.getResponseLimit("responses");

        List<String> choices = new ArrayList<>();

        for(int i = 0; i < numberOfChoices; i++){
            choices.add(this.consoleInputDriver.getStringInput("Enter choice #" + (i+1) + ": "));
        }

        return new MultipleChoice(prompt, choices, numberOfResponses);
    }
}
