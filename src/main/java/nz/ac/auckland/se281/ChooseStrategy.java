package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** This class represents the strategy chosen to select fingers. */
public class ChooseStrategy {

  private Strategy strategy;
  private List<Integer> roundList;
  private Choice choice;

  /**
   * The constructor for this class.
   *
   * @param strategy the strategy chosen to be used.
   * @param roundList the list for all of the user's previous inputs.
   * @param choice the choice the user made for even or odd.
   */
  public ChooseStrategy(Strategy strategy, List<Integer> roundList, Choice choice) {
    this.strategy = strategy;
    this.roundList = roundList;
    this.choice = choice;
  }

  /**
   * Set the strategy during runtime.
   *
   * @param strategy The strategy we want to set it to.
   */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Getter method for the strategy.
   *
   * @return the strategy chosen.
   */
  public Strategy getStrategy() {
    return this.strategy;
  }

  /**
   * Use the chosen strategy to select the fingers for AI.
   *
   * @return the method that selects the number of fingers for AI.
   */
  public int process() {
    return this.strategy.fingerStrategy(this.roundList, this.choice);
  }
}
