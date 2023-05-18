package nz.ac.auckland.se281.level;

import nz.ac.auckland.se281.strategy.RandomStrategy;
import nz.ac.auckland.se281.strategy.StrategyCreator;

public class EasyDifficultyLevel implements DifficultyLevel {
  // create new randomStrategy Instance for this specific EasyDifficultyLevel
  private StrategyCreator randomStrategy = new StrategyCreator(new RandomStrategy());

  @Override
  public Integer[] playUsingLevel(Integer humanFingers) {
    
    // call jarvisPlays() from StrategyCreator.java
    return randomStrategy.jarvisPlays(humanFingers);

  }

}
