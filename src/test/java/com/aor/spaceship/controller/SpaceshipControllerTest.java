package com.aor.spaceship.controller;

import com.aor.spaceship.controller.game.ArenaController;
import com.aor.spaceship.controller.game.SpaceshipController;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.Spaceship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpaceshipControllerTest {
    private SpaceshipController spaceshipController;
    private Spaceship spaceship;
    private Arena arena;
    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        spaceship = new Spaceship(10, 10);
        arena.setSpaceship(spaceship);
        spaceshipController = new SpaceshipController(arena);
    }

    @Test
    void moveSpaceshipDown() {
        spaceshipController.moveSpaceshipDown();
        assertEquals(new Position(10, 11), spaceship.getPosition());
    }
    @Test
    void moveSpaceshipLeft() {
        spaceshipController.moveSpaceshipLeft();
        assertEquals(new Position(9, 10), spaceship.getPosition());
    }
    @Test
    void moveSpaceshipRight() {
        spaceshipController.moveSpaceshipRight();
        assertEquals(new Position(11, 10), spaceship.getPosition());
    }
    @Test
    void moveSpaceshipUp() {
        spaceshipController.moveSpaceshipUp();
        assertEquals(new Position(10, 9), spaceship.getPosition());
    }
}
