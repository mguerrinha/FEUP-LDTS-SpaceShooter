package com.aor.spaceship.controller.game;

import com.aor.spaceship.Application;
import com.aor.spaceship.controller.Controller;
import com.aor.spaceship.gui.GUI;
import com.aor.spaceship.model.game.arena.Arena;
import com.aor.spaceship.states.GameState;

import java.io.IOException;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) { super(arena); }

}
