package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** This class represents the medium level of the game */
public class MediumLevel implements DifficultyLevel {

  @Override
  public int selectFingers(List<Integer> roundList, Choice choice, Boolean aiWonLastRound) {

    // For the first three rounds use the Random strategy to select fingers
    if (roundList.size() < 3) {
      ChooseStrategy choosenStrategy = new ChooseStrategy(new Random(), roundList, choice);
      return choosenStrategy.process();

      // After three rounds use the Top Strategy to select fingers
    } else {
      ChooseStrategy choosenStrategy = new ChooseStrategy(new Top(), roundList, choice);
      return choosenStrategy.process();
    }
  }
}
