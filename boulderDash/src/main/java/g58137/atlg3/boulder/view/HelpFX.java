package g58137.atlg3.boulder.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import static g58137.atlg3.boulder.view.UtilFX.*;

/**
 * Represents a window that explain the menu.
 * @author Florian Essomba
 */
public class HelpFX extends VBox {
    private HBox exit;

    /**
     * Constructs a new HelpFX which initializes the exit attribute.
     */
    public HelpFX(){
        initUndoText();
        initRedoText();
        initUp();
        initDown();
        initSurender();
        initExit();
    }

    /**
     * Init the undo image and text.
     */
    private void initUndoText(){
        HBox hbox = new HBox();
        String undoPath = "/images/undo.png";
        Image image = new Image(getClass().getResourceAsStream(undoPath));
        ImageView imageView = new ImageView(image);
        hbox.getChildren().add(imageView);
        setLetterImage("go back",hbox);
        this.getChildren().add(hbox);
    }

    /**
     * Init the redo image and text.
     */
    private void initRedoText(){
        HBox hbox = new HBox();
        String redoPath = "/images/redo.png";
        Image image = new Image(getClass().getResourceAsStream(redoPath));
        ImageView imageView = new ImageView(image);
        hbox.getChildren().add(imageView);
        setLetterImage("do a move again",hbox);
        this.getChildren().add(hbox);
    }

    /**
     * Init the up image and text.
     */
    private void initUp(){
        HBox hbox = new HBox();
        String upPath = "/images/up.png";
        Image image = new Image(getClass().getResourceAsStream(upPath));
        ImageView imageView = new ImageView(image);
        hbox.getChildren().add(imageView);
        setLetterImage("go to the next level",hbox);
        this.getChildren().add(hbox);
    }
    /**
     * Init the down image and text.
     */
    private void initDown(){
        HBox hbox = new HBox();
        String downPath = "/images/down.png";
        Image image = new Image(getClass().getResourceAsStream(downPath));
        ImageView imageView = new ImageView(image);
        hbox.getChildren().add(imageView);
        setLetterImage("go to the previous level",hbox);
        this.getChildren().add(hbox);
    }

    /**
     * Init the surrender image and text.
     */
    private void initSurender(){
        HBox hbox = new HBox();
        String stopPath = "/images/stop.png";
        Image image = new Image(getClass().getResourceAsStream(stopPath));
        ImageView imageView = new ImageView(image);
        hbox.getChildren().add(imageView);
        setLetterImage("give up the game",hbox);
        this.getChildren().add(hbox);
    }

    /**
     * Init the exit text.
     */
    private void initExit(){
        exit = new HBox();
        setLetterImage("exit",exit);
        exit.setStyle("-fx-cursor: hand;");
        this.getChildren().add(exit);
    }
    /**
     * Return the exit attribute.
     * @return the exit attribute.
     */
    HBox getExit() {
        return exit;
    }
}
