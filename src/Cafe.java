import java.util.Scanner;

public class Cafe {
    private static final String CAFE_NAME = "Fagan's cafe";

    private final Scanner scanner;

    public Cafe(Scanner scanner) {
        this.scanner = scanner;
    }

    public void open() {
        System.out.println("Welcome to our cafe (" + CAFE_NAME + ")");

        Order order = takeOrder();
        order.printReceipt();
        pay(order.getTotalInCents());

        System.out.println("Have a good day!");
    }

    private Order takeOrder() {
        Order order = new Order();

        while (true) {
            printMenu();
            int choice = readInt("Your order (0 to finish): ", 0, MenuItem.values().length);

            if (choice == 0) {
                if (order.isEmpty()) {
                    System.out.println("Your order is empty, please choose something.");
                    continue;
                }
                return order;
            }

            MenuItem item = MenuItem.values()[choice - 1];
            int quantity = readInt("How many? ", 1, 20);
            order.add(item, quantity);
            System.out.println(quantity + " x " + item.getDisplayName() + " added. Great choice!");
        }
    }

    private void pay(int total) {
        System.out.println("Total to pay: " + Money.format(total));

        while (true) {
            System.out.print("Enter your money: ");
            int money = Money.parse(scanner.nextLine());

            if (money < 0) {
                System.out.println("Invalid amount, please enter a number.");
            } else if (money < total) {
                System.out.println("Not enough money. You still need "
                        + Money.format(total - money) + " more.");
            } else {
                System.out.println("Here's your change: " + Money.format(money - total));
                return;
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Menu:");
        MenuItem[] items = MenuItem.values();
        for (int i = 0; i < items.length; i++) {
            System.out.println(" " + (i + 1) + ". " + items[i].getDisplayName()
                    + " - " + Money.format(items[i].getPriceInCents()));
        }
    }

    /** Asks until the user enters a whole number between min and max. */
    private int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // falls through to the message below
            }
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }
}
