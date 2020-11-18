package aBigProjects.battleship;
/*
Battleship (also called Battleships or Sea Battle) is a two-player strategy game whose history traces back
to the First World War. It started off as a pencil and paper game, until Milton Bradley coined the rules and published
the game. Fun fact: it was one of the first games to be produced as a computer game in 1979! In this project, we will
recreate this timeless classic.

First off, brush up on the rules of the game(https://en.wikipedia.org/wiki/Battleship_(game)).
There are different variations of the Battleship game, but we will
stick to the original rules written by Milton Bradley. You have a 10×10 game field and five ships to arrange on
that field. The ships can be placed horizontally or vertically but not diagonally across the grid spaces; the ships
should not cross or touch each other. The goal is to sink all the ships of the opponent before your opponent
does this to you.
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //create two battle fields
        BattleField bf1 = new BattleField("1");
        BattleField bf2 = new BattleField("2");

        //fill constant position of ships
/*        String[][] squadron1 = new String[5][2];
        squadron1[0][0] = "F3";
        squadron1[0][1] = "F7";
        squadron1[1][0] = "A1";
        squadron1[1][1] = "D1";
        squadron1[2][0] = "J10";
        squadron1[2][1] = "J8";
        squadron1[3][0] = "B9";
        squadron1[3][1] = "D9";
        squadron1[4][0] = "I2";
        squadron1[4][1] = "J2";

        String[][] squadron2 = new String[5][2];
        squadron2[0][0] = "H2";
        squadron2[0][1] = "H6";
        squadron2[1][0] = "F3";
        squadron2[1][1] = "F6";
        squadron2[2][0] = "H8";
        squadron2[2][1] = "F8";
        squadron2[3][0] = "D4";
        squadron2[3][1] = "D6";
        squadron2[4][0] = "C8";
        squadron2[4][1] = "D8";*/


        // fill both fields
        bf1.placeShips(null);
//        bf1.placeShips(squadron1);
        promptEnterKey();
        bf2.placeShips(null);
