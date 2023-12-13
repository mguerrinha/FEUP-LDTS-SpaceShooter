package com.aor.spaceship.controller;

import com.aor.spaceship.controller.game.DefaultEnemyController;
import com.aor.spaceship.controller.game.EnemyShootingController;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.DefaultEnemy;
import com.aor.spaceship.model.game.elements.EnemyShot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyShootingControllerTest {
    private Arena arena;
    private EnemyShot enemyShot;
    private EnemyShootingController enemyShootingController;
    private DefaultEnemy defaultEnemy;
    private List<DefaultEnemy> defaultEnemies;
    private List<EnemyShot> enemyShots;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        defaultEnemy = new DefaultEnemy(10, 10, 2);
        defaultEnemies.add(defaultEnemy);
        enemyShootingController = new EnemyShootingController(arena, defaultEnemies);
    }

    @Test
    void addEnemyShot() {
        enemyShootingController.DefaultEnemyShot();
        assertEquals(1, defaultEnemies.size());
    }
}
