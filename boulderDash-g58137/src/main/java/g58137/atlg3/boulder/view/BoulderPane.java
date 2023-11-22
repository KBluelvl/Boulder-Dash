package g58137.atlg3.boulder.view;

import g58137.atlg3.boulder.model.Direction;
import g58137.atlg3.boulder.model.Facade;
import g58137.atlg3.boulder.model.Player;
import g58137.atlg3.boulder.model.Position;
import g58137.atlg3.boulder.model.element.*;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.util.Objects;

/**
 * Represents a GridPane called BoulderPane.
 * @author Florian Essomba
 */
public class BoulderPane extends GridPane {
    private Facade facade;
    private Element[][] currLevel;
    private int leftOffset;
    private int rightOffset;
    private int topOffset;
    private int downOffset;
    private int nb;
    private TranslateTransition transition;

    /**
     * Constructs a new BoulderPane which initializes the offsets, facade, currLevel, nb and transition attributes.
     * @param facade a given Facade.
     */
    public BoulderPane(Facade facade) {
        this.facade = facade;
        nb = facade.getLevelNumber();
        initCurrLevel();
        initOffsets();
        initTransition();
    }

    /**
     * Display the game (Element[][]).
     */
    public void display(){
        Element[][] elements = facade.getLevel().getElements();
        int x = facade.getLevel().getPlayerX();
        int y = facade.getLevel().getPlayerY();
        if(nb != facade.getLevelNumber()){
            this.getChildren().clear();
            initCurrLevel();
            initOffsets();
            resetTransition();
            nb = facade.getLevelNumber();
        }
        setOffsets(x,y);
        for (int i = elements.length-1 - topOffset; i >= downOffset; i--) {
            for (int j = leftOffset; j < elements[i].length - rightOffset; j++) {
                ImageView imageView = new ImageView();
                    if(!(currLevel[i][j] instanceof Diamond) && elements[i][j] instanceof Diamond){
                        if (!((Diamond) elements[i][j]).isPlayerKiller()) {
                            imageView = new ImageView(getImage(nb, "diamond"));
                        } else {
                            explosion(i,j,elements);
                            i = downOffset;
                            break;
                        }
                    this.add(imageView, j,elements.length-1 - i);
                    setCurrLevel(i,j);
                } else if(!(currLevel[i][j] instanceof EmptyTile) && elements[i][j] instanceof EmptyTile){
                    imageView = new ImageView(getImage(nb, "emptyTile"));
                    this.add(imageView, j,elements.length-1 - i);
                    setCurrLevel(i,j);
                } else if(!(currLevel[i][j] instanceof Ground) && elements[i][j] instanceof Ground){
                    imageView = new ImageView(getImage(nb,"ground"));
                    this.add(imageView, j,elements.length-1 - i);
                    setCurrLevel(i,j);
                } else if(!(currLevel[i][j] instanceof Player) && elements[i][j] instanceof Player){
                    if(facade.getPlayerDirection() == Direction.RIGHT){
                        imageView = new ImageView(getImage(nb, "playerRight"));
                    } else if(facade.getPlayerDirection() == Direction.LEFT){
                        imageView = new ImageView(getImage(nb, "playerLeft"));
                    }
                    this.add(imageView, j, elements.length - 1 - i);
                    setCurrLevel(i,j);
                } else if(!(currLevel[i][j] instanceof Rock) && elements[i][j] instanceof Rock){
                    if (!((Rock) elements[i][j]).isPlayerKiller()) {
                        imageView = new ImageView(getImage(nb, "rock"));
                    } else {
                        explosion(i,j,elements);
                        i = downOffset;
                        break;
                    }
                    this.add(imageView, j, elements.length - 1 - i);
                    setCurrLevel(i,j);
                } else if(!(currLevel[i][j] instanceof Wall) && elements[i][j] instanceof Wall){
                    if(j != 0 && i != 0 && j != elements[i].length-1 &&
                            i != elements.length-1) {
                        imageView = new ImageView(getImage(nb,"wall1"));
                    } else {
                        imageView = new ImageView(getImage(nb,"wall2"));
                    }
                    this.add(imageView, j, elements.length - 1 - i);
                    setCurrLevel(i,j);
                } else if((!(currLevel[i][j] instanceof Exit) || facade.canExit()) && elements[i][j] instanceof Exit){
                    if (facade.canExit()){
                        imageView = new ImageView(getImage(nb,"exit"));
                    } else {
                        imageView = new ImageView(getImage(nb,"wall2"));
                    }
                    this.add(imageView, j, elements.length - 1 - i);
                    setCurrLevel(i,j);
                }
            }
        }
    }

