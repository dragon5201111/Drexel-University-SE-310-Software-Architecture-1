package Menu;

public abstract class MenuOption {
    private final String optionLabel;

    public MenuOption(String optionLabel) {
        this.optionLabel = optionLabel;
    }

     public abstract void execute();

    public String getOptionLabel() {
        return this.optionLabel;
    }
}
