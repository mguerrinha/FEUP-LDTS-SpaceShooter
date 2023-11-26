package com.aor.spaceship.model.game.arena;

import com.aor.spaceship.model.game.elements.Spaceship;

public class Arena {
    private int width;
    private int height;
    private Spaceship spaceship;
    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public Spaceship getSpaceship() { return spaceship; }

    public void setSpaceship(Spaceship spaceship) { this.spaceship = spaceship; }

}
