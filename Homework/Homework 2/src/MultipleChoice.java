import java.io.Serializable;
import java.util.List;

public class MultipleChoice extends Question implements Serializable {
    private final static long serialVersionUID = 1L;
    private final char CHAR_BASE = 'a';


    private List<String> choices;
    private int numberOfChoices;

    public MultipleChoice(String prompt, List<String> choices, int numberOfChoices) {
        super(prompt);
        this.choices = choices;
        this.numberOfChoices = numberOfChoices;
    }

    private void displayChoicesList(){
        for (int i = 0; i < this.choices.size(); i++) {
            consoleOutputDriver.println((char)(CHAR_BASE + i) + ") " + this.choices.get(i));
        }
    }

    @Override
    public void displayQuestion() {
        this.consoleOutputDriver.println(this.getPrompt());
        this.displayChoicesList();
    }

    private boolean isValidChoiceIndex(int index) {
        return index >= 0 && index < this.choices.size();
    }



    private int getChoiceIndex(String choice) {
        if(choice.isEmpty()){
            return -1;
        }

        return (int)(choice.charAt(0))- (int)CHAR_BASE;
    }

    @Override
    public void answerQuestion() {
        this.displayQuestion();

        for(int i = 0; i < this.numberOfChoices; i++){
            while (true) {
                String choice = consoleInputDriver.getStringInput("Choice " + (i + 1) + ": ");

                int choiceIndex = getChoiceIndex(choice);

                if (isValidChoiceIndex(choiceIndex)) {
                    this.addResponse(this.choices.get(choiceIndex));
                    break;
                }

            }
        }

    }

    @Override
    public void modifyQuestionParameters() {
        this.numberOfChoices = consoleInputDriver.getIntegerInput("Enter number of choices for question: ");
        consoleOutputDriver.println("Select a choice from the list to modify: ");
        this.displayChoicesList();

        String choice = consoleInputDriver.getStringInput("Choice to modify: ");
        int choiceIndex = getChoiceIndex(choice);

        String newChoice = consoleInputDriver.getStringInput("New choice to overwrite '" + this.choices.get(choiceIndex) + "': " );
        this.choices.set(choiceIndex, newChoice);
    }

    @Override
    public void displayResponse() {
        consoleOutputDriver.printLines(this.getResponseList());
    }
}
