package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.Meteor;
import com.aor.spaceship.model.game.elements.Power;

import java.io.IOException;

public class SpaceshipController extends GameController {
    private long lastMovement;
    private long lastShot;
    ShootingController shootingController;
    public SpaceshipController(Arena arena) {
        super(arena);
        lastMovement = 0;
        lastShot = 0;
        shootingController = new ShootingController(arena, getModel().getSpaceship());
    }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        if (time - lastMovement > 300) {
            shootingController.defaultShot();
            this.lastMovement = time;
        }
        if (time - lastShot > 100) {
            shootingController.moveShot();
            this.lastShot = time;
        }
        if (getModel().isPower(getModel().getSpaceship().getPosition())) {
            getModel().removePower(getModel().getSpaceship().getPosition());
        }
        if (action == GUI.Action.LEFT) { moveSpaceshipLeft(); }
        if (action == GUI.Action.RIGHT) { moveSpaceshipRight(); }
        if (action == GUI.Action.UP) { moveSpaceshipUp(); }
        if (action == GUI.Action.DOWN) { moveSpaceshipDown(); }
    }

    public void moveSpaceship(Position position) {
        if (!getModel().isLimit(position)) {
            getModel().getSpaceship().setPosition(position);
            if (getModel().isPower(position) || getModel().isPower(position.moveDown()) || getModel().isPower(position.moveUp())) {
                getModel().removePower(position);
            }
        }
        if (getModel().hasCollided(position) || getModel().isEnemy(position)) {
            getModel().getSpaceship().reduceEnergy();
        }
    }

    public void moveSpaceshipLeft() {
        moveSpaceship(getModel().getSpaceship().getPosition().moveLeft());
    }
    public void moveSpaceshipRight() {
        moveSpaceship(getModel().getSpaceship().getPosition().moveRight());
    }
    public void moveSpaceshipUp() {
        moveSpaceship(getModel().getSpaceship().getPosition().moveUp());
    }
    public void moveSpaceshipDown() {
        moveSpaceship(getModel().getSpaceship().getPosition().moveDown());
    }

}
