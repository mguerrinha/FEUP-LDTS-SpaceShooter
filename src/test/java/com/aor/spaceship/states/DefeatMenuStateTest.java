package com.aor.spaceship.states;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.arena.ArenaBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefeatMenuStateTest {
    DefeatMenuState defeatMenuState;
    GUI gui;
    Application application;

    @BeforeEach
    void setUp() {
        application = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
        defeatMenuState = Mockito.mock(DefeatMenuState.class);
    }

    @Test
    public void selectRematch() {
        GameState gameState = new GameState(new ArenaBuilder(30, 30).createArena());
        application.setState(gameState);
        assertEquals(null, application.getState());
    }

    @Test
    public void selectExit() {
        application.setState(null);
        assertEquals(null, application.getState());
    }
}
