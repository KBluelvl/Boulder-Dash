package g58137.atlg3.boulder.model.element;

import g58137.atlg3.boulder.model.Position;
import java.util.Objects;

/**
 * Represents an element.
 * @author Florian Essomba
 */
public class Element {
    protected Position position;

    /**
     * Constructs a new Element which initializes the position attribute.
     * @param position the position of the Element.
     */
    public Element(Position position){
        this.position = position;
    }
    /**
     * Return the position attribute.
     * @return the position attribute.
     */
    public Position getPosition() {
        return position;
    }
    /**
     * Sets the position attribute with a given Position.
     * @param position a given Position.
     */
    public void setPosition(Position position) {
        this.position = position;
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
        Element element = (Element) o;
        return Objects.equals(position, element.position);
    }
    /**
     * Returns a hash code value for the object.
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
