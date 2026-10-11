# Fagan's Cafe

A console cafe ordering app written in Java. Pick drinks from the menu, order several items at once, get a receipt, and pay.

## Features
- Menu with prices
- Order multiple drinks and quantities
- Receipt with the total
- Payment with change calculation
- Input validation (wrong input just asks again)
- Prices stored in cents to avoid rounding errors

## Menu
| # | Item | Price |
|---|------|-------|
| 1 | Matcha & strawberry | 5.99 |
| 2 | Americano | 4.99 |
| 3 | Latte | 6.99 |
| 4 | Purrengi cay | 9.99 |

## Technologies
- Java
- IntelliJ IDEA

## How to run

**In IntelliJ IDEA:** open the project and run `Main.java`.

**From the terminal:**
```bash
cd src
javac *.java
java Main
```

## Project structure
```
src/
 ├── Main.java       # entry point
 ├── Cafe.java       # ordering flow and user interaction
 ├── Order.java      # items in the order, total, receipt
 ├── MenuItem.java   # menu items and their prices
 └── Money.java      # money formatting and parsing helpers
```

## Author
faganaliev - [GitHub](https://github.com/faganaliev)