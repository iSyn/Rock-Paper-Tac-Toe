import processing.core.PApplet;
import processing.core.PFont;

import java.util.Arrays;
import java.util.LinkedList;

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

        if (currentScene == 0) { //************************************************************************************ MAIN MENU
            rectMode(CORNER);
            background(70, 32, 102);
            fill(237, 119, 87);
            rect(0, 0, 350, 700);
            fill(252, 244, 217);
            textFont(font, 100);
            textAlign(RIGHT);
            text("ROCK PAPER", 680, 90);
            text("TAC TOE",  680, 180);

            int posX = 80;
            int posY = 380;
            for (int i = 0; i < menu.getButtons().length; i++) {
                textFont(font, 70);
                if (i == menu.getSelected()) {
                    fill(142, 210, 201);
                    textAlign(LEFT);
                    text(">", posX - 50, posY);
                }
                fill(252, 244, 217);
                textAlign(LEFT);
                text(menu.getButtons()[i], posX, posY);
                posY += 70;
            }
        } else if (currentScene == 1) { //****************************************************************************** RPS
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
        } else if (currentScene == 2) { //***************************************************************************** RPS RESULTS
            background(88, 75, 83);
            noStroke();
            fill(252);
            textFont(font, 50);
            text("Player 1 Chose: " + rps.getSelectedString(), 30, 70);
            text("Computer Chose: " + rps.getComputerSelectedString(), 30, 130);
        } else if (currentScene == 3) { //***************************************************************************** TIC TAC TOE
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
                    strokeWeight(6);
                    stroke(70, 32, 102);
                    rect(xPos, yPos, 100, 100);

                    // DRAW SELECTED COL
                    if (rps.getWinner() == 1) {
                        if (col == selectedColumn && row == selectedRow) {
                            stroke(237, 119, 87);
                            rect(xPos + 5, yPos + 5, 90, 90);
                        }
                    } else {
                        int[] xy = ttt.getComputerSelected();
                        if (col == xy[0] && row == xy[1]) {
                            stroke(80, 171, 160);
                            rect(xPos + 5, yPos + 5, 90, 90);
                        }
                    }
                    // DRAW X's AND O's
                    if (board[col][row] != 0) {
                        if (board[col][row] == 1) {
                            stroke(237, 119, 87);
                            line(xPos + 15, yPos + 15, xPos + 85, yPos + 85);
                            line(xPos + 85, yPos + 15, xPos + 15, yPos + 85);
                        } else {
                            stroke(80, 171, 160);
                            ellipse(xPos + 50, yPos + 50, 80, 80);
                        }
                    }

                    xPos += 100;
                }
                yPos += 100;
            }
        } else if (currentScene == 4) { //***************************************************************************** GAME OVER SCREEN
            background(70, 32, 102);
            stroke(237, 119, 87);
            strokeWeight(6);
            fill(252, 244, 217);
            textAlign(CENTER);
            textFont(font, 70);
            text(game.getWinnerString() + " Wins!", 350, 100);
            rectMode(CORNER);
            rect(100, 150, 500, 600);
            rectMode(CENTER);
            Integer[] history = game.getHistory();

            int posY = 210;

            for (int scores = 1; scores <= history.length; scores++) {
                textAlign(LEFT);
                fill(244, 241, 187);
                rect(350, posY, 450, 70);
                textFont(font, 30);
                fill(70, 32, 102);
                text("Game " + scores + ": " + game.getSpecificWin(scores-1),150, posY + 10);
                posY += 85;
            }

        }
    }

    public void keyPressed() {
        int currentScene = game.getScene();

        if (key == '=') {
            game.gameOver(1);
        }
        if (key == '-') {
            game.gameOver(2);
        }
        if (key == '0') {
            game.gameOver(0);
        }

        if (currentScene == 0) { //************************************************************************************* MENU SCENE
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
        } else if (currentScene == 1) { //***************************************************************************** RPS SCENE
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
        } else if (currentScene == 2) { //***************************************************************************** RPS RESULTS SCENE
            if (key == ' ' || key == ENTER || key == RETURN) {
                if (rps.getWinner() == 0) {
                    game.setScene(1);
                } else {
                    if (rps.getWinner() == 2) {
                        ttt.getRandomOpenSpace();
                        ttt.enterMove(2);
                    }
                    game.setScene(3);
                }
            }
        } else if (currentScene == 3) { //***************************************************************************** TTT SCENE
            if (rps.getWinner() == 1) { // if player won TTT
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
                } else if (key == ' ' || key == ENTER || key == RETURN) {
                    if (ttt.getBoard()[ttt.getColumn()][ttt.getRow()] == 0) {
                        ttt.enterMove(1);
                        if (ttt.checkBoard(1) == 1) {
                            game.gameOver(1);
                        } else {
                            game.setScene(1);
                        }
                    }
                }
            } else {
                if (key == ' ' || key == ENTER || key == RETURN) {
                    if (ttt.checkBoard(2) == 2) {
                        game.gameOver(2);
                    } else {
                        game.setScene(1);
                    }
                }
            }
        } else if (currentScene == 4) { //***************************************************************************** GAME OVER SCENE
            if (key == ' ' || key == RETURN || key == ENTER) {
                game.setScene(0);
            }
        }
    }
}
