package com.aor.spaceship.viewer;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.menu.DefeatMenu;
import com.aor.spaceship.viewer.menu.DefeatMenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DefeatMenuViewerTest {

    @Test
    void drawElement() {
        DefeatMenu defeatMenu = new DefeatMenu();
        GUI gui = Mockito.mock(GUI.class);
        Application application = Mockito.mock(Application.class);
        DefeatMenuViewer defeatMenuViewer = new DefeatMenuViewer(defeatMenu);
        defeatMenuViewer.drawElements(application, gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(1, 5), "YOU LOST!", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(8, 22), "Insert Coin (c)", !application.hasCredits() ? "#FF0000" :"#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(18, 29), "Credits: " + application.getCredits(), !application.hasCredits() ? "#FF0000" : "#FFFFFF");
    }
}
