//import processing.core.PApplet;
//import processing.core.PFont;
//
//public class Main extends PApplet {
//    PFont font;
//    static Game game = new Game();
//
//    public Main() {
//    }
//
//    public static void main(String[] args) {
//        PApplet.main("Main", args);
//    }
//
//    public void settings() {
//        this.size(500, 500);
//    }
//
//    public void setup() {
//        this.font = this.createFont("Arial", 25.0F, true);
//        this.stroke(0);
//        this.fill(0);
//    }
//
//    public void draw() {
//        if (game.getCurrentScene() == 1) {
//            this.background(230.0F, 230.0F, 250.0F);
//            this.textFont(this.font, 25.0F);
//            this.stroke(0);
//            this.text("Pick 1", 200.0F, 150.0F);
//            this.rect(80.0F, 200.0F, 100.0F, 100.0F);
//            this.rect(200.0F, 200.0F, 100.0F, 100.0F);
//            this.rect(320.0F, 200.0F, 100.0F, 100.0F);
//            if (game.getSelectedRockPaperScissor() == 1) {
//                this.noFill();
//                this.stroke(0.0F, 255.0F, 127.0F);
//                this.strokeWeight(4.0F);
//                this.rect(70.0F, 190.0F, 120.0F, 120.0F);
//            } else if (game.getSelectedRockPaperScissor() == 2) {
//                this.noFill();
//                this.stroke(0.0F, 255.0F, 127.0F);
//                this.strokeWeight(4.0F);
//                this.rect(190.0F, 190.0F, 120.0F, 120.0F);
//            } else if (game.getSelectedRockPaperScissor() == 3) {
//                this.noFill();
//                this.stroke(0.0F, 255.0F, 127.0F);
//                this.strokeWeight(4.0F);
//                this.rect(310.0F, 190.0F, 120.0F, 120.0F);
//            }
//        } else if (game.getCurrentScene() == 2) {
//            this.background(189.0F, 252.0F, 201.0F);
//            this.textFont(this.font, 25.0F);
//            this.stroke(0);
//            this.text("You Picked: " + game.rockPaperScissorString(game.getSelectedRockPaperScissor()), 100.0F, 100.0F);
//            this.text("Computer Picked: " + game.rockPaperScissorString(game.getComputerSelectedRockPaperScissor()), 100.0F, 150.0F);
//            this.text("You " + game.getPlayerWin() + "!", 100.0F, 200.0F);
//        } else if (game.getCurrentScene() == 3) {
//            this.background(252.0F, 244.0F, 217.0F);
//            int[][] board = game.getBoard();
//            this.textFont(this.font, 30.0F);
//            if (game.getPlayerWin() == "Win") {
//                this.text("Players Turn", 200.0F, 50.0F);
//            } else if (game.getPlayerWin() == "Lose") {
//                this.text("Computers Turn", 150.0F, 50.0F);
//            }
//
//            this.noFill();
//            this.stroke(0);
//            int startingYPos = 100;
//
//            for(int column = 0; column < board.length; ++column) {
//                int startingXPos = 100;
//
//                for(int row = 0; row < board[column].length; ++row) {
//                    this.strokeWeight(6.0F);
//                    this.stroke(70.0F, 32.0F, 102.0F);
//                    this.rect((float)startingXPos, (float)startingYPos, 100.0F, 100.0F);
//                    if (game.getPlayerWin() == "Win") {
//                        if (row == game.getSelected()[0] && column == game.getSelected()[1]) {
//                            this.stroke(237.0F, 119.0F, 87.0F);
//                            this.rect((float)(startingXPos + 5), (float)(startingYPos + 5), 90.0F, 90.0F);
//                        }
//                    } else if (game.getPlayerWin() == "Lose") {
//                        game.changeCurrentScene(3);
//                        if (row == game.getComputerSelectedTTT()[0] && column == game.getComputerSelectedTTT()[1]) {
//                            this.stroke(80.0F, 171.0F, 160.0F);
//                            this.rect((float)(startingXPos + 5), (float)(startingYPos + 5), 90.0F, 90.0F);
//                            int[] selected = game.getComputerSelectedTTT();
//                            if (game.getBoard()[selected[0]][selected[1]] == 0) {
//                                game.enterMove(2);
//                                if (game.checkWin(2) == 2) {
//                                    game.changeCurrentScene(4);
//                                } else {
//                                    game.changeCurrentScene(1);
//                                }
//                            }
//                        }
//                    }
//
//                    if (game.getBoard()[row][column] == 1) {
//                        this.textFont(this.font, 15.0F);
//                        this.text("player", (float)startingXPos, (float)(startingYPos + 50));
//                    } else if (game.getBoard()[row][column] == 2) {
//                        this.textFont(this.font, 15.0F);
//                        this.text("computer", (float)startingXPos, (float)(startingYPos + 50));
//                    }
//
//                    startingXPos += 100;
//                }
//
//                startingYPos += 100;
//            }
//        } else if (game.getCurrentScene() == 4) {
//            this.background(0);
//        }
//
//    }
//
//    public void keyPressed() {
//        if (game.getCurrentScene() == 1) {
//            if (this.key == '\uffff') {
//                if (this.keyCode == 39) {
//                    if (game.getSelectedRockPaperScissor() < 3) {
//                        game.changeSelectedRockPaperScissor(1);
//                    }
//                } else if (this.keyCode == 37 && game.getSelectedRockPaperScissor() > 1) {
//                    game.changeSelectedRockPaperScissor(-1);
//                }
//            } else if (this.key == ' ' || this.key == '\n' || this.key == '\r') {
//                game.setSelectedRockPaperScissor(game.getSelectedRockPaperScissor());
//                game.playRPS();
//                if (game.getPlayerWin() == "Lose") {
//                    game.computerSelectedTTT();
//                }
//
//                game.changeCurrentScene(2);
//            }
//        } else if (game.getCurrentScene() == 2) {
//            if (this.key == ' ' || this.key == '\n' || this.key == '\r') {
//                if (game.getPlayerWin() == "Tie") {
//                    game.changeCurrentScene(1);
//                } else {
//                    game.changeCurrentScene(3);
//                }
//            }
//        } else if (game.getCurrentScene() == 3) {
//            if (game.getPlayerWin() == "Win") {
//                if (this.key == '\uffff') {
//                    if (this.keyCode == 39) {
//                        if (game.getRow() < 2) {
//                            game.moveRow(1);
//                        }
//                    } else if (this.keyCode == 37) {
//                        if (game.getRow() > 0) {
//                            game.moveRow(-1);
//                        }
//                    } else if (this.keyCode == 38) {
//                        if (game.getColumn() > 0) {
//                            game.moveColumn(-1);
//                        }
//                    } else if (this.keyCode == 40 && game.getColumn() < 2) {
//                        game.moveColumn(1);
//                    }
//                } else if (this.key == ' ' || this.key == '\r' || this.key == '\n') {
//                    int[] selected = game.getSelected();
//                    if (game.getBoard()[selected[0]][selected[1]] == 0) {
//                        game.enterMove(1);
//                        if (game.checkWin(1) == 1) {
//                            game.changeCurrentScene(4);
//                        } else {
//                            game.changeCurrentScene(1);
//                        }
//                    }
//                }
//            } else if (this.key == ' ' || this.key == '\r' || this.key == '\n') {
//                if (game.checkWin(2) == 2) {
//                    game.changeCurrentScene(4);
//                } else {
//                    game.changeCurrentScene(1);
//                }
//            }
//        }
//
//    }
//}
