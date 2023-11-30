package com.aor.spaceship.model.game.elements;

public class Bullet extends Element {
    public Bullet(int x, int y) {
        super(x, y);
    }

    public void moveBullet() {
        this.setPosition(getPosition().moveUp());
    }
}
