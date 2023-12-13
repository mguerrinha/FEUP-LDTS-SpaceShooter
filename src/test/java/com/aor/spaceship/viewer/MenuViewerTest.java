package com.aor.spaceship.viewer;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.viewer.menu.MenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MenuViewerTest {

    @Test
    void drawElement() {
        Menu menu = new Menu();
        GUI gui = Mockito.mock(GUI.class);
        Application application = Mockito.mock(Application.class);
        MenuViewer menuViewer = new MenuViewer(menu);
        menuViewer.drawElements(application, gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3, 3), " ----------------------", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(13, 12), "Menu", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(18, 29), "Credits: " + application.getCredits(), "#FFFFFF");
    }
}

