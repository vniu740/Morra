package nz.ac.auckland.se281;

import java.util.ArrayList;

public class MasterDifficultyLevel implements DifficultyLevel {
  private ArrayList<Integer> listOfHumanFingers = new ArrayList<>();
  private ArrayList<Integer> listHumanFingersAppearences;
  private StrategyCreator easyStrategy = new StrategyCreator(new RandomStrategy());
  private StrategyCreator averageStrategy = new StrategyCreator(new AverageStrategy());
  private StrategyCreator topStrategy = new StrategyCreator(new TopStrategy());

  @Override
  public Integer[] playUsingLevel(Integer humanFingers) {

    // Add the human's finger input to the arraylist
    listOfHumanFingers.add(humanFingers);

    // If the current round is 3 or less return decideSumAndFingers() using
    // easyStrategy
    if (listOfHumanFingers.size() <= 3) {

      return easyStrategy.jarvisPlays(humanFingers);

      // If the current round is greater than 3 and an even number return
      // decideSumAndFingers() using averageStrategy
    } else if ((listOfHumanFingers.size() % 2) == 0) {

      return averageStrategy.jarvisPlays(findAverageForAverageStrategy());

      // if the current round is greater than 3 and an odd numver return
      // decideSumAndFingers() using TopStrategy
    } else {
      return topStrategy.jarvisPlays(findTopForTopStrategy());
    }

  }

  public int findAverageForAverageStrategy() {
    double humanAvg = 0;

    // calculate the sum of the fingers, excluding the current round
    for (int i = 0; i < (listOfHumanFingers.size() - 1); i++) {
      humanAvg += listOfHumanFingers.get(i);
    }
    // Calculate the average
    humanAvg = humanAvg / (listOfHumanFingers.size() - 1);
    humanAvg = Math.round(humanAvg);

    return (int) humanAvg;
  }

  public int findTopForTopStrategy() {
    listHumanFingersAppearences = new ArrayList<>();
    int fingerCount = 0;
    int mode = 0;
    int fingerWeAreCheckingAgainst;
    int fingersWeAreCheckingfor;

    for (int j = 0; j < (listOfHumanFingers.size() - 1); j++) {
      fingersWeAreCheckingfor = listOfHumanFingers.get(j);
      for (int i = 0; i < (listOfHumanFingers.size() - 1); i++) {
        fingerWeAreCheckingAgainst = listOfHumanFingers.get(i);
        if (fingersWeAreCheckingfor == fingerWeAreCheckingAgainst) {
          fingerCount++;
        }
      }
      listHumanFingersAppearences.add(fingerCount);
      fingerCount = 0;
    }

    for (int i = 0; i < listHumanFingersAppearences.size(); i++) {
      if (listHumanFingersAppearences.get(0) <= listHumanFingersAppearences.get(i)) {
        listHumanFingersAppearences.set(0, listHumanFingersAppearences.get(i));
        mode = listOfHumanFingers.get(i);
      }
    }
    return mode;
  }

}
