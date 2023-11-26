package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.Spaceship;

public class SpaceshipViewer implements ElementViewer<Spaceship> {
    @Override
    public void draw(Spaceship spaceship, GUI gui) { gui.drawSpaceship(spaceship.getPosition());}
}
