package g58137.atlg3.boulder.model;

import g58137.atlg3.boulder.model.element.*;

/**
 * Represents the level.
 * @author Florian Essomba.
 */
public class Level {
    private LevelInfo info;
    private int seconds;
    private int score;
    private int currDiamonds;
    private boolean winTheGame;

    /**
     * Constructs a new Level which initializes the info, seconds, score, currDiamonds attributes.
     * @param info a given LevelInfo.
     */
    public Level(LevelInfo info){
        this.info = info;
        seconds = info.getTimeMax();
        score = 0;
        currDiamonds = 0;
    }

    /**
     * Move the player in the Level with a given direction.
     * @param direction a given Direction.
     */
    public void movePlayer(Direction direction) {
        Position position = info.getPlayer().getPosition();
        int x = info.getPlayerX();
        int y = info.getPlayerY();
        if(direction == Direction.UP && canCross(Direction.UP)) { // up
            info.getPlayer().moveUp();
            if(isDiamond()){
                addDiamondAndScore();
            }
            info.getElements()[y][x] = new EmptyTile(position);
            info.getElements()[y+1][x] = info.getPlayer();
        } else if (direction == Direction.DOWN && canCross(Direction.DOWN)) { // down
            info.getPlayer().moveDown();
            if(isDiamond()){
                addDiamondAndScore();
            }
            info.getElements()[y][x] = new EmptyTile(position);
            info.getElements()[y-1][x] = info.getPlayer();
        } else if (direction == Direction.RIGHT && canCross(Direction.RIGHT)) { // right
            info.getPlayer().moveRight();
            info.setPlayerDirection(Direction.RIGHT);
            if(info.getElements()[y][x + 1] instanceof Rock){
                info.getElements()[y][x + 2] = new Rock(new Position(x+2,y));
            } else if (isDiamond()) {
                addDiamondAndScore();
            }
            info.getElements()[y][x] = new EmptyTile(position);
            info.getElements()[y][x+1] = info.getPlayer();
        }  else if(direction == Direction.LEFT && canCross(Direction.LEFT)){ // left
            info.getPlayer().moveLeft();
            info.setPlayerDirection(Direction.LEFT);
            if(info.getElements()[y][x - 1] instanceof Rock){
                info.getElements()[y][x - 2] = new Rock(new Position(x-2,y));
            } else if (isDiamond()) {
                addDiamondAndScore();
            }
            info.getElements()[y][x] = new EmptyTile(position);
            info.getElements()[y][x-1] = info.getPlayer();
        }
        fallingRocksAndDiamonds();
        nextLevel();
    }

    /**
     * Increments the currDiamonds and score attributes.
     */
    private void addDiamondAndScore(){
        currDiamonds++;
        score += info.getDiamondValue();
    }

    /**
     * Tells if the player lose the game.
     * @return a boolean.
     */
    public boolean lose(){
        return !info.getPlayerLife() || seconds <= 0;
    }

    /**
     * Show if the game is over with a boolean.
     * @return a boolean.
     */
    public boolean endGame(){
        return lose() || winTheGame;
    }

    /**
     * Make the rock(s) and the diamond(s) fall if they can fall.
     */
    private void fallingRocksAndDiamonds() {
        for (int y = 0; y < info.getElements().length; y++) {
            for (int x = 0; x < info.getElements()[y].length; x++) {
                Element element = info.getElements()[y][x];
                if(isFallingTile(element)){
                    fallTile(element,false);
                }
            }
        }
    }

    /**
     * Show if the tile can fall with a boolean.
     * @param element a given element.
     * @return a boolean.
     */
    private boolean isFallingTile(Element element){
        return element instanceof Rock || element instanceof Diamond;
    }

    /**
     * Drop the tile.
     * @param element a given element.
     * @param hasRolled a given boolean.
     */
    private void fallTile(Element element,boolean hasRolled){
        int x = element.getPosition().getX();
        int y = element.getPosition().getY();
        int index = 1;
        while((info.getElements()[y-index][x] instanceof EmptyTile ||
                ((hasRolled || index > 1) && info.getElements()[y-index][x] instanceof Player) && info.getPlayerLife())){
            if(info.getElements()[y-index][x] instanceof Player && info.getPlayerLife()){
                setKiller(index,y,x,element);
            } else {
                info.getElements()[y - index + 1][x] = new EmptyTile(new Position(x, y - index + 1));
                info.getElements()[y - index][x] = element;
                element.setPosition(new Position(x, y - index));
                index++;
            }
        }
        if (canRollLeft(element)  && info.getPlayerLife()){
            rollLeft(element);
            fallTile(element,true);
        } else if (canRollRight(element) && info.getPlayerLife()) {
            rollRight(element);
            fallTile(element,true);
        }
    }

