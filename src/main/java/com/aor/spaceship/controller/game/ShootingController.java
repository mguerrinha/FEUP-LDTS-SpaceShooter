package com.aor.spaceship.controller.game;

import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.DefaultShots;
import com.aor.spaceship.model.game.elements.Spaceship;

public class ShootingController {
    private Arena arena;
    private Spaceship spaceship;
    public ShootingController (Arena arena, Spaceship spaceship) {
        this.arena = arena;
        this.spaceship = spaceship;
    }
     public void defaultShot() {
        arena.getdefaultShots().add(new DefaultShots(spaceship.getPosition().getX(), spaceship.getPosition().moveUp().getY()));
        moveShot();
     }

     public void moveShot() {
        for (DefaultShots defaultShots : arena.getdefaultShots()) {
            defaultShots.moveBullet();
        }
     }
}
