package com.aor.spaceship.model.game.arena;

import com.aor.spaceship.model.game.elements.DefaultShots;
import com.aor.spaceship.model.game.elements.Spaceship;

public class ArenaBuilder {
    private int width;
    private int heigth;
    private Spaceship spaceship;
    public ArenaBuilder(int width, int height) {
        this.width = width;
        this.heigth = height;
    }

    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setSpaceship(createSpaceship());
        arena.setDefaultShots(createDefaultShots());
        return arena;
    }

    protected int getWidth() { return width; };
    protected int getHeight() { return heigth; };
    protected Spaceship createSpaceship() {
        this.spaceship = new Spaceship (width/2, heigth/2);
        return spaceship;
    }
    protected DefaultShots createDefaultShots() { return new DefaultShots(spaceship.getPosition().getX(), spaceship.getPosition().getY()-1); }
}
