import java.util.Arrays;
import java.util.LinkedList;

public class Game {

    private int scene = 0;
    private int winner;
    private LinkedList<Integer> history = new LinkedList<>();

    public int getScene() { return scene; }
    public void setScene(int num) { scene = num; }

    public int getWinner() { return winner; }
    public String getWinnerString() {
        if (winner == 0) { return "No One"; }
        if (winner == 1) { return "Player 1"; }
        if (winner == 2) { return "Computer"; }
        return null;
    }
    public String getSpecificWin(int gameNum) {
        Integer[] newHistory = history.toArray(new Integer[history.size()]);
        if (newHistory[gameNum] == 0) { return "Tied"; }
        if (newHistory[gameNum] == 1) { return "Player 1 Wins"; }
        if (newHistory[gameNum] == 2) { return "Computer Wins"; }
        return null;
    }

    public void gameOver(int player) {
        winner = player;
        history.add(player);
        setScene(4);
    }


    public Integer[] getHistory() {
        Integer[] newHistory = history.toArray(new Integer[history.size()]);
        return newHistory;
    }
}