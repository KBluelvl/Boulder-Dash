package g58137.atlg3.boulder.view;

import g58137.atlg3.boulder.model.Level;
import g58137.atlg3.boulder.model.Player;
import g58137.atlg3.boulder.model.element.*;
import static g58137.atlg3.boulder.model.ColoredChar.setColor;

/**
 * Represents a view of the console.
 * @author Florian Essomba
 */
public class BoulderViewConsole {

    /**
     * Display the game (Element[][]).
     */
    public void displayGame(Level level){
        for (int i = level.getElements().length-1; i >= 0; i--) {
            for (int j = 0; j < level.getElements()[i].length; j++) {
                if(level.getElements()[i][j] instanceof Diamond){
                    System.out.print(setColor('d'));
                } else if(level.getElements()[i][j] instanceof EmptyTile){
                    System.out.print(setColor(' '));
                } else if(level.getElements()[i][j] instanceof Ground){
                    System.out.print(setColor('s'));
                } else if(level.getElements()[i][j] instanceof Player){
                    System.out.print(setColor('i'));
                } else if(level.getElements()[i][j] instanceof Rock){
                    System.out.print(setColor('r'));
                } else if(level.getElements()[i][j] instanceof Wall){
                    System.out.print(setColor('w'));
                } else if(level.getElements()[i][j] instanceof Exit){
                    System.out.print(setColor('e'));
                }
            }
            System.out.println();
        }
    }
    /**
     * Show the control keys.
     */
    public void displayControls(){
        System.out.println("use : z,q,s,d,undo,redo ");
    }
    /**
     * Display a message saying that you win the game.
     */
    public void displayWinMessage(){
        System.out.println("Vous avez gagner !");
    }

    /**
     * Display a message saying that you have lost the game.
     */
    public void displayLoseMessage(){
        System.out.println("Vous avez perdu !");
    }

    /**
     * Display the number of diamond.
     * @param level a given Level.
     */
    public void displayDiamonds(Level level){
        System.out.print("Vous avez "+level.getCurrDiamonds()+" diamant(s). ");

        if(level.getMinDiamonds() - level.getCurrDiamonds() >= 0){
            System.out.print("Vous devez avoir "+(level.getMinDiamonds() - level.getCurrDiamonds())+" diamants pour ouvrir la porte\n");
        } else {
            System.out.print("la porte est ouverte !");
        }
    }
}
