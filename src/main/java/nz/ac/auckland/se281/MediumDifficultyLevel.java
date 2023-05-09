package nz.ac.auckland.se281;

public class MediumDifficultyLevel implements DifficultyLevel{

    @Override
    public Integer[] playUsingLevel(Integer currentRound, Integer humanFingers) {
        StrategyCreator easyStrategy = new StrategyCreator(new RandomStrategy());
        StrategyCreator averageStrategy = new StrategyCreator(new AverageStrategy());

        if (currentRound <= 3) {
            return easyStrategy.jarvisPlays(humanFingers);
        } else {
            return averageStrategy.jarvisPlays(humanFingers);
        }
    }

    public 
    
}
