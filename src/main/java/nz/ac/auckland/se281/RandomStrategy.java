package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

    private int jarvisFingers;
    private int jarvisSum;

    @Override
    public Integer[] decideSumAndFingers() {
        jarvisFingers = Utils.getRandomNumber(1, 5);
        jarvisSum = Utils.getRandomNumber((jarvisFingers + 1), (jarvisFingers + 5));

        return new Integer[] { jarvisFingers, jarvisSum };
    }

}
