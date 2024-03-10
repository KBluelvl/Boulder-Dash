package g58137.atlg3.boulder.model;

import g58137.atlg3.boulder.model.element.*;
/**
 * Represents the command move.
 * @author Florian Essomba
 */
public class MoveCommand implements Command{
    private Direction direction;
    private Level level;
    private Player player;
    private int currDiamonds;
    private Element[][] elements;

    /**
     * Constructs a new MoveCommand which initializes the direction,level, player, currDiamonds and elements attributes.
     * @param direction a given Direction.
     * @param level a given Level.
     */
    public MoveCommand(Direction direction, Level level){
        this.direction = direction;
        this.level = level;
        this.currDiamonds = level.getCurrDiamonds();
        initElements();
    }

    /**
     * The method that execute the command.
     */
    @Override
    public void execute(){
        level.movePlayer(direction);
    }

    /**
     * The method that unexecute the Command.
     */
    @Override
    public void unexecute(){
        level.setElements(elements);
        level.setPlayer(player);
        level.setCurrDiamonds(currDiamonds);
    }

    /**
     * Init the elements.
     */
    private void initElements(){
        elements = new Element[22][40];
        Element[][] currElements = level.getElements();
        for (int i = 0; i < currElements.length; i++) {
            for (int j = 0; j < currElements[i].length; j++) {
                if(currElements[i][j] instanceof Ground){
                    elements[i][j] = new Ground(new Position(j,i));
                } else if (currElements[i][j] instanceof EmptyTile) {
                    elements[i][j] = new EmptyTile(new Position(j,i));
                } else if (currElements[i][j] instanceof Exit) {
                    elements[i][j] = new Exit(new Position(j,i));
                } else if (currElements[i][j] instanceof Rock) {
                    elements[i][j] = new Rock(new Position(j,i));
                } else if (currElements[i][j] instanceof Wall) {
                    elements[i][j] = new Wall(new Position(j,i));
                } else if (currElements[i][j] instanceof Diamond) {
                    elements[i][j] = new Diamond(new Position(j,i));
                } else if (currElements[i][j] instanceof Player) {
                    elements[i][j] = new Player(new Position(j,i));
                    player = new Player(new Position(j,i));
                }
            }
        }
    }
}
