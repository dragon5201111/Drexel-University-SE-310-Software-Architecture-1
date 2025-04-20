package Question;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Matching extends Question implements Serializable {
    @Serial
    private final static long serialVersionUID = 4L;

    private final String LEFT_SET = "left-Set";
    private final String RIGHT_SET = "right-Set";

    private final List<String> leftSet;
    private final List<String> rightSet;

    public Matching(String prompt, List<String> leftSet, List<String> rightSet) {
        super(prompt);
        this.leftSet = leftSet;
        this.rightSet = rightSet;
    }


    @Override
    public void displayQuestion() {
        this.consoleOutputDriver.println(this.getPrompt());
        for(int i = 0; i < this.leftSet.size(); i++){
            consoleOutputDriver.println(constructPairString(i, i));
        }
    }

    private String constructPairString(int leftIndex, int rightIndex){
        return String.format("%c) %-15s %d) %s", (char)(this.consoleInputDriver.CHAR_BASE+leftIndex),this.leftSet.get(leftIndex), rightIndex+1,this.rightSet.get(rightIndex));
    }

    @Override
    public void answerQuestionBody() {
        String pair;
        for(int i = 0; i < this.leftSet.size(); i++){

            while(true){
                pair = consoleInputDriver.getStringInput("Enter a pair (" + (i+1) + "):");

                if(isValidPair(pair)){
                    break;
                }

                consoleOutputDriver.println("Invalid pair. Enter a character followed by an integer.");
            }

            int[] pairIndexes = getPairIndexes(pair);
            this.addResponse(constructPairString(pairIndexes[0], pairIndexes[1]));
        }
    }


    private boolean indexIsInList(int index, List<String> list){
        return index >= 0 && index < list.size();
    }


    private boolean isValidPair(String pair){
        int length = pair.length();

        if(length < 2){
            return false;
        }

        int[] pairIndexes = getPairIndexes(pair);
        if (pairIndexes[0] == -1 || pairIndexes[1] == -1) return false;

        return indexIsInList(pairIndexes[0], leftSet) && indexIsInList(pairIndexes[1], rightSet);
    }

    private int[] getPairIndexes(String pair){
        int leftIndex = convertCharToInt(pair.charAt(0));

        String rightPart = pair.substring(1);
        int rightIndex;
        try {
            rightIndex = Integer.parseInt(rightPart) - 1;
        } catch (NumberFormatException e) {
            return new int[]{-1, -1};
        }

        return new int[]{leftIndex, rightIndex};
    }


    private int convertCharToInt(char c){
        return c - this.consoleInputDriver.CHAR_BASE;
    }

    private int getSetIndex(String side, String selection){
        int setIndex;
        while(true){
            try {
                if (side.equals(LEFT_SET)) {
                    setIndex = convertCharToInt(selection.charAt(0));
                } else {
                    setIndex = Integer.parseInt(selection) - 1;
                }
                break;
            } catch (Exception e) {
                consoleOutputDriver.println("Invalid input format.");
            }

        }
        return setIndex;
    }

    private void modifySet(List<String> set, String side){
        while (true) {
            String selection = consoleInputDriver.getStringInput("Enter a selection to modify in the " + side + " set: ");

            if (selection.isEmpty()) {
                continue;
            }

            int setIndex = getSetIndex(side, selection);

            if (!indexIsInList(setIndex, set)) {
                consoleOutputDriver.println("Invalid selection for " + side + " set.");
                continue;
            }

            String newSelection = consoleInputDriver.getStringInput("Overwriting '" + set.get(setIndex) + "' with: ");
            set.set(setIndex, newSelection);
            break;
        }
    }

    @Override
    public void modifyQuestionParameters() {
        this.displayQuestion();

        if(this.consoleInputDriver.userWantsToModify("modify", LEFT_SET)){
            this.modifySet(leftSet, LEFT_SET);
        }

        if (this.consoleInputDriver.userWantsToModify("modify", RIGHT_SET)) {
           this.modifySet(rightSet, RIGHT_SET);
        }
    }

    @Override
    public void displayResponse() {
        consoleOutputDriver.printLines(this.getResponseList());
    }
}
