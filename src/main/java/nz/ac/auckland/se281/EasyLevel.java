package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class EasyLevel implements DifficultyLevel {

  @Override
  public int selectFingers(List<Integer> roundList, Choice choice, Boolean aiWonLastRound) {
    // Always use the random strategy to select number of fingers
    ChooseStrategy choosenStrategy = new ChooseStrategy(new Random(), roundList, choice);
    return choosenStrategy.process();
  }
}
