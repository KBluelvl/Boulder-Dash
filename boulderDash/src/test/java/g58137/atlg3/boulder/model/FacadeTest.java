package g58137.atlg3.boulder.model;

import g58137.atlg3.boulder.model.element.Element;
import g58137.atlg3.boulder.model.element.Rock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    // undo ------------------------------------------------------------------------------------------------------------
    @Test
    void undoTestMoveUpPlayerPosition() {
        Facade facade = new Facade();
        facade.movePlayer(Direction.UP);
        facade.undo();
        Position result = facade.getLevel().getInfo().getPlayer().getPosition();
        Position expResult = new Position(3,19);
        assertEquals(expResult,result);
    }
    @Test
    void undoTestMoveDownPlayerPosition() {
        Facade facade = new Facade();
        facade.movePlayer(Direction.DOWN);
        facade.undo();
        Position result = facade.getLevel().getInfo().getPlayer().getPosition();
        Position expResult = new Position(3,19);
        assertEquals(expResult,result);
    }

    @Test
    void undoTestMoveUpLeftPlayerPosition() {
        Facade facade = new Facade();
        facade.movePlayer(Direction.UP);
        facade.movePlayer(Direction.LEFT);
        facade.undo();
        facade.undo();
        Position result = facade.getLevel().getInfo().getPlayer().getPosition();
        Position expResult = new Position(3,19);
        assertEquals(expResult,result);
    }
    @Test
    void undoTestMoveUpRightPlayerPosition() {
        Facade facade = new Facade();
        facade.movePlayer(Direction.UP);
        facade.movePlayer(Direction.RIGHT);
        facade.undo();
        facade.undo();
        Position result = facade.getLevel().getInfo().getPlayer().getPosition();
        Position expResult = new Position(3,19);
        assertEquals(expResult,result);
    }

    @Test
    void undoTestRockFallArray() {
        Facade facade = new Facade();
        facade.movePlayer(Direction.UP);
        facade.undo();
        Element result = facade.getLevel().getElements()[17][3];
        Class<?> expResult = Rock.class;
        assertInstanceOf(expResult,result);
    }
    // redo ------------------------------------------------------------------------------------------------------------
    @Test
    void testRedo() {
        Facade facade = new Facade();
        facade.movePlayer(Direction.UP);
        facade.movePlayer(Direction.RIGHT);
        facade.redo();
        Position result = facade.getLevel().getInfo().getPlayer().getPosition();
        Position expResult = new Position(4,20);
        assertEquals(expResult,result);
    }
    @Test
    void testUndoRedo() {
        Facade facade = new Facade();
        facade.movePlayer(Direction.UP);
        facade.movePlayer(Direction.RIGHT);
        facade.undo();
        facade.redo();
        Position result = facade.getLevel().getInfo().getPlayer().getPosition();
        Position expResult = new Position(4,20);
        assertEquals(expResult,result);
    }
    // movePlayer position ---------------------------------------------------------------------------------------------
    @Test
    void testMoveUpPlayerPosition(){
        Facade facade = new Facade();
        facade.movePlayer(Direction.UP);
        Position expResult = new Position(3,20);
        Position result = facade.getLevel().getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveDownPlayerPosition(){
        Facade facade = new Facade();
        facade.movePlayer(Direction.DOWN);
        Position expResult = new Position(3,18);
        Position result = facade.getLevel().getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveLeftPlayerPosition(){
        Facade facade = new Facade();
        facade.movePlayer(Direction.UP);
        facade.movePlayer(Direction.LEFT);
        Position expResult = new Position(2,20);
        Position result = facade.getLevel().getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveRightPlayerPosition(){
        Facade facade = new Facade();
        facade.movePlayer(Direction.UP);
        facade.movePlayer(Direction.RIGHT);
        Position expResult = new Position(4,20);
        Position result = facade.getLevel().getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    // changing level --------------------------------------------------------------------------------------------------
    @Test
    void testGoToNextLevel() {
        Facade facade = new Facade();
        facade.goToNextLevel(1);
        int result = facade.getLevelNumber();
        int expResult = 2;
        assertEquals(expResult,result);
    }

    @Test
    void testGoToLevel() {
        Facade facade = new Facade();
        facade.goToLevel(3);
        int result = facade.getLevelNumber();
        int expResult = 3;
        assertEquals(expResult,result);
    }
}