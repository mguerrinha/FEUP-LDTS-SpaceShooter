package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.DefaultEnemy;
import com.aor.spaceship.model.game.elements.DefaultShot;
import com.aor.spaceship.model.menu.DefeatMenu;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.states.DefeatMenuState;
import com.aor.spaceship.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final SpaceshipController spaceshipController;
    private final MeteorController meteorController;
    private final SpecialEnemyController specialEnemyController;
    private final DefaultEnemyController defaultEnemyController;
    private final PowerController powerController;
    public ArenaController(Arena arena) {
        super(arena);
        this.spaceshipController = new SpaceshipController(arena);
        this.meteorController = new MeteorController(arena);
        this.specialEnemyController = new SpecialEnemyController(arena);
        this.defaultEnemyController = new DefaultEnemyController(arena);
        this.powerController = new PowerController(arena);
    }
    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        if (getModel().getSpaceship().getScore() > application.getHishestScore())
            application.setHighestScore(getModel().getSpaceship().getScore());
        if (action == GUI.Action.QUIT) {
            getModel().getExecutorService().shutdown();
            application.setState(new MenuState(new Menu()));
        }
        else if (getModel().getSpaceship().getEnergy() == 0) {
            getModel().getExecutorService().shutdown();
            application.setState(new DefeatMenuState(new DefeatMenu()));
        }
        else {
            spaceshipController.step(application, action, time);
            meteorController.step(application, action, time);
            specialEnemyController.step(application, action, time);
            defaultEnemyController.step(application, action, time);
            powerController.step(application, action, time);
        }
    }
}
