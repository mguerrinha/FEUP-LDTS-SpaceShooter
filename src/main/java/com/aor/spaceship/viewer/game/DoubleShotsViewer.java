package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.DoubleShot;
import com.aor.spaceship.model.game.elements.Element;

public class DoubleShotsViewer implements ElementViewer<DoubleShot> {
    @Override
    public void draw(DoubleShot doubleShot, GUI gui) { gui.drawDoubleShots(doubleShot.getPosition());}

}
