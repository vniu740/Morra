package nz.ac.auckland.se281.level;

import java.util.ArrayList;

import nz.ac.auckland.se281.strategy.AverageStrategy;
import nz.ac.auckland.se281.strategy.RandomStrategy;
import nz.ac.auckland.se281.strategy.StrategyCreator;

public class MediumDifficultyLevel implements DifficultyLevel {
  // Create new randomStrategy Instance and averageStrategy Instance for this specific
  // HardDifficultyLevel
  // Create new ArrayList to store the human's inputs
  private ArrayList<Integer> listOfHumanFingers = new ArrayList<>();
  private StrategyCreator randomStrategy = new StrategyCreator(new RandomStrategy());
  private StrategyCreator averageStrategy = new StrategyCreator(new AverageStrategy());

  @Override
  public Integer[] playUsingLevel(Integer humanFingers) {
    double humanAvg = 0;

    // add the human's finger input to the arraylist
    listOfHumanFingers.add(humanFingers);

    // if the round is less than or equal to 3, then use the randomStrategy 
    if (listOfHumanFingers.size() <= 3) {
      return randomStrategy.jarvisPlays(humanFingers);
    } else {
      // calculate the sum of the fingers, excluding the current round
      for (int i = 0; i < (listOfHumanFingers.size() - 1); i++) {
        humanAvg += listOfHumanFingers.get(i);
      }
      // Calculate the average
      humanAvg = humanAvg / (listOfHumanFingers.size() - 1);
      humanAvg = Math.round(humanAvg);

      // call jarvisPlays() on the average strategy from StrategyCreator.java
      return averageStrategy.jarvisPlays((int) humanAvg);
    }
  }

}
