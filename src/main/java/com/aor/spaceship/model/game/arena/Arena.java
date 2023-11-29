package com.aor.spaceship.model.game.arena;

import com.aor.spaceship.model.game.elements.DefaultShots;
import com.aor.spaceship.model.game.elements.Spaceship;

public class Arena {
    private int width;
    private int height;
    private Spaceship spaceship;
    private DefaultShots defaultShots;
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
    public DefaultShots getdefaultShots() { return defaultShots; }

    public void setSpaceship(Spaceship spaceship) { this.spaceship = spaceship; }
    public void setDefaultShots(DefaultShots defaultShots) { this.defaultShots = defaultShots; }

}
