package com.aor.spaceship.model.game.arena;

import com.aor.spaceship.model.game.elements.Spaceship;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setSpaceship(createSpaceship());
        return arena;
    }

    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract Spaceship createSpaceship();


}