    /**
     * Show if the tile can roll on the left.
     * @param element a given element.
     * @return a boolean
     */
    private boolean canRollLeft(Element element){
        int x = element.getPosition().getX();
        int y = element.getPosition().getY();
        return info.getElements()[y][x - 1] instanceof EmptyTile &&
                info.getElements()[y - 1][x - 1] instanceof EmptyTile &&
                (info.getElements()[y - 1][x] instanceof Wall ||
                 info.getElements()[y - 1][x] instanceof Rock ||
                 info.getElements()[y - 1][x] instanceof Diamond);
    }

    /**
     * Rolls on the left.
     * @param element a given element.
     */
    private void rollLeft(Element element){
        int x = element.getPosition().getX();
        int y = element.getPosition().getY();
        info.getElements()[y][x] = new EmptyTile(new Position(x,y));
        info.getElements()[y - 1][x - 1] = element;
        element.setPosition(new Position(x - 1,y - 1));
    }

    /**
     * Show if the tile can roll on the right.
     * @param element a given element.
     * @return a boolean
     */
    private boolean canRollRight(Element element){
        int x = element.getPosition().getX();
        int y = element.getPosition().getY();
        return info.getElements()[y][x + 1] instanceof EmptyTile &&
                info.getElements()[y - 1][x + 1] instanceof EmptyTile &&
                (info.getElements()[y - 1][x] instanceof Wall ||
                        info.getElements()[y - 1][x] instanceof Rock ||
                        info.getElements()[y - 1][x] instanceof Diamond);
    }

    /**
     * Rolls on the right.
     * @param element a given element.
     */
    private void rollRight(Element element){
        int x = element.getPosition().getX();
        int y = element.getPosition().getY();
        info.getElements()[y][x] = new EmptyTile(new Position(x,y));
        info.getElements()[y - 1][x + 1] = element;
        element.setPosition(new Position(x + 1,y - 1));
    }

    /**
     * Sets the playerLife attribute to false and move the tile on the position of the player.
     * @param index a given number.
     * @param y a given number.
     * @param x a given number.
     * @param element a given element.
     */
    private void setKiller(int index,int y ,int x,Element element){
        info.setPlayerLife(false);
        info.getElements()[y - index+1][x] = new EmptyTile(new Position(x, y - index+1));
        if (element instanceof Rock){ // if the player killer is a rock.
            Rock rock = new Rock(new Position(x,y - index));
            info.getElements()[y - index][x] = rock;
            rock.setPlayerKiller(true);
        } else { // if the player killer is a diamond.
            Diamond diamond = new Diamond(new Position(x,y - index));
            info.getElements()[y - index][x] = diamond;
            diamond.setPlayerKiller(true);
        }
    }

    /**
     * Tells if the player can go in a given direction.
     * @param direction a given direction.
     * @return a boolean.
     */
    public boolean canCross(Direction direction){
        int x = info.getPlayer().getX();
        int y = info.getPlayer().getY();
        switch (direction){
            case UP:
                return !(info.getElements()[y + 1][x] instanceof Wall) && !(info.getElements()[y + 1][x] instanceof Rock) &&
                        !(info.getElements()[y + 1][x] instanceof Exit && !canExit());
            case DOWN:
                return !(info.getElements()[y - 1][x] instanceof Wall) && !(info.getElements()[y - 1][x] instanceof Rock) &&
                        !(info.getElements()[y - 1][x] instanceof Exit && !canExit());
            case RIGHT:
                if(x+2 < info.getElements()[0].length) {
                    return !(info.getElements()[y][x + 1] instanceof Wall) && !(info.getElements()[y][x + 1] instanceof Exit && !canExit()) &&
                            !(info.getElements()[y][x + 1] instanceof Rock && info.getElements()[y][x + 2] instanceof Wall) &&
                            !(info.getElements()[y][x + 1] instanceof Rock && info.getElements()[y][x + 2] instanceof Exit) &&
                            !(info.getElements()[y][x + 1] instanceof Rock && info.getElements()[y][x + 2] instanceof Rock) &&
                            !(info.getElements()[y][x + 1] instanceof Rock && info.getElements()[y][x + 2] instanceof Diamond) &&
                            !(info.getElements()[y][x + 1] instanceof Rock && info.getElements()[y][x + 2] instanceof Ground);
                }
                return false;
            case LEFT:
                if(x-2 >= 0) {
                    return !(info.getElements()[y][x - 1] instanceof Wall) && !(info.getElements()[y][x - 1] instanceof Exit && !canExit()) &&
                            !(info.getElements()[y][x - 1] instanceof Rock && info.getElements()[y][x - 2] instanceof Wall) &&
                            !(info.getElements()[y][x - 1] instanceof Rock && info.getElements()[y][x - 2] instanceof Exit) &&
                            !(info.getElements()[y][x - 1] instanceof Rock && info.getElements()[y][x - 2] instanceof Rock) &&
                            !(info.getElements()[y][x - 1] instanceof Rock && info.getElements()[y][x - 2] instanceof Diamond) &&
                            !(info.getElements()[y][x - 1] instanceof Rock && info.getElements()[y][x - 2] instanceof Ground);
                }
                return false;
        }
        return false;
    }

