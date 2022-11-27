import DataService.DataService;

import java.util.Arrays;

public class Bouquet {

    private String title;
    private Flower[] bouquet;
    private int bouquetNumber;

    static private int bouqetsCount;
    static private final String UNKNOWN_BOUQUET = "букет без названия";
    static private final String CURRENCY = "руб.";

    Bouquet(String title) {
        setTitle(title);
        bouquet = new Flower[0];
        bouquetNumber = ++bouqetsCount;
    }

    Bouquet() {
        this(null);
    }

    public String getTitle() {
        if (!DataService.isCorrect(title)) title = bouquetNumber + "-й " + UNKNOWN_BOUQUET;
        return "«" + title + "»";
    }

    public void setTitle(String title) {
        if (DataService.isCorrect(title)) this.title = title;
    }

    public Flower[] getBouquet() {
        if (bouquet != null) bouquet = DataService.getValidObjects(bouquet);
        if (bouquet == null) bouquet = new Flower[0];
        return bouquet;
    }

    public void setBouquet(Flower[] bouquet) {
        if (bouquet != null) this.bouquet = bouquet;
    }

    void addFlower(Flower flower) {
        if (!DataService.isCorrect(flower)) return;
        bouquet = Arrays.copyOf(getBouquet(), bouquet.length + 1);
        bouquet[bouquet.length - 1] = flower;
        System.out.println("\nВ букет " + getTitle() + " добавлен новый цветок - " + flower + '.');
    }

    float calcCost() {
        float cost = 0.00f;
        for (Flower curFlower :
                bouquet) {
            if (DataService.isCorrect(curFlower)) cost += curFlower.getCost();
        }
        cost += cost / 10;
        return cost;
    }

    String getStrCost() {
        return String.format("%.2f %s", calcCost(), CURRENCY);
    }

    int getLifeSpan() {
        int lifeSppan = Integer.MAX_VALUE;
        for (Flower curFlower :
                bouquet) {
            if (DataService.isCorrect(curFlower) && curFlower.getLifeSpan() < lifeSppan) {
                lifeSppan = curFlower.getLifeSpan();
            }
        }
        return lifeSppan;
    }

    String[][] getFlowerList() {
        Flower[] bouquet = getBouquet();
        if (bouquet.length < 1) return null;
        String[][] flowerList = new String[bouquet.length][3];
        int listItemIndex = 0;
        for (Flower assortmentFlower : Flowers.getAssortment()) {
            int numberOfIdentical = 0;
            if (assortmentFlower != null) {
                for (Flower curFlower : bouquet) {
                    if (curFlower != null && curFlower.equals(assortmentFlower)) {
                        ++numberOfIdentical;
                    }
                }
                if (numberOfIdentical > 0) {
                    flowerList[listItemIndex][0] = assortmentFlower.getName();
                    flowerList[listItemIndex][1] = assortmentFlower.getSpecifications();
                    flowerList[listItemIndex++][2] = Integer.toString(numberOfIdentical);
                }
            }
        }
        return DataService.getValidObjects(flowerList);
    }

    void showSimpleList() {
        Flower[] bouquet = DataService.getValidObjects(getBouquet());
        if (bouquet == null) {
            System.out.println("\nВ данный букет пока ещё не добавлено ни одного цветка.");
            return;
        }
        System.out.println();
        char printSeparator = ';';
        for (Flower curFlower : bouquet) {
            if (curFlower != null && curFlower.equals(bouquet[bouquet.length - 1])) printSeparator = '.';
            if (curFlower != null) System.out.printf("%s%s\n", curFlower, printSeparator);
        }
    }

    boolean showFlowerList() {
        String[][] flowerList = getFlowerList();
        if (flowerList == null) {
            System.out.println("\nВ данный букет пока ещё не добавлено ни одного цветка.");
            return false;
        }
        System.out.printf("\nБукет %s состоит из следующих цветов:\n", getTitle());
        char printSeparator = ';';
        for (int itemIndex = 0; itemIndex < flowerList.length; ++itemIndex) {
            if (itemIndex == flowerList.length - 1) printSeparator = '.';
            System.out.printf("%s - %s шт.\n%s%c\n",
                    flowerList[itemIndex][0], flowerList[itemIndex][2], flowerList[itemIndex][1], printSeparator);
        }
        return true;
    }

    void showInfo() {
        if (!showFlowerList()) return;
        System.out.println("Минимальный срок сохранения свежести (в днях): " + getLifeSpan() + ".");
        System.out.println("-".repeat(25));
        System.out.println("Стоимость букета - " + getStrCost() + ".");
    }
}
