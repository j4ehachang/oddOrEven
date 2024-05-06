package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private static int round;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    round = 0;

  }

  public void play() {
    round ++;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.ASK_INPUT.printMessage();

    String input = Utils.scanner.nextLine();
    if (!(Utils.isInteger(input))) {
      MessageCli.INVALID_INPUT.printMessage();
    } else if (Integer.parseInt(input) < 0 || Integer.parseInt(input) > 5) {
      MessageCli.INVALID_INPUT.printMessage();
    }

  }

  public void endGame() {}

  public void showStats() {}
}
