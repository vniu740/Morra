package nz.ac.auckland.se281;

import java.util.ArrayList;

public class MediumDifficultyLevel implements DifficultyLevel {
  private ArrayList<Integer> listOfHumanFingers = new ArrayList<>();
  private StrategyCreator easyStrategy = new StrategyCreator(new RandomStrategy());
  private StrategyCreator averageStrategy = new StrategyCreator(new AverageStrategy());

  @Override
  public Integer[] playUsingLevel(Integer humanFingers) {
    double humanAvg = 0;

    // add the human's finger input to the arraylist
    listOfHumanFingers.add(humanFingers);

    if (listOfHumanFingers.size() <= 3) {
      return easyStrategy.jarvisPlays(humanFingers);
    } else {
      // calculate the sum of the fingers, excluding the current round
      for (int i = 0; i < (listOfHumanFingers.size() - 1); i++) {
        humanAvg += listOfHumanFingers.get(i);
      }
      // Calculate the average
      humanAvg = humanAvg / (listOfHumanFingers.size() - 1);
      humanAvg = Math.round(humanAvg);

      return averageStrategy.jarvisPlays((int) humanAvg);
    }
  }

}
