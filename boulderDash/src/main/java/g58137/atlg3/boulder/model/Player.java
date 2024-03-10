package g58137.atlg3.boulder.model;

import g58137.atlg3.boulder.model.element.Element;

/**
 * Represents a player.
 * @author Florian Essomba
 */
public class Player extends Element {
    private boolean life;
    private Direction direction;
    /**
     * Constructs a new Player which initializes the position attribute.
     * @param position a given position.
     */
    public Player(Position position){
        super(position);
        life = true;
        direction = Direction.LEFT;
    }

    /**
     * Move the player up.
     */
    void moveUp(){
        position.incY();
    }

    /**
     * Move the player down.
     */
    void moveDown(){
        position.decY();
    }

    /**
     * Move the player left.
     */
    void moveLeft(){
        position.decX();
    }

    /**
     * Move the player right.
     */
    void moveRight(){
        position.incX();
    }

    /**
     * Return the x position of the player.
     * @return the x position of the player.
     */
    public int getX(){
        return position.getX();
    }

    /**
     * Return the y position of the player.
     * @return the y position of the player.
     */
    public int getY(){
        return position.getY();
    }

    /**
     * Sets the life attribute with a given boolean.
     * @param life a given boolean.
     */
    public void setLife(boolean life) {
        this.life = life;
    }

    /**
     * Return the life attribute.
     * @return the life attribute.
     */
    public boolean isAlive() {
        return life;
    }

    /**
     * Return the direction.
     * @return the direction.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Sets the direction with a given Direction.
     * @param direction a given Direction.
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
