package com.aor.spaceship.gui;

import com.aor.spaceship.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;

public class InterfaceTest {
    private Screen screen;
    private Interface gui;
    private TextGraphics graphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);
        gui = new Interface(screen);
    }

    @Test
    void drawSpaceShip() {
        gui.drawSpaceship(new Position(1, 1));

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "»");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Space Shooter", "#000000");

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, "Space Shooter");
    }
}
