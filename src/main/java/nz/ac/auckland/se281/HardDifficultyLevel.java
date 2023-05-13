package nz.ac.auckland.se281;

import java.util.ArrayList;

public class HardDifficultyLevel implements DifficultyLevel {
  // Create new randomStrategy Instance and topStrategy Instance for this specific
  // HardDifficultyLevel
  // Create new ArrayList to store the human's inputs
  private ArrayList<Integer> listOfHumanFingers = new ArrayList<>();
  private ArrayList<Integer> listHumanFingersAppearences;
  private StrategyCreator randomStrategy = new StrategyCreator(new RandomStrategy());
  private StrategyCreator topStrategy = new StrategyCreator(new TopStrategy());

  @Override
  public Integer[] playUsingLevel(Integer humanFingers) {

    int fingerCount = 0;
    int mode = 0;
    int fingerWeAreCheckingAgainst;
    int fingersWeAreCheckingfor;

    // Create new arrayList to store the amount of occurences of each finger input
    listHumanFingersAppearences = new ArrayList<>();

    // add the human's finger input to the arraylist
    listOfHumanFingers.add(humanFingers);

    // if the round is less than or equal to 3, then use the randomStrategy
    if (listOfHumanFingers.size() <= 3) {

      // call jarvisPlays() on the random strategy from StrategyCreator.java
      return randomStrategy.jarvisPlays(humanFingers);

    } else {

      // find the mode of the Human's finger inputs
      // Check each number in listOfHumanFingers against every number in
      // listOfHumanFingers
      for (int j = 0; j < (listOfHumanFingers.size() - 1); j++) {
        fingersWeAreCheckingfor = listOfHumanFingers.get(j);
        for (int i = 0; i < (listOfHumanFingers.size() - 1); i++) {
          fingerWeAreCheckingAgainst = listOfHumanFingers.get(i);

          // If the number is found increase the occurence count
          if (fingersWeAreCheckingfor == fingerWeAreCheckingAgainst) {
            fingerCount++;
          }
        }
        // Add the number of occurences to the arrayList
        listHumanFingersAppearences.add(fingerCount);
        fingerCount = 0;
      }

      // Find the number that has the greatest number of occurences and set it as the
      // mode
      for (int i = 0; i < listHumanFingersAppearences.size(); i++) {
        if (listHumanFingersAppearences.get(0) <= listHumanFingersAppearences.get(i)) {
          listHumanFingersAppearences.set(0, listHumanFingersAppearences.get(i));
          mode = listOfHumanFingers.get(i);
        }
      }

      // call jarvisPlays() on the top strategy from StrategyCreator.java
      return topStrategy.jarvisPlays(mode);

    }
  }

}
