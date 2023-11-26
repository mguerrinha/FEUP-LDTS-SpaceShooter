package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;

import java.io.IOException;

public class SpaceshipController extends GameController {
    public SpaceshipController(Arena arena) { super(arena); }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        if (action == GUI.Action.LEFT) { moveSpaceshipLeft(); }
        if (action == GUI.Action.RIGHT) { moveSpaceshipRight(); }
        if (action == GUI.Action.UP) { moveSpaceshipUp(); }
        if (action == GUI.Action.DOWN) { moveSpaceshipDown(); }
    }

    public void moveSpaceship(Position position) {
        getModel().getSpaceship().setPosition(position);
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
