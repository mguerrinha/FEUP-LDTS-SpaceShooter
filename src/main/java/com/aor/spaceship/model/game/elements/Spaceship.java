package com.aor.spaceship.model.game.elements;

public class Spaceship extends Element {
    private int energy;

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
}
