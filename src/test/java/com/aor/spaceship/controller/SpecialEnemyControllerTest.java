package com.aor.spaceship.controller.game;

        import com.aor.spaceship.model.Position;
        import com.aor.spaceship.model.game.arena.Arena;
        import com.aor.spaceship.model.game.elements.SpecialEnemy;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialEnemyControllerTest {
    private SpecialEnemyController specialEnemyController;
    private Arena arena;

    @BeforeEach
    public void setUp() {
        arena = new Arena();
        specialEnemyController = new SpecialEnemyController(arena);
    }

    @Test
    public void testMoveSpecialEnemy() {
        SpecialEnemy specialEnemy = new SpecialEnemy(new Position(0, 0));
        Position position = new Position(1, 0);

        specialEnemyController.moveSpecialEnemy(specialEnemy, position);

        assertEquals(position, specialEnemy.getPosition());
    }
}