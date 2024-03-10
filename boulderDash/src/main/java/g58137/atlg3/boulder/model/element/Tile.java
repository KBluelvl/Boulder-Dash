package g58137.atlg3.boulder.model.element;

import g58137.atlg3.boulder.model.Position;

/**
 * Represents a tile.
 * @author Florian essomba
 */
public abstract class Tile extends Element{

    /**
     * Constructs a new Tile which initializes the position attribute.
     * @param position the position of the Tile.
     */
    public Tile(Position position){
        super(position);
    }
}
