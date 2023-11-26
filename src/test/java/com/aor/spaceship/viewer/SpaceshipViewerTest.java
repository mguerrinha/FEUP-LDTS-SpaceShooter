package com.aor.spaceship.viewer;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.Spaceship;
import com.aor.spaceship.viewer.game.GameViewer;
import com.aor.spaceship.viewer.game.SpaceshipViewer;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpaceshipViewerTest {
    private Spaceship spaceship;
    private SpaceshipViewer spaceshipViewer;
    private GUI gui;
    @BeforeEach
    void setUp() {
        spaceship =  new Spaceship(5, 5);
        spaceshipViewer = new SpaceshipViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        spaceshipViewer.draw(spaceship, gui);
        Mockito.verify(gui, Mockito.times(1)).drawSpaceship(spaceship.getPosition());
    }
}
