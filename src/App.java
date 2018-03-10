import processing.core.PApplet;
import processing.core.PFont;

public class App extends PApplet{

    PFont font;
    Game game = new Game();
    MainMenu menu = new MainMenu();

    public static void main(String[] args) {
        PApplet.main("App", args);
    }

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        font = createFont("Arial", 25, true);
        stroke(0);
        fill(0);
    }

    public void draw() {
        int currentScene = game.getScene();

        if (currentScene == 0) { // DRAW MENU
            background(43, 45, 66);
            fill(237, 242, 244);
            textFont(font, 60);
            textAlign(RIGHT);
            text("ROCK PAPER", 480, 70);
            text("TAC TOE",  480, 130);

            int posX = 70;
            int posY = 380;
            for (int i = 0; i < menu.getButtons().length; i++) {
                if (i == menu.getSelected()) {
                    textAlign(LEFT);
                    text(">", posX - 40, posY);
                }
                textAlign(LEFT);
                text(menu.getButtons()[i], posX, posY);
                posY += 60;
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
        }

    }
}
