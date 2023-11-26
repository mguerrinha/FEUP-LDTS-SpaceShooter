package com.aor.spaceship.viewer.game;

import com.aor.spaceship.Element;
import com.aor.spaceship.gui.GUI;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
