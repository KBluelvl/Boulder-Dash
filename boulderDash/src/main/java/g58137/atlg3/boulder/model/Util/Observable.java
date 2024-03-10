package g58137.atlg3.boulder.model.Util;

/**
 * Represents an observable interface.
 * @author Florian Essomba
 */
public interface Observable {

    /**
     * Register an observer.
     * @param observer a given observer.
     */
    void register(Observer observer);
}
