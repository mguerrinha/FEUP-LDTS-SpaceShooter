package com.aor.spaceship.controller;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model) { this.model = model; }
    public T getModel() { return model; }
    public abstract void step(Application application, GUI.Action action, long time) throws IOException;
}
