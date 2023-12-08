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
        gui.drawText(new Position(3, 3),  " ----------------------", "#FFFFFF");
        gui.drawText(new Position(3, 4),  "|         SPACE        |", "#FFFFFF");
        gui.drawText(new Position(3, 5),  "|        SHOOTER       |", "#FFFFFF");
        gui.drawText(new Position(3, 6),  " ---------------------- ", "#FFFFFF");
        gui.drawText(new Position(3, 7),  "                        ", "#FFFFFF");
        gui.drawText(new Position(3, 8),  "           /\\          ", "#FFFFFF");
        gui.drawText(new Position(3, 9),  "          |()|          ", "#FFFFFF");
        gui.drawText(new Position(3, 10), " /\\       |  |       /\\", "#FFFFFF");
        gui.drawText(new Position(3, 11), " ||       |()|       ||", "#FFFFFF");
        gui.drawText(new Position(3, 12), " ||      /    \\      ||", "#FFFFFF");
        gui.drawText(new Position(3, 13), " ||     /      \\     ||", "#FFFFFF");
        gui.drawText(new Position(3, 14), " ||____/        \\____||", "#FFFFFF");
        gui.drawText(new Position(3, 15), " |                     |", "#FFFFFF");
        gui.drawText(new Position(3, 16), " |                     |", "#FFFFFF");

        gui.drawText(new Position(7, 24), "Insert Coin (c)", !application.hasCredits() ? "#FF0000" : "#000000");
        gui.drawText(new Position(18, 29), "Credits: " + application.getCredits(), !application.hasCredits() ? "#FF0000" : "#FFFFFF");
        if (application.getCredits() > 0) {
            gui.drawText(new Position(13, 12), "Menu", "#FFFFFF");
            for (int i = 0; i < getModel().getNumberEntries(); i++) {
                gui.drawText(new Position(13, 14 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#89CFF0" : "#FFFFFF");
            }
            gui.drawText(new Position(7, 22), "Insert Coin (c)", "#FFFFFF");
            gui.drawText(new Position(18, 29), "Credits: " + application.getCredits(), "#FFFFFF");
        }
    }
}
