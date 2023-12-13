package com.aor.spaceship.controller.game;

import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.SpecialEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class SpecialEnemyControllerTest {

    private SpecialEnemyController specialEnemyController;
    private Arena mockArena;

    @BeforeEach
    void setUp() {
        mockArena = mock(Arena.class);
        specialEnemyController = new SpecialEnemyController(mockArena);
    }

    @Test
    void step_ShouldMoveSpecialEnemiesWithinLimits() throws IOException {
        // Arrange
        List<SpecialEnemy> specialEnemies = new ArrayList<>();
        SpecialEnemy specialEnemy = new SpecialEnemy(10, 20, 100);
        specialEnemy.setPosition(new Position(5, 5));
        specialEnemies.add(specialEnemy);

        when(mockArena.getSpecialEnemies()).thenReturn(specialEnemies);
        when(mockArena.isLimit(any())).thenReturn(false);
        when(mockArena.hasCollided(any())).thenReturn(false);
        when(mockArena.isEnemy(any())).thenReturn(false);
        GUI.Action action = GUI.Action.NONE;
        long time = 500;


        specialEnemyController.step(null, action, time);


        verify(mockArena, times(1)).getSpecialEnemies();
        verify(mockArena, times(1)).isLimit(any());
        verify(mockArena, times(1)).hasCollided(any());
        verify(mockArena, times(1)).isEnemy(any());
    }
}
