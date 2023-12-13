package com.aor.spaceship.viewer;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.menu.Initial;
import com.aor.spaceship.viewer.menu.InitialViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class InitialMenuViewerTest {

    @Test
    void drawElement() {
        Initial initialMenu = new Initial();
        GUI gui = Mockito.mock(GUI.class);
        Application application = Mockito.mock(Application.class);
        InitialViewer initialMenuViewer = new InitialViewer(initialMenu);
        initialMenuViewer.drawElements(application, gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3, 4),  "|         SPACE        |", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3, 5),  "|        SHOOTER       |", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3, 6),  " ---------------------- ", "#FFFFFF");
    }
}
