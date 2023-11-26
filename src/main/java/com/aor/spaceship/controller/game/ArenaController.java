package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.states.MenuState;

public class ArenaController extends GameController {
    public ArenaController(Arena arena) {
        super(arena);

    }

    public void step(Application application, GUI.Action action, long time) {
        if (action == GUI.Action.QUIT) {
            application.setState(new MenuState(new Menu()));
        }
        else {

        }
    }
}
