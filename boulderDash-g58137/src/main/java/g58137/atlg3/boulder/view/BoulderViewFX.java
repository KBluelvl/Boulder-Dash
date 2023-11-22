package g58137.atlg3.boulder.view;

import g58137.atlg3.boulder.model.Direction;
import g58137.atlg3.boulder.model.Facade;
import g58137.atlg3.boulder.model.Util.Observer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Represents the view of the boulder dash.
 * @author Florian Essomba
 */
public class BoulderViewFX extends Application implements Observer {
    private Facade facade;
    private StartScreen startScreen;
    private ChooseLevelFX chooseLevelFX;
    private HelpFX helpFX;
    private BoulderPane boulderPane;
    private Scoreboard scoreboard;
    private MenuFX menu;
    private Scene start;
    private Scene choose;
    private Scene help;
    private Scene game;
    private StackPane root;
    /**
     * Constructs a new BoulderViewFX which initializes the attributes.
     */
    public BoulderViewFX() {
        facade = new Facade();
        startScreen = new StartScreen();
        initChooseLevelFX();
        initHelpFX();
        initBoulderPane();
        initScoreBoard();
        initMenu();
        facade.register(this);
    }

    /**
     * The main entry point for all JavaFX applications.
     * @param stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Boulder dash");
        stage.getIcons().add(new Image("/images/3/rock.png"));
        boulderPane.display();
        scoreboard.displayMinDiamondsAndScore();
        scoreboard.displayDiamonds();
        scoreboard.displayTime();
        scoreboard.displayScore();
        initStart();
        initChoose();
        initHelp();
        initRoot();
        initGame();
        setOnMouseClickedStart(stage);
        setOnMouseClickedChoose(stage);
        setOnMouseClickedHelp(stage);
        setOnMouseClickedMenu(stage);

        game.addEventHandler(KeyEvent.KEY_PRESSED,(KeyEvent keyEvent) -> {
                if (!facade.endGame()) {
                    KeyCode code = keyEvent.getCode();

                    if (code == KeyCode.UP) {
                        if(!facade.getLevel().canCross(Direction.UP)) {
                            menu.displayCantMove();
                        } else {
                            facade.movePlayer(Direction.UP);
                        }
                    } else if (code == KeyCode.DOWN) {
                        if(!facade.getLevel().canCross(Direction.DOWN)) {
                            menu.displayCantMove();
                        } else {
                            facade.movePlayer(Direction.DOWN);
                        }
                    } else if (code == KeyCode.LEFT) {
                        if(!facade.getLevel().canCross(Direction.LEFT)) {
                            menu.displayCantMove();
                        } else {
                            facade.movePlayer(Direction.LEFT);
                        }
                    } else if (code == KeyCode.RIGHT) {
                        if(!facade.getLevel().canCross(Direction.RIGHT)) {
                            menu.displayCantMove();
                        } else {
                            facade.movePlayer(Direction.RIGHT);
                        }
                    } else if(code == KeyCode.N){
                        Stage stage1 = new Stage();
                        BoulderCopy boulderCopy1 = new BoulderCopy(facade);
                        Scene scene1 = new Scene(boulderCopy1);
                        stage1.setScene(scene1);
                        stage1.show();
                    }
                }
            if(facade.lose() && scoreboard.getChildren().size() != 1) {
                scoreboard.displayGameOver();
                menu.getChildren().clear();
            } else if(facade.endGame() && scoreboard.getChildren().size() != 1){
                scoreboard.displayWinMessage();
                menu.getChildren().clear();
            }
        });

        stage.setScene(start);
        stage.show();
        stage.setResizable(false);
    }



    /**
     * Initilizes the ChooseLevelFX attribute.
     */
    private void initChooseLevelFX(){
        chooseLevelFX = new ChooseLevelFX(facade);
    }

    /**
     * Initializes the helpFX attribute.
     */
    private void initHelpFX(){
        helpFX = new HelpFX();
        helpFX.setPadding(new Insets(32.4,151.5,10,11.5));
        helpFX.setSpacing(70);
    }

