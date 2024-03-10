package g58137.atlg3.boulder.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Objects;

/**
 * A class with methode for my FX view.
 */
public class UtilFX {
    /**
     * Transform a text to imageView and add it to a HBox.
     * @param message a given message.
     * @param pane a given pane.
     */
    static void setLetterImage(String message, Pane pane){
        message = message.toLowerCase();
        String pathLetter;
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == ' '){
                pathLetter = "/images/lettresEtNombres/space.png";
            } else {
                pathLetter = "/images/lettresEtNombres/" + message.charAt(i) + ".png";
            }
            Image image = new Image(Objects.requireNonNull(UtilFX.class.getResourceAsStream(pathLetter)),32,16,true,true);
            ImageView imageView = new ImageView(image);
            pane.getChildren().add(imageView);
        }
    }

    /**
     * Take a given number and return an imageView in white corresponding.
     * @param number a given number.
     * @return an imageView in white corresponding to the given number.
     */
    static ImageView getImageWhiteNumber(int number) {
        char nb = (char) number;
        String pathNumber = "/images/numéro/" + nb + ".png";
        Image image = new Image(Objects.requireNonNull(UtilFX.class.getResourceAsStream(pathNumber)));
        return new ImageView(image);
    }

    /**
     * Take a given number and return an imageView in yellow corresponding.
     * @param number a given number.
     * @return an imageView in yellow corresponding to the given number.
     */
    static ImageView getImageYellowNumber(int number) {
        char nb = (char) number;
        String pathYellowNumber = "/images/numéro/yellow" + nb + ".png";
        Image image = new Image(Objects.requireNonNull(UtilFX.class.getResourceAsStream(pathYellowNumber)), 32, 32, true, true);
        return new ImageView(image);
    }
}
