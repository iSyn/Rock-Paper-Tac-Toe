import processing.core.PApplet;
import processing.core.PFont;

import static java.lang.Thread.sleep;

public class App extends PApplet{

    PFont font;
    Game game = new Game();
    MainMenu menu = new MainMenu();
    RPS rps = new RPS();

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
//            rect(30, 30, 250, 440);
//            fill(25, 100, 126);
//            textFont(font, 50);
//            text(rps.getChoices()[rps.getSelected()], 70, 250);
//            fill(252);
//            rect(420, 30, 250, 440);
//            fill(237, 106, 90);
//            textFont(font, 190);
//            text("VS", 250, 240);

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
        }

    }
}
