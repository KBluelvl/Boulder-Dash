package g58137.atlg3.boulder.view;

import g58137.atlg3.boulder.model.Facade;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import static g58137.atlg3.boulder.view.UtilFX.*;

/**
 * Represents a window to choose a level.
 * @author Florian Essomba
 */
public class ChooseLevelFX extends VBox {
    private Facade facade;
    private HBox exit;

    /**
     * Constructs a new ChooseLevelFX which initializes the exit attribute and add images.
     */
    public ChooseLevelFX(Facade facade){
        this.facade = facade;
        this.setAlignment(Pos.CENTER);
        this.setMinWidth(975);
        this.setMinHeight(681);
        this.setSpacing(10);
        initHBox();
        initExit();
        this.setOnScroll(scrollEvent -> {
            if(this.getTranslateY() + scrollEvent.getDeltaY() < 40 &&
                    this.getTranslateY() + scrollEvent.getDeltaY() > (-200* facade.getNumberOfLevels())+800) {
                this.setTranslateY(this.getTranslateY() + scrollEvent.getDeltaY());
            }
        });
    }

    /**
     * Init all HBox and ImageView.
     */
    private void initHBox(){
        VBox vbox;
        HBox hbox;
        Image image;
        ImageView imageView;
        for (int i = 1; i < facade.getNumberOfLevels()+1; i++) {
            vbox = new VBox();
            hbox = new HBox();
            String levelStr = "level "+i;
            setLetterImage(levelStr,hbox);
            String levelPath = "";
            if(i <= 3) {
                levelPath = "/images/" + i + "/level" + i + ".png";
            } else{
                levelPath = "/images/4/level4.png";
            }
            image = new Image(getClass().getResourceAsStream(levelPath),300,200,true,true);
            imageView = new ImageView(image);
            vbox.getChildren().add(hbox);
            vbox.getChildren().add(imageView);
            vbox.setStyle("-fx-cursor: hand;");
            hbox.setAlignment(Pos.CENTER);
            vbox.setAlignment(Pos.CENTER);
            this.getChildren().add(vbox);
        }
    }

    /**
     * Init the exit attribute.
     */
    private void initExit(){
        exit = new HBox();
        exit.setStyle("-fx-cursor: hand;");
        String exitStr = "exit";
        setLetterImage(exitStr,exit);
        exit.setAlignment(Pos.BOTTOM_LEFT);
        this.getChildren().add(exit);
        VBox.setMargin(exit,new Insets(10,0,0,0));
    }

    /**
     * Return the exit attribute.
     * @return the exit attribute.
     */
    HBox getExit() {
        return exit;
    }
}
