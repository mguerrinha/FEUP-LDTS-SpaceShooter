package com.aor.spaceship.controller.menu;

import com.aor.spaceship.Application;
import com.aor.spaceship.controller.Controller;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.arena.ArenaBuilder;
import com.aor.spaceship.model.menu.DefeatMenu;
import com.aor.spaceship.states.GameState;

public class DefeatMenuController extends Controller<DefeatMenu> {
    public DefeatMenuController(DefeatMenu defeatMenu) { super(defeatMenu); }

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
                if (getModel().isSelectedStart() && application.getCoins() > 0) {
                    application.setState(new GameState(new ArenaBuilder(30, 30).createArena()));
                    application.useCoin();
                }
                break;
            case COIN:
                if (application.getCoins() < 9)
                    application.addCoin();
                break;
        }
    }

}
