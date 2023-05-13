package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int roundCounter;
  private int numberOfJarvisWins;
  private int numberOfPlayerWins;
  private int numberOfPointsPlayerInput;
  private String playerName;
  private DifficultyLevel currentDifficultyLevel;
  private Integer[] jarvisValues;
  private boolean isGameInPlay = false;

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {

    // Set the round to 1
    roundCounter = 1;

    // Print the message to welcome the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // Save the player name
    playerName = options[0];

    // Create a new difficulty level specific to the users input
    currentDifficultyLevel = createLevel(difficulty);

    // Set isGameInPlay to true
    isGameInPlay = true;

    // Set numberOfRoundsPlayerInput to the players input
    numberOfPointsPlayerInput = pointsToWin;

    // Set numberOfJarvisWins to 0
    numberOfJarvisWins = 0;

    // Set numberOfPlayerWins to 0
    numberOfPlayerWins = 0;
  }

  public void play() {

    // Check if a game has started, if not do not continue with code
    if (isGameInPlay == false) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Print give fingers and sum inputs
    MessageCli.ASK_INPUT.printMessage();
    String fingersSumInputString = Utils.scanner.nextLine();

    boolean isInputsValid = false;

    // Print round being played
    MessageCli.START_ROUND.printMessage(String.valueOf(roundCounter));

    while (isInputsValid == false) {
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
        isInputsValid = true;

        // Check if any player has won the game
        if ((numberOfJarvisWins == numberOfPointsPlayerInput) || (numberOfPlayerWins == numberOfPointsPlayerInput)) {
          if (numberOfJarvisWins == numberOfPointsPlayerInput) {
            MessageCli.END_GAME.printMessage("Jarvis", String.valueOf(roundCounter - 1));
            isGameInPlay = false;
          } else {
            MessageCli.END_GAME.printMessage(playerName, String.valueOf(roundCounter - 1));
            isGameInPlay = false;
          }

        }

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
        return new MasterDifficultyLevel();

      case MEDIUM:
        return new MediumDifficultyLevel();

    }
    return null;

  }

  public void findResultOfRound(int humanFingers, int humanSum, int jarvisFingers, int jarvisSum) {

    int trueSum = humanFingers + jarvisFingers;

    if ((trueSum == humanSum) && (trueSum == jarvisSum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      return;
    }
    if (trueSum == humanSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      numberOfPlayerWins++;
      return;
    }
    if (trueSum == jarvisSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      numberOfJarvisWins++;
      return;
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
  }

  public void showStats() {
    // Check if a game is running, if not print message and return out of method
    if (isGameInPlay == false) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // Print the message for number of Player wins and needed points to win
    MessageCli.PRINT_PLAYER_WINS.printMessage(playerName, String.valueOf(numberOfPlayerWins),
        String.valueOf(numberOfPointsPlayerInput - numberOfPlayerWins));

    // Print the message for number of Jarvis wins and needed points to win
    MessageCli.PRINT_PLAYER_WINS.printMessage("Jarvis", String.valueOf(numberOfJarvisWins),
        String.valueOf(numberOfPointsPlayerInput - numberOfJarvisWins));
  }
}
