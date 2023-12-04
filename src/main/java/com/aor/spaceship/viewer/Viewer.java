package com.aor.spaceship.viewer;

import com.aor.spaceship.Application;
import com.aor.spaceship.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;
    public Viewer(T model) { this.model = model; }
    public T getModel() { return model; }
    public void draw(Application application, GUI gui) throws IOException {
        gui.clear();
        drawElements(application, gui);
        gui.refresh();
    }
    protected abstract void drawElements(Application application, GUI gui);
}
