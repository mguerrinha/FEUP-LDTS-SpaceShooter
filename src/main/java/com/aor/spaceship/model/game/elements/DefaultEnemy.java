package com.aor.spaceship.model.game.elements;

public class DefaultEnemy extends Element {
    private int health;

    public DefaultEnemy(int x, int y) {
        super(x, y);
    }

    public int getHealth() { return health; }

    public void reduceHealth() { this.health--; }
}
