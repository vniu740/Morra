package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  @Override
  public Integer[] decideSumAndFingers(int top) {
    Integer jarvisFingers;
    Integer jarvisSum;

    jarvisFingers = Utils.getRandomNumber(1, 5);
    jarvisSum = jarvisFingers + top;

    return new Integer[] { jarvisFingers, jarvisSum };
  }
}
