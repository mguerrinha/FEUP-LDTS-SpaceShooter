package com.aor.spaceship.states;

import com.aor.spaceship.controller.Controller;
import com.aor.spaceship.controller.menu.MenuController;
import com.aor.spaceship.model.menu.Menu;
import com.aor.spaceship.viewer.Viewer;
import com.aor.spaceship.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() { return new MenuViewer(getModel()); }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}