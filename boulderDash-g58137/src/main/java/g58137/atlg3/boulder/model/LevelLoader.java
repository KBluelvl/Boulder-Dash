package g58137.atlg3.boulder.model;

import g58137.atlg3.boulder.model.element.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Load a level.
 * @author Florian Essomba
 */
public class LevelLoader {
    private LevelInfo levelInfo;
    private int levelNumber;
    private Player player;
    private Exit exit;
    private final int numberOfLevels;


    /**
     * Constructs a new LevelLoader which initializes the attributes with a given number.
     * @param levelNumber a given number.
     */
    public LevelLoader(int levelNumber){
        File file = new File(Objects.requireNonNull(getClass().getResource("/Levels")).getPath());
        numberOfLevels = file.list().length;
        if(levelNumber > numberOfLevels) {
            throw new IllegalArgumentException("There is no level over "+levelNumber+".");
        } else if(levelNumber < 1) {
            throw new IllegalArgumentException("There is no level below level 1.");
        }
        this.levelNumber = levelNumber;
        initLevelInfo();
    }

    /**
     * Init the levelInfo attribute.
     */
    private void initLevelInfo() {
        int minDiamonds = 0;
        int diamondValue = 0;
        int bonusDiamondValue = 0;
        int timeMax = 0;
        String path = "/Levels/Level" + levelNumber;
        List<String> dataList = new ArrayList<>();
        int b;
        char c;
        Element[][] elements = new Element[0][];
        try (InputStream in = LevelLoader.class.getResourceAsStream(path)) {
            getInformation(dataList,in);
            // set information
            minDiamonds = Integer.parseInt(dataList.get(3));
            diamondValue = Integer.parseInt(dataList.get(6));
            bonusDiamondValue = Integer.parseInt(dataList.get(10));
            timeMax = Integer.parseInt(dataList.get(12));
            elements = new Element[Integer.parseInt(dataList.get(14))][Integer.parseInt(dataList.get(16))];
            int i = elements.length - 1;
            int j = 0;
            do { // get the level from the file.
                b = in.read();
                c = (char) b;
                if (isSquare(c)) {
                    if (j == elements[i].length) {
                        j = 0;
                        i--;
                    }
                    elements[i][j] = getSquare(c, new Position(j, i));
                    j++;
                }
            } while (b != -1);
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
        levelInfo = new LevelInfo(levelNumber, elements, player, exit, minDiamonds,
                diamondValue, bonusDiamondValue, timeMax, numberOfLevels);
    }

    /**
     * Gets the information from the file.
     * @param dataList a given List of string
     * @param in a given inputStream
     */
    private void getInformation(List<String> dataList,InputStream in) throws IOException {
        String data = "";
        int b;
        char c;
        do {
            b = in.read();
            c = (char) b;
            if (c != ' ' && c != '\r') {
                data += c;
            } else {
                dataList.add(data);
                data = "";
                if (c == '\r') {
                    in.read();
                }
            }
        } while (!data.equals("end"));
    }

    /**
     * Gets an Element from a given character.
     * @param nameSquare a given character.
     * @param position a given position.
     * @return an element.
     */
    private Element getSquare(char nameSquare, Position position) {
        switch (nameSquare){
            case 'd': return new Diamond(position);
            case 'w': return new Wall(position);
            case 's': return new Ground(position);
            case 'r': return new Rock(position);
            case 'i': player = new Player(position);
                return player;
            case 'e': exit = new Exit(position);
                return exit;
            default: return new EmptyTile(position);
        }
    }

    /**
     * Show if it is a good character.
     * @param nameSquare a given character.
     * @return a boolean.
     */
    private boolean isSquare(char nameSquare){
        return nameSquare == 'd' || nameSquare == 'w' || nameSquare == 's'
                || nameSquare == 'r' || nameSquare == 'i'
                || nameSquare == 'e' || nameSquare == ' ';
    }

    /**
     * Return the levelInfo attribute.
     * @return the levelInfo attribute.
     */
    public LevelInfo getLevelInfo() {
        return levelInfo;
    }

    /**
     * Return the number of levels in the game.
     * @return the number of levels in the game.
     */
    public int getNumberOfLevels() {
        return numberOfLevels;
    }
}
