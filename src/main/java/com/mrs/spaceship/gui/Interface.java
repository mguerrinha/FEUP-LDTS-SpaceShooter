package com.mrs.spaceship.gui;

import com.mrs.spaceship.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Interface implements GUI {
    private Screen screen;
    public Interface(Screen screen) { this.screen = screen; }
    public Interface(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/KongtextFinalVersion.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 30);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public Action getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return Action.NONE;
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'q' || keyStroke.getCharacter() == 'Q')) return Action.QUIT;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return Action.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return Action.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return Action.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return Action.LEFT;
        if (keyStroke.getKeyType() == KeyType.Enter) return Action.SELECT;
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'c' || keyStroke.getCharacter() == 'C')) return Action.COIN;
        return Action.NONE;
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }
    @Override
    public void drawSpaceship(Position position) {
        drawCharacter(position.getX(), position.getY(), '\u00BB', "#FFFFFF");
    }

    @Override
    public void drawEnemyShots(Position position) { drawCharacter(position.getX(), position.getY(), '.', "#FFA500"); }

    @Override
    public void drawDefaultShots(Position position) { drawCharacter(position.getX(), position.getY(), '.' , "#FFFFFF"); }

    @Override
    public void drawDoubleShots(Position position) { drawCharacter(position.getX(), position.getY(), '"', "#FFFFFF"); }

    @Override
    public void drawBurstShots(Position position) { drawCharacter(position.getX(), position.getY(), '|', "#FFFFFF"); }

    @Override
    public void drawTripleShots(Position position) { drawCharacter(position.getX(), position.getY(), '.', "#FFFFFF"); }

    @Override
    public void drawMeteor(Position position) { drawCharacter(position.getX(), position.getY(), '\u00D3', "#FF0000"); }


    @Override
    public void drawPower(Position position) { drawCharacter(position.getX(), position.getY(), '\u00D9', "#FFFF00"); }

    @Override
    public void drawLimits(Position position) { drawCharacter(position.getX(), position.getY(), '#', "#FFFFFF"); }
    @Override
    public void drawDefaultEnemies(Position position) { drawCharacter(position.getX(), position.getY(), '\u00DA', "#FFC300"); }
    @Override
    public void drawSpecialEnemies(Position position) { drawCharacter(position.getX(), position.getY(), '\u00DB', "#FF0FF0"); }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void clear() { screen.clear(); }

    @Override
    public void close() throws IOException { screen.close(); }

    @Override
    public void refresh() throws IOException { screen.refresh(); }
}
