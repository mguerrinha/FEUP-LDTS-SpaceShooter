package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;

import java.io.IOException;

public class SpaceshipController extends GameController {
    private long lastMovement;
    private long lastDefaultShot;
    private long lastDoubleShot;

    ShootingController shootingController;
    public SpaceshipController(Arena arena) {
        super(arena);
        lastMovement = 0;
        lastDefaultShot = 0;
        lastDoubleShot = 0;
        shootingController = new ShootingController(arena, getModel().getSpaceship());
    }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        switch (getModel().getSpaceship().getShot()) {
            case "defaultShot":
                if (time - lastMovement > 300) {
                    shootingController.defaultShot();
                    this.lastMovement = time;
                }
                break;
            case "doubleShot":
                if (time - lastMovement > 300) {
                    shootingController.doubleShots();
                    this.lastMovement = time;
                }
                break;
            case "burst":
                if(time - lastMovement > 50) {
                    shootingController.defaultShot();
                    this.lastMovement = time;
                }
        }
        if (time - lastDefaultShot > 100) {
            shootingController.moveDefaultShot();
            this.lastDefaultShot = time;
        }
        if (time - lastDoubleShot > 100) {
            shootingController.moveDoubletShot();
            this.lastDoubleShot = time;
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
