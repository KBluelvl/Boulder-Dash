package g58137.atlg3.boulder.view;

import g58137.atlg3.boulder.model.Facade;
import g58137.atlg3.boulder.model.Level;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import java.util.Objects;

import static g58137.atlg3.boulder.view.UtilFX.*;

/**
 * Represents the Bar above the game.
 * @author Florian Essomba
 */
public class Scoreboard extends HBox {
    private final Image object1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/object1.png")),32,32,true,true);
    private Level level;
    private HBox diamondsAndScore;
    private HBox diamonds;
    private HBox time;
    private HBox score;

    /**
     * Constructs a new Scoreboard which initializes the level, diamondsAndScore, diamonds, time and score attribute.
     * @param facade a given Facade
     */
    public Scoreboard(Facade facade) {
        this.level = facade.getLevel();
        diamondsAndScore = new HBox();
        diamonds = new HBox();
        time = new HBox();
        score = new HBox();
        HBox.setMargin(diamondsAndScore,new Insets(0,131,0,0));
        HBox.setMargin(diamonds,new Insets(0,131,0,0));
        HBox.setMargin(time,new Insets(0,185,0,0));
        this.getChildren().add(diamondsAndScore);
        this.getChildren().add(diamonds);
        this.getChildren().add(time);
        this.getChildren().add(score);
    }

    /**
     * Display the minimum of diamonds required and the score value for a diamond.
     */
    public void displayMinDiamondsAndScore() {
        diamondsAndScore.getChildren().clear();
        ImageView imageView;
        if(!level.canExit()) {
            String minDiamonds = Integer.toString(level.getMinDiamonds());
            for (int i = 0; i < minDiamonds.length(); i++) {
                diamondsAndScore.getChildren().add(getImageYellowNumber(minDiamonds.charAt(i)));
            }
            diamondsAndScore.getChildren().add(new ImageView(object1));
            String diamondValue = Integer.toString(level.getDiamondValue());
            for (int i = 0; i < diamondValue.length(); i++) {
                imageView = getImageWhiteNumber(diamondValue.charAt(i));
                diamondsAndScore.getChildren().add(imageView);
            }
        } else {
            String bonusDiamondValue = Integer.toString(level.getBonusDiamondValue());
            for (int i = 0; i < 3; i++) {
                diamondsAndScore.getChildren().add(new ImageView(object1));
            }
            for (int i = 0; i < bonusDiamondValue.length(); i++) {
                imageView = getImageWhiteNumber(bonusDiamondValue.charAt(i));
                diamondsAndScore.getChildren().add(imageView);
            }
        }
    }

    /**
     * Display the current number of diamond(s) that the player has.
     */
    public void displayDiamonds(){
        diamonds.getChildren().clear();
        String currDiamonds = Integer.toString(level.getCurrDiamonds());
        if(currDiamonds.length() == 1){
            diamonds.getChildren().add(getImageYellowNumber('0'));
        }
        for (int i = 0; i < currDiamonds.length(); i++) {
            diamonds.getChildren().add(getImageYellowNumber(currDiamonds.charAt(i)));
        }
    }

    /**
     * Display the time.
     */
    public void displayTime(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e ->{
            if(level.getSeconds() != 0){
                time.getChildren().clear();
                level.decSeconds();
                String timeStr = Integer.toString(level.getSeconds());
                if(timeStr.length() < 2){
                    time.getChildren().add(getImageWhiteNumber('0'));
                    time.getChildren().add(getImageWhiteNumber('0'));
                } else if (timeStr.length() < 3) {
                    time.getChildren().add(getImageWhiteNumber('0'));
                }
                for (int i = 0; i < timeStr.length(); i++) {
                    time.getChildren().add(getImageWhiteNumber(timeStr.charAt(i)));
                }
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * Display the score.
     */
    public void displayScore(){
        score.getChildren().clear();
        String scoreValue = Integer.toString(level.getScore());
        switch (scoreValue.length()){
            case 1:
                score.getChildren().add(getImageWhiteNumber('0'));
                score.getChildren().add(getImageWhiteNumber('0'));
                score.getChildren().add(getImageWhiteNumber('0'));
                score.getChildren().add(getImageWhiteNumber('0'));
                score.getChildren().add(getImageWhiteNumber('0'));
                break;
            case 2:
                score.getChildren().add(getImageWhiteNumber('0'));
                score.getChildren().add(getImageWhiteNumber('0'));
                score.getChildren().add(getImageWhiteNumber('0'));
                score.getChildren().add(getImageWhiteNumber('0'));
                break;
            case 3:
                score.getChildren().add(getImageWhiteNumber('0'));
                score.getChildren().add(getImageWhiteNumber('0'));
                score.getChildren().add(getImageWhiteNumber('0'));
                break;
            case 4:
                score.getChildren().add(getImageWhiteNumber('0'));
                score.getChildren().add(getImageWhiteNumber('0'));
            case 5:
                score.getChildren().add(getImageWhiteNumber('0'));
        }
        for (int i = 0; i < scoreValue.length(); i++) {
            score.getChildren().add(getImageWhiteNumber(scoreValue.charAt(i)));
        }
    }

    /**
     * Display a message saying that you have lost the game.
     */
    public void displayGameOver(){
        this.getChildren().clear();
        HBox hbox = new HBox();
        setLetterImage("game over",hbox);
        HBox.setMargin(hbox,new Insets(10,0,10,350));//v0:haut v1:droite v2:bas v3:gauche
        this.getChildren().add(hbox);
    }
    /**
     * Display a message saying that you win the game.
     */
    public void displayWinMessage(){
        this.getChildren().clear();
        HBox hbox = new HBox();
        setLetterImage("you win",hbox);
        HBox.setMargin(hbox,new Insets(10,0,10,350));//v0:haut v1:droite v2:bas v3:gauche
        this.getChildren().add(hbox);
    }
}