    /**
     * Tells if the player gets a diamond.
     * @return a boolean.
     */
    private boolean isDiamond(){
        int x = info.getPlayerX();
        int y = info.getPlayerY();
        return info.getElements()[y][x] instanceof Diamond;
    }

    /**
     * Tells if the player gets a diamond.
     * @return a boolean.
     */
    public boolean isDiamond(Direction direction){
        int x = info.getPlayerX();
        int y = info.getPlayerY();
        switch (direction){
            case UP -> y+=1;
            case DOWN -> y-=1;
            case LEFT -> x-=1;
            case RIGHT -> x+=1;
        }
        return info.getElements()[y][x] instanceof Diamond;
    }

    /**
     * Show if the player has enough diamonds to finish the level.
     * @return a boolean.
     */
    public boolean canExit(){
        return currDiamonds >= info.getMinDiamonds();
    }

    /**
     * If the player completes the level go to the next level.
     */
    private void nextLevel(){
        if(info.getLevelNumber() != info.getNumberOfLevels() && canExit() && levelFinished()){
            changeLevel(1);
        } else if(levelFinished()){
            winTheGame = true;
        }
    }

    /**
     * Change the level with a given number.
     * @param nb a given number.
     */
    public void changeLevel(int nb){
        LevelLoader levelLoader = new LevelLoader(info.getLevelNumber()+nb);
        info = levelLoader.getLevelInfo();
        seconds = info.getTimeMax();
        score = 0;
        currDiamonds = 0;
    }

    /**
     * Choose the level with a given number.
     * @param nb a given number.
     */
    public void chooseLevel(int nb) {
        LevelLoader levelLoader = new LevelLoader(nb);
        info = levelLoader.getLevelInfo();
        seconds = info.getTimeMax();
        score = 0;
        currDiamonds = 0;
    }

    /**
     * Show if the level is finished.
     * @return a boolean
     */
    private boolean levelFinished(){
        return info.isFinished();
    }

    /**
     * Return the array of Element[][] of the level.
     * @return the array of Element[][] of the level.
     */
    public Element[][] getElements() {
        return info.getElements();
    }

    /**
     * Return the position x of the player.
     * @return the position x of the player.
     */
    public int getPlayerX() {
        return info.getPlayerX();
    }
    /**
     * Return the position y of the player.
     * @return the position y of the player.
     */
    public int getPlayerY() {
        return info.getPlayerY();
    }

    /**
     * Return the minimum of diamonds.
     * @return the minimum of diamonds.
     */
    public int getMinDiamonds() {
        return info.getMinDiamonds();
    }

    /**
     * Return the current diamonds.
     * @return the current diamonds.
     */
    public int getCurrDiamonds() {
        return currDiamonds;
    }

    /**
     * Return the value of a diamond.
     * @return the value of a diamond.
     */
    public int getDiamondValue() {
        return info.getDiamondValue();
    }

    /**
     * Return the bonus value of the diamond.
     * @return the bonus value of the diamond.
     */
    public int getBonusDiamondValue() {
        return info.getBonusDiamondValue();
    }

    /**
     * Return the seconds remaining.
     * @return the seconds remaining.
     */
    public int getSeconds() {
        return seconds+1;
    }

    /**
     *  Return the score attribute.
     * @return the score attribute.
     */
    public int getScore() {
        return score;
    }

    /**
     * Return the info attribute.
     * @return the info attribute.
     */
    public LevelInfo getInfo() {
        return info;
    }

    /**
     * Decrement the seconds attribute.
     */
    public void decSeconds() {
        seconds--;
    }

    /**
     * Sets the Element[][] array.
     * @param elements a given Element[][].
     */
    public void setElements(Element[][] elements) {
        info.setElements(elements);
    }

    /**
     * Sets the player.
     * @param player a given player.
     */
    public void setPlayer(Player player) {
        info.setPlayer(player);
    }

    /**
     * Return the player's life.
     * @return the player's life.
     */
    public boolean getPlayerLife(){
        return info.getPlayerLife();
    }

    /**
     * Sets the currDiamonds attribute with a given number.
     * @param currDiamonds a given number.
     */
    public void setCurrDiamonds(int currDiamonds) {
        this.currDiamonds = currDiamonds;
    }

    /**
     * Return the direction attribute of the player.
     * @return the direction attribute of the player.
     */
    public Direction getPlayerDirection(){
        return info.getPlayerDirection();
    }

    /**
     * Return the levelNumber.
     * @return the levelNumber.
     */
    public int getLevelNumber(){
        return info.getLevelNumber();
    }
}