    /**
     * Initializes the scoreboard attribute.
     */
    private void initScoreBoard(){
        scoreboard = new Scoreboard(facade);
        scoreboard.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        scoreboard.setMaxHeight(scoreboard.getHeight());
        scoreboard.setTranslateY(-271);
    }

    /**
     * Initializes the menu attribute.
     */
    private void initMenu(){
        menu = new MenuFX(facade.getLevel());
        menu.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        menu.setTranslateY(542);
    }

    /**
     * initializes the start attribute.
     */
    private void initStart(){
        start = new Scene(startScreen);
        start.setFill(Color.BLACK);
    }

    /**
     * Initializes the choose attribute.
     */
    private void initChoose(){
        choose = new Scene(chooseLevelFX);
        choose.setFill(Color.BLACK);
    }

    /**
     * Initializes the help attribute.
     */
    private void initHelp(){
        help = new Scene(helpFX);
        help.setFill(Color.BLACK);
    }

    /**
     * Initializes the boulderPane attribute.
     */
    private void initBoulderPane(){
        boulderPane = new BoulderPane(facade);
        boulderPane.setTranslateY(32);
    }

    /**
     * Initializes the game attribute.
     */
    private void initGame(){
        game = new Scene(root);
        game.setFill(Color.BLACK);
        root.getChildren().addAll(boulderPane,scoreboard,menu);
    }

    /**
     * Initializes the root attribute.
     */
    private void initRoot(){
        root = new StackPane();
        root.setMinHeight(18*32+1);
    }

    /**
     * Sets event when mouse clicking on startScreen.
     * @param stage a given Stage.
     */
    private void setOnMouseClickedStart(Stage stage){
        startScreen.getFirstChoice().setOnMouseClicked(mouseEvent -> {
            stage.setScene(game);
            facade.resetGame();
        });
        startScreen.getSecondChoice().setOnMouseClicked(mouseEvent -> stage.setScene(choose));
        startScreen.getThirdChoice().setOnMouseClicked(mouseEvent -> stage.setScene(help));
        startScreen.getLastChoice().setOnMouseClicked(mouseEvent -> stage.close());
    }

    /**
     * Sets event when mouse is clicking on chooseLevelFX.
     * @param stage a given Stage.
     */
    private void setOnMouseClickedChoose(Stage stage){
        for (int i = 0; i < facade.getNumberOfLevels(); i++) {
            int levelNumber = i+1;
            chooseLevelFX.getChildren().get(i).setOnMouseClicked(mouseEvent -> {
                facade.goToLevel(levelNumber);
                stage.setScene(game);
            });
        }
        chooseLevelFX.getExit().setOnMouseClicked(mouseEvent -> stage.setScene(start));
    }

    /**
     * Sets event when mouse is clicking on helpFX.
     * @param stage a given Stage.
     */
    private void setOnMouseClickedHelp(Stage stage){
        helpFX.getExit().setOnMouseClicked(mouseEvent -> stage.setScene(start));
    }

    /**
     * Sets event when mouse is clicking on the menu.
     * @param stage a given Stage.
     */
    private void setOnMouseClickedMenu(Stage stage){
        menu.getUndo().setOnMouseClicked(mouseEvent -> facade.undo());
        menu.getRedo().setOnMouseClicked(mouseEvent -> facade.redo());
        menu.getGoToNextLevel().setOnMouseClicked(mouseEvent -> {
            try {
                facade.goToNextLevel(1);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        });

        menu.getGoToPreviousLevel().setOnMouseClicked(mouseEvent -> {
            try {
                facade.goToNextLevel(-1);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
        menu.getSurender().setOnMouseClicked(mouseEvent -> {
            stage.setScene(start);
            facade.resetGame();
        });
    }

    /**
     * Update the view.
     */
    @Override
    public void update() {
        boulderPane.display();
        scoreboard.displayMinDiamondsAndScore();
        scoreboard.displayDiamonds();
        scoreboard.displayScore();
        menu.initCurrentLevel();
    }

    public static void main(String[] args) {
        launch();
    }
}
