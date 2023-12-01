package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.DefaultShot;

public class DefaultShotsViewer implements ElementViewer<DefaultShot> {
    @Override
    public void draw(DefaultShot defaultShots, GUI gui) { gui.drawDefaultShots(defaultShots.getPosition());}
}
