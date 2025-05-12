package Menu.Survey;

public class TestMenuDecorator extends MenuDecorator {
    public TestMenuDecorator(Menu menu) {
        super(menu);
        this.addTestOptions();
    }

    private void addTestOptions(){
        this.setMenuOption(0, new SurveyCreateOption((SurveyMenu) this.menu, true));
        this.addMenuOption(2, new SurveyDisplayWAnswersOption((SurveyMenu) this.menu));
        this.addMenuOption(7, new SurveyGradeOption((SurveyMenu) this.menu));
    }
}