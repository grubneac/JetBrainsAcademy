package aBigProjects.machine;

import java.util.Scanner;

public class CoffeeMachine {
    private final Scanner scanner = new Scanner(System.in);

    private int totalAmountWater;
    private int totalAmountMilk;
    private int totalAmountCoffeeBeans;
    private int totalAmountDisposablesCup;
    private int totalAmountMoney;

    public CoffeeMachine(int totalAmountWater, int totalAmountMilk, int totalAmountCoffeeBeans, int totalAmountDisposablesCup, int totalAmountMoney) {
        this.totalAmountWater = totalAmountWater;
        this.totalAmountMilk = totalAmountMilk;
        this.totalAmountCoffeeBeans = totalAmountCoffeeBeans;
        this.totalAmountDisposablesCup = totalAmountDisposablesCup;
        this.totalAmountMoney = totalAmountMoney;
    }

    public static void main(String[] args) {

        CoffeeMachine theCoffeeMachine;
        theCoffeeMachine = new CoffeeMachine(400,
                540,
                120,
                9,
                550);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = theCoffeeMachine.scanner.nextLine();
            WorkType workType;
            try {
                workType = WorkType.valueOf(action);
            } catch (IllegalArgumentException e) {
                return;
            }
            System.out.println();
            switch (workType) {
                case buy:
                    theCoffeeMachine.buyAction();
                    break;
                case fill:
                    theCoffeeMachine.fillAction();
                    break;
                case take:
                    theCoffeeMachine.takeAction();
                    break;
                case remaining:
                    theCoffeeMachine.showCoffeeMachineStatus();
                    break;
                case exit:
                    return;
            }
        }
    }

    private void takeAction() {
        System.out.println("I gave you $" + totalAmountMoney);
        System.out.println();
        totalAmountMoney = 0;
    }

    private void fillAction() {
        System.out.println("Write how many ml of water do you want to add:");
        totalAmountWater += scanner.nextInt();

        System.out.println("Write how many ml of milk do you want to add:");
        totalAmountMilk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add:");
        totalAmountCoffeeBeans += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        totalAmountDisposablesCup += scanner.nextInt();
        scanner.nextLine();

        System.out.println();
    }

    private void buyAction() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String answer = scanner.nextLine();
        int typeCoffee;
        if (!answer.equals("back")) {
            try {
                typeCoffee = Integer.parseInt(answer);
            } catch (NumberFormatException e) {
                return;
            }
            try {
                switch (CoffeeType.findById(typeCoffee)) {
                    case espresso:
                        Coffee espresso = new Espresso();
                        createCoffee(espresso);
                        break;
                    case latte:
                        Coffee latte = new Latte();
                        createCoffee(latte);
                        break;
                    case cappuccino:
                        Coffee cappuccino = new Cappuccino();
                        createCoffee(cappuccino);
                        break;
                    default:
                        System.out.println("Don`t know this command");
                }
            } catch (NullPointerException e) {
                System.out.println("Don`t know this command");
            }
        }
        System.out.println();
    }

    private void createCoffee(Coffee coffee) {
        if (totalAmountWater < coffee.AMT_WATER_PER_PORTION) {
            System.out.println("Sorry, not enough water!");
            System.out.println();
            return;
        }
        if (totalAmountMilk < coffee.AMT_MILK_PER_PORTION) {
            System.out.println("Sorry, not enough milk!");
            System.out.println();
            return;
        }
        if (totalAmountCoffeeBeans < coffee.AMT_COFFEE_BEANS_PER_PORTION) {
            System.out.println("Sorry, not enough coffee beans!");
            System.out.println();
            return;
        }
        if (totalAmountDisposablesCup == 0) {
            System.out.println("Sorry, not enough disposables cup!");
            System.out.println();
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");
        totalAmountWater -= coffee.AMT_WATER_PER_PORTION;
        totalAmountMilk -= coffee.AMT_MILK_PER_PORTION;
        totalAmountCoffeeBeans -= coffee.AMT_COFFEE_BEANS_PER_PORTION;
        totalAmountDisposablesCup -= 1;
        totalAmountMoney += coffee.priceCoffee;
    }

    private void showCoffeeMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(totalAmountWater + " of water");
        System.out.println(totalAmountMilk + " of milk");
        System.out.println(totalAmountCoffeeBeans + " of coffee beans");
        System.out.println(totalAmountDisposablesCup + " of disposable cups");
        System.out.println(totalAmountMoney + " of money");
        System.out.println();
    }

}

enum WorkType {
    buy,
    fill,
    take,
    remaining,
    exit
}

enum CoffeeType {
    //1 - espresso, 2 - latte, 3 - cappuccino
    empty(0), espresso(1), latte(2), cappuccino(3);
    private final int typeInt;

    CoffeeType(int type) {
        typeInt = type;
    }

    public static CoffeeType findById(int theType) {
        for (CoffeeType type : values()) {
            if (theType == type.typeInt) {
                return type;
            }
        }
        return CoffeeType.empty;
    }
}

class Coffee {
    public int AMT_WATER_PER_PORTION;
    public int AMT_MILK_PER_PORTION;
    public int AMT_COFFEE_BEANS_PER_PORTION;
    public int priceCoffee;

    public Coffee(int AMT_WATER_PER_PORTION, int AMT_MILK_PER_PORTION, int AMT_COFFEE_BEANS_PER_PORTION, int priceCoffee) {
        this.AMT_WATER_PER_PORTION = AMT_WATER_PER_PORTION;
        this.AMT_MILK_PER_PORTION = AMT_MILK_PER_PORTION;
        this.AMT_COFFEE_BEANS_PER_PORTION = AMT_COFFEE_BEANS_PER_PORTION;
        this.priceCoffee = priceCoffee;
    }
}

class Espresso extends Coffee {
    public Espresso() {
        super(250, 0, 16, 4);
    }
}

class Latte extends Coffee {
    public Latte() {
        super(350, 75, 20, 7);
    }
}

class Cappuccino extends Coffee {
    public Cappuccino() {
        super(200, 100, 12, 6);
    }
}