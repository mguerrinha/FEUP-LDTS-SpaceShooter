package com.aor.spaceship.model.game.elements;

public class SpecialEnemy extends Element {
    private int health;
    public SpecialEnemy(int x, int y) {
        super(x, y);
    }

    public int getHealth() { return health; }

    public void reduceHealth() { this.health--; }
}
