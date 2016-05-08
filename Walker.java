import java.awt.*;
/**
 * This class is a subclass of Piece class
 * @author Akarachai Passavoranan
 *
 */
public class Walker extends Piece {
	/**
	 * Constructor
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param c color of this walker(int)
	 * @param m map of which this object will be
	 */
	public Walker(int x, int y, int c, Map m) {
		super(Piece.WALKER, m);
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
	 * @param c color of this walker
	 * @param m map of which the object will be
	 */
	public Walker(int x, int y, Color c, Map m) {
		super(Piece.WALKER, m);
		this.setX(x);
		this.setY(y);
		this.setColor(c);
	}
	/**
	 * Behavior of Walker
	 * 2/3 of time, it does nothing
	 * 1/3 of time, it move in a random direction(up, down, left, right)
	 */
	public void act() {
		int randomLength = rand(1, 12);
		if (!hasActed() && randomLength < 5) {
			if (randomLength == 1) {
				if (getMap().isEmpty(getX() - 1, getY())) {
					getMap().move(getX(), getY(), getX() - 1, getY());
				}
			} else if (randomLength == 2) {
				if (getMap().isEmpty(getX() + 1, getY())) {
					getMap().move(getX(), getY(), getX() + 1, getY());
				}

			} else if (randomLength == 3) {
				if (getMap().isEmpty(getX(), getY() + 1)) {
					getMap().move(getX(), getY(), getX(), getY() + 1);
				}
			} else {
				if (getMap().isEmpty(getX(), getY() - 1)) {
					getMap().move(getX(), getY(), getX(), getY() - 1);
				}
			}
		}
		this.setActed(true);
	}
	/**
	 * @return String String of its coordinate and color
	 */
	public String toString() {
		return getColorWord() + " Walker at (" + getX() + ", " + getY() + ")";
	}
}
