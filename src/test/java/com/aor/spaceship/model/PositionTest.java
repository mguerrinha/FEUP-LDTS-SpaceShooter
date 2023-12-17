package com.aor.spaceship.model;

import com.aor.spaceship.model.game.elements.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PositionTest {
    private Position position;
    @BeforeEach
    void setUp() {
        position = new Position(10, 10);
    }

    @Test
    void getRight() {
        assertEquals(new Position(11, 10), position.moveRight());
    }
    @Test
    void getLeft() {
        assertEquals(new Position(9, 10), position.moveLeft());
    }
    @Test
    void getDown() {
        assertEquals(new Position(10, 11), position.moveDown());
    }
    @Test
    void getUp() {
        assertEquals(new Position(10, 9), position.moveUp());
    }

    @Test
    void testEquals() {
        Position pos_2 = new Position(10, 10);
        Position pos_3 = new Position(11, 11);
        assertTrue(position.equals(pos_2));
        assertFalse(position.equals(pos_3));
    }

    @Test
    void testElement() {
        Element element = new Element(11, 11);
        element.setPosition(position);
        assertEquals(10, element.getPosition().getX());
        assertEquals(10, element.getPosition().getY());
    }
}
