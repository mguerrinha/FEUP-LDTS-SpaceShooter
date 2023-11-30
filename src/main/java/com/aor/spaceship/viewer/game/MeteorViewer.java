package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.Meteor;

public class MeteorViewer implements ElementViewer<Meteor> {

    @Override
    public void draw(Meteor meteor, GUI gui) { gui.drawMeteor(meteor.getPosition()); }
}
