package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {
  public static DifficultyLevel createDifficulty(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new Easy();

      case MEDIUM:
        return new Easy();

      case HARD:
        return new Easy();

      default:
        MessageCli.INVALID_DIFFICULTY.printMessage();
        System.exit(0);
    }
    return null;
  }
}
