package nz.ac.auckland.se281;


import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  // public Morra() {
  // }

  private int roundCounter;
  private String playerName;
  private DifficultyLevel currentDifficultyLevel;
  private Integer[] jarvisValues;

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {

    // Set the round to 1
    roundCounter = 1;

    // Print the message to welcome the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // Save the player name
    playerName = options[0];

    currentDifficultyLevel = createLevel(difficulty);
  }

  public void play() {

    // Print give fingers and sum inputs
    MessageCli.ASK_INPUT.printMessage();
    String fingersSumInputString = Utils.scanner.nextLine();

    boolean areInputsValid = false;

    // Print round being played
    MessageCli.START_ROUND.printMessage(String.valueOf(roundCounter));

    while (areInputsValid == false) {
      // Split the input string into an array of string of the numbers (seperating by
      // white space)
      String[] arrayFingersSumInput = fingersSumInputString.split("\\s+");

      if ((arrayFingersSumInput.length == 2) && (Utils.isInteger(arrayFingersSumInput[0]) == true)
          && (Utils.isInteger(arrayFingersSumInput[1]) == true)
          && ((Integer.parseInt(arrayFingersSumInput[0]) >= 1) && (Integer.parseInt(arrayFingersSumInput[0]) <= 5))
          && ((Integer.parseInt(arrayFingersSumInput[1]) >= 1) && (Integer.parseInt(arrayFingersSumInput[1]) <= 10))) {
        MessageCli.PRINT_INFO_HAND.printMessage(playerName, arrayFingersSumInput[0], arrayFingersSumInput[1]);

        // Get jarvis' values according to the difficulty level
        jarvisValues = currentDifficultyLevel.playUsingLevel(Integer.parseInt(arrayFingersSumInput[0]));
        // Display Jarvis' values
        MessageCli.PRINT_INFO_HAND.printMessage("Jarvis",
            String.valueOf(jarvisValues[0]),
            String.valueOf(jarvisValues[1]));

        findResultOfRound(Integer.parseInt(arrayFingersSumInput[0]),
            Integer.parseInt(arrayFingersSumInput[1]),
            jarvisValues[0], jarvisValues[1]);

        roundCounter++;
        areInputsValid = true;

      } else {
        MessageCli.INVALID_INPUT.printMessage();
        fingersSumInputString = Utils.scanner.nextLine();
      }
    }

  }

  public DifficultyLevel createLevel(Difficulty level) {

    switch (level) {
      case EASY:
        return new EasyDifficultyLevel();

      case HARD:
        return new HardDifficultyLevel();

      case MASTER:
        // TODO CHANGE RETURN TYPE WHEN LEVELS ARE CREATED
        return new EasyDifficultyLevel();

      case MEDIUM:
        return new MediumDifficultyLevel();

    }
    return null;

  }

  public void findResultOfRound(int humanFingers, int humanSum, int jarvisFingers, int jarvisSum) {

    int trueSum = humanFingers + jarvisFingers;

    if ((trueSum == humanSum) && (trueSum == jarvisFingers)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      return;
    }
    if (trueSum == humanSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    }
    if (trueSum == jarvisSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }

  }

  public void showStats() {
  }
}
