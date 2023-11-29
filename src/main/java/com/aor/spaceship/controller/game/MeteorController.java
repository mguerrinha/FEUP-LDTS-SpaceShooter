package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.Meteor;

import java.io.IOException;

public class MeteorController extends GameController {

    private long lastMovement;

    public MeteorController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Application application, GUI.Action action, long time) throws IOException {
        if (time - lastMovement > 300) {
            for (Meteor meteor : getModel().getMeteors())
                moveMeteor(meteor, meteor.getPosition().moveDown());
            this.lastMovement = time;
        }
    }
    private void moveMeteor(Meteor meteor, Position position) {
        meteor.setPosition(position);
        /*
        if (position.getY() >= getModel().getHeight()) {
            getModel().getMeteors().remove(meteor);
        }
        if (getModel().getMeteors().isEmpty()) {

        }
        */
        if (getModel().getSpaceship().getPosition().equals(position))
            getModel().getSpaceship().setEnergyToZero();
    }
}
