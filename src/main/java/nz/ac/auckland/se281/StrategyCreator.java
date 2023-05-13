package nz.ac.auckland.se281;

public class StrategyCreator {

  private Strategy strategy;

  // Constructor for strategies
  public StrategyCreator(Strategy strategy) {
    this.strategy = strategy;
  }

  // Method for caling decideSumAndFingers() for strategies that implement strategy.java
  public Integer[] jarvisPlays(Integer humanFingers) {
    return strategy.decideSumAndFingers(humanFingers);
  }
}
