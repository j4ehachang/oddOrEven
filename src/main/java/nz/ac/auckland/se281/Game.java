package nz.ac.auckland.se281;

import java.util.Random;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private static int round;
  private String name;
  private int sum;
  private int fingersAi;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // Initiate round number to 0 each time a new game is made
    round = 0;

    this.name = options[0];
  }

  public void play() {
    round++;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.ASK_INPUT.printMessage();

    String input = Utils.scanner.nextLine();

    // Print out error message whenever the input is invalid
    while ((!Utils.isInteger(input))
        || Integer.parseInt(input) < 0
        || Integer.parseInt(input) > 5) {
      MessageCli.INVALID_INPUT.printMessage();

      // Ask user for new input until the input is valid
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }

    MessageCli.PRINT_INFO_HAND.printMessage(this.name, input);

    fingersAi = Utils.getRandomNumberRange(0,5);
    
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(fingersAi));

    sum = fingersAi + Integer.parseInt(input);

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", this.name);
  }

  public void endGame() {}

  public void showStats() {}
}
