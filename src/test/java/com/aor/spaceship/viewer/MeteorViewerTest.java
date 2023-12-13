package com.aor.spaceship.viewer;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.Meteor;
import com.aor.spaceship.viewer.game.MeteorViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MeteorViewerTest {
    private Meteor meteor;
    private MeteorViewer meteorViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        meteor = new Meteor(10,10);
        meteorViewer = new MeteorViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        meteorViewer.draw(meteor, gui);
        Mockito.verify(gui, Mockito.times(1)).drawMeteor(meteor.getPosition());
    }
}
