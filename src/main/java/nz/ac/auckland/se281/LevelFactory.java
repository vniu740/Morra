package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class LevelFactory {

    public DifficultyLevel createLevel(Difficulty level) {

        switch (level) {
            case EASY:
                return new EasyDifficultyLevel();

            case HARD:
                // TODO CHANGE RETURN TYPE WHEN LEVELS ARE CREATED
                return new EasyDifficultyLevel();

            case MASTER:
                // TODO CHANGE RETURN TYPE WHEN LEVELS ARE CREATED
                return new EasyDifficultyLevel();

            case MEDIUM:
                // TODO CHANGE RETURN TYPE WHEN LEVELS ARE CREATED
                return new EasyDifficultyLevel();

        }
        return null;

    }
}