//        bf2.placeShips(squadron2);

        //start battle
        boolean battleGameContinue = true;
        BattleField currBF = bf2;
        String opponentName = bf1.getPlayerName();

        while (battleGameContinue) {
            promptEnterKey();
            if (currBF.getPlayerName().equals(bf1.getPlayerName()))
                printBothFields(bf1, bf2);
            else
                printBothFields(bf2, bf1);

            // hit to ships
            currBF.hitShip(opponentName);
            if (currBF.isTheLastShipIsSank()) {
                System.out.println("You sank the last ship. You won. Congratulations!");
                battleGameContinue = false;
            } else { // change gamers
                if (currBF.getPlayerName().equals(bf1.getPlayerName())) {
                    currBF = bf2;
                    opponentName = bf1.getPlayerName();
                } else {
                    currBF = bf1;
                    opponentName = bf2.getPlayerName();
                }
            }

        }
    }

    private static void printBothFields(BattleField hideBF, BattleField realBF) {
        hideBF.printWithFog();
        System.out.println("---------------------");
        realBF.print();
        System.out.println();
    }

    public static void promptEnterKey() {
        System.out.print("Press Enter and pass the move to another player");
        try {
            System.in.read();
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Ship {
    private final String name;
    private final int shipSize;
    private Point begPos;
    private Point endPos;
    Map<Point, Character> shipPosition;

    public Ship(String name, int shipSize) {
        this.name = name;
        this.shipSize = shipSize;
        shipPosition = new HashMap<>(shipSize);
    }

    public String getName() {
        return name;
    }

    public int getShipSize() {
        return shipSize;
    }

    public Point getBegPos() {
        return begPos;
    }

    public void setBegPos(Point begPos) {
        this.begPos = begPos;
    }

    public Point getEndPos() {
        return endPos;
    }

    public void setEndPos(Point endPos) {
        this.endPos = endPos;
    }

    public Boolean isDead(Character liveChar) {
        for (Map.Entry<Point, Character> pointCharacterEntry : shipPosition.entrySet()) {
            if (pointCharacterEntry.getValue().equals(liveChar))
                return false;
        }
        return true;
    }

    public void addShipPosition(Point point, Character liveChar) {
        shipPosition.put(point, liveChar);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", sizeCell=" + shipSize +
                '}';
    }
}

class Point {
    private final int row;
    private final int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row &&
                col == point.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

class BattleField {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int SIZE_FIELD = 10;
    public static final int NUM_OF_SHIPS = 5;
    private static final char START_LETTER = 'A';
    private static final char MISS = 'M';
    private static final char SHIP = 'O';
    private static final char HIT = 'X';
    private static final char FOG = '~';
    private Ship[] ships;
    private char[][] field;
    private final String playerName;

    public BattleField(String thePlayerName) {
        this.playerName = thePlayerName;
        initField();
        initShips();
    }

    public String getPlayerName() {
        return playerName;
    }

    private void initField() {
        field = new char[SIZE_FIELD][SIZE_FIELD];
        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                field[i][j] = FOG;
            }
        }
    }

    public void initShips() {
        ships = new Ship[NUM_OF_SHIPS];
        ships[0] = new Ship("Aircraft Carrier", 5);
        ships[1] = new Ship("Battleship", 4);
        ships[2] = new Ship("Submarine", 3);
        ships[3] = new Ship("Cruiser", 3);
        ships[4] = new Ship("Destroyer", 2);
    }

    public void print() {
        System.out.print(" ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < SIZE_FIELD; i++) {
            System.out.print((char) (i + (int) START_LETTER));
            for (int j = 0; j < SIZE_FIELD; j++) {
                System.out.print(" " + field[i][j]);
            }
            System.out.println();
        }
    }

    public void printWithFog() {
        System.out.print(" ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < SIZE_FIELD; i++) {
            System.out.print((char) (i + (int) START_LETTER));
            for (int j = 0; j < SIZE_FIELD; j++) {
                if (field[i][j] != SHIP)
                    System.out.print(" " + field[i][j]);
                else
                    System.out.print(" " + FOG);
            }
            System.out.println();
        }
    }

    public Ship getShip(int ind) {
        return ships[ind];
    }

    public void placeShips(String[][] squadron) {
        int curShip = 0;
        String error = null;
        System.out.printf("Player %s, place your ships on the game field\n", playerName);
        System.out.println();
        print();
        while (curShip < NUM_OF_SHIPS) {
            String[] shipPosition;
            if (squadron == null) { //real game
                shipPosition = scanForShipPosition(getShip(curShip), error);
                error = putShipOnField(getShip(curShip), curShip, shipPosition);
            } else { //for test
                for (String[] currShip : squadron) {
                    putShipOnField(getShip(curShip), curShip, currShip);
                    curShip++;
                }
                return;
            }

            if (error == null) {
                curShip++;
                print();
            } else {
                System.out.println(error);
            }
        }

    }

    private String[] scanForShipPosition(Ship curShip, String error) {
        if (error == null) {
            System.out.printf("Enter the coordinates of the %s (%d cells):\n"
                    , curShip.getName()
                    , curShip.getShipSize()
            );
        }
        System.out.println();
        String[] shipPosition = scanner.nextLine().split("\\s+");
        System.out.println();

        return shipPosition;
    }

    private String putShipOnField(Ship curShip, int indexOfShip, String[] shipPosition) {


        curShip.setBegPos(new Point(convertToInt(shipPosition[0].substring(0, 1)), Integer.parseInt(shipPosition[0].substring(1)) - 1));
        curShip.setEndPos(new Point(convertToInt(shipPosition[1].substring(0, 1)), Integer.parseInt(shipPosition[1].substring(1)) - 1));

        int lenByRow = Math.abs(curShip.getEndPos().getRow() - curShip.getBegPos().getRow()) + 1;
        int lenByCol = Math.abs(curShip.getEndPos().getCol() - curShip.getBegPos().getCol()) + 1;

        if (curShip.getShipSize() != lenByRow && curShip.getShipSize() != lenByCol) { // ship len incorrect
            return String.format("Error! Wrong length of the %s! Try again:", curShip.getName());
        } else if (lenByCol != 1 && lenByRow != 1) { // try put ship by diagonal
            return "Error! Wrong ship location! Try again:";
        } //out of the field
        if (curShip.getBegPos().getRow() >= SIZE_FIELD || curShip.getBegPos().getRow() < 0
                || curShip.getBegPos().getCol() >= SIZE_FIELD || curShip.getBegPos().getCol() < 0
                || curShip.getEndPos().getRow() >= SIZE_FIELD || curShip.getEndPos().getRow() < 0
                || curShip.getEndPos().getCol() >= SIZE_FIELD || curShip.getEndPos().getCol() < 0
        ) {
            return "Error! Wrong ship location! Try again:";
        } else if (isTooCloseToAnotherShip(curShip)) { //check too close to another ship
            return "Error! You placed it too close to another one. Try again:";
        } else {
            installShip(curShip, indexOfShip);
            return null;
        }
    }

    private void installShip(Ship curShip, int indexOfShip) {
        int leftRow;
        int leftCol;
        int rightRow;
        int rightCol;
        if (curShip.getBegPos().getRow() > curShip.getEndPos().getRow()) {
            rightRow = curShip.getBegPos().getRow();
            leftRow = curShip.getEndPos().getRow();
        } else {
            leftRow = curShip.getBegPos().getRow();
            rightRow = curShip.getEndPos().getRow();
        }
        if (curShip.getBegPos().getCol() > curShip.getEndPos().getCol()) {
            rightCol = curShip.getBegPos().getCol();
            leftCol = curShip.getEndPos().getCol();
        } else {
            leftCol = curShip.getBegPos().getCol();
            rightCol = curShip.getEndPos().getCol();
        }
        for (int i = leftRow; i <= rightRow; i++) {
            for (int j = leftCol; j <= rightCol; j++) {
                field[i][j] = SHIP;
                ships[indexOfShip].addShipPosition(new Point(i, j), SHIP);
            }
        }
    }

    // return true if too close to another ship
    private boolean isTooCloseToAnotherShip(Ship curShip) {
        int leftRow = 0;
        int leftCol = 0;
        int rightRow;
        int rightCol;
        if (curShip.getBegPos().getRow() >= curShip.getEndPos().getRow()) {
            if (curShip.getBegPos().getRow() == SIZE_FIELD - 1)
                rightRow = SIZE_FIELD - 1;
            else
                rightRow = curShip.getBegPos().getRow() + 1;
            if (curShip.getEndPos().getRow() != 0)
                leftRow = curShip.getEndPos().getRow() - 1;
        } else {
            if (curShip.getEndPos().getRow() == SIZE_FIELD - 1)
                rightRow = SIZE_FIELD - 1;
            else
                rightRow = curShip.getEndPos().getRow() + 1;
            if (curShip.getBegPos().getRow() != 0)
                leftRow = curShip.getBegPos().getRow() - 1;
        }
        if (curShip.getBegPos().getCol() > curShip.getEndPos().getCol()) {
            if (curShip.getBegPos().getCol() == SIZE_FIELD - 1)
                rightCol = SIZE_FIELD - 1;
            else
                rightCol = curShip.getBegPos().getCol() + 1;
            if (curShip.getEndPos().getCol() != 0)
                leftCol = curShip.getEndPos().getCol() - 1;
        } else {
            if (curShip.getEndPos().getCol() == SIZE_FIELD - 1)
                rightCol = SIZE_FIELD - 1;
            else
                rightCol = curShip.getEndPos().getCol() + 1;
            if (curShip.getBegPos().getCol() == 0)
                leftCol = 0;
            else
                leftCol = curShip.getBegPos().getCol() - 1;
        }
        for (int i = leftRow; i <= rightRow; i++) {
            for (int j = leftCol; j <= rightCol; j++) {
                if (field[i][j] != '~')
                    return true;
            }
        }
        return false;
    }

    private int convertToInt(String row) {
        char symbol = row.charAt(0);
        return (int) symbol - (int) START_LETTER;
    }

    public void hitShip(String opponentName) {
        System.out.printf("Player %s, it's your turn:\n", opponentName);
        System.out.println();
        boolean playFlag = true;
        while (playFlag) {
            String hitPosition = scanner.nextLine();
            System.out.println();
            Point pt = new Point(convertToInt(hitPosition.substring(0, 1)),
                    Integer.parseInt(hitPosition.substring(1)) - 1);
            if (pt.getRow() < 0 || pt.getRow() >= SIZE_FIELD || pt.getCol() < 0 || pt.getCol() >= SIZE_FIELD) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            } else if (isCellOfShip(new Point(pt.getRow(), pt.getCol()))) {
                field[pt.getRow()][pt.getCol()] = HIT;
                if (markShipsCellLikeDestroy(new Point(pt.getRow(), pt.getCol()))) {
                    System.out.println("You sank a ship!");
                } else
                    System.out.println("You hit a ship!");
                playFlag = false;
            } else {
                field[pt.getRow()][pt.getCol()] = MISS;
                System.out.println("You missed!");
                playFlag = false;
            }
        }
    }

    // Do all ships sank?
    public boolean isTheLastShipIsSank() {
        for (Ship ship : ships) {
            if (!ship.isDead(SHIP))
                return false;
        }
        return true;
    }

    // mark cell of ship like dead and check is the ship sank
    private boolean markShipsCellLikeDestroy(Point point) {
        for (Ship ship : ships) {
            for (Point curPoint : ship.shipPosition.keySet()) {
                if (point.equals(curPoint)) {
                    ship.shipPosition.put(curPoint, HIT);
                    return ship.isDead(SHIP);
                }
            }
        }
        return false;
    }

    //Is there a ship in this cell?
    private boolean isCellOfShip(Point point) {
        for (Ship ship : ships) {
            for (Point currPoint : ship.shipPosition.keySet()) {
                if (point.equals(currPoint)) {
                    return true;
                }
            }
        }
        return false;
    }
}
