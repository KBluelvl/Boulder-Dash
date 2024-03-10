package g58137.atlg3.boulder.model;

/**
 * Represents a command.
 * @author Florian Essomba
 */
public interface Command {

    /**
     * The method that execute the Command.
     */
    void execute();

    /**
     * The method that unexecute the Command.
     */
    void unexecute();
}