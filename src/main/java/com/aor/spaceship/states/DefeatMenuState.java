package com.aor.spaceship.states;

import com.aor.spaceship.controller.Controller;
import com.aor.spaceship.controller.menu.DefeatMenuController;
import com.aor.spaceship.model.menu.DefeatMenu;
import com.aor.spaceship.viewer.Viewer;
import com.aor.spaceship.viewer.menu.DefeatMenuViewer;

public class DefeatMenuState extends State<DefeatMenu> {
    public DefeatMenuState (DefeatMenu model) { super(model); }

    @Override
    protected Viewer<DefeatMenu> getViewer() { return new DefeatMenuViewer(getModel()); }

    @Override
    protected Controller<DefeatMenu> getController() { return new DefeatMenuController(getModel()); }
}
