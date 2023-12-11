package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.BurstShot;

public class BurstShotsViewer implements ElementViewer<BurstShot> {
    @Override
    public void draw(BurstShot burstShot, GUI gui) { gui.drawBurstShots(burstShot.getPosition()); }
}
