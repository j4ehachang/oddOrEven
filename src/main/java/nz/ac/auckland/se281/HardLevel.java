package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** This class represnts the hardlevel of the game. */
public class HardLevel implements DifficultyLevel {
  private Strategy lastStrategy;
  private ChooseStrategy chosenStrategy;

  @Override
  public int selectFingers(List<Integer> roundList, Choice choice, Boolean aiWonLastRound) {
    chosenStrategy = new ChooseStrategy(null, roundList, choice);

    // Use the random strategy for the first three rounds
    if (roundList.size() < 3) {
      chosenStrategy.setStrategy(new Random());
      lastStrategy = chosenStrategy.getStrategy();
      return chosenStrategy.process();

      // After three rounds if the AI wins keep using the strategy it used in the previous round
    } else if (aiWonLastRound) {
      chosenStrategy.setStrategy(lastStrategy);
      lastStrategy = chosenStrategy.getStrategy();
      return chosenStrategy.process();

      // After three rounds if the AI loses change the strategy
    } else {

      // Changing Strategy from Random to Top
      if (lastStrategy instanceof Random) {
        chosenStrategy.setStrategy(new Top());
        lastStrategy = chosenStrategy.getStrategy();
        return chosenStrategy.process();

        // Changing Strategy from Top to Random
      } else {
        chosenStrategy.setStrategy(new Random());
        lastStrategy = chosenStrategy.getStrategy();
        return chosenStrategy.process();
      }
    }
  }
}
