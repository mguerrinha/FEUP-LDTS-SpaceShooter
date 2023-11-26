package com.aor.spaceship.viewer.game;

import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.elements.Element;
import com.aor.spaceship.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) { super(arena); }

    @Override
    protected void drawElements(GUI gui) {
        drawElement(gui, getModel().getSpaceship(), new SpaceshipViewer());
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
