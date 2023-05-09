package nz.ac.auckland.se281;


public class AverageStrategy implements Strategy {

    @Override
    public Integer[] decideSumAndFingers(int average) {
        Integer jarvisFingers;
        Integer jarvisSum;

            jarvisFingers = Utils.getRandomNumber(1, 5);
            jarvisSum = jarvisFingers + average;

            return new Integer[] {jarvisFingers, jarvisSum };

        }

    }

