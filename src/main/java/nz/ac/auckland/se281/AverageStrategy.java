package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AverageStrategy implements Strategy {
    ArrayList<Integer> listOfHumanFingers = new ArrayList<>();

    @Override
    public Integer[] decideSumAndFingers(Integer humanFingers) {
        Integer jarvisFingers;
        Integer jarvisSum;
        Integer humanAvg = 0;

        // add the human's finger input to the arraylist
        listOfHumanFingers.add(humanFingers);

        if (listOfHumanFingers.size() == 1) {
            jarvisFingers = Utils.getRandomNumber(1, 5);
            jarvisSum = Utils.getRandomNumber((jarvisFingers + 1), (jarvisFingers + 5));

            return new Integer[] { jarvisFingers, jarvisSum };
        } else {

            // Find the sum of the human's previous fingers inputs
            for (int i = 0; i < (listOfHumanFingers.size() - 1); i++) {
                humanAvg += listOfHumanFingers.get(i);
            }
            // Calculate the average
            humanAvg = Math.round(humanAvg / (listOfHumanFingers.size() - 1));

            jarvisFingers = Utils.getRandomNumber(1, 5);
            jarvisSum = jarvisFingers + humanAvg;

            return new Integer[] { jarvisFingers, jarvisSum };

        }
    }

}
