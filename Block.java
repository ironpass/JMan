import java.awt.*;
/**
 * This class is a subclass of Piece class
 * The default color is white
 * @author Akarachai Passavoranan
 *
 */
public class Block extends Piece{
	/**
	 * Constructor
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param m map of which this object will be
	 */
	public Block(int x, int y, Map m) {
		super(Piece.BLOCK, m);
		this.setX(x);
		this.setY(y);
		this.setColor(Color.WHITE);
	}
/**
 * A Block object should act nothing.
 */
	public void act() {
		this.setActed(true);
	}
/**
 * @return String String of its coordinate and color(which is always white anyway)
 */
	public String toString() {
		return getColorWord() + " Block at (" + getX() + ", " + getY() + ")";
	}
}
