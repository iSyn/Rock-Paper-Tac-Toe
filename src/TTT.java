import java.util.Arrays;
import java.util.LinkedList;

public class TTT {

    private int[] row1 = {0, 0, 0};
    private int[] row2 = {0, 0, 0};
    private int[] row3 = {0, 0, 0};
    private int[][] board = {row1, row2, row3};
    private int winner;
    private LinkedList<Integer> history = new LinkedList<>();
    private int turn = 0;

    private int selectedColumn = 0;
    private int selectedRow = 0;
    private int[] computerSelected = new int[2];

    public int[][] getBoard() { return board; }
    public int getColumn() { return selectedColumn; }
    public int getRow() { return selectedRow; }
    public void setColumn(int num) {
        selectedColumn += num;
        if (selectedColumn == -1) { selectedColumn = 2; }
        if (selectedColumn == 3) { selectedColumn = 0; }
        printBoard();
    }
    public void setRow(int num) {
        selectedRow += num;
        if (selectedRow == -1) { selectedRow = 2; }
        if (selectedRow == 3) { selectedRow = 0; }
        printBoard();
    }

    public int[] getComputerSelected() { return computerSelected; }

    public void getRandomOpenSpace() {
        int x = (int)Math.floor(Math.random() * 3);
        int y = (int)Math.floor(Math.random() * 3);

        while(board[x][y] != 0) {
            x = (int)Math.floor(Math.random() * 3);
            y = (int)Math.floor(Math.random() * 3);
        }

        computerSelected[0] = x;
        computerSelected[1] = y;
    }

    public int checkBoard(int player) {
        // CHECK COLUMNS
        for (int col = 0; col < 3; col++) {
            if (board[col][0] == player && board[col][1] == player && board[col][2] == player) { winner = player; return player; }
        }
        // CHECK ROWS
        for (int row = 0; row < 3; row++) {
            if (board[0][row] == player && board[1][row] == player && board[2][row] == player) { winner = player; return player; }
        }
        // CHECK DIAGONALS
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) { winner = player; return player; }
        if (board[2][0] == player && board[1][1] == player && board[0][2] == player) { winner = player; return player; }

        return 0;
    }

    public void enterMove(int player) {
        if (player == 1) {
            board[selectedColumn][selectedRow] = 1;
            System.out.println("ENTERING VALUE " + player + " INTO " + selectedColumn + ", " + selectedRow);
        }
        else {
            board[computerSelected[0]][computerSelected[1]] = 2;
            System.out.println("ENTERING VALUE " + player + " INTO " + computerSelected[0] + ", " + computerSelected[1]);
        }
        turn++;
        printBoard();
    }

    public int getTurn() {
        return turn;
    }

    public void printBoard() {
        System.out.println(Arrays.toString(board[0]));
        System.out.println(Arrays.toString(board[1]));
        System.out.println(Arrays.toString(board[2]));
    }

}
