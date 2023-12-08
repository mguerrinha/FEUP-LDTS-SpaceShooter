package com.aor.spaceship.viewer.menu;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.menu.DefeatMenu;
import com.aor.spaceship.viewer.Viewer;

public class DefeatMenuViewer extends Viewer<DefeatMenu> {
    public DefeatMenuViewer(DefeatMenu defeatMenu) { super(defeatMenu); }

    @Override
    public void drawElements(Application application, GUI gui) {
        gui.drawText(new Position(2, 10), "YOU LOST!", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(2, 12+i), getModel().getEntry(i), getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
        }
        gui.drawText(new Position(8, 22), "Insert Coin (c)", application.hasCredits() ? "#FF0000" :"#FFFFFF");
        gui.drawText(new Position(18, 29), "Credits: " + application.getCredits(), "#FFFFFF");
        gui.drawText(new Position(18, 0), "   _          ", "#FFFFFF");
        gui.drawText(new Position(18, 1), "  /  \\       ", "#FFFFFF");
        gui.drawText(new Position(18, 2), " /    \\      ", "#FFFFFF");
        gui.drawText(new Position(18, 3), "|  ()  |      ", "#FFFFFF");
        gui.drawText(new Position(18, 4), "|      |      ", "#FFFFFF");
        gui.drawText(new Position(18, 5), "|      |      ", "#FFFFFF");
        gui.drawText(new Position(6, 6), "|      |      ", "#FFFFFF");
        gui.drawText(new Position(6, 7), "|      |      ", "#FFFFFF");
        gui.drawText(new Position(6, 8), "|      |      ", "#FFFFFF");
        gui.drawText(new Position(6, 9), "|      |      ", "#FFFFFF");
        gui.drawText(new Position(6, 10), "|      |      ", "#FFFFFF");
        gui.drawText(new Position(6, 11), "|      |      ", "#FFFFFF");
        gui.drawText(new Position(6, 12), "|      |      ", "#FFFFFF");
        gui.drawText(new Position(6, 13), "|      |      ", "#FFFFFF");
    }
}
