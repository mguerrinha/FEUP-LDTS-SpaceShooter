package com.aor.spaceship.states;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsMenuStateTest {
    InstructionsMenuState instructionsMenuState;
    GUI gui;
    Application application;

    @BeforeEach
    void setUp() {
        application = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
        instructionsMenuState = Mockito.mock(InstructionsMenuState.class);
    }

    @Test
    void selectExit() {
        application.setState(new MenuState(new Menu()));
        assertEquals(null, application.getState());
    }
}
