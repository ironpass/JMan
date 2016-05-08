import java.awt.*;
/**
 * This class is a subclass of Piece class
 * @author Akarachai Passavoranan
 *
 */
public class Pillar extends Piece {
	/**
	 * Constructor
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param c color of this pillar(int)
	 * @param m map of which this object will be
	 */
	public Pillar(int x, int y, int c, Map m) {
		super(Piece.PILLAR, m);
		this.setX(x);
		this.setY(y);
		if (c == 0) {
			this.setColor(Color.RED);
		} else if (c == 1) {
			this.setColor(Color.GREEN);
		} else {
			this.setColor(Color.YELLOW);
		}
	}
	/**
	 * Constructor
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param c color of this pillar
	 * @param m map of which this object will be
	 */
	public Pillar(int x, int y, Color c, Map m) {
		super(Piece.PILLAR, m);
		this.setX(x);
		this.setY(y);
		this.setColor(c);
	}
	/**
	 * Behavior of Pillar
	 * 2/3 of time, it does nothing
	 * 1/3 of time, it change its color randomly(between RED, GREEN, and YELLOW)
	 */
	public void act() {
		int randomLength = rand(1,9);
		if (!this.hasActed() && randomLength < 4) {
			if (randomLength == 1) {
				this.setColor(Color.RED);
			} else if (randomLength == 2) {
				this.setColor(Color.GREEN);
			} else {
				this.setColor(Color.YELLOW);
			}
		}
		this.setActed(true);
		
	}
	/**
	 * @return String String of its coordinate and color
	 */
	public String toString() {
		return getColorWord() + " Pillar at (" + getX() + ", " + getY() + ")";
	}
}
