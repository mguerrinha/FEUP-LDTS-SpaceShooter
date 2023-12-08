package com.aor.spaceship;

import com.aor.spaceship.gui.Interface;
import com.aor.spaceship.model.menu.DefeatMenu;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.states.DefeatMenuState;
import com.aor.spaceship.states.MenuState;
import com.aor.spaceship.states.State;

import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;

public class Application {

    private Interface gui;
    private State state;
    private int highestScore;
    private int credits;
    private static final String SCORE_FILE = "highest_score.txt";


    public Application() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new Interface(30, 30);
        this.state = new DefeatMenuState(new DefeatMenu());
        this.highestScore = loadHighestScore();
        this.credits = 0;
    }
    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Application().start();
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
        saveHighestScore(highestScore);

    }
    public int getHishestScore() { return highestScore; }

    public int getCredits() { return credits; }

    public void addCredit() { this.credits++; }

    public void useCredit() { this.credits--; }

    public boolean hasCredits() {
        return credits == 0;
    }

    public void setState(State state) { this.state = state; }

    private int loadHighestScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SCORE_FILE))) {
            String line = reader.readLine();
            return Integer.parseInt(line);
        } catch (IOException | NumberFormatException e) {
            return 0;
        }
    }

    private void saveHighestScore(int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORE_FILE))) {
            writer.write(Integer.toString(score));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
