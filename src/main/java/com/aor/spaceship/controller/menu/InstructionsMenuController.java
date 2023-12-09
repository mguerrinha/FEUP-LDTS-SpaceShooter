package com.aor.spaceship.controller.menu;

import com.aor.spaceship.Application;
import com.aor.spaceship.controller.Controller;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.menu.InstructionsMenu;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.states.MenuState;

import java.io.IOException;

public class InstructionsMenuController extends Controller<InstructionsMenu> {
    public InstructionsMenuController(InstructionsMenu instructionsMenu) { super(instructionsMenu); }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        switch (action) {
            case RIGHT:
                if (getModel().isSelectedStay()) {
                    getModel().nextEntry();
                }
                break;
            case LEFT:
                if (getModel().isSelectedExit()) {
                    getModel().previousEntry();
                }
                break;
            case SELECT:
                if (getModel().isSelectedExit()) {
                    application.setState(new MenuState(new Menu()));
                }
        }
    }
}
