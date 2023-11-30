package com.aor.spaceship.controller.menu;

import com.aor.spaceship.Application;
import com.aor.spaceship.controller.Controller;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.arena.ArenaBuilder;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.states.GameState;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) { super(menu); }
    @Override
    public void step(Application application, GUI.Action action, long time) {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) application.setState(null);
                if (getModel().isSelectedStart()) application.setState(new GameState(new ArenaBuilder(30, 30).createArena()));
        }
    }
}
