package com.aor.spaceship.viewer.menu;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.menu.InstructionsMenu;
import com.aor.spaceship.viewer.Viewer;

public class InstructionsMenuViewer extends Viewer<InstructionsMenu> {
    public InstructionsMenuViewer(InstructionsMenu instructionsMenu) { super(instructionsMenu); }

    @Override
    protected void drawElements(Application application, GUI gui) {
        gui.drawText(new Position(26, 1), getModel().getEntry(0), getModel().isSelected(0) ? "#00FF00" : "#FFFFFF");
        gui.drawText(new Position(28, 1), getModel().getEntry(1), getModel().isSelected(1) ? "#FF0000" : "#FFFFFF");
    }
}
