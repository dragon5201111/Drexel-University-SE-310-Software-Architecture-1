package Menu.Survey;

public abstract class MenuDecorator implements Menu {
    protected final Menu menu;

    public MenuDecorator(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void start(){
        this.menu.start();
    }

    @Override
    public void addMenuOption(int position, SurveyMenuOption menuOption){
        this.menu.addMenuOption(position, menuOption);
    }

    @Override
    public void setMenuOption(int position, SurveyMenuOption menuOption){
        this.menu.setMenuOption(position, menuOption);
    }
}