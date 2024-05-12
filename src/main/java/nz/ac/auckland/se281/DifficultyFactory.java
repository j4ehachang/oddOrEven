package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {
  public static DifficultyLevel createDifficulty(Difficulty difficulty) {

    // Create a difficulty level corresponding to the user's input
    switch (difficulty) {
      case EASY:
        return new EasyLevel();

      case MEDIUM:
        return new MediumLevel();

      case HARD:
        return new HardLevel();

      default:
        // Print error message if the difficulty given is invalid
        MessageCli.INVALID_DIFFICULTY.printMessage();
        System.exit(0);
    }
    return null;
  }
}
