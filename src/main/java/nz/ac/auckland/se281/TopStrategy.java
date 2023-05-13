package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  @Override
  public Integer[] decideSumAndFingers(int top) {
    Integer jarvisFingers;
    Integer jarvisSum;

    // Set jarvisFingers to a random number between 1 and 5
    jarvisFingers = Utils.getRandomNumber(1, 5);

    // Set jarvisSum to jarvisFingers plus the calculated top of previous inputs
    jarvisSum = jarvisFingers + top;

    // Return jarvisSum and jarvisFingers as an array of integers
    return new Integer[] { jarvisFingers, jarvisSum };
  }
}
