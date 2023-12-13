package com.aor.spaceship.controller;

import com.aor.spaceship.controller.game.MeteorController;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.Meteor;
import com.aor.spaceship.model.game.elements.Spaceship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeteorControllerTest {
    private Arena arena;
    private Meteor meteor;
    private List<Meteor> meteors;
    private Spaceship spaceship;
    private MeteorController meteorController;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        meteor = new Meteor(10, 10);
        spaceship = new Spaceship(15, 15);
        meteors.add(meteor);
        arena.setSpaceship(spaceship);
        arena.setMeteors(meteors);
        meteorController = new MeteorController(arena);
    }

    @Test
    void moveMeteor() {
        meteorController.moveMeteor(meteor, meteor.getPosition(), 1);
        assertEquals(new Position(10, 11), meteor.getPosition());
    }
}
