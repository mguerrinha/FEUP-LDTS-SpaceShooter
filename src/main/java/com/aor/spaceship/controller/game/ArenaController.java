package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final SpaceshipController spaceshipController;
    private final MeteorController meteorController;
    public ArenaController(Arena arena) {
        super(arena);
        this.spaceshipController = new SpaceshipController(arena);
        this.meteorController = new MeteorController(arena);
    }
    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        if (action == GUI.Action.QUIT || getModel().getSpaceship().getEnergy() == 0) {
            application.setState(new MenuState(new Menu()));
        }
        else {
            spaceshipController.step(application, action, time);
            meteorController.step(application, action, time);
        }
    }
}
