package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.TripleShot;

public class TripleShotsViewer implements ElementViewer<TripleShot> {
    @Override
    public void draw(TripleShot tripleShot, GUI gui) { gui.drawTripleShots(tripleShot.getPosition()); }
}
