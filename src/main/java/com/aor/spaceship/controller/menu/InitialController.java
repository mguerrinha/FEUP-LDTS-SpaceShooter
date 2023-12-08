package com.aor.spaceship.controller.menu;

import com.aor.spaceship.Application;
import com.aor.spaceship.controller.Controller;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.menu.Initial;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.states.MenuState;

import java.io.IOException;

public class InitialController extends Controller<Initial> {
    public InitialController(Initial model) {
        super(model);
    }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        switch (action) {
            case SELECT:
                application.setState(null);
                break;
            case COIN:
                application.setState(new MenuState(new Menu()));
                application.addCredit();
                break;
        }
    }
}
