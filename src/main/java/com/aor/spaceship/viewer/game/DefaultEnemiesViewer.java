package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.DefaultEnemy;

public class DefaultEnemiesViewer implements ElementViewer<DefaultEnemy> {
    @Override
    public void draw(DefaultEnemy defaultEnemy, GUI gui) { gui.drawDefaultEnemies(defaultEnemy.getPosition()); }
}
