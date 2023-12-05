package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.DefaultEnemy;
import com.aor.spaceship.model.game.elements.SpecialEnemy;

import java.io.IOException;
import java.util.Random;

public class DefaultEnemyController extends GameController {
    private long lastMovement;
    DefaultEnemyShootingController defaultEnemyShootingController;

    public DefaultEnemyController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
        defaultEnemyShootingController = new DefaultEnemyShootingController(arena, getModel().getDefaultEnemies());
    }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        Random random = new Random();
        if (time - lastMovement > 300) {
            defaultEnemyShootingController.DefaultEnemyShot();
            for (DefaultEnemy defaultEnemy : getModel().getDefaultEnemies()) {
                int randomPosition = random.ints(1, 3).findFirst().getAsInt();
                switch (randomPosition) {
                    case 1:
                        if (!getModel().isLimit(defaultEnemy.getPosition().moveLeft()) && !getModel().hasCollided(defaultEnemy.getPosition().moveLeft()) && !getModel().isEnemy(defaultEnemy.getPosition().moveLeft()))
                            moveDefaultEnemy(defaultEnemy, defaultEnemy.getPosition().moveLeft());
                        break;
                    case 2:
                        if (!getModel().isLimit(defaultEnemy.getPosition().moveRight()) && !getModel().hasCollided(defaultEnemy.getPosition().moveRight()) && !getModel().isEnemy(defaultEnemy.getPosition().moveRight()))
                            moveDefaultEnemy(defaultEnemy, defaultEnemy.getPosition().moveRight());
                        break;
                    default:
                }
            }
            this.lastMovement = time;
        }
    }

    private void moveDefaultEnemy(DefaultEnemy defaultEnemy, Position position) {
        defaultEnemy.setPosition(position);
    }

}
