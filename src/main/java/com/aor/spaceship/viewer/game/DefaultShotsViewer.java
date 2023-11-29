package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.DefaultShots;

public class DefaultShotsViewer implements ElementViewer<DefaultShots> {
    @Override
    public void draw(DefaultShots defaultShots, GUI gui) { gui.drawDefaultShots(defaultShots.getPosition());}
}
