package g58137.atlg3.boulder.model;

import g58137.atlg3.boulder.model.element.Element;
import g58137.atlg3.boulder.model.element.Exit;

/**
 * Represents the information of the level.
 * @author Florian Essomba
 */
public class LevelInfo {
    private int levelNumber;
    private Element[][] elements;
    private Player player;
    private Exit exit;
    private int minDiamonds;
    private int diamondValue;
    private int bonusDiamondValue;
    private int timeMax;
    private final int numberOfLevels;

    /**
     * Constructs a new LevelInfo which initializes the attributes.
     * @param levelNumber a given number.
     * @param elements a given Element[][] array.
     * @param player a given Player.
     * @param exit a given Exit.
     * @param minDiamonds a given number.
     * @param diamondValue a given number.
     * @param bonusDiamondValue a given number.
     * @param timeMax a given number.
     */
    public LevelInfo(int levelNumber, Element[][] elements, Player player, Exit exit, int minDiamonds,
                     int diamondValue, int bonusDiamondValue, int timeMax,int numberOfLevels){
        this.numberOfLevels = numberOfLevels;
        this.levelNumber = levelNumber;
        this.elements = elements;
        this.player = player;
        this.exit = exit;
        this.minDiamonds = minDiamonds;
        this.diamondValue = diamondValue;
        this.bonusDiamondValue = bonusDiamondValue;
        this.timeMax = timeMax;
    }

    /**
     * Return the levelNumber attribute.
     * @return the levelNumber attribute.
     */
    int getLevelNumber() {
        return levelNumber;
    }

    /**
     * Return the elements attribute.
     * @return the elements attribute.
     */
    Element[][] getElements() {
        return elements;
    }

    /**
     * Sets the elements attribute with a given Element[][].
     * @param elements a given Element[][].
     */
    void setElements(Element[][] elements) {
        this.elements = elements;
    }

    /**
     * Return the player attributes.
     * @return the player attributes.
     */
    Player getPlayer() {
        return player;
    }
    /**
     * Return the position x of the player.
     * @return the position x of the player.
     */
    int getPlayerX(){
        return player.getX();
    }
    /**
     * Return the position y of the player.
     * @return the position y of the player.
     */
    int getPlayerY(){
        return player.getY();
    }

    /**
     * Sets the player attribute with a given player.
     * @param player a given player.
     */
    void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Return the minimum of diamonds.
     * @return the minimum of diamonds.
     */
    int getMinDiamonds() {
        return minDiamonds;
    }

    /**
     * Return the value of a diamond.
     * @return the value of a diamond.
     */
    int getDiamondValue() {
        return diamondValue;
    }

    /**
     * Return the bonusDiamondValue attribute.
     * @return the bonusDiamondValue attribute.
     */
    int getBonusDiamondValue() {
        return bonusDiamondValue;
    }

    /**
     * Return the timeMax attribute.
     * @return the timeMax attribute.
     */
    int getTimeMax() {
        return timeMax;
    }

    /**
     * Show if the level is finished.
     * @return a boolean
     */
    boolean isFinished(){
        return exit.getPosition().equals(player.getPosition());
    }

    /**
     * Sets the life attribute.
     * @param bool a given boolean
     */
    void setPlayerLife(boolean bool){
        player.setLife(bool);
    }

    /**
     * Return the life attribute.
     * @return the life attribute
     */
    boolean getPlayerLife(){
        return player.isAlive();
    }

    /**
     * Sets the direction attribute of the player with a given direction.
     * @param direction a given direction.
     */
    void setPlayerDirection(Direction direction){
        player.setDirection(direction);
    }

    /**
     * Return the direction attribute of the player.
     * @return the direction attribute of the player.
     */
    Direction getPlayerDirection(){
        return player.getDirection();
    }

    /**
     * Return the number of levels in the game.
     * @return the number of levels in the game.
     */
    int getNumberOfLevels() {
        return numberOfLevels;
    }
}
