package Enum;

public class EnumDirections {
    public static void main(String[] args) {
        System.out.println(Direction.NORTH.toString());
        Direction dr = Direction.valueOf("NORTH");
        System.out.println(dr);
        System.out.println(Direction.NORTH.getShortCode());
//        Enum.Direction dr2 = Enum.Direction.valueOf("N");

        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day);
        }
        DangerLevel high = DangerLevel.HIGH;
        DangerLevel medium = DangerLevel.MEDIUM;

        System.out.println(high.getLevel() > medium.getLevel()); // true
    }
}
enum Direction {
    EAST("E"),
    WEST("W"),
    NORTH("N"),
    SOUTH("S");

    private final String shortCode;

    Direction(String code) {
        this.shortCode = code;
    }

    public String getShortCode() {
        return this.shortCode;
    }
}
enum DayOfWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

enum DangerLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);
    private int level;

    DangerLevel(int theLevel) {
        level = theLevel;
    }

    public int getLevel() {
        return level;
    }
}