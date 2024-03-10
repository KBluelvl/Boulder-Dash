package g58137.atlg3.boulder.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.Objects;

import static g58137.atlg3.boulder.view.UtilFX.*;

/**
 * Represents a window before you start the game.
 */
public class StartScreen extends VBox {
    private HBox firstChoice;
    private HBox secondChoice;
    private HBox thirdChoice;
    private HBox lastChoice;

    /**
     * Constructs a new StartScreen which initializes the facade attribute and display text.
     */
    public StartScreen(){
        display();
        this.setMinWidth(975);
        this.setMinHeight(681);
        this.setPadding(new Insets(60,82,60,82));//v0:haut v1:droite v2:bas v3:gauche
    }

    /**
     * Display text(s) and image(s).
     */
    public void display(){
        initBoulderImage();
        initFirstChoice();
        initSecondChoice();
        initThirdChoice();
        initLastChoice();
        VBox.setMargin(firstChoice,new Insets(10,0,25,0));//v0:haut v1:droite v2:bas v3:gauche
        VBox.setMargin(secondChoice,new Insets(0,0,25,0));
        VBox.setMargin(thirdChoice,new Insets(0,0,25,0));
        this.getChildren().add(firstChoice);
        this.getChildren().add(secondChoice);
        this.getChildren().add(thirdChoice);
        this.getChildren().add(lastChoice);
    }

    /**
     * Add an imageView.
     */
    private void initBoulderImage(){
        String boulderDash = "/images/boulderDashTM.gif";
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(boulderDash)));
        ImageView imageView = new ImageView(image);
        this.getChildren().add(imageView);
    }

    /**
     * Initializes the firsChoice attribute.
     */
    private void initFirstChoice(){
        firstChoice = new HBox();
        firstChoice.setStyle("-fx-cursor: hand;");
        String firstStr = "play";
        setLetterImage(firstStr,firstChoice);
        firstChoice.setAlignment(Pos.CENTER);
    }

    /**
     * Initializes the secondChoice attribute.
     */
    private void initSecondChoice(){
        secondChoice = new HBox();
        secondChoice.setStyle("-fx-cursor: hand;");
        String secondStr = "choose your level";
        setLetterImage(secondStr,secondChoice);
        secondChoice.setAlignment(Pos.CENTER);
    }

    /**
     * Initializes the thirdChoice attribute.
     */
    private void initThirdChoice(){
        thirdChoice = new HBox();
        thirdChoice.setStyle("-fx-cursor: hand;");
        String thirdStr = "help";
        setLetterImage(thirdStr,thirdChoice);
        thirdChoice.setAlignment(Pos.CENTER);
    }

    /**
     * Initializes the lastChoice attribute.
     */
    private void initLastChoice(){
        lastChoice = new HBox();
        lastChoice.setStyle("-fx-cursor: hand;");
        String exit = "exit";
        setLetterImage(exit,lastChoice);
        lastChoice.setAlignment(Pos.CENTER);
    }

    /**
     * Return the firstChoice attribute.
     * @return the firstChoice attribute.
     */
    HBox getFirstChoice() {
        return firstChoice;
    }

    /**
     * Return the secondChoice attribute.
     * @return the secondChoice attribute.
     */
    HBox getSecondChoice() {
        return secondChoice;
    }

    /**
     * Return the thirdChoice attribute.
     * @return the thirdChoice attribute.
     */
    HBox getThirdChoice() {
        return thirdChoice;
    }

    /**
     * Return the lastChoice attribute.
     * @return the lastChoice attribute.
     */
    HBox getLastChoice() {
        return lastChoice;
    }
}
