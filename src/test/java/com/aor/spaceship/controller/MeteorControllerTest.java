package com.aor.spaceship.controller;

import com.aor.spaceship.Application;
import com.aor.spaceship.controller.game.MeteorController;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.model.game.elements.Meteor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MeteorControllerTest {

        private Application application;
        private GUI.Action action;
        private long time;
        private Arena arena;
        private MeteorController meteorController;

        @BeforeEach
        void setUp() {
            application = new Application();
            action = GUI.Action.SPACE;
            time = System.currentTimeMillis();
            arena = new Arena(10, 10);
            meteorController = new MeteorController(arena);
        }

        @Test
        void step() throws IOException {
            Position position = new Position(1, 2);
            Meteor meteor = new Meteor(position);
            List<Meteor> meteors = new ArrayList<>();
            meteors.add(meteor);
            arena.setMeteors(meteors);

            meteorController.step(application, action, time);

            assertNotEquals(position, meteor.getPosition());
        }
    }
}
