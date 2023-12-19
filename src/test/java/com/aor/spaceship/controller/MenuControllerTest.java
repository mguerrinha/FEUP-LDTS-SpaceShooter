package com.aor.spaceship.controller;

import com.aor.spaceship.Application;
import com.aor.spaceship.controller.menu.MenuController;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuControllerTest {
    Application application;
    MenuController menuController;
    Menu menu;


    @BeforeEach
    void setUp() {
        menu = Mockito.mock(Menu.class);
        application = Mockito.mock(Application.class);
        menuController = new MenuController(menu);
    }

    @Test
    public void stepUp() throws IOException {
        menuController.step(application, GUI.Action.UP, 1000);
        Mockito.verify()
    }
}
