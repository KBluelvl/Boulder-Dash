package g58137.atlg3.boulder.model;

import g58137.atlg3.boulder.model.Util.Observer;
import java.util.ArrayList;
import java.util.List;
import g58137.atlg3.boulder.model.Util.Observable;

/**
 * Configure the game.
 * @author Florian Essomba
 */
public class Facade implements Observable{
    private CommandManager commandManager = new CommandManager();
    private List<Observer> observers = new ArrayList();
    private Level level;
    private final int numberOfLevels;

    /**
     * Constructs a new Facade which initializes the level and levelNumber attributes.
     */
    public Facade() {
        LevelLoader levelLoader = new LevelLoader(1);
        level = new Level(levelLoader.getLevelInfo());
        numberOfLevels = levelLoader.getNumberOfLevels();
        notifyObservers();
    }

    /**
     * Cancel the previous command.
     */
    public void undo(){
        commandManager.undo();
        notifyObservers();
    }

    /**
     * Do the command again.
     */
    public void redo(){
        commandManager.redo();
        notifyObservers();
    }

    /**
     * Move the player in the level with a given direction.
     * @param direction a given Direction.
     */
    public void movePlayer(Direction direction) {
        MoveCommand moveCommand = new MoveCommand(direction,level);
        commandManager.register(moveCommand);
        notifyObservers();
    }

    /**
     * Change the level with a given number.
     * @param nb a given number.
     */
    public void goToNextLevel(int nb){
            level.changeLevel(nb);
            commandManager.clear();
            notifyObservers();
    }

    /**
     * Load a level with a given number.
     * @param nb a given number.
     */
    public void goToLevel(int nb){
        level.chooseLevel(nb);
        commandManager.clear();
        notifyObservers();
    }

    /**
     * Show if the game is lost.
     * @return a boolean.
     */
    public boolean lose(){
        return level.lose();
    }

    /**
     * Show if the game is over with a boolean.
     * @return a boolean.
     */
    public boolean endGame(){
        return level.endGame();
    }

    /**
     * Show if the player has enough diamonds to finish the level.
     * @return a boolean.
     */
    public boolean canExit(){
        return level.canExit();
    }

    /**
     * Reset the time.
     */
    public void resetGame(){
        level.chooseLevel(level.getLevelNumber());
        commandManager.clear();
        notifyObservers();
    }

    /**
     * Return the level.
     * @return the level.
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Return the levelNumber.
     * @return the levelNumber.
     */
    public int getLevelNumber() {
        return level.getLevelNumber();
    }


    /**
     * Return the direction attribute of the player.
     * @return the direction attribute of the player.
     */
    public Direction getPlayerDirection(){
        return level.getPlayerDirection();
    }

    /**
     * Return the number of levels in the game.
     * @return the number of levels in the game.
     */
    public int getNumberOfLevels() {
        return numberOfLevels;
    }

    /**
     * Register an observer.
     * @param observer a given observer.
     */
    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    /**
     * Notify all observers.
     */
    private void notifyObservers() {
        for (Observer obs: observers) {
            obs.update();
        }
    }
}
