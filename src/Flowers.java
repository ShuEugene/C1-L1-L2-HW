import DataService.DataService;

import java.util.Arrays;

public class Flowers {

    static private Flower[] assortment;
    static private int varietyCount = 0;

    static Flower[] getAssortment() {
        if (assortment != null) assortment = DataService.getValidObjects(assortment);
        if (assortment == null) assortment = new Flower[0];
        return assortment;
    }

    static int getVarietyCount() {
        return varietyCount;
    }

    static int addVariety(Flower variety) {
        if (variety == null) return 0;
        if (assortment == null) {
            assortment = new Flower[++varietyCount];
            assortment[varietyCount - 1] = variety;
            return 1;
        }
        int varietyNumber = variety.alreadyInAssortment();
        if (varietyNumber > 0) {
            System.out.println("\nДанный тип цветка уже присутствует в БД.");
            return varietyNumber;
        }
        assortment = Arrays.copyOf(assortment, ++varietyCount);
        assortment[varietyCount - 1] = variety;
        return varietyCount;
    }

    static int getNumberIdenticalFlowers(Flower flower) {
        if (assortment == null || assortment.length < 1) return 0;
        int numberIdenticalFlowers = 0;
        for (Flower curFlower :
                assortment) {
            if (curFlower != null && curFlower.equals(flower)) ++numberIdenticalFlowers;
        }
        return numberIdenticalFlowers;
    }

    static void showAssortment() {
        Flower[] assortment = getAssortment();
        if (assortment == null || assortment.length < 1) {
            System.out.println("\nВ магазине нет ни одного цветка.");
            return;
        }
        System.out.printf("\nРазновидностей цветков в ассортименте магазина - %s:\n", varietyCount);
        char printSeparator = ';';
        for (Flower curFlower : assortment) {
            if (curFlower != null && curFlower.equals(assortment[assortment.length - 1])) printSeparator = '.';
            if (curFlower != null) System.out.printf("%d. %s%c\n", curFlower.getVarietyNumber(), curFlower, printSeparator);
        }
    }
}
