package com.aor.spaceship.viewer;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.Limit;
import com.aor.spaceship.viewer.game.LimitViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LimitViewerTest {
    private Limit limit;
    private LimitViewer limitViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        limit = new Limit(10,10);
        limitViewer = new LimitViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        limitViewer.draw(limit, gui);
        Mockito.verify(gui, Mockito.times(1)).drawLimits(limit.getPosition());
    }
}
