package transport;

import dataService.DataService;

public class Transport {

    private final String brand, model;
    private String color;

    private final String productionCountry;
    private final int productionYear;

    private int speed;

    protected byte defaultParametersNumber = 0;


    protected static final String DEFAULT_STRING = "default";
    protected static final String UNKNOWN_INFO = "<Информация не указана>";
//    protected static final String SPEED_MEASUREMENT_UNIT = "км/ч";

    public Transport(String brand, String model, String color, String productionCountry, int productionYear) {
        this(brand, model, color, productionCountry, productionYear, 0);
    }

    public Transport(String brand, String model, String color, String productionCountry, int productionYear, int speed) {
        defaultParametersNumber = 0;
        this.brand = getCorrect(brand);
        this.model = getCorrect(model);
        this.color = getCorrectColor(color);
        this.productionCountry = getCorrect(productionCountry);
        this.productionYear = getCorrectProductionYear(productionYear);
        setSpeed(speed);
    }

    String getCorrect(String parameter) {
        if (!DataService.isCorrect(parameter)) {
            parameter = DEFAULT_STRING;
            ++defaultParametersNumber;
        }
        return parameter;
    }

    public String getBrand() {
        return getCorrect(brand);
    }

    public String getModel() {
        return getCorrect(model);
    }

    public String getProductionCountry() {
        return getCorrect(productionCountry);
    }

    int getCorrectProductionYear(int parameter) {
        if (parameter <= 0) {
            parameter = 2_000;
            ++defaultParametersNumber;
        }
        return parameter;
    }

    public int getProductionYear() {
        return getCorrectProductionYear(productionYear);
    }

    String getCorrectColor(String color) {
        if (!DataService.isCorrect(color)) {
            color = "белый";
            ++defaultParametersNumber;
        }
        return color;
    }

    public String getColor() {
        return getCorrectColor(color);
    }

    public void setColor(String color) {
        if (DataService.isCorrect(color)) {
            this.color = color;
        } else this.color = getCorrectColor(color);
    }

    public int getSpeed() {
        return speed;
    }

    public String getStrSpeed() {
        return speed != 0 ? Integer.toString(speed) + " км/ч" : "не указана";
    }

    public void setSpeed(int speed) {
        if (speed != 0) {
            this.speed = Math.abs(speed);
        } else ++defaultParametersNumber;
    }
}