package com.aor.spaceship.viewer;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.*;
import com.aor.spaceship.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class ArenaViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;
    private Application application;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);
        application = new Application();
        arena.setSpaceship(new Spaceship(5, 5));

        arena.setDefaultEnemies(new ArrayList<>());
        arena.getDefaultEnemies().add(new DefaultEnemy(3, 3, 2));

        arena.setDoubleShots(new ArrayList<>());
        arena.getDoubleShots().add(new DoubleShot(6, 6));

        arena.setDefaultShots(new ArrayList<>());
        arena.getDefaultShots().add(new DefaultShot(4, 4));

        arena.setLimits(new ArrayList<>());
        arena.getLimits().add(new Limit(1, 1));

        arena.setMeteors(new ArrayList<>());
        arena.getMeteors().add(new Meteor(2, 2));

        arena.setEnemyShots(new ArrayList<>());
        arena.getEnemyShots().add(new EnemyShot(7, 7));

        arena.setPowers(new ArrayList<>());
        arena.getPowers().add(new Power(8, 8));

        arena.setSpecialEnemies(new ArrayList<>());
        arena.getSpecialEnemies().add(new SpecialEnemy(9, 9, 5));
    }

    @Test
    void drawSpaceShip() throws IOException {
        viewer.draw(application, gui);
        Mockito.verify(gui, Mockito.times(1)).drawSpaceship(new Position(5, 5));
        Mockito.verify(gui, Mockito.times(1)).drawSpaceship(Mockito.any(Position.class));
    }

    @Test
    void drawDefaultEnemie() throws IOException {
        viewer.draw(application, gui);
        Mockito.verify(gui, Mockito.times(1)).drawDefaultEnemies(new Position(3, 3));
        Mockito.verify(gui, Mockito.times(1)).drawDefaultEnemies(Mockito.any(Position.class));
    }

    @Test
    void drawDoubleShot() throws IOException {
        viewer.draw(application, gui);
        Mockito.verify(gui, Mockito.times(1)).drawDoubleShots(new Position(6, 6));
        Mockito.verify(gui, Mockito.times(1)).drawDoubleShots(Mockito.any(Position.class));
    }

    @Test
    void drawDefaultShot() throws IOException {
        viewer.draw(application, gui);
        Mockito.verify(gui, Mockito.times(1)).drawDefaultShots(new Position(4, 4));
        Mockito.verify(gui, Mockito.times(1)).drawDefaultShots(Mockito.any(Position.class));
    }

    @Test
    void drawLimit() throws IOException {
        viewer.draw(application, gui);
        Mockito.verify(gui, Mockito.times(1)).drawLimits(new Position(1, 1));
        Mockito.verify(gui, Mockito.times(1)).drawLimits(Mockito.any(Position.class));
    }

    @Test
    void drawMeteor() throws IOException {
        viewer.draw(application, gui);
        Mockito.verify(gui, Mockito.times(1)).drawMeteor(new Position(2, 2));
        Mockito.verify(gui, Mockito.times(1)).drawMeteor(Mockito.any(Position.class));
    }

    @Test
    void drawEnemyShot() throws IOException {
        viewer.draw(application, gui);
        Mockito.verify(gui, Mockito.times(1)).drawEnemyShots(new Position(7, 7));
        Mockito.verify(gui, Mockito.times(1)).drawEnemyShots(Mockito.any(Position.class));
    }

    @Test
    void drawPower() throws IOException {
        viewer.draw(application, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPower(new Position(8, 8));
        Mockito.verify(gui, Mockito.times(1)).drawPower(Mockito.any(Position.class));
    }

    @Test
    void drawSpecialEnemy() throws IOException {
        viewer.draw(application, gui);
        Mockito.verify(gui, Mockito.times(1)).drawSpecialEnemies(new Position(9, 9));
        Mockito.verify(gui, Mockito.times(1)).drawSpecialEnemies(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(application, gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
