package com.aor.spaceship.model.game.elements;

public class Spaceship extends Element {
    private int energy;
    private int score;

    public Spaceship(int x, int y) {
        super(x, y);
        this.energy = 3;
    }

    public int getEnergy() {
        return energy;
    }

    public void reduceEnergy() {
        this.energy--;
    }

    public int getScore() { return score; }

    public void addScore(int score) { this.score += score; }
}
