package com.aor.spaceship.model.game.arena;

import com.aor.spaceship.model.Position;
import com.aor.spaceship.model.game.elements.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Arena {
    private int width;
    private int height;
    private Spaceship spaceship;
    private List<EnemyShot> enemyShots;
    private List<DefaultShot> defaultShots;
    private List<Meteor> meteors;
    private List<Power> powers;
    private List<Limit> limits;
    private List<DefaultEnemy> defaultEnemies;
    private List<SpecialEnemy> specialEnemies;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public Spaceship getSpaceship() { return spaceship; }

    public List<EnemyShot> getEnemyShots() { return enemyShots; }
    public List<DefaultShot> getdefaultShots() { return defaultShots; }
    public List<Meteor> getMeteors() {return meteors; }

    public List<Power> getPowers() {return powers; }
    public List<Limit> getLimits() { return limits; }

    public List<DefaultEnemy> getDefaultEnemies() { return defaultEnemies; }
    public List<SpecialEnemy> getSpecialEnemies() { return specialEnemies; }

    public ExecutorService getExecutorService() {return executorService; }

    public void setSpaceship(Spaceship spaceship) { this.spaceship = spaceship; }

    public void setEnemyShots(List<EnemyShot> enemyShots) { this.enemyShots = enemyShots; }
    public void setDefaultShots(List<DefaultShot> defaultShots) { this.defaultShots = defaultShots; }

    public void setMeteors(List<Meteor> meteors) { this.meteors = meteors; }

    public void setPowers(List<Power> powers) { this.powers = powers; }
    public void setLimits(List<Limit> limits) { this.limits = limits; }

    public void setDefaultEnemies(List<DefaultEnemy> defaultEnemies) { this.defaultEnemies = defaultEnemies; }

    public void setSpecialEnemies(List<SpecialEnemy> specialEnemies) { this.specialEnemies = specialEnemies; }

    public boolean hasCollided(Position position) {
        for (Meteor meteor : meteors) {
            if (meteor.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isLimit(Position position) {
        for (Limit limit : limits) {
            if (limit.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEnemy(Position position) {
        for (SpecialEnemy specialEnemy : specialEnemies) {
            if (specialEnemy.getPosition().equals(position)) {
                return true;
            }
        }
        for (DefaultEnemy defaultEnemy : defaultEnemies) {
            if (defaultEnemy.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPower(Position position) {
        for (Power power : powers) {
            if (power.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public void GetRandomPower() {
        Random random = new Random();
        int randomPower = random.ints(1, 2).findFirst().getAsInt();
        switch (randomPower) {
            case 1:
                this.spaceship.increaseEnergy();
                break;
            default:
        }
    }
    public void removePower(Position position) {
        for (int i = 0; i < powers.size(); i++) {
            if (powers.get(i).getPosition().equals(position)) {
                powers.remove(i);
                spaceship.addScore(50);
                GetRandomPower();
            }
        }
    }

    public void removeSpecialEnemy(Position position) {
        for (int i = 0; i < specialEnemies.size(); i++) {
            if (specialEnemies.get(i).getPosition().equals(position)) {
                specialEnemies.get(i).reduceHealth();
                if (specialEnemies.get(i).getHealth() == 0) {
                    specialEnemies.remove(i);
                    powers.add(new Power(position.getX(), position.getY()));
                    spaceship.addScore(250);
                }
            }
        }
    }

    public void removeDefaultEnemy(Position position) {
        for (int i = 0; i < defaultEnemies.size(); i++) {
            if (defaultEnemies.get(i).getPosition().equals(position)) {
                defaultEnemies.get(i).reduceHealth();
                if (defaultEnemies.get(i).getHealth() == 0) {
                    defaultEnemies.remove(i);
                    spaceship.addScore(150);
                }
            }
        }
        if (getDefaultEnemies().isEmpty()) {
            scheduleEnemySpawnWithDelay();
        }
    }

    private void scheduleEnemySpawnWithDelay() {
        Random random = new Random();
        executorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getDefaultEnemies().add(new DefaultEnemy(random.ints(9, width - 1).findFirst().getAsInt(), random.ints(3, height/2 - 4).findFirst().getAsInt(), 3));
        });

    }
}
