import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import java.io.IOException;

public class Game {

    private Screen screen = new TerminalScreen(new DefaultTerminalFactory().createTerminal());
    private Arena arena;
    private TextGraphics graphics = screen.newTextGraphics();
    public Game() throws IOException {
        arena = new Arena(80,24);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
        screen.doResizeIfNecessary();
    }

    public void run() throws IOException {
        while(arena.getRunning()) {
            draw();
            KeyStroke key = screen.readInput();
            arena.processKey(key);
        }
        screen.close();
    }
}
