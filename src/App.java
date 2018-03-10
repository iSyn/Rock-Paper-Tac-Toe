import processing.core.PApplet;
import processing.core.PFont;

import static java.lang.Thread.sleep;

public class App extends PApplet{

    PFont font;
    Game game = new Game();
    MainMenu menu = new MainMenu();
    RPS rps = new RPS();
    TTT ttt = new TTT();

    public static void main(String[] args) {
        PApplet.main("App", args);
    }

    public void settings() {
        size(700, 500);
    }

    public void setup() {
        font = createFont("Arial", 25, true);
//        stroke(0);
        noStroke();
        fill(0);
    }

    public void draw() {
        int currentScene = game.getScene();

        if (currentScene == 0) { // MAIN MENU
            background(43, 45, 66);
            fill(46, 196, 182);
            textFont(font, 100);
            textAlign(RIGHT);
            text("ROCK PAPER", 680, 90);
            text("TAC TOE",  680, 180);

            int posX = 80;
            int posY = 380;
            for (int i = 0; i < menu.getButtons().length; i++) {
                textFont(font, 70);
                if (i == menu.getSelected()) {
                    fill(239, 35, 60);
                    textAlign(LEFT);
                    text(">", posX - 50, posY);
                }
                fill(237, 242, 244);
                textAlign(LEFT);
                text(menu.getButtons()[i], posX, posY);
                posY += 70;
            }
        } else if (currentScene == 1) { // RPS
            background(250, 121, 33);
            fill(253, 231, 76);
            textFont(font, 80);
            text("PICK ONE", 170, 100);
            strokeWeight(5);
            stroke(253, 231, 76);
            line(0, 140, 700, 140);
            noStroke();
            int posX = 35;
            int posY = 220;
            for (int i = 0; i < rps.getChoices().length; i++) {

                noStroke();
                fill(155, 197, 61);
                rect(posX, posY, 190, 190);
                textFont(font, 30);
                fill(0);
                text(rps.getChoices()[i], posX + 50, posY + 100);

                if (i == rps.getSelected()) {
                    noFill();
                    strokeWeight(5);
                    stroke(0);
                    rect(posX - 5, posY - 5, 200, 200);
                }
                posX += 220;
            }
        } else if (currentScene == 2) {// RPS RESULTS
            background(88, 75, 83);
            noStroke();
            fill(252);
            textFont(font, 50);
            text("Player 1 Chose: " + rps.getSelectedString(), 30, 70);
            text("Computer Chose: " + rps.getComputerSelectedString(), 30, 130);
        } else if (currentScene == 3) { // TIC TAC TOE
            background(252, 244, 217);
            int[][] board = ttt.getBoard();
            int selectedRow = ttt.getRow();
            int selectedColumn = ttt.getColumn();

            noFill();
            stroke(0);
            int yPos = 100;

            for (int col = 0; col < board.length; col++) {
                int xPos = 190;
                for (int row = 0; row < board[col].length; row++) {
                    strokeWeight(4);
                    stroke(70, 32, 102);
                    rect(xPos, yPos, 100, 100);

                    if (col == selectedColumn && row == selectedRow) {
                        stroke(237, 119, 87);
                        rect(xPos + 5, yPos + 5, 90, 90);
                    }

                    if (board[col][row] != 0) {
                        if (board[col][row] == 1) {
                            line(xPos + 15, yPos + 15, xPos + 85, yPos + 85);
                            line(xPos + 85, yPos + 15, xPos + 15, yPos + 85);
                        }
                    }


                    xPos += 100;
                }
                yPos += 100;
            }
        }
    }

    public void keyPressed() {
        int currentScene = game.getScene();

        if (currentScene == 0) {
            if (key == CODED) {
                if (keyCode == UP) {
                    menu.changeSelected(1);
                } else if (keyCode == DOWN) {
                    menu.changeSelected(-1);
                }
            } else if (key == ' ' || key == ENTER || key == RETURN) {
                if (menu.getSelected() == 0) { game.setScene(1); }
                else { exit(); }
            }
        } else if (currentScene == 1) {
            if (key == CODED) {
                if (keyCode == LEFT) {
                    rps.changeSelected(-1);
                } else if (keyCode == RIGHT) {
                    rps.changeSelected(1);
                }
            } else if (key == ' ' || key == ENTER || key == RETURN) {
                rps.play();
                game.setScene(2);
            }
        } else if (currentScene == 2) {
            if (key == ' ' || key == ENTER || key == RETURN) {
                game.setScene(3);
            }
        } else if (currentScene == 3) {
            if (key == CODED) {
                if (keyCode == LEFT) {
                    ttt.setRow(-1);
                } else if (keyCode == RIGHT) {
                    ttt.setRow(1);
                } else if (keyCode == UP) {
                    ttt.setColumn(-1);
                } else if (keyCode == DOWN) {
                    ttt.setColumn(1);
                }
            }
        }

    }
}
