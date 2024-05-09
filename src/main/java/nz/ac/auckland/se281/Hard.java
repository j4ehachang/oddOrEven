package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Hard implements DifficultyLevel {
  private Strategy lastStrategy;
  private ChooseStrategy chosenStrategy;

  @Override
  public int selectFingers(List<Integer> roundList, Choice choice, Boolean aiWonLastRound) {
    chosenStrategy = new ChooseStrategy(null, roundList, choice);

    if (roundList.size() < 3) {
      chosenStrategy.setStrategy(new Random());
      lastStrategy = chosenStrategy.getStrategy();
      return chosenStrategy.process();

    } else if (aiWonLastRound) {
      chosenStrategy.setStrategy(lastStrategy);
      lastStrategy = chosenStrategy.getStrategy();
      return chosenStrategy.process();

    } else {
      if (lastStrategy instanceof Random) {
        chosenStrategy.setStrategy(new Top());
        lastStrategy = chosenStrategy.getStrategy();
        return chosenStrategy.process();

      } else {
        chosenStrategy.setStrategy(new Random());
        lastStrategy = chosenStrategy.getStrategy();
        return chosenStrategy.process();
      }
    }
  }
}
