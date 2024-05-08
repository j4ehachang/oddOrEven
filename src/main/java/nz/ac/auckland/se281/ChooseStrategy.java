package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

public class ChooseStrategy {

  private Strategy strategy;
  private List<Integer> roundList;
  private Choice choice;
  

  public ChooseStrategy(Strategy strategy, List<Integer> roundList, Choice choice) {
    this.strategy = strategy;
    this.roundList = roundList;
    this.choice = choice;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int process() {
    return this.strategy.fingerStrategy(this.roundList, this.choice);
  }
}
