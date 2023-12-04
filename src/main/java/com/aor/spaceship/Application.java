package com.aor.spaceship;

import com.aor.spaceship.gui.Interface;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.states.MenuState;
import com.aor.spaceship.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private Interface gui;

    private State state;
    private int highestScore = 0;

    public Application() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new Interface(30, 30);
        this.state = new MenuState(new Menu());
    }
    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Application().start();
    }

    public void setHighestScore(int highestScore) { this.highestScore = highestScore; }
    public int getHishestScore() { return highestScore; }
    public void setState(State state) { this.state = state; }

    public void start() throws IOException {
        int FPS = 10;
        int frameTime = 100 / FPS;
        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        gui.close();
    }

}
