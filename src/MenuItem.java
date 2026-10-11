public enum MenuItem {
    MATCHA_STRAWBERRY("Matcha & strawberry", 599),
    AMERICANO("Americano", 499),
    LATTE("Latte", 699),
    PURRENGI_CAY("Purrengi cay", 999);

    private final String displayName;
    private final int priceInCents;

    MenuItem(String displayName, int priceInCents) {
        this.displayName = displayName;
        this.priceInCents = priceInCents;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPriceInCents() {
        return priceInCents;
    }
}
