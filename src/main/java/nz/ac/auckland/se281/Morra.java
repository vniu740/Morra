package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  public Morra() {
  }

  private int roundCounter;

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {

    // Set the round to 1
    roundCounter = 1;

    // Print the message to welcome the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

  }

  public void play() {

    // Print round being played
    MessageCli.START_ROUND.printMessage(String.valueOf(roundCounter));
    roundCounter++;

    // Print give fingers and sum inputs
    MessageCli.ASK_INPUT.printMessage();
    String fingersSumInputString = Utils.scanner.nextLine();

    boolean areInputsValid = false;

    while (areInputsValid == false) {
      // Split the input string into an array of string of the numbers (seperating by
      // white space)
      String[] arrayFingersSumInput = fingersSumInputString.split("\\s+");

      if ((arrayFingersSumInput.length == 2) && (arrayFingersSumInput[0].matches("\\d+"))
          && (arrayFingersSumInput[1].matches("\\d+"))
          && ((Integer.parseInt(arrayFingersSumInput[0]) >= 1) && (Integer.parseInt(arrayFingersSumInput[0]) <= 5))
          && ((Integer.parseInt(arrayFingersSumInput[1]) >= 1) && (Integer.parseInt(arrayFingersSumInput[1]) <= 10))) {
        areInputsValid = true;
      } else {
        MessageCli.INVALID_INPUT.printMessage();
        fingersSumInputString = Utils.scanner.nextLine();
      }

    }
  }

  public void showStats() {
  }
}
