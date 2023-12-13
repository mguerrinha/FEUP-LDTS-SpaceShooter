package com.aor.spaceship.viewer.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.elements.SpecialEnemy;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class SpecialEnemiesViewerTest {

    @Test
    void draw_ShouldCallDrawSpecialEnemiesWithCorrectPosition() {

        SpecialEnemy specialEnemy = new SpecialEnemy(10, 20, 100);
        specialEnemy.setPosition(new Position(10, 20));

        GUI mockGui = mock(GUI.class);
        SpecialEnemiesViewer specialEnemiesViewer = new SpecialEnemiesViewer();

        specialEnemiesViewer.draw(specialEnemy, mockGui);
        verify(mockGui).drawSpecialEnemies(new Position(10, 20));
    }
}
