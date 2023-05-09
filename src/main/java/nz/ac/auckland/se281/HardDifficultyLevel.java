package nz.ac.auckland.se281;

import java.util.ArrayList;

public class HardDifficultyLevel implements DifficultyLevel {
    ArrayList<Integer> listOfHumanFingers = new ArrayList<>();
    ArrayList<Integer> listHumanFingersAppearences;
    StrategyCreator easyStrategy = new StrategyCreator(new RandomStrategy());
    StrategyCreator topStrategy = new StrategyCreator(new TopStrategy());

    @Override
    public Integer[] playUsingLevel(Integer humanFingers) {
        listHumanFingersAppearences = new ArrayList<>();
        int fingerCount = 0;
        int mode = 0;
        int fingerWeAreCheckingAgainst;
        int fingersWeAreCheckingfor;

        // add the human's finger input to the arraylist
        listOfHumanFingers.add(humanFingers);

        if (listOfHumanFingers.size() <= 3) {
            return easyStrategy.jarvisPlays(humanFingers);
        } else {
            // find the mode of the Human's finger inputs
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

            return topStrategy.jarvisPlays(mode);

        }
    }

}
