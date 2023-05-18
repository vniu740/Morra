package nz.ac.auckland.se281.strategy;

import nz.ac.auckland.se281.Utils;

public class AverageStrategy implements Strategy {

  @Override
  public Integer[] decideSumAndFingers(int average) {
    Integer jarvisFingers;
    Integer jarvisSum;

    // Set jarvisFingers to a random number between 1 and 5 
    jarvisFingers = Utils.getRandomNumber(1, 5);
    
    // Set jarvisSum to jarvisFingers plus the calculated average of previous inputs
    jarvisSum = jarvisFingers + average;

    // Return jarvisSum and jarvisFingers as an array of integers
    return new Integer[] { jarvisFingers, jarvisSum };

  }

}
