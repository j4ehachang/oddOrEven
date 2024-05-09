package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Hard implements DifficultyLevel {
  private Strategy lastStrategy;

  @Override
  public int selectFingers(List<Integer> roundList, Choice choice, Boolean aiWonLastRound) {

    if (roundList.size() < 3) {
      ChooseStrategy choosenStrategy = new ChooseStrategy(new Random(), roundList, choice);
      lastStrategy = choosenStrategy.getStrategy();
      return choosenStrategy.process();

    } else if (aiWonLastRound) {
      ChooseStrategy choosenStrategy = new ChooseStrategy(lastStrategy, roundList, choice);
      lastStrategy = choosenStrategy.getStrategy();
      return choosenStrategy.process();

    } else {
      if (lastStrategy instanceof Random) {
        ChooseStrategy choosenStrategy = new ChooseStrategy(new Top(), roundList, choice);
        lastStrategy = choosenStrategy.getStrategy();
        return choosenStrategy.process();

      } else {
        ChooseStrategy choosenStrategy = new ChooseStrategy(new Random(), roundList, choice);
        lastStrategy = choosenStrategy.getStrategy();
        return choosenStrategy.process();
      }
    }
  }
}
