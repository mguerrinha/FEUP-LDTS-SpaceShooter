package com.aor.spaceship.viewer;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.elements.EnemyShot;
import com.aor.spaceship.viewer.game.ElementViewer;
import com.aor.spaceship.viewer.game.EnemyShotsViewer;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class EnemyShotsViewerTest {

    @Test
    public void testDraw() {

        GUI mockGUI = mock(GUI.class);

        EnemyShot enemyShot = new EnemyShot(new Position(5, 5));


        ElementViewer<EnemyShot> enemyShotsViewer = new EnemyShotsViewer();

        enemyShotsViewer.draw(enemyShot, mockGUI);

        verify(mockGUI, times(1)).drawEnemyShots(enemyShot.getPosition());
    }
}
