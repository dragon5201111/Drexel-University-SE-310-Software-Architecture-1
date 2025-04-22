package Question;

import java.util.HashMap;
import java.util.Map;

public enum QuestionType {
    // DO NOT USE DUPLICATE VALUES
    TRUE_FALSE(1, "True/False"),
    MULTIPLE_CHOICE(2, "Multiple Choice"),
    SHORT_ANSWER(3, "Short Answer"),
    ESSAY(4, "Essay"),
    VALID_DATE(5, "Valid Date"),
    MATCHING(6, "Matching");

    private final int value;
    private final String displayName;
    private final static Map<Integer, QuestionType> typeMap = new HashMap<Integer, QuestionType>();

    static {
        for (QuestionType questionType : QuestionType.values()) {
            typeMap.put(questionType.value, questionType);
        }
    }

    QuestionType(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static boolean isValidValue(int value) {
        return typeMap.containsKey(value);
    }

    public int getValue() {
        return this.value;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static QuestionType fromValue(int value) {
        for (QuestionType type : QuestionType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        // Default is to return TRUE_FALSE as to throwing exception
        return TRUE_FALSE;
    }

}
