package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.Meteor;
import com.aor.spaceship.model.game.elements.Power;

public class PowerViewer implements ElementViewer<Power> {

    @Override
    public void draw(Power power, GUI gui) { gui.drawPower(power.getPosition()); }
}
