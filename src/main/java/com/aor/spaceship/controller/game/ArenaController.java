package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final SpaceshipController spaceshipController;
    public ArenaController(Arena arena) {
        super(arena);
        this.spaceshipController = new SpaceshipController(arena);
    }
    public void step(Application application, GUI.Action action, long time) throws IOException {
        if (action == GUI.Action.QUIT) {
            application.setState(new MenuState(new Menu()));
        }
        else {
            spaceshipController.step(application, action, time);
        }
    }
}
