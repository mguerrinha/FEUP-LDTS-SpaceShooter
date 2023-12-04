package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.SpecialEnemy;

import java.io.IOException;
import java.util.Random;

public class SpecialEnemyController extends GameController {
    private long lastMovement;
    public SpecialEnemyController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        Random random = new Random();
        if (time - lastMovement > 500) {
            for (SpecialEnemy specialEnemy : getModel().getSpecialEnemies()) {
                int randomPosition = random.ints(1, 5).findFirst().getAsInt();
                switch (randomPosition) {
                    case 1:
                        if (!getModel().isLimit(specialEnemy.getPosition().moveUp()) && !getModel().hasCollided(specialEnemy.getPosition().moveUp()))
                            moveSpecialEnemy(specialEnemy, specialEnemy.getPosition().moveUp());
                        break;
                    case 2:
                        if (!getModel().isLimit(specialEnemy.getPosition().moveDown()) && !getModel().hasCollided(specialEnemy.getPosition().moveDown()))
                            moveSpecialEnemy(specialEnemy, specialEnemy.getPosition().moveDown());
                        break;
                    case 3:
                        if (!getModel().isLimit(specialEnemy.getPosition().moveLeft()) && !getModel().hasCollided(specialEnemy.getPosition().moveLeft()))
                            moveSpecialEnemy(specialEnemy, specialEnemy.getPosition().moveLeft());
                        break;
                    case 4:
                        if (!getModel().isLimit(specialEnemy.getPosition().moveRight()) && !getModel().hasCollided(specialEnemy.getPosition().moveRight()))
                            moveSpecialEnemy(specialEnemy, specialEnemy.getPosition().moveRight());
                        break;
                    default:
                }
            }
            this.lastMovement = time;
        }
    }

    private void moveSpecialEnemy(SpecialEnemy specialEnemy, Position position) {
        specialEnemy.setPosition(position);
    }
}
