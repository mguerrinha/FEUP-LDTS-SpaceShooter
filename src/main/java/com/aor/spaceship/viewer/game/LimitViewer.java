package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.Element;
import com.aor.spaceship.model.game.elements.Limit;

import java.util.List;

public class LimitViewer implements ElementViewer<Limit> {
    @Override
    public void draw(Limit limit, GUI gui) { gui.drawLimits(limit.getPosition()); }
}