    /**
     * Explodes the player.
     * @param i a given number.
     * @param j a given number
     * @param elements a given Element[][].
     */
    private void explosion(int i,int j,Element[][] elements){
        this.add(new ImageView(getImage(facade.getLevelNumber(), "explosion")), j-1,elements.length-1 - i-1);
        this.add(new ImageView(getImage(facade.getLevelNumber(), "explosion")), j-1,elements.length-1 - i);
        this.add(new ImageView(getImage(facade.getLevelNumber(), "explosion")), j-1,elements.length-1 - i+1);
        this.add(new ImageView(getImage(facade.getLevelNumber(), "explosion")), j,elements.length-1 - i-1);
        this.add(new ImageView(getImage(facade.getLevelNumber(), "explosion")), j,elements.length-1 - i);
        this.add(new ImageView(getImage(facade.getLevelNumber(), "explosion")), j,elements.length-1 - i+1);
        this.add(new ImageView(getImage(facade.getLevelNumber(), "explosion")), j+1,elements.length-1 - i-1);
        this.add(new ImageView(getImage(facade.getLevelNumber(), "explosion")), j+1,elements.length-1 - i);
        this.add(new ImageView(getImage(facade.getLevelNumber(), "explosion")), j+1,elements.length-1 - i+1);
    }

    /**
     * Sets the offsets attribute.
     * @param x a given number.
     * @param y a given number.
     */
    private void setOffsets(int x, int y){
        if(rightOffset != 10 && x <= 16){
            leftOffset = 0;
            rightOffset = 10;
            transition.setToX(160);
            transition.play();
        } else if(leftOffset != 10 && x >= 25){
            leftOffset = 10;
            rightOffset = 0;
            transition.setToX(-160);
            transition.play();
        }
        if(topOffset != 6 && y < 8){
            topOffset = 6;
            downOffset = 0;
            transition.setToY(-187+30*3);
            transition.play();
        } else if(downOffset != 6 && y >= 14){
            topOffset = 0;
            downOffset = 3;
            transition.setToY(30*4+10);
            transition.play();
        }
    }

    /**
     * Sets the currLevel attribute.
     * @param i a given number.
     * @param j a given number.
     */
    private void setCurrLevel(int i,int j) {
        Position position = currLevel[i][j].getPosition();
        if (facade.getLevel().getElements()[i][j] instanceof Ground){
            currLevel[i][j] = new Ground(position);
        } else if (facade.getLevel().getElements()[i][j] instanceof Player){
            currLevel[i][j] = new Player(position);
        } else if (facade.getLevel().getElements()[i][j] instanceof Exit){
            currLevel[i][j] = new Exit(position);
        } else if (facade.getLevel().getElements()[i][j] instanceof Rock){
            currLevel[i][j] = new Rock(position);
        } else if (facade.getLevel().getElements()[i][j] instanceof Diamond){
            currLevel[i][j] = new Diamond(position);
        } else if (facade.getLevel().getElements()[i][j] instanceof Wall){
            currLevel[i][j] = new Wall(position);
        } else if (facade.getLevel().getElements()[i][j] instanceof EmptyTile){
            currLevel[i][j] = new EmptyTile(position);
        }
    }

    /**
     * Init the offsets.
     */
    private void initOffsets(){
        int x = facade.getLevel().getPlayerX();
        int y = facade.getLevel().getPlayerY();
        if(x <= 18){
            leftOffset = 0;
            rightOffset = 10;
        } else if(x >= 25){
            leftOffset = 10;
            rightOffset = 0;

        }
        if(y < 8){
            topOffset = 6;
            downOffset = 0;
        } else if(y >= 14){
            topOffset = 0;
            downOffset = 6;
        }
    }

    /**
     * Init the currLevel attribute.
     */
    private void initCurrLevel(){
        Element[][] tab = facade.getLevel().getElements();
        currLevel = new Element[tab.length][tab[0].length];
        for (int i = 0; i < currLevel.length; i++) {
            for (int j = 0; j < currLevel[i].length; j++) {
                currLevel[i][j] = new Element(new Position(i,j));
            }
        }
    }

    /**
     * Init the transition attribute.
     */
    private void initTransition(){
        transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.seconds(0.7));
    }

    /**
     * Get a Image from a given String.
     * @param niveau a given number.
     * @param str a given String.
     * @return an Image.
     */
    private Image getImage(int niveau,String str){
        if(niveau > 4){
            niveau = 4;
        }
        switch (str) {
            case "diamond" -> str = "/images/" + niveau + "/diamond.gif";
            case "rock" -> str = "/images/" + niveau + "/rock.png";
            case "ground" -> str = "/images/" + niveau + "/ground.png";
            case "player" -> str = "/images/" + niveau + "/player.png";
            case "playerLeft" -> str = "/images/" + niveau + "/playerLeft.gif";
            case "playerRight" -> str = "/images/" + niveau + "/playerRight.gif";
            case "emptyTile" -> str = "/images/emptyTile.png";
            case "exit" -> str = "/images/" + niveau + "/exit.png";
            case "wall1" -> str = "/images/" + niveau + "/wall1.png";
            case "wall2" -> str = "/images/" + niveau + "/wall2.png";
            case "explosion" -> str = "/images/" + niveau + "/explosion.gif";
        }
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(str)), 32, 32, true, true);
    }

    /**
     * Reset the transition.
     */
    private void resetTransition(){
        transition.setToX(0);
        transition.setToY(32);
        transition.play();
    }
}
