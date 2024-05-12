package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int round;
  private String name;
  private int sum;
  private int fingersAi;
  private Choice choice;
  private Choice result;
  private String resultString;
  private DifficultyLevel difficultyLevel;
  private List<Integer> roundList = new ArrayList<>();
  private boolean aiWonLastRound;
  private boolean gameRunning = false;
  private int aiScore;
  private int humanScore;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // Initiate round number to 0 each time a new game is made
    round = 0;

    gameRunning = true;

    aiScore = 0;
    humanScore = 0;

    this.name = options[0];
    this.choice = choice;
    difficultyLevel = DifficultyFactory.createDifficulty(difficulty);
    roundList.clear();
  }

  public void play() {
    if (!gameRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

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

    fingersAi = difficultyLevel.selectFingers(roundList, this.choice, aiWonLastRound);

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(fingersAi));

    getResult(Integer.parseInt(input), fingersAi);

    roundList.add(Integer.parseInt(input));
  }

  public void getResult(int human, int ai) {
    sum = human + ai;

    if (Utils.isEven(sum)) {
      result = Choice.EVEN;
      resultString = "EVEN";
    } else {
      result = Choice.ODD;
      resultString = "ODD";
    }

    if (result == this.choice) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), resultString, this.name);
      aiWonLastRound = false;
      humanScore++;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), resultString, "HAL-9000");
      aiWonLastRound = true;
      aiScore++;
    }
  }

  public void endGame() {
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        name, Integer.toString(humanScore), Integer.toString(aiScore));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", Integer.toString(aiScore), Integer.toString(humanScore));

    if (aiScore == humanScore) {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    } else if (aiScore < humanScore) {
      MessageCli.PRINT_END_GAME.printMessage(name);
    } else {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    }

    gameRunning = false;
  }

  public void showStats() {
    if (!gameRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        name, Integer.toString(humanScore), Integer.toString(aiScore));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", Integer.toString(aiScore), Integer.toString(humanScore));
  }
}
