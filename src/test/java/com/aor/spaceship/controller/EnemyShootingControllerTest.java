package com.aor.spaceship.controller;
import com.aor.spaceship.controller.game.EnemyShootingController;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.DefaultEnemy;
import com.aor.spaceship.model.game.elements.EnemyShot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnemyShootingControllerTest {

    private EnemyShootingController enemyShootingController;
    private Arena mockedArena;
    private List<DefaultEnemy> defaultEnemies;

    @BeforeEach
    public void setup() {
        mockedArena = mock(Arena.class);
        defaultEnemies = new ArrayList<>();
        enemyShootingController = new EnemyShootingController(mockedArena, defaultEnemies);
    }

    @Test
    public void testDefaultEnemyShot() {

        DefaultEnemy enemy1 = mock(DefaultEnemy.class);
        DefaultEnemy enemy2 = mock(DefaultEnemy.class);
        when(enemy1.getPosition()).thenReturn(new Position(5, 5));
        when(enemy2.getPosition()).thenReturn(new Position(10, 10));

        defaultEnemies.add(enemy1);
        defaultEnemies.add(enemy2);

        enemyShootingController.DefaultEnemyShot();

        assertEquals(2, mockedArena.getEnemyShots().size());
    }

    @Test
    public void testMoveEnemyShot() {

        EnemyShot enemyShot = mock(EnemyShot.class);
        when(enemyShot.getPosition()).thenReturn(new Position(3, 3));
        List<EnemyShot> enemyShots = new ArrayList<>();
        enemyShots.add(enemyShot);

        when(mockedArena.getEnemyShots()).thenReturn(enemyShots);
        when(mockedArena.getHeight()).thenReturn(20);


        when(mockedArena.getSpaceship().getPosition()).thenReturn(new Position(3, 4));

        enemyShootingController.moveEnemyShot();


        assertTrue(mockedArena.getEnemyShots().isEmpty());
    }
}
