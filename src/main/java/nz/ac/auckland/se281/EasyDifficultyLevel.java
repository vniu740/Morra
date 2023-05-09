package nz.ac.auckland.se281;

public class EasyDifficultyLevel implements DifficultyLevel {
  private StrategyCreator easyStrategy = new StrategyCreator(new RandomStrategy());

  @Override
  public Integer[] playUsingLevel(Integer humanFingers) {

    return easyStrategy.jarvisPlays(humanFingers);

  }

}
