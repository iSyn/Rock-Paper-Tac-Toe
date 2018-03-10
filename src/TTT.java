public class TTT {

    private int[] row1 = {0, 0, 1};
    private int[] row2 = {1, 0, 0};
    private int[] row3 = {0, 1, 0};
    private int[][] board = {row1, row2, row3};

    private int selectedColumn = 0;
    private int selectedRow = 0;

    public int[][] getBoard() { return board; }
    public int getColumn() { return selectedColumn; }
    public int getRow() { return selectedRow; }
    public void setColumn(int num) {
        selectedColumn += num;
        if (selectedColumn == -1) { selectedColumn = 2; }
        if (selectedColumn == 3) { selectedColumn = 0; }
        System.out.println(selectedRow + ", " + selectedColumn);
    }
    public void setRow(int num) {
        selectedRow += num;
        if (selectedRow == -1) { selectedRow = 2; }
        if (selectedRow == 3) { selectedRow = 0; }
        System.out.println(selectedRow + ", " + selectedColumn);
    }

}
