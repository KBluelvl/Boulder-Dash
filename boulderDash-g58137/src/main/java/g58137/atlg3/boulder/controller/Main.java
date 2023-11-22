package g58137.atlg3.boulder.controller;

import g58137.atlg3.boulder.model.Direction;
import g58137.atlg3.boulder.model.Facade;
import g58137.atlg3.boulder.view.BoulderViewConsole;
import java.util.Scanner;

/**
 * Main class of the boulder dash console.
 * @author Florian Essomba
 */
public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        BoulderViewConsole view = new BoulderViewConsole();
        while (!facade.endGame()) {
            view.displayGame(facade.getLevel());
            view.displayDiamonds(facade.getLevel());
            view.displayControls();
            Scanner clavier = new Scanner(System.in);
            String input = clavier.nextLine();
            char move;
            if (!input.isBlank()) {
                if(input.equals("undo")){
                    facade.undo();
                } else if (input.equals("redo")) {
                    facade.redo();
                } else {
                    move = input.charAt(0);
                    if(move == Direction.UP.getDir()) {
                        facade.movePlayer(Direction.UP);
                    } else if (move == Direction.LEFT.getDir()) {
                        facade.movePlayer(Direction.LEFT);
                    } else if (move == Direction.DOWN.getDir()) {
                        facade.movePlayer(Direction.DOWN);
                    } else if (move == Direction.RIGHT.getDir()) {
                        facade.movePlayer(Direction.RIGHT);
                    }
                }
            }
        }
        view.displayGame(facade.getLevel());
        if(facade.lose()){
            view.displayLoseMessage();
        } else{
            view.displayWinMessage();
        }
    }
}
