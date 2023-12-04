package com.aor.spaceship.viewer.game;

import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.Element;
import com.aor.spaceship.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) { super(arena); }

    @Override
    protected void drawElements(GUI gui) {
        drawElements(gui, getModel().getdefaultShots(), new DefaultShotsViewer());
        drawElement(gui, getModel().getSpaceship(), new SpaceshipViewer());
        drawElements(gui, getModel().getMeteors(), new MeteorViewer());
        drawElements(gui, getModel().getLimits(), new LimitViewer());
        drawElements(gui, getModel().getPowers(), new PowerViewer());
        drawElements(gui, getModel().getSpecialEnemies(), new SpecialEnemiesViewer());


        gui.drawText(new Position(0, 1), "Highest", "#89CFF0");
        gui.drawText(new Position(0, 2), "Score", "#89CFF0");
        gui.drawText(new Position(0, 3), ":0", "#FFFFFF");
        gui.drawText(new Position(0, 14), "Current", "#89CFF0");
        gui.drawText(new Position(0, 15), "Score", "#89CFF0");
        gui.drawText(new Position(0, 16), ":" + getModel().getSpaceship().getScore(), "#FFFFFF");
        gui.drawText(new Position(0, 28), "Lives", "#89CFF0");
        gui.drawText(new Position(0, 29), ":" + getModel().getSpaceship().getEnergy(), "#FFFFFF");
    }

    private  <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements) {
            drawElement(gui, element, viewer);
        }
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}
