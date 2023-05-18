package nz.ac.auckland.se281.level;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyLevelFactory {

    // Method for determining which DifficultyLevel Instance should be created
    public static DifficultyLevel createLevel(Difficulty level) {

        switch (level) {
            // If input is easy, create new EasyDifficultyLevel instance
            case EASY:
                return new EasyDifficultyLevel();

            // If input is hard, create new HardDifficultyLevel instance
            case HARD:
                return new HardDifficultyLevel();

            // If input is Master, create new MasterDifficultyLevel instance
            case MASTER:
                return new MasterDifficultyLevel();

            // If input is medium, create new MediumDifficultyLevel instance
            case MEDIUM:
                return new MediumDifficultyLevel();

        }
        return null;

    }

}
