public class RPS {

    private String[] choices = {"Rock", "Paper", "Scissor"};
    private int selected = 0;
    private int computerSelected = 0;
    private int winner;

    public void play() {
        computerSelected = (int)Math.floor(Math.random() * 3);
        if (selected == computerSelected) {
            winner = 0; // tie
            return;
        }
        if (selected == 0) { // Player chose rock
            if (computerSelected == 1) {
                winner = 2;
            } else {
                winner = 1;
            }
        } else if (selected == 1) { // Player chose paper
            if (computerSelected == 0) {
                winner = 1;
            } else {
                winner = 2;
            }
        } else if (selected == 2) { // Player chose scissor
            if (computerSelected == 0) {
                winner = 2;
            } else {
                winner = 1;
            }
        }
    }

    public String[] getChoices() { return choices; }

    public int getSelected() { return selected; }
    public String getSelectedString() { return choices[selected]; }
    public int getComputerSelected() { return computerSelected; }
    public String getComputerSelectedString() { return choices[computerSelected]; }
    public int getWinner() { return winner; }
    public String getWinnerString() {
        if (winner == 0) { return "Tie"; }
        if (winner == 1) { return "Win"; }
        if (winner == 2) { return "Lose"; }

        return null;
    }

    public void changeSelected(int num) {
        selected += num;
        if (selected == -1) { selected = 1; }
        if (selected == 3) { selected = 0; }
    }
}
