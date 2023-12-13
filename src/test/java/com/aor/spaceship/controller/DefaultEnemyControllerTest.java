package com.aor.spaceship.controller;

import com.aor.spaceship.controller.game.ArenaController;
import com.aor.spaceship.controller.game.DefaultEnemyController;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.DefaultEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultEnemyControllerTest {
    private DefaultEnemy defaultEnemie;
    private DefaultEnemyController defaultEnemyController;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        defaultEnemie = new DefaultEnemy(10, 10, 2);
        defaultEnemyController = new DefaultEnemyController(arena);
    }

    @Test
    void moveDefaultEnemy() {
        defaultEnemyController.moveDefaultEnemy(defaultEnemie, new Position(10, 11));
        assertEquals(new Position(10, 11), defaultEnemie.getPosition());
    }
}
