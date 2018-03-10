public class RPS {

    private String[] choices = {"Rock", "Paper", "Scissor"};
    private int selected = 0;
    private int computerSelected = 0;

    public void play() {
        computerSelected = (int)Math.floor(Math.random() * 3);
    }

    public String[] getChoices() { return choices; }

    public int getSelected() { return selected; }
    public String getSelectedString() { return choices[selected]; }
    public int getComputerSelected() { return computerSelected; }
    public String getComputerSelectedString() { return choices[computerSelected]; }

    public void changeSelected(int num) {
        selected += num;
        if (selected == -1) { selected = 1; }
        if (selected == 3) { selected = 0; }
    }
}
