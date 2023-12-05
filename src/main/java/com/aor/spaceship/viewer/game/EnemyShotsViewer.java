package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.EnemyShot;

public class EnemyShotsViewer implements ElementViewer<EnemyShot> {
    @Override
    public void draw(EnemyShot enemyShots, GUI gui) { gui.drawEnemyShots(enemyShots.getPosition()); }
}
