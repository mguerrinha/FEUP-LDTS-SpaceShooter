package com.aor.spaceship.controller.game;

import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.DefaultEnemy;
import com.aor.spaceship.model.game.elements.DefaultShot;
import com.aor.spaceship.model.game.elements.Spaceship;

public class ShootingController {
    private Arena arena;
    private Spaceship spaceship;
    public ShootingController (Arena arena, Spaceship spaceship) {
        this.arena = arena;
        this.spaceship = spaceship;
    }
     public void defaultShot() {
        arena.getdefaultShots().add(new DefaultShot(spaceship.getPosition().getX(), spaceship.getPosition().moveUp().getY()));
     }

     public void moveShot() {
        for (DefaultShot defaultShot : arena.getdefaultShots()) {
            defaultShot.moveBulletUp();
            if (arena.hasCollided(defaultShot.getPosition()) || arena.hasCollided(defaultShot.getPosition().moveUp())) {
                defaultShot.setPosition(new Position(0, -2));
            }
            if (arena.isEnemy(defaultShot.getPosition())) {
                arena.removeSpecialEnemy(defaultShot.getPosition());
                arena.removeDefaultEnemy(defaultShot.getPosition());
                defaultShot.setPosition(new Position(0, -2));
            }
        }
     }
}
