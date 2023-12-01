package com.aor.spaceship.model.game.arena;

import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.elements.*;

import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Spaceship spaceship;
    private List<DefaultShot> defaultShots;
    private List<Meteor> meteors;
    private List<Power> powers;
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
    public List<DefaultShot> getdefaultShots() { return defaultShots; }
    public List<Meteor> getMeteors() {return meteors; }

    public List<Power> getPowers() {return powers; }
    public List<Limit> getLimits() { return limits; }

    public void setSpaceship(Spaceship spaceship) { this.spaceship = spaceship; }
    public void setDefaultShots(List<DefaultShot> defaultShots) { this.defaultShots = defaultShots; }

    public void setMeteors(List<Meteor> meteors) { this.meteors = meteors; }

    public void setPowers(List<Power> powers) { this.powers = powers; }
    public void setLimits(List<Limit> limits) { this.limits = limits; }

    public boolean hasCollided(Position position) {
        for (Meteor meteor : meteors) {
            if (meteor.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isLimit(Position position) {
        for (Limit limit : limits) {
            if (limit.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPower(Position position) {
        for (Power power : powers) {
            if (power.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public void removePower(Position position) {
        for (int i = 0; i < powers.size(); i++) {
            if (powers.get(i).getPosition().equals(position)) {
                powers.remove(i);
            }
        }
    }

}
