package g58137.atlg3.boulder.model;

import java.util.Stack;

/**
 * Configure the command.
 * @author Florian Essomba
 */
public class CommandManager {
    private final Stack<Command> redoStack = new Stack<>();
    private final Stack<Command> undoStack = new Stack<>();

    /**
     * Cancel the previous command.
     */
    void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.unexecute();
            redoStack.push(command);
        }
    }
    /**
     * Do the command again.
     */
    void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

    /**
     * Add the command in the undoStack.
     * @param command a given command.
     */
    public void register(Command command){
        redoStack.clear();
        command.execute();
        undoStack.push(command);
    }

    /**
     * Clear all stacks.
     */
    void clear(){
        undoStack.clear();
        redoStack.clear();
    }

}
