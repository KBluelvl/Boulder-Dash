package g58137.atlg3.boulder.model.element;

import g58137.atlg3.boulder.model.Position;

/**
 * Represents a Diamond.
 * @author Florian Essomba
 */
public class Diamond extends Tile {
    private boolean playerKiller;
    /**
     * Constructs a new Diamond which initializes the position attribute.
     * @param position the position of the Diamond.
     */
    public Diamond(Position position){
        super(position);
    }
    /**
     * Return the playerKiller attribute.
     * @return the playerKiller attribute.
     */
    public boolean isPlayerKiller() {
        return playerKiller;
    }

    /**
     * Sets the playerKiller attribute with a given boolean.
     * @param playerKiller a given boolean.
     */
    public void setPlayerKiller(boolean playerKiller) {
        this.playerKiller = playerKiller;
    }
}
