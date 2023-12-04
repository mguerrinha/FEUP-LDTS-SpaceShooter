package com.aor.spaceship.viewer.menu;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.menu.DefeatMenu;
import com.aor.spaceship.viewer.Viewer;

public class DefeatMenuViewer extends Viewer<DefeatMenu> {
    public DefeatMenuViewer(DefeatMenu defeatMenu) { super(defeatMenu); }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(11, 13), "YOU LOST!", "#880808");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(11, 15+i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFFFFF" : "#880808");
        }
    }
}
