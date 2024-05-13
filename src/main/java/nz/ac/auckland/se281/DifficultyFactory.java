package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/** Class representing the "factory" creating all the difficulties */
public class DifficultyFactory {

  /**
   * Creates the diffculty depending on the user's input
   *
   * @param difficulty The input given by the user
   * @return The difficulty class corresponding to the user's input
   */
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
