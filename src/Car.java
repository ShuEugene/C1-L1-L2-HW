public class Car {
    String brand, model, color, productionCountry;
    int productionYear;
    float engineVolume;
    byte defaultParametersNumber = 0;

    static final String defaultString = "default";

    String isValid(String parameter) {
        if (parameter == null || parameter.equals("")) {
            parameter = defaultString;
            ++defaultParametersNumber;
        }
        return parameter;
    }

    float isValid(float parameter) {
        if (parameter <= 0) {
            parameter = 1.5f;
            ++defaultParametersNumber;
        }
        return parameter;
    }

    int isValid(int parameter) {
        if (parameter <= 0) {
            parameter = 2_000;
            ++defaultParametersNumber;
        }
        return parameter;
    }

    String isValidColor(String color) {
        if (color == null || color.equals("")) {
            color = "белый";
            ++defaultParametersNumber;
        }
        return color;
    }

    Car(String brand, String model, String color, String productionCountry, int productionYear, float engineVolume) {
        defaultParametersNumber = 0;
        this.brand = isValid(brand);
        this.model = isValid(model);
        this.color = isValidColor(color);
        this.productionCountry = isValid(productionCountry);
        this.productionYear = isValid(productionYear);
        this.engineVolume = isValid(engineVolume);
        if (defaultParametersNumber > 0) {
            System.out.println("\nАвтомобиль " + this.brand + "добавлен c " + defaultParametersNumber + " параметром(-ами) по умолчанию.");
        } else {
            System.out.println("\n" + this + "успешно добавлен.");
        }
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
