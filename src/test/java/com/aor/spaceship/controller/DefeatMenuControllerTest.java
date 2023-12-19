package com.aor.spaceship.controller;

import com.aor.spaceship.Application;
import com.aor.spaceship.controller.menu.DefeatMenuController;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.menu.DefeatMenu;
import com.aor.spaceship.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefeatMenuControllerTest {
    DefeatMenuController defeatMenuController;
    DefeatMenu defeatMenu;
    Application application;
    @BeforeEach
    void setUp() {
        application = Mockito.mock(Application.class);
        defeatMenu = Mockito.mock(DefeatMenu.class);
        defeatMenuController = new DefeatMenuController(defeatMenu);
    }

    @Test
    void insertCoin() {
        assertEquals(0, application.getCredits());
    }
}
