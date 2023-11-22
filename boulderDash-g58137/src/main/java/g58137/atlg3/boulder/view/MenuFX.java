package g58137.atlg3.boulder.view;

import g58137.atlg3.boulder.model.Level;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import static g58137.atlg3.boulder.view.UtilFX.setLetterImage;

/**
 * Represents the menu under the game.
 * @author Florian Essomba
 */
public class MenuFX extends HBox{
    private Level level;
    private HBox goToNextLevel;
    private HBox goToPreviousLevel;
    private HBox currentLevel;
    private HBox undo;
    private HBox redo;
    private HBox blocked;
    private HBox surender;

    /**
     * Constructs a new MenuFX which initializes the attributes.
     * @param level a given Level.
     */
    public MenuFX(Level level) {
        this.level = level;
        initGoToNextLevel();
        initGoToPreviousLevel();
        currentLevel = new HBox();
        initCurrentLevel();
        initUndo();
        initRedo();
        initBlocked();
        initSurender();
        HBox.setMargin(currentLevel,new Insets(10,0,0,40));
        HBox.setMargin(undo,new Insets(0,0,0,75));//v0:haut v1:droite v2:bas v3:gauche
        HBox.setMargin(redo,new Insets(0,160,0,0));
        HBox.setMargin(blocked,new Insets(0,80,0,0));
        this.getChildren().add(goToNextLevel);
        this.getChildren().add(goToPreviousLevel);
        this.getChildren().add(currentLevel);
        this.getChildren().add(undo);
        this.getChildren().add(redo);
        this.getChildren().add(blocked);
        this.getChildren().add(surender);
    }

    /**
     * Display an image during a few seconds.
     */
    public void displayCantMove() {
        blocked.getChildren().clear();
        String cantMovePath = "/images/cantMove.png";
        Image cantMove = new Image(getClass().getResourceAsStream(cantMovePath));
        ImageView imageView = new ImageView(cantMove);
        blocked.getChildren().add(imageView);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),e ->{
            blocked.getChildren().clear();
            String canMovePath = "/images/emptyTile.png";
            Image image = new Image(getClass().getResourceAsStream(canMovePath),32,34,true,true);
            ImageView viewImg = new ImageView(image);
            blocked.getChildren().add(viewImg);
        }));
        timeline.play();
    }

    /**
     * Init the undo attribute.
     */
    private void initUndo(){
        undo = new HBox();
        undo.setStyle("-fx-cursor: hand;");
        String undoPath = "/images/undo.png";
        Image image = new Image(getClass().getResourceAsStream(undoPath));
        ImageView imageView = new ImageView(image);
        undo.getChildren().add(imageView);
    }

    /**
     * Init the redo attribute.
     */
    private void initRedo(){
        redo = new HBox();
        redo.setStyle("-fx-cursor: hand;");
        String redoPath = "/images/redo.png";
        Image image = new Image(getClass().getResourceAsStream(redoPath));
        ImageView imageView = new ImageView(image);
        redo.getChildren().add(imageView);
    }

    /**
     * Init the goToNextLevel attribute.
     */
    private void initGoToNextLevel(){
        goToNextLevel = new HBox();
        String upPath = "/images/up.png";
        Image image = new Image(getClass().getResourceAsStream(upPath));
        ImageView imageView = new ImageView(image);
        goToNextLevel.getChildren().add(imageView);
    }

    /**
     * Init the goToPreviousLevel attribute.
     */
    private void initGoToPreviousLevel(){
        goToPreviousLevel = new HBox();
        String downPath = "/images/down.png";
        Image image = new Image(getClass().getResourceAsStream(downPath));
        ImageView imageView = new ImageView(image);
        goToPreviousLevel.getChildren().add(imageView);
    }

    /**
     * Init the currentLevel attribute.
     */
    public void initCurrentLevel(){
        currentLevel.getChildren().clear();
        setLetterImage("level"+level.getLevelNumber(),currentLevel);
    }

    /**
     * Init the surender attribute.
     */
    private void initSurender(){
        surender = new HBox();
        String stopPath = "/images/stop.png";
        Image image = new Image(getClass().getResourceAsStream(stopPath));
        ImageView imageView = new ImageView(image);
        surender.getChildren().add(imageView);
    }

    /**
     * Init the blocked attribute.
     */
    private void initBlocked(){
        blocked = new HBox();
        String canMovePath = "/images/emptyTile.png";
        Image image = new Image(getClass().getResourceAsStream(canMovePath),32,34,true,true);
        ImageView imageView = new ImageView(image);
        blocked.getChildren().add(imageView);
    }

    /**
     * Return the undo attribute.
     * @return the undo attribute.
     */
    HBox getUndo() {
        return undo;
    }

    /**
     * Return the redo attribute.
     * @return the redo attribute.
     */
    HBox getRedo() {
        return redo;
    }

    /**
     * Return the goToNextLevel attribute.
     * @return the goToNextLevel attribute.
     */
    HBox getGoToNextLevel() {
        return goToNextLevel;
    }

    /**
     * Return the goToPreviousLevel attribute.
     * @return the goToPreviousLevel attribute.
     */
    HBox getGoToPreviousLevel() {
        return goToPreviousLevel;
    }

    /**
     * Return the surender attribute.
     * @return the surender attribute.
     */
    HBox getSurender() {
        return surender;
    }
}
