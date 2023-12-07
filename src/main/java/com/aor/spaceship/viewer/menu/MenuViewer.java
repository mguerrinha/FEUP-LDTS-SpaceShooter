package com.aor.spaceship.viewer.menu;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.viewer.Viewer;
import com.aor.spaceship.model.Position;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) { super(menu); }

    @Override
    public void drawElements(Application application, GUI gui) {
        gui.drawText(new Position(12, 12), "Menu", "#FFFFFF");
        gui.drawText(new Position(3, 3), "----------------------", "#FFFFFF");
        gui.drawText(new Position(2, 4), "|        SPACE         |", "#FFFFFF");
        gui.drawText(new Position(2, 5), "|       SHOOTER        |", "#FFFFFF");
        gui.drawText(new Position(3, 6), "----------------------", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(12, 14+i), getModel().getEntry(i), getModel().isSelected(i) ? "#89CFF0" : "#FFFFFF");
        }
        gui.drawText(new Position(7, 22), "Insert Coin (c)", application.hasCredits() ? "#FF0000" :"#FFFFFF");
        gui.drawText(new Position(18, 29), "Credits: " + application.getCredits(), "#FFFFFF");
    }
}
