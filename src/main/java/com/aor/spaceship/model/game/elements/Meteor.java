package com.aor.spaceship.model.game.elements;

import com.aor.spaceship.model.Position;

public class Meteor extends Element {
    private long lastSpawnTime;

    public Meteor(int x, int y) {
        super(x, y);
        this.lastSpawnTime = 0;
    }
    public long getLastSpawnTime() {
        return lastSpawnTime;
    }

    public void setLastSpawnTime(long lastSpawnTime) {
        this.lastSpawnTime = lastSpawnTime;
    }
}
