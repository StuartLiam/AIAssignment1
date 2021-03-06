// import org.junit.Before;
// import org.junit.Test;

// import java.util.ArrayList;

// import static junit.framework.TestCase.assertFalse;
// import static junit.framework.TestCase.assertTrue;

// public class ValidationTests {
//     private char[][]testBoard;
//     private ArrayList<Space> testList;
//     private Board singleLine;
//     @Before
//     public void setUp(){

//     }
//     @Test
//     public void bulbToTheLeftOfCurrentInvalidates(){
//         testBoard = new char[1][3];
//         testBoard[0][0]='b';
//         testBoard[0][1]='_';
//         testBoard[0][2]='b';
//         singleLine = new Board(testBoard);
//         assertFalse(singleLine.isRowValid(0,2));
//     }

//     @Test
//     public void bulbToTheRightOfCurrentInvalidates(){
//         testBoard = new char[1][3];
//         testBoard[0][0]='b';
//         testBoard[0][1]='_';
//         testBoard[0][2]='b';
//         singleLine = new Board(testBoard);
//         assertFalse(singleLine.isRowValid(0,0));
//     }

//     @Test
//     public void wallInBetweenBulbsIsValid(){
//         testBoard = new char[1][5];
//         testBoard[0][0]='b';
//         testBoard[0][1]='_';
//         testBoard[0][2]='3';
//         testBoard[0][3]='_';
//         testBoard[0][4]='b';
//         singleLine = new Board(testBoard);
//         assertTrue(singleLine.isRowValid(0,0));
//     }

//     @Test
//     public void checkWholeBoardIsInvalidNoWalls(){
//         testBoard = new char[1][3];
//         testBoard[0][0]='b';
//         testBoard[0][1]='_';
//         testBoard[0][2]='b';
//         testList = new ArrayList<>();
//         testList.add(new Space(0,0));
//         testList.add(new Space(0,2));
//         singleLine = new Board(testBoard);
//         assertFalse(singleLine.areBulbsValid(testList));
//     }

//     @Test
//     public void checkValidBoardCorrectly(){
//         testBoard = new char[1][5];
//         testBoard[0][0]='b';
//         testBoard[0][1]='_';
//         testBoard[0][2]='3';
//         testBoard[0][3]='_';
//         testBoard[0][4]='b';
//         testList = new ArrayList<>();
//         testList.add(new Space(0,0));
//         testList.add(new Space(0,4));
//         singleLine = new Board(testBoard);
//         assertTrue(singleLine.areBulbsValid(testList));
//     }

//     @Test
//     public void checkWallFull(){
//         testBoard = new char[3][3];
//         testBoard[0][0] = '_';
//         testBoard[0][1] = 'b';
//         testBoard[0][2] = '_';
//         testBoard[1][0] = 'b';
//         testBoard[1][1] = '4';
//         testBoard[1][2] = 'b';
//         testBoard[2][0] = '_';
//         testBoard[2][1] = 'b';
//         testBoard[2][2] = '_';
//         testList = new ArrayList<>();
//         testList.add(new Space(1,1));
//         singleLine = new Board(testBoard);
//         assertTrue(singleLine.areWallsValid(testList));
//     }

//     @Test
//     public void checkTomakeSureEdgesDontBreakThis(){
//         testBoard = new char[1][3];
//         testBoard[0][0]='b';
//         testBoard[0][1]='2';
//         testBoard[0][2]='b';
//         testList = new ArrayList<>();
//         testList.add(new Space(0,0));
//         testList.add(new Space(0,2));
//         singleLine = new Board(testBoard);
//         testList.add(new Space(0,1));
//         assertTrue(singleLine.areWallsValid(testList));
//     }
// }
