package com.aor.spaceship.viewer.menu;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.viewer.Viewer;
import com.aor.spaceship.model.Position;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) { super(menu); }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(5, 7+i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

    }

}
