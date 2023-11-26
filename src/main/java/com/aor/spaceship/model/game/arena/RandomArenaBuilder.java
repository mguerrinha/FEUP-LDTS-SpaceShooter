package com.aor.spaceship.model.game.arena;

import com.aor.spaceship.model.game.elements.Spaceship;

public class RandomArenaBuilder extends ArenaBuilder {
    private int width;
    private int height;
    public RandomArenaBuilder(int width, int height) {
        this.height = height;
        this.width = width;
    }
    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected Spaceship createSpaceship() {
        return new Spaceship(getWidth()/2, getHeight()/2);
    }
}
