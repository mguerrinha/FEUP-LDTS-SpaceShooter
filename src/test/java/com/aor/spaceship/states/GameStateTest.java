package com.aor.spaceship.states;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.arena.ArenaBuilder;
import com.aor.spaceship.model.menu.DefeatMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStateTest {
    GameState gameState;
    GUI gui;
    Application application;

    @BeforeEach
    void setUp() {
        application = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
        gameState = Mockito.mock(GameState.class);
    }

    @Test
    void startGame() {
        gameState = new GameState(new ArenaBuilder(30, 30).createArena());
        application.setState(gameState);
        assertEquals(null, application.getState());
    }

    @Test
    void loseGame() {
        DefeatMenuState defeatMenuState = new DefeatMenuState(new DefeatMenu());
        application.setState(defeatMenuState);
        assertEquals(null, application.getState());
    }

    @Test
    void endGame() {
        application.setState(null);
        assertEquals(null, application.getState());
    }
}
