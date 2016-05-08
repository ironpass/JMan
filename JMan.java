import java.awt.*;

/**
 * An instance of this class is a J*Man. There should at most one J*Man in a
 * game board at a time
 */
public class JMan extends Piece {

	/**
	 * Constructor: a new J*Man at position (x, y) on Map m with color red if c
	 * = 0, green if c = 1, and yellow if c = 2.
	 */
	public JMan(int x, int y, int c, Map m) {
		super(Piece.JMAN, m);
		// Complete this
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
	 * Constructor: a new J*Man at position (x, y) on Map m with color c.
	 * Precondition: c is one of Color.RED, Color.GREEN, and Color.YELLOW.
	 */
	public JMan(int x, int y, Color c, Map m) {
		super(Piece.JMAN, m);
		// Complete this;
		this.setX(x);
		this.setY(y);
		this.setColor(c);
	}

	/**
	 * J*Man should move based on what button is pushed. This method is not
	 * used.
	 */
	public void act() {
		return;
	}

	/**
	 * Move J*Man one step based on the value of i: 0 = up, 1 = down, 2 = left,
	 * 3 = right.
	 */
	public void step(int i) {
		setActed(true);
		// Complete this

		if (i == 0) {
			if (getMap().isInGrid(getX(), getY() - 1)) {
				Piece ent = getMap().pieceAt(getX(), getY() - 1);
				if (ent == null) {
					getMap().move(getX(), getY(), getX(), getY() - 1);

				} else if (ent.getType() != 0 && isEdible(ent)) {
					getMap().move(getX(), getY(), getX(), getY() - 1);
					setColor(ent.getColor());
				}
			}
		} else if (i == 1) {
			if (getMap().isInGrid(getX(), getY() + 1)) {
				Piece ent = getMap().pieceAt(getX(), getY() + 1);
				if (ent == null) {
					getMap().move(getX(), getY(), getX(), getY() + 1);

				} else if (ent.getType() != 0 && isEdible(ent)) {
					getMap().move(getX(), getY(), getX(), getY() + 1);
					setColor(ent.getColor());
				}
			}
		} else if (i == 2) {
			if (getMap().isInGrid(getX() - 1, getY())) {
				Piece ent = getMap().pieceAt(getX() - 1, getY());
				if (ent == null) {
					getMap().move(getX(), getY(), getX() - 1, getY());

				} else if (ent.getType() != 0 && isEdible(ent)) {
					getMap().move(getX(), getY(), getX() - 1, getY());
					setColor(ent.getColor());
				}
			}
		} else {
			if (getMap().isInGrid(getX() + 1, getY())) {
				Piece ent = getMap().pieceAt(getX() + 1, getY());
				if (ent == null) {
					getMap().move(getX(), getY(), getX() + 1, getY());

				} else if (ent.getType() != 0 && isEdible(ent)) {
					getMap().move(getX(), getY(), getX() + 1, getY());
					setColor(ent.getColor());
				}
			}
		}
	}
	/**
	 * This method is to check that J*Man can move over an entity or not.
	 * Depend on the color condition
	 * @param ent
	 * @return boolean the status of which the entity ent is edible or not
	 */
	private boolean isEdible(Piece ent) {
		if (this.getColor() == Color.RED && ent.getColor() == Color.YELLOW) {
			return true;
		}
		if (this.getColor() == Color.GREEN && ent.getColor() == Color.RED) {
			return true;
		}
		if (this.getColor() == Color.YELLOW && ent.getColor() == Color.GREEN) {
			return true;
		}
		return false;
	}

	/** = representation of this piece */
	public String toString() {
		return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
	}
}
