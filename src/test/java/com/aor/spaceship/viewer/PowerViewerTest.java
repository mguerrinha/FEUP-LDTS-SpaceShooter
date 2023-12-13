package com.aor.spaceship.viewer;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.Power;
import com.aor.spaceship.viewer.game.PowerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PowerViewerTest {
    private Power power;
    private PowerViewer powerViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        power = new Power(10,10);
        powerViewer = new PowerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        powerViewer.draw(power, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPower(power.getPosition());
    }
}
