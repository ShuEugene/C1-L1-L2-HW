package transport;

public class Bus extends Transport{

    public Bus(String brand, String model, int productionYear, int speed) {
        this(brand, model, null, null, productionYear, speed);
    }

    public Bus(String brand, String model, String color, String productionCountry, int productionYear, int speed) {
        super(brand, model, color, productionCountry, productionYear, speed);
        if (defaultParametersNumber > 0) {
            System.out.println("\nТранспортное средство «" + getBrand() + "» добавлено c " + defaultParametersNumber
                    + " параметром(-ами) по умолчанию.");
        } else {
            System.out.println("\n" + this + "успешно добавлен.");
        }
    }

    @Override
    public String toString() {
        return String.format("Автобус марки %s %s\n" +
                        "(цвет: %s; страна-производитель: %s; год выпуска: %d, макс. скорость - %s)\n",
                getBrand(), getModel(), getColor(),getProductionCountry(), getProductionYear(), getStrSpeed());
    }
}
