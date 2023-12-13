package com.aor.spaceship.controller;

import com.aor.spaceship.Application;
import com.aor.spaceship.controller.menu.InitialController;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.menu.Initial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitialControllerTest {
    private Initial initial;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        initial = new Initial();
    }

    @Test
    void addCredits() throws IOException {
        assertEquals(0, initial.getCredits());
    }
}
