import java.util.LinkedList;

public class Game {

    private int scene = 0;
    private int winner;

    public int getScene() { return scene; }
    public void setScene(int num) { scene = num; }
    public int getWinner() { return winner; }
    public String getWinnerString() {
        if (winner == 1) { return "Player 1"; }
        if (winner == 2) { return "Computer"; }
        return null;
    }

    private LinkedList<Integer> history = new LinkedList<>();

    public void gameOver(int player) {
        winner = player;
        history.add(player);
        setScene(4);
    }


}