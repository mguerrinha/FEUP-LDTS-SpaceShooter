package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.DefaultShots;

import java.io.IOException;

public class DefaultShotsController extends GameController {
    public DefaultShotsController(Arena arena) { super(arena); }
    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        if (action == GUI.Action.UP) {
            moveDefaultShotsUp();
        }
        if (action == GUI.Action.DOWN) {
            moveDefaultShotsDown();
        }
        if (action == GUI.Action.LEFT) {
            moveDefaultShotsLeft();
        }
        if (action == GUI.Action.RIGHT) {
            moveDefaultShotsRight();
        }
    }
    public void moveDefaultShots(Position position) { getModel().getdefaultShots().setPosition(position); }
    public void moveDefaultShotsUp() { moveDefaultShots(getModel().getdefaultShots().getPosition().moveUp()); }
    public void moveDefaultShotsDown() { moveDefaultShots(getModel().getdefaultShots().getPosition().moveDown()); }
    public void moveDefaultShotsLeft() { moveDefaultShots(getModel().getdefaultShots().getPosition().moveLeft()); }
    public void moveDefaultShotsRight() { moveDefaultShots(getModel().getdefaultShots().getPosition().moveRight()); }
}
