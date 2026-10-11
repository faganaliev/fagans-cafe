/**
 * Helper for working with money.
 * Prices are stored in cents (int) to avoid rounding errors that double causes,
 * e.g. 5.99 * 3 can become 17.970000000000002 as a double.
 */
public final class Money {
    private Money() {
    }

    /** 599 -> "5.99" */
    public static String format(int cents) {
        return String.format("%d.%02d", cents / 100, cents % 100);
    }

    /** Parses "10", "10.5" or "10,50" into cents. Returns -1 if the text is invalid. */
    public static int parse(String text) {
        try {
            double value = Double.parseDouble(text.trim().replace(',', '.'));
            if (Double.isNaN(value) || value < 0 || value > 1_000_000) {
                return -1;
            }
            return (int) Math.round(value * 100);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
