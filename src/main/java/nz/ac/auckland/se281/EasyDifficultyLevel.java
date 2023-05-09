package nz.ac.auckland.se281;

public class EasyDifficultyLevel implements DifficultyLevel {

    @Override
    public Integer[] playUsingLevel(Integer currentRound, Integer humanFingers) {
        StrategyCreator easyStrategy = new StrategyCreator(new RandomStrategy());

        return easyStrategy.jarvisPlays(humanFingers);
    }

}
