package com.aor.spaceship.controller;

import com.aor.spaceship.model.menu.DefeatMenu;
import com.aor.spaceship.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefeatMenuControllerTest {
    private DefeatMenu defeatMenu;
    @BeforeEach
    void setUp() {
        defeatMenu = new DefeatMenu();
    }

    @Test
    void createMenu() {
        assertEquals("Rematch", defeatMenu.getEntry(0));
        assertEquals("Exit", defeatMenu.getEntry(1));
    }
    @Test
    void moveMenu() {
        assertEquals(2, defeatMenu.getNumberEntries());
        assertEquals(0, defeatMenu.getCurrentEntry());
        defeatMenu.nextEntry();
        assertEquals(1, defeatMenu.getCurrentEntry());
        assertEquals(true, defeatMenu.isSelectedExit());
        defeatMenu.previousEntry();
        assertEquals(0, defeatMenu.getCurrentEntry());
        assertEquals(true, defeatMenu.isSelectedStart());
        defeatMenu.previousEntry();
        assertEquals(1, defeatMenu.getCurrentEntry());
        assertEquals(true, defeatMenu.isSelectedExit());
    }
}
