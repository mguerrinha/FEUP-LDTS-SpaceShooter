import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class SpaceShip extends Element {
    public SpaceShip(int x, int y) {super(x, y); }

    public Position moveUp(){
        return position.moveUp();
    }

    public Position moveDown(){
        return position.moveDown();
    }

    public Position moveRight() {
        return position.moveRight();
    }

    public Position moveLeft(){ return position.moveLeft(); }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "┃");
    }
}
