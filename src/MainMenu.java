public class MainMenu {
    private String[] buttons = {"START", "EXIT"};
    private int selected = 0;

    public String[] getButtons() {
        return buttons;
    }

    public int getSelected() {
        return selected;
    }

    public void changeSelected(int num) {
        selected += num;
        if (selected == -1) { selected = 1; }
        if (selected == 2) { selected = 0; }
    }

    public void select() {

    }
}
