package nz.ac.auckland.se281;

public class ChooseStrategy {

  private Strategy strategy;

  public ChooseStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int process() {
    return strategy.fingerStrategy();
  }
}
