package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.DefaultEnemy;

import java.io.IOException;
import java.util.Random;

public class DefaultEnemyController extends GameController {
    private long lastMovement;
    private long lastShot;
    private long lastAdd;
    EnemyShootingController enemyShootingController;

    public DefaultEnemyController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
        enemyShootingController = new EnemyShootingController(arena, getModel().getDefaultEnemies());
    }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        if (time - lastAdd > 700) {
            enemyShootingController.DefaultEnemyShot();
            this.lastAdd = time;
        }
        if (time - lastShot > 100) {
            enemyShootingController.moveEnemyShot();
            this.lastShot = time;
        }
        Random random = new Random();
        if (time - lastMovement > 500) {
            for (DefaultEnemy defaultEnemy : getModel().getDefaultEnemies()) {
                int randomPosition = random.ints(1, 5).findFirst().getAsInt();
                switch (randomPosition) {
                    case 1:
                        if (!getModel().isLimit(defaultEnemy.getPosition().moveLeft()) && !getModel().hasCollided(defaultEnemy.getPosition().moveLeft()) && !getModel().isEnemy(defaultEnemy.getPosition().moveLeft()))
                            moveDefaultEnemy(defaultEnemy, defaultEnemy.getPosition().moveLeft());
                        break;
                    case 2:
                        if (!getModel().isLimit(defaultEnemy.getPosition().moveRight()) && !getModel().hasCollided(defaultEnemy.getPosition().moveRight()) && !getModel().isEnemy(defaultEnemy.getPosition().moveRight()))
                            moveDefaultEnemy(defaultEnemy, defaultEnemy.getPosition().moveRight());
                        break;
                    case 3:
                        if (!getModel().isLimit(defaultEnemy.getPosition().moveUp()) && !getModel().hasCollided(defaultEnemy.getPosition().moveUp()) && !getModel().isEnemy(defaultEnemy.getPosition().moveUp()))
                            moveDefaultEnemy(defaultEnemy, defaultEnemy.getPosition().moveUp());
                        break;
                    case 4:
                        if (!getModel().isLimit(defaultEnemy.getPosition().moveDown()) && !getModel().hasCollided(defaultEnemy.getPosition().moveDown()) && !getModel().isEnemy(defaultEnemy.getPosition().moveDown()))
                            moveDefaultEnemy(defaultEnemy, defaultEnemy.getPosition().moveDown());
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
