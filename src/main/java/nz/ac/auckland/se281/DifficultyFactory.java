package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {
  public static DifficultyLevel createDifficulty(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new Easy();

      case MEDIUM:
        return new Medium();

      case HARD:
        return new Hard();

      default:
        MessageCli.INVALID_DIFFICULTY.printMessage();
        System.exit(0);
    }
    return null;
  }
}
