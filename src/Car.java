public class Car {
    String brand, model, color, productionCountry;
    int productionYear;
    float engineVolume;

    Car(String brand, String model, String color, String country, int year, float engineVolume) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.productionCountry = country;
        this.productionYear = year;
        this.engineVolume = engineVolume;
        System.out.println("\n" + this + "успешно добавлен.");
    }

    @Override
    public String toString() {
        return "Автомобиль марки «" + brand + "»\n(" +
                "модель: " + model + "; " +
                "цвет: " + color + "; " +
                "страна-производитель: " + productionCountry + "; " +
                "год производства: " + productionYear + "; " +
                "объём двигателя: " + engineVolume + ")\n";
    }
}
