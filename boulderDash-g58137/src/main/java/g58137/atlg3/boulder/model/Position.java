package g58137.atlg3.boulder.model;

import java.util.Objects;

/**
 * Represents a position.
 * @author Florian Essomba
 */
public class Position {
    private int x;
    private int y;

    /**
     * Constructs a new Position which initializes the x and y attributes.
     * @param x a given number
     * @param y a given number
     */
    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Increments the x attribute
     */
    void incX(){
        x++;
    }
    /**
     * Increments the y attribute
     */
    void incY(){
        y++;
    }
    /**
     * Decrements the x attribute
     */
    void decX(){
        x--;
    }
    /**
     * Decrements the y attribute
     */
    void  decY(){
        y--;
    }

    /**
     * Return the x attribute.
     * @return the x attribute.
     */
    int getX() {
        return x;
    }

    /**
     * Sets the x attribute with a given number.
     * @param x a given number.
     */
    void setX(int x) {
        this.x = x;
    }

    /**
     * Return the y attribute.
     * @return the y attribute.
     */
    int getY() {
        return y;
    }

    /**
     * Sets the y attribute with a given number.
     * @param y a given number.
     */
    void setY(int y) {
        this.y = y;
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param o the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    /**
     * Returns a hash code value for the object.
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
