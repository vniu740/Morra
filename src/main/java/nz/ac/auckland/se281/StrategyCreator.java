package nz.ac.auckland.se281;

public class StrategyCreator {

  private Strategy strategy;

  public StrategyCreator(Strategy strategy) {
    this.strategy = strategy;
  }

  public Integer[] jarvisPlays(Integer humanFingers) {
    return strategy.decideSumAndFingers(humanFingers);
  }
}
