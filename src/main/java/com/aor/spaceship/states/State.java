package com.aor.spaceship.states;

import com.aor.spaceship.Application;
import com.aor.spaceship.controller.Controller;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;
    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() { return model; }

    public void step(Application application, GUI gui, long time) throws IOException {
        GUI.Action action = gui.getNextAction();
        controller.step(application, action, time);
        viewer.draw(gui);
    }
}
