package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  public Morra() {
  }

  private int roundCounter;
  private String playerName;

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {

    // Set the round to 1
    roundCounter = 1;

    // Print the message to welcome the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // Save the player name
    playerName = options[0];

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

      if ((arrayFingersSumInput.length == 2) && (Utils.isInteger(arrayFingersSumInput[0]) == true)
          && (Utils.isInteger(arrayFingersSumInput[1]) == true)
          && ((Integer.parseInt(arrayFingersSumInput[0]) >= 1) && (Integer.parseInt(arrayFingersSumInput[0]) <= 5))
          && ((Integer.parseInt(arrayFingersSumInput[1]) >= 1) && (Integer.parseInt(arrayFingersSumInput[1]) <= 10))) {
        MessageCli.PRINT_INFO_HAND.printMessage(playerName, arrayFingersSumInput[0], arrayFingersSumInput[1]);
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
