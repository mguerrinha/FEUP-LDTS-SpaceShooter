package com.aor.spaceship;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.aor.spaceship.model.Position;

public class Meteor extends Element {
    public Meteor(int x, int y) { super(x, y); }

    public Position move(){ return position.moveDown(); }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.putString(new TerminalPosition(position.getX(),position.getY()), "◈");
    }

}
