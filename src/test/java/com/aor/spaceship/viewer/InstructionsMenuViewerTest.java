package com.aor.spaceship.viewer;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.menu.InstructionsMenu;
import com.aor.spaceship.viewer.menu.InstructionsMenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class InstructionsMenuViewerTest {

    @Test
    void drawElement() {
        InstructionsMenu instructionsMenu = new InstructionsMenu();
        GUI gui = Mockito.mock(GUI.class);
        Application application = Mockito.mock(Application.class);
        InstructionsMenuViewer instructionsMenuViewer = new InstructionsMenuViewer(instructionsMenu);
        instructionsMenuViewer.drawElements(application, gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(1,1), "Controls: ", "#89CFF0");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(1,3), "È", "#89CFF0");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(2,3), " : Move Up", "#FFFFFF");
    }
}
