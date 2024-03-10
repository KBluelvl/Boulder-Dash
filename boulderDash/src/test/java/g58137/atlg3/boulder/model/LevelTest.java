package g58137.atlg3.boulder.model;

import g58137.atlg3.boulder.model.element.Diamond;
import g58137.atlg3.boulder.model.element.Element;
import g58137.atlg3.boulder.model.element.Rock;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LevelTest {
    // player position -------------------------------------------------------------------------------------------------
    @Test
    void testMoveUpPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.UP);
        Position expResult = new Position(3,20);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveDownPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        Position expResult = new Position(3,18);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveLeftPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.LEFT);
        Position expResult = new Position(2,20);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveRightPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.RIGHT);
        Position expResult = new Position(4,20);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveUpButRockBlockPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.UP);
        Position expResult = new Position(2,18);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveDownButRockBlockPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.DOWN);
        Position expResult = new Position(4,20);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveLeftButRockBlockPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.LEFT);
        Position expResult = new Position(3,19);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }

    @Test
    void testMoveRightButRockBlockPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.RIGHT);
        Position expResult = new Position(3,19);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveUpButDiamondsPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.UP);
        Position expResult = new Position(10,20);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveDownButDiamondsPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(2);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.DOWN);
        Position expResult = new Position(19,2);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveLeftButDiamondsPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(2);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.LEFT);
        Position expResult = new Position(19,5);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveRightButDiamondsPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(2);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.RIGHT);
        Position expResult = new Position(19,2);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveUpButWallBlockPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.UP);
        Position expResult = new Position(3,20);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveDownButWallBlockPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(2);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.RIGHT);
        Position expResult = new Position(19,2);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveLeftButWallBlockPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(2);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        Position expResult = new Position(17,2);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testMoveRightButWallBlockPlayerPosition(){
        LevelLoader levelLoader = new LevelLoader(3);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.RIGHT);
        Position expResult = new Position(3,19);
        Position result = level.getInfo().getPlayer().getPosition();
        assertEquals(expResult,result);
    }
    // player array ----------------------------------------------------------------------------------------------------
    @Test
    void testPlayerMoveUp(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.UP);
        boolean result = level.getElements()[6][5] instanceof Player;
        if(!result){
            System.out.println("testPlayerMoveUp : "+level.getElements()[6][5].getClass());
        }
        assertTrue(result);
    }
    @Test
    void testPlayerMoveLeft(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.LEFT);
        boolean result = level.getElements()[5][4] instanceof Player;
        if(!result){
            System.out.println("testPlayerMoveLeft : "+level.getElements()[5][4].getClass());
        }
        assertTrue(result);
    }
    @Test
    void testPlayerMoveRight(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.RIGHT);
        boolean result = level.getElements()[5][6] instanceof Player;
        if(!result){
            System.out.println("testPlayerMoveRight : "+level.getElements()[5][6].getClass());
        }
        assertTrue(result);
    }
    @Test
    void testPlayerMoveDown(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        boolean result = level.getElements()[4][5] instanceof Player;
        if(!result){
            System.out.println("testPlayerMoveDown : "+level.getElements()[4][5].getClass());
        }
        assertTrue(result);
    }
    @Test
    void testPlayerMoveUpButBlock(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.UP);
        boolean result = level.getElements()[4][2] instanceof Player;
        if(!result){
            System.out.println("testPlayerMoveUpButBlock : "+level.getElements()[4][2].getClass());
        }
        assertTrue(result);
    }
    @Test
    void testPlayerMoveRightButDiamond(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.RIGHT);
        boolean result = level.getElements()[5][7] instanceof Player;
        if(!result){
            System.out.println("testPlayerMoveRightButDiamond : "+level.getElements()[5][7].getClass());
        }
        assertTrue(result);
    }

    // move tile position ----------------------------------------------------------------------------------------------

    @Test
    void testPushRockLeftPosition(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        Position result = new Position(4,3);
        Position expResult = level.getElements()[3][4].getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testPushRockRightPosition(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.RIGHT);
        Position result = new Position(6,3);
        Position expResult = level.getElements()[3][6].getPosition();
        assertEquals(expResult,result);
    }

    @Test
    void testRockFallDownPosition(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        Position result = new Position(2,4);
        Position expResult = level.getElements()[4][2].getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testRockFallDownRollLeftPosition(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.UP);
        Position result = new Position(1,4);
        Position expResult = level.getElements()[4][1].getPosition();
        assertEquals(expResult,result);
    }
    @Test
    void testRockRollRightPosition(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.UP);
        Position result = new Position(3,5);
        Position expResult = level.getElements()[5][3].getPosition();
        assertEquals(expResult,result);
    }

    // move tile array -------------------------------------------------------------------------------------------------
    @Test
    void testPushRockLeftArray(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        Element result = level.getElements()[3][4];
        Class<?> expResult = Rock.class;
        assertInstanceOf(expResult,result);
    }
    @Test
    void testPushRockRightArray(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.RIGHT);
        Element result = level.getElements()[3][6];
        Class<?> expResult = Rock.class;
        assertInstanceOf(expResult,result);
    }

    @Test
    void testFallRocksDownArray(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        Element expResult = level.getElements()[17][3];
        level.movePlayer(Direction.UP);
        Element result = level.getElements()[16][3];
        assertEquals(expResult,result);
    }
    @Test
    void testFallRocksLeftDownArray(){
        LevelLoader levelLoader = new LevelLoader(2);
        Level level = new Level(levelLoader.getLevelInfo());
        Element expResult = level.getElements()[3][21];
        level.movePlayer(Direction.UP);
        Element result = level.getElements()[1][20];
        assertEquals(expResult,result);
    }
    @Test
    void testRocksPushRightFallDownRollLeftFallDownArray(){
        LevelLoader levelLoader = new LevelLoader(2);
        Level level = new Level(levelLoader.getLevelInfo());
        Boolean expResult = level.getElements()[11][19] instanceof Rock;
        level.movePlayer(Direction.RIGHT);
        for (int i = 0; i < 5; i++) {
            level.movePlayer(Direction.UP);
        }
        level.movePlayer(Direction.RIGHT);
        for (int i = 0; i < 5; i++) {
            level.movePlayer(Direction.UP);
        }
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.RIGHT);
        boolean result = level.getElements()[2][19] instanceof Rock;
        assertEquals(expResult,result);
    }
    @Test
    void testFallRocksDownRollRightFallDownRollRightFallDownArray(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        Element expResult = level.getElements()[19][4];
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        Element result = level.getElements()[15][6];
        assertEquals(expResult,result);
    }
    @Test
    void testRockDonNotMoveWhenRightIsEmpty(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        Element result = level.getElements()[6][2];
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.RIGHT);
        Element expResult = level.getElements()[6][2];
        assertEquals(expResult,result);
    }
    @Test
    void testRockDonNotMoveWhenLeftIsEmpty(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        Element result = level.getElements()[6][2];
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.UP);
        Element expResult = level.getElements()[6][2];
        assertEquals(expResult,result);
    }

    // player dead -----------------------------------------------------------------------------------------------------
    @Test
    void testIsDeadByRockFallingDown(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.DOWN);
        Boolean expResult = false;
        Boolean result = level.getPlayerLife();
        assertEquals(expResult,result);
    }
    @Test
    void testIsDeadByRockFallingFromHigh(){
        LevelLoader levelLoader = new LevelLoader(3);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.DOWN);
        Boolean expResult = false;
        Boolean result = level.getPlayerLife();
        assertEquals(expResult,result);
    }
    @Test
    void testIsDeadByRockRollingRight(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.DOWN);;
        level.movePlayer(Direction.DOWN);
        Boolean expResult = false;
        Boolean result = level.getPlayerLife();
        assertEquals(expResult,result);
    }
    @Test
    void testIsDeadByRockRollingLeft(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        for (int i = 0; i < 10; i++) {
            level.movePlayer(Direction.RIGHT);
        }
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.DOWN);
        Boolean expResult = false;
        Boolean result = level.getPlayerLife();
        assertEquals(expResult,result);
    }
    @Test
    void testIsDeadByDiamondFallingDown(){
        LevelLoader levelLoader = new LevelLoader(2);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.DOWN);
        Boolean expResult = false;
        Boolean result = level.getPlayerLife();
        assertEquals(expResult,result);
    }
    @Test
    void testIsDeadByDiamondFallingFromHigh(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.UP);
        for (int i = 0; i < 6; i++) {
            level.movePlayer(Direction.RIGHT);
        }
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.DOWN);
        Boolean expResult = false;
        Boolean result = level.getPlayerLife();
        assertEquals(expResult,result);
    }
    @Test
    void testIsDeadByDiamondRollingRight(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.UP);
        for (int i = 0; i < 6; i++) {
            level.movePlayer(Direction.RIGHT);
        }
        level.movePlayer(Direction.DOWN);
        for (int i = 0; i < 4; i++) {
            level.movePlayer(Direction.RIGHT);
        }
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.LEFT);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.DOWN);
        Boolean expResult = false;
        Boolean result = level.getPlayerLife();
        assertEquals(expResult,result);
    }
    @Test
    void testIsDeadByDiamondRollingLeft(){
        LevelLoader levelLoader = new LevelLoader(4);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.DOWN);
        Boolean result = level.getPlayerLife();
        assertFalse(result);
    }

    // player killer ---------------------------------------------------------------------------------------------------
    @Test void playerKillerIsRockByFallingDownOnPlayerTest(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.DOWN);
        boolean result;
        if(level.getElements()[17][4] instanceof Rock rock){
            result = rock.isPlayerKiller();
        } else {
            result = false;
        }
        assertTrue(result);
    }
    @Test void isNotPlayerKiller1Test(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.RIGHT);
        boolean result;
        Rock rock = (Rock) level.getElements()[19][4];
        result = rock.isPlayerKiller();
        assertFalse(result);
    }
    @Test void isNotPlayerKiller2Test(){
        LevelLoader levelLoader = new LevelLoader(1);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.DOWN);
        level.movePlayer(Direction.RIGHT);
        boolean result;
        if(level.getElements()[19][4] instanceof Rock rock){
            result = rock.isPlayerKiller();
        } else {
            result = false;
        }
        assertFalse(result);
    }
    @Test void playerKillerIsDiamondTest(){
        LevelLoader levelLoader = new LevelLoader(2);
        Level level = new Level(levelLoader.getLevelInfo());
        level.movePlayer(Direction.RIGHT);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.UP);
        level.movePlayer(Direction.DOWN);
        boolean result;
        if(level.getElements()[3][19] instanceof Diamond diamond){
            result = diamond.isPlayerKiller();
        } else {
            result = false;
            System.out.println("Tile : "+level.getElements()[3][19].toString());
        }
        assertTrue(result);
    }
}