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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BattleField bf = new BattleField();
        bf.placeShips();
        bf.startBattle();

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

    public void setShipPosition(Point point, Character hitChar) {
        shipPosition.put(point, hitChar);
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

    public BattleField() {
        initField();
        initShips();
        print();
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
        System.out.println();
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
        System.out.println();
    }

    public Ship getShip(int ind) {
        return ships[ind];
    }

    public String putShipOnField(Ship curShip, int indexOfShip, String error) {
        if (error == null) {
            System.out.printf("Enter the coordinates of the %s (%d cells):\n"
                    , curShip.getName()
                    , curShip.getShipSize()
            );
        }
        System.out.println();
        String[] shipPosition = scanner.nextLine().split("\\s+");
        System.out.println();

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

    public void placeShips() {
        int curShip = 0;
        String error = null;
        while (curShip < NUM_OF_SHIPS) {
            error = putShipOnField(getShip(curShip), curShip, error);

            if (error == null) {
                curShip++;
                print();
            } else {
                System.out.println(error);
            }
        }

    }

    public void startBattle() {
        System.out.println("The game starts!");
        System.out.println();
        printWithFog();
        hitShip();

    }

    private void hitShip() {
        System.out.println("Take a shot!");
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
                printWithFog();
                if (markShipsCellLikeDestroy(new Point(pt.getRow(), pt.getCol()))) {
                    if (isTheLastShipIsSank()) {
                        playFlag = false;
                        System.out.println("You sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("You sank a ship! Specify a new target:");
                    }
                } else
                    System.out.println("You hit a ship! Try again:");
//                print();
            } else {
                field[pt.getRow()][pt.getCol()] = MISS;
                printWithFog();
                System.out.println("You missed. Try again:");
//                print();
            }
            System.out.println();
        }
    }

    // all ships sank
    private boolean isTheLastShipIsSank() {
        for (int i = 0; i < ships.length; i++) {
            if (!ships[i].isDead(SHIP))
                return false;
        }
        return true;
    }

    // mark cell of ship like dead and check is the ship sank
    private boolean markShipsCellLikeDestroy(Point point) {
        for (int i = 0; i < ships.length; i++) {
            for (Point curPoint : ships[i].shipPosition.keySet()) {
                if (point.equals(curPoint)) {
                    ships[i].shipPosition.put(curPoint, HIT);
                    if (ships[i].isDead(SHIP))
                        return true;
                    else
                        return false;
                }
            }
        }
        return false;
    }

    private boolean isCellOfShip(Point point) {
        for (int i = 0; i < ships.length; i++) {
            for (Point currPoint : ships[i].shipPosition.keySet()) {
                if (point.equals(currPoint)) {
                    return true;
                }
            }
        }
        return false;
    }
}
