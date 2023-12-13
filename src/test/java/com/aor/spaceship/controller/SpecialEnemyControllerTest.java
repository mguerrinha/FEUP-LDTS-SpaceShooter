package com.aor.spaceship.controller;

import com.aor.spaceship.controller.game.SpecialEnemyController;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.SpecialEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialEnemyControllerTest {
    private SpecialEnemy specialEnemy;
    private SpecialEnemyController specialEnemyController;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        specialEnemy = new SpecialEnemy(10, 10, 5);
        specialEnemyController = new SpecialEnemyController(arena);
    }

    @Test
    void moveSpecialEnemy() {
        specialEnemyController.moveSpecialEnemy(specialEnemy, new Position(10, 11));
        assertEquals(new Position(10, 11), specialEnemy.getPosition());
    }
}
