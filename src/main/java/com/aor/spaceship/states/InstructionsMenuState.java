package com.aor.spaceship.states;

import com.aor.spaceship.controller.Controller;
import com.aor.spaceship.controller.menu.InstructionsMenuController;
import com.aor.spaceship.model.menu.InstructionsMenu;
import com.aor.spaceship.viewer.Viewer;
import com.aor.spaceship.viewer.menu.InstructionsMenuViewer;

public class InstructionsMenuState extends State<InstructionsMenu> {
    public InstructionsMenuState(InstructionsMenu model) {
        super(model);
    }

    @Override
    protected Viewer<InstructionsMenu> getViewer() {
        return new InstructionsMenuViewer(getModel());
    }

    @Override
    protected Controller<InstructionsMenu> getController() {
        return new InstructionsMenuController(getModel());
    }
}
