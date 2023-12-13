package com.aor.spaceship.viewer;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.TripleShot;
import com.aor.spaceship.viewer.game.TripleShotsViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TripleShotViewerTest {
    private TripleShot tripleShot;
    private TripleShotsViewer tripleShotsViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        tripleShot = new TripleShot(10,10);
        tripleShotsViewer = new TripleShotsViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        tripleShotsViewer.draw(tripleShot, gui);
        Mockito.verify(gui, Mockito.times(1)).drawTripleShots(tripleShot.getPosition());
    }
}
