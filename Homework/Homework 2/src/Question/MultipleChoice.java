package Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MultipleChoice extends Question implements Serializable {
    private final static long serialVersionUID = 5L;

    private final List<String> choices;
    private int numberOfChoices;

    public MultipleChoice(String prompt, List<String> choices, int numberOfChoices) {
        super(prompt);
        this.choices = new ArrayList<>(choices);
        this.numberOfChoices = numberOfChoices;
    }

    private void displayChoicesList(){
        for (int i = 0; i < this.choices.size(); i++) {
            String choiceText = String.format("%c) %s", this.consoleInputDriver.CHAR_BASE + i, this.choices.get(i));
            if (i < this.choices.size() - 1) {
                choiceText += "  "; // Add space between choices
            }
            consoleOutputDriver.print(choiceText);
        }
        this.consoleOutputDriver.println();
    }

    @Override
    public void displayQuestion() {
        this.consoleOutputDriver.println(this.getPrompt() + " Please Give " + this.numberOfChoices + " choices.");
        this.displayChoicesList();
    }


    @Override
    public List<String> tabulateResponses() {
        return this.getResponseFrequenciesList();
    }

    private List<String> collectChoices(String promptPrefix) {
        List<String> selections = new ArrayList<>();

        for (int i = 0; i < this.numberOfChoices; i++) {
            while (true) {
                String choice = consoleInputDriver.getStringInput(promptPrefix + " " + (i + 1) + ": ");

                int choiceIndex = getChoiceIndex(choice);

                if (isValidChoiceIndex(choiceIndex)) {
                    selections.add(this.choices.get(choiceIndex));
                    break;
                }

                consoleOutputDriver.println("Invalid Choice. Please try again.");
            }
        }

        return selections;
    }


    @Override
    public List<String> getCorrectAnswers() {
        return this.collectChoices("Choice");
    }

    @Override
    public void answerQuestionBody() {
        List<String> choices = collectChoices("Choice");
        for (String choice : choices) {
            this.addResponse(choice);
        }
    }

    private boolean isValidChoiceIndex(int index) {
        return index >= 0 && index < this.choices.size();
    }



    private int getChoiceIndex(String choice) {
        if(choice.isEmpty()){
            return -1;
        }

        return (int)(choice.charAt(0))- (int)this.consoleInputDriver.CHAR_BASE;
    }


    @Override
    public void modifyQuestionParameters() {
        this.numberOfChoices = consoleInputDriver.getIntegerInput("Enter number of responses permitted for the question: ");

        consoleOutputDriver.println("Select a choice from the list to modify: ");
        this.displayChoicesList();

        String choice = consoleInputDriver.getStringInput("Select a choice to modify (A,B,C,D...): ");
        int choiceIndex = getChoiceIndex(choice);

        String newChoice = consoleInputDriver.getStringInput("Overwriting '" + this.choices.get(choiceIndex) + "': " );
        this.choices.set(choiceIndex, newChoice);
    }

    @Override
    public void displayResponse() {
        consoleOutputDriver.printLines(this.getResponseList());
    }
}
