package nz.ac.auckland.se281;

public class EasyDifficultyLevel implements DifficultyLevel {

    @Override
    public Integer[] playUsingLevel() {
        CPU easyStrategy = new CPU(new RandomStrategy());

        return easyStrategy.jarvisPlays();
    }

}
