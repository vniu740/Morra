package nz.ac.auckland.se281;

public class CPU {

    private Strategy strategy;

    public CPU(Strategy strategy) {
        this.strategy = strategy;
    }

    public Integer[] jarvisPlays() {
        return strategy.decideSumAndFingers();
    }
}
