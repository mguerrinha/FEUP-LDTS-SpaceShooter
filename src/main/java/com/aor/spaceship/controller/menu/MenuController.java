package com.aor.spaceship.controller.menu;

import com.aor.spaceship.Application;
import com.aor.spaceship.controller.Controller;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.arena.ArenaBuilder;
import com.aor.spaceship.model.menu.InstructionsMenu;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.states.GameState;
import com.aor.spaceship.states.InstructionsMenuState;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) { super(menu); }
    @Override
    public void step(Application application, GUI.Action action, long time) {
        if (!application.hasCredits()) {
            switch (action) {
                case SELECT:
                    application.setState(null);
                    break;
                case COIN:
                    application.addCredit();
                    break;
            }

        }
        else {
            switch (action) {
                case UP:
                    getModel().previousEntry();
                    break;
                case DOWN:
                    getModel().nextEntry();
                    break;
                case SELECT:
                    if (getModel().isSelectedExit()) application.setState(null);
                    if (getModel().isSelectedStart() && application.getCredits() > 0) {
                        application.setState(new GameState(new ArenaBuilder(30, 30).createArena()));
                        application.useCredit();
                    }
                    if (getModel().isSelectedInstructions()) application.setState(new InstructionsMenuState( new InstructionsMenu()));
                    break;
                case COIN:
                    if (application.getCredits() < 9)
                        application.addCredit();
                    break;

            }
        }
    }
}
