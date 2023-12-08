package com.aor.spaceship.states;

import com.aor.spaceship.controller.Controller;
import com.aor.spaceship.controller.menu.InitialController;
import com.aor.spaceship.model.menu.Initial;
import com.aor.spaceship.viewer.Viewer;
import com.aor.spaceship.viewer.menu.InitialViewer;

public class InitialState extends State<Initial> {
    public InitialState(Initial model) { super(model); }
    @Override
    protected Viewer<Initial> getViewer() {
        return new InitialViewer(getModel());
    }

    @Override
    protected Controller<Initial> getController() {
        return new InitialController(getModel());
    }
}
