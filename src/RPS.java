public class RPS {

    private String[] choices = {"Rock", "Paper", "Scissor"};
    private int selected = 0;

    public void play() {

    }

    public String[] getChoices() { return choices; }

    public int getSelected() { return selected; }

    public void changeSelected(int num) {
        selected += num;
        if (selected == -1) { selected = 1; }
        if (selected == 3) { selected = 0; }
    }
}
