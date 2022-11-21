
import java.util.Objects;

public class Flower {
    private String name, color, country;
    private float cost;
    private int lifeSpan;
    private int varietyNumber;

    static private final String UNKNOWN_FLOWER = "Неизвестный цветок";
    static private final String CURRENCY = "руб.";

    Flower(String name, String color, String country, float cost, int lifeSpan) {
        setName(name);
        setColor(color);
        setCountry(country);
        setCost(cost);
        setLifeSpan(lifeSpan);
        System.out.println("\nЦветок " + this + "\nдоставлен в магазин.");
        varietyNumber = getVarietyNumber();
    }

    Flower(String name, float cost, int lifeSpan) {
        this(name, null, null, cost, lifeSpan);
    }

    Flower(String name, String country, float cost, int lifeSpan) {
        this(name, null, country, cost, lifeSpan);
    }

    Flower(String name, String country, float cost) {
        this(name, null, country, cost, 0);
    }

    public String getName() {
        if (!DataService.isCorrect(name)) name = UNKNOWN_FLOWER;
        return "«" + name + "»";
    }

    public void setName(String name) {
        if (DataService.isCorrect(name)) this.name = name;
        else this.name = UNKNOWN_FLOWER;
    }

    public String getColor() {
        if (!DataService.isCorrect(color)) color = "белый";
        return color;
    }

    public void setColor(String color) {
        if (DataService.isCorrect(color)) {
            this.color = color;
        } else this.color = "белый";
    }

    public String getCountry() {
        if (!DataService.isCorrect(country)) country = "Россия";
        return country;
    }

    public void setCountry(String country) {
        if (DataService.isCorrect(country)) {
            this.country = country;
        } else this.country = "Россия";
    }

    public float getCost() {
        if (!DataService.isCorrect(cost)) {
            if (cost == 0) cost = 1.00f;
            else cost = Math.abs(cost);
        }
        return cost;
    }

    public String getStrCost() {
        return String.format("%.2f %s", getCost(), CURRENCY);
    }

    public void setCost(float cost) {
        if (DataService.isCorrect(cost)) {
            this.cost = cost;
        } else if (cost == 0) this.cost = 1.00f;
        else this.cost = Math.abs(cost);
    }

    public int getLifeSpan() {
        if (!DataService.isCorrect(lifeSpan))
            if (lifeSpan == 0) lifeSpan = 3;
            else lifeSpan = Math.abs(lifeSpan);
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        if (DataService.isCorrect(lifeSpan)) this.lifeSpan = lifeSpan;
        else if (lifeSpan == 0) this.lifeSpan = 3;
        else this.lifeSpan = Math.abs(lifeSpan);
    }

    public int getVarietyNumber() {
        if (varietyNumber == 0) varietyNumber = alreadyInAssortment();
        if (varietyNumber == 0) varietyNumber = Flowers.addVariety(this);
        return varietyNumber;
    }

    public void setVarietyNumber(int varietyNumber) {
        this.varietyNumber = varietyNumber;
    }

    @Override
    public String toString() {
        return getName() +
                "\n(цвет: " + getColor() + "; страна происхождения: " + getCountry() + "; " +
                "стоимость: " + getStrCost() + "; срок стояния (в днях): " + getLifeSpan() + ")";
    }

    String getSpecifications() {
        return "(цвет: " + getColor() + "; страна происхождения: " + getCountry() + "; " +
                "стоимость: " + getStrCost() + "; срок стояния (в днях): " + getLifeSpan() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flower)) return false;
        Flower flower = (Flower) o;
        return Float.compare(flower.getCost(), getCost()) == 0 && getLifeSpan() == flower.getLifeSpan() && getName().equals(flower.getName()) && getColor().equals(flower.getColor()) && getCountry().equals(flower.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getColor(), getCountry(), getCost(), getLifeSpan());
    }

    int alreadyInAssortment() {
        int flowerIndex;
        Flower[] assortment = Flowers.getAssortment();
        for (flowerIndex = 0; flowerIndex < assortment.length; ++flowerIndex) {
            if (assortment[flowerIndex].equals(this)) return flowerIndex + 1;
        }
        return 0;
    }
}
