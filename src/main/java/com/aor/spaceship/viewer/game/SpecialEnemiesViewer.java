package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.SpecialEnemy;

public class SpecialEnemiesViewer implements ElementViewer<SpecialEnemy> {

    @Override
    public void draw(SpecialEnemy specialEnemy, GUI gui) { gui.drawSpecialEnemies(specialEnemy.getPosition()); }
}
