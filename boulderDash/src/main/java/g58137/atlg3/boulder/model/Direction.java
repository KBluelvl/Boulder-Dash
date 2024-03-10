package g58137.atlg3.boulder.model;

/**
 * Represents all direction.
 * @author Florian Essomba
 */
public enum Direction {
    UP('z'),DOWN('s'),LEFT('q'),RIGHT('d');
    private final char dir;

    /**
     * Constructs a new direction.
     * @param dir a given character.
     */
    Direction(char dir){
        this.dir = dir;
    }

    /**
     * Return the direction.
     * @return the direction.
     */
    public char getDir() {
        return dir;
    }
}
