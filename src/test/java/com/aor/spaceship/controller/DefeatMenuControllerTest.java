package com.aor.spaceship.controller;

import com.aor.spaceship.Application;
import com.aor.spaceship.controller.menu.DefeatMenuController;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.menu.DefeatMenu;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class DefeatMenuControllerTest {
    DefeatMenuController defeatMenuController;
    DefeatMenu defeatMenu;
    Application application;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        application = new Application();
        defeatMenu = new DefeatMenu();
        defeatMenuController = new DefeatMenuController(defeatMenu);
    }

    @Test
    public void stepInsertCoin() {
        assertEquals(0, application.getCredits());
        defeatMenuController.step(application, GUI.Action.COIN, 1000);
        assertEquals(1, application.getCredits());
        defeatMenuController.step(application, GUI.Action.COIN, 1000);
        assertEquals(2, application.getCredits());
    }

    @Test
    public void stepUp() {
        assertEquals(0, application.getCredits());
        application.addCredit();
        assertEquals(1, application.getCredits());
        assertEquals(0, defeatMenu.getCurrentEntry());
        defeatMenuController.step(application, GUI.Action.UP, 1000);
        assertEquals(1, defeatMenu.getCurrentEntry());
        assertTrue(defeatMenu.isSelectedExit());
        defeatMenuController.step(application, GUI.Action.UP, 1000);
        assertEquals(0, defeatMenu.getCurrentEntry());
        assertTrue(defeatMenu.isSelectedStart());

    }

    @Test
    public void stepDown() {
        assertEquals(0, application.getCredits());
        application.addCredit();
        assertEquals(1, application.getCredits());
        defeatMenuController.step(application, GUI.Action.DOWN, 1000);
        assertEquals(1, defeatMenu.getCurrentEntry());
        assertTrue(defeatMenu.isSelectedExit());
        defeatMenuController.step(application, GUI.Action.DOWN, 1000);
        assertEquals(0, defeatMenu.getCurrentEntry());
        assertTrue(defeatMenu.isSelectedStart());
    }

    @Test
    public void stepSelect() {
        defeatMenuController.step(application, GUI.Action.SELECT, 1000);
        assertNull(application.getState());
        application.addCredit();
        defeatMenuController.step(application, GUI.Action.SELECT, 1000);
        assertTrue(defeatMenu.isSelectedStart());
        assertEquals(0, application.getCredits());
        application.addCredit();
        defeatMenu.nextEntry();
        defeatMenuController.step(application, GUI.Action.SELECT, 1000);
        assertTrue(defeatMenu.isSelectedExit());
        assertNull(application.getState());
    }


}