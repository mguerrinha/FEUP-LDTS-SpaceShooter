package com.aor.spaceship.model.game.arena;

import com.aor.spaceship.model.game.elements.Spaceship;

public class ArenaBuilder {
    private int width;
    private int heigth;
    public ArenaBuilder(int width, int height) {
        this.width = width;
        this.heigth = height;
    }

    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setSpaceship(createSpaceship());
        return arena;
    }

    protected int getWidth() { return width; };
    protected int getHeight() { return heigth; };
    protected Spaceship createSpaceship() {
        return new Spaceship(width/2, heigth/2);
    }
}
