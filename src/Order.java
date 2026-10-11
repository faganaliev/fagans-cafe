import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    private final Map<MenuItem, Integer> items = new LinkedHashMap<>();

    public void add(MenuItem item, int quantity) {
        items.merge(item, quantity, Integer::sum);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int getTotalInCents() {
        int total = 0;
        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPriceInCents() * entry.getValue();
        }
        return total;
    }

    public void printReceipt() {
        System.out.println();
        System.out.println("-------- Receipt --------");
        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            int quantity = entry.getValue();
            int lineTotal = entry.getKey().getPriceInCents() * quantity;
            System.out.printf("%d x %-20s %7s%n",
                    quantity, entry.getKey().getDisplayName(), Money.format(lineTotal));
        }
        System.out.println("-------------------------");
        System.out.printf("%-24s %7s%n", "TOTAL", Money.format(getTotalInCents()));
        System.out.println();
    }
}
