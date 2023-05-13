package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public Integer[] decideSumAndFingers(int humanFingers) {
    int jarvisFingers;
    int jarvisSum;

    // Set jarvisFingers to a random number between 1 and 5
    jarvisFingers = Utils.getRandomNumber(1, 5);

    // Set jarvisSum to a random number between jarvisFingers + 1 and jarvisFingers
    // + 5
    jarvisSum = Utils.getRandomNumber((jarvisFingers + 1), (jarvisFingers + 5));

    // Return jarvisSum and jarvisFingers as an array of integers
    return new Integer[] { jarvisFingers, jarvisSum };
  }

}
