package com.aor.spaceship.model.game.arena;

import com.aor.spaceship.model.game.elements.DefaultShots;
import com.aor.spaceship.model.game.elements.Meteor;
import com.aor.spaceship.model.game.elements.Spaceship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArenaBuilder {
    private final Random random;
    private int width;
    private int heigth;
    private Spaceship spaceship;
    public ArenaBuilder(int width, int height) {
        this.random = new Random();
        this.width = width;
        this.heigth = height;
    }

    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setSpaceship(createSpaceship());
        arena.setDefaultShots(createDefaultShots());
        arena.setMeteors(createMeteors());
        return arena;
    }

    protected int getWidth() { return width; };
    protected int getHeight() { return heigth; };
    protected Spaceship createSpaceship() {
        this.spaceship = new Spaceship (width/2, heigth/2);
        return spaceship;
    }
    protected DefaultShots createDefaultShots() { return new DefaultShots(spaceship.getPosition().getX(), spaceship.getPosition().getY()-1); }

    protected List<Meteor> createMeteors() {
        List<Meteor> meteors = new ArrayList<>();

        for (int i = 0; i <= 2; i++) {
            meteors.add(new Meteor(random.nextInt(width - 2) + 1, -2));
        }
        return meteors;
    }
}
