package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {
  public DifficultyLevel createFactory(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new Easy();

      default:
        System.err.println("wrong difficulty level");
        System.exit(0);
      }
      return null;
  }
}
