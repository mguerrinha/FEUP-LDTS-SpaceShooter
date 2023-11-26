package com.aor.spaceship.states;

import com.aor.spaceship.controller.Controller;
import com.aor.spaceship.controller.game.ArenaController;
import com.aor.spaceship.controller.game.GameController;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.viewer.Viewer;
import com.aor.spaceship.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState (Arena arena) { super(arena); }

    @Override
    protected Viewer<Arena> getViewer() { return new GameViewer(getModel()); }

    @Override
    protected Controller<Arena> getController() { return new ArenaController(getModel()); }

}
