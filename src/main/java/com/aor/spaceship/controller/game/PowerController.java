package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.Power;

import java.io.IOException;

public class PowerController extends GameController {
    private long lastMovement;
    public PowerController(Arena arena) {
        super(arena);
        lastMovement = 0;
    }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        if (time - lastMovement > 300) {
            for (Power power : getModel().getPowers()) {
                movePower(power, power.getPosition());
            }
            lastMovement = time;
        }
    }

    public void movePower(Power power, Position position) {
        power.setPosition(position.moveDown());
    }
}
