package g58137.atlg3.boulder.model;

/**
 * Represents a colored character.
 * @author Florian Essomba
 */
public class ColoredChar {
    private static final String TEXT_RESET  = "\u001B[0m";
    private static final String TEXT_BG_BLACK  = "\u001B[40m";// empty
    private static final String TEXT_BG_YELLOW = "\u001B[43m";// ground
    private static final String TEXT_BG_BLUE   = "\u001B[44m";// diamond
    private static final String TEXT_BG_WHITE  = "\u001B[47m";// rock
    private static final String TEXT_BRIGHT_BG_BLACK  = "\u001B[100m";// wall
    private static final String TEXT_BRIGHT_BG_GREEN  = "\u001B[102m";// player
    private static final String TEXT_BG_RED    = "\u001B[41m";// exit

    /**
     * Add color to a character.
     * @param letter a given character.
     * @return a colored character as a string.
     */
    public static String setColor(char letter){
        return switch (letter) {
            case 's' -> TEXT_BG_YELLOW + " " + letter + " " + TEXT_RESET;
            case ' ' -> TEXT_BG_BLACK + " " + letter + " " + TEXT_RESET;
            case 'd' -> TEXT_BG_BLUE + " " + letter + " " + TEXT_RESET;
            case 'i' -> TEXT_BRIGHT_BG_GREEN + " " + letter + " " + TEXT_RESET;
            case 'w' -> TEXT_BRIGHT_BG_BLACK + " " + letter + " " + TEXT_RESET;
            case 'r' -> TEXT_BG_WHITE + " " + letter + " " + TEXT_RESET;
            case 'e' -> TEXT_BG_RED + " " + letter + " " + TEXT_RESET;
            default -> " " + letter + " ";
        };
    }
}
