package com.aor.spaceship.model.game.arena;

import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.elements.DefaultShots;
import com.aor.spaceship.model.game.elements.Limit;
import com.aor.spaceship.model.game.elements.Meteor;
import com.aor.spaceship.model.game.elements.Spaceship;

import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Spaceship spaceship;
    private DefaultShots defaultShots;
    private List<Meteor> meteors;
    private List<Limit> limits;
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

    public List<Meteor> getMeteors() {return meteors; }
    public List<Limit> getLimits() { return limits; }

    public void setSpaceship(Spaceship spaceship) { this.spaceship = spaceship; }
    public void setDefaultShots(DefaultShots defaultShots) { this.defaultShots = defaultShots; }

    public void setMeteors(List<Meteor> meteors) {this.meteors = meteors; }
    public void setLimits(List<Limit> limits) { this.limits = limits; }

    public boolean hasCollided(Position position) {
        for (Meteor meteor : meteors)
            if (meteor.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isLimit(Position position) {
        for (Limit limit : limits) {
            if (limit.getPosition().equals(position)) {
                return false;
            }
        }
        return true;
    }
}
