package Menu.Survey;

public class TestMenu extends SurveyMenu{
    @Override
    protected void initializeOptions() {
        SurveyCreateOption createOption = new SurveyCreateOption(this, true);
        createOption.setOptionLabel("Create a new Test");

        SurveyDisplayOption displayOption = new SurveyDisplayOption(this);
        displayOption.setOptionLabel("Display an existing Test without correct answers");

        SurveyDisplayWAnswersOption displayWAnswersOption = new SurveyDisplayWAnswersOption(this);
        displayWAnswersOption.setOptionLabel("Display an existing Test with correct answers");

        SurveyLoadOption loadOption = new SurveyLoadOption(this);
        loadOption.setOptionLabel("Load an existing Test");

        SurveySaveOption saveOption = new SurveySaveOption(this);
        saveOption.setOptionLabel("Save the current Test");

        SurveyTakeOption takeOption = new SurveyTakeOption(this);
        takeOption.setOptionLabel("Take the current Test");

        SurveyModifyOption modifyOption = new SurveyModifyOption(this);
        modifyOption.setOptionLabel("Modify the current Test");

        SurveyTabulateOption tabulateOption = new SurveyTabulateOption(this);
        tabulateOption.setOptionLabel("Tabulate a Test");

        SurveyGradeOption gradeOption = new SurveyGradeOption(this);

        this.addMenuOption(createOption);
        this.addMenuOption(displayOption);
        this.addMenuOption(displayWAnswersOption);
        this.addMenuOption(loadOption);
        this.addMenuOption(saveOption);
        this.addMenuOption(takeOption);
        this.addMenuOption(modifyOption);
        this.addMenuOption(tabulateOption);
        this.addMenuOption(gradeOption);
        this.addMenuOption(new SurveyExitOption(this));
    }
}
