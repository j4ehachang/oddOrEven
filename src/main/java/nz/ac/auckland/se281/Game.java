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
  private Choice choice;
  private Choice result;
  private String resultString;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // Initiate round number to 0 each time a new game is made
    round = 0;

    this.name = options[0];
    this.choice = choice;
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

    if (Utils.isEven(sum)) {
      result = Choice.EVEN;
      resultString = "EVEN";
    } else {
      result = Choice.ODD;
      resultString = "ODD";
    }

    if (result == this.choice) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), resultString, this.name);
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), resultString, "HAL-9000");
    }
   
  }

  public void endGame() {}

  public void showStats() {}
}
