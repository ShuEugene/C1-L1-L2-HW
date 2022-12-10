package transport;

import dataService.DataService;

public abstract class Transport {

    private final String brand, model;
    private String color;

    private final String productionCountry;
    private final int productionYear;

    private int speed;

    protected String fuelType;
    private float fuelPercentage;

    protected byte defaultParametersNumber = 0;


    protected static final String DEFAULT_STRING = "default";
    protected static final String UNKNOWN_INFO = "<Информация не указана>";
    protected static final String FULL_FUEL_TANK = "\nТС не нуждается в заправке.";
    protected static final String REFILL_FUEL_TANK = "\nТопливный бак дозаправлен <типТоплива> на <частьБака>%.";
//    protected static final String SPEED_MEASUREMENT_UNIT = "км/ч";

    protected Transport(String brand, String model, String color, String productionCountry, int productionYear) {
        this(brand, model, color, productionCountry, productionYear, 0);
    }

    protected Transport(String brand, String model, String color, String productionCountry, int productionYear, int speed) {
        defaultParametersNumber = 0;
        this.brand = getCorrect(brand);
        this.model = getCorrect(model);
        this.color = getCorrectColor(color);
        this.productionCountry = getCorrect(productionCountry);
        this.productionYear = getCorrectProductionYear(productionYear);
        setSpeed(speed);
    }

    protected abstract void refill();

    protected void refuel(String fuelType) {
        if (!fuelType.equals(this.fuelType)) {
            if (fuelType.equals("бензин")) {
                fuelType += "ом";
            }
            System.out.println(REFILL_FUEL_TANK.replace("<типТоплива>", fuelType).
                    replace("<частьБака>", "100").
                    replace(" дозаправлен ", " перезаправлен "));
            return;
        }
        if (getFuelPercentage() >= 100) {
            System.out.println(FULL_FUEL_TANK);
        } else {
            if (fuelType.equals("бензин")) {
                fuelType += "ом";
            }
            System.out.println(REFILL_FUEL_TANK.replace("<типТоплива>", fuelType).
                    replace("<частьБака>", Float.toString(100f - getFuelPercentage())));
        }
    }

    protected String getCorrect(String parameter) {
        if (!DataService.isCorrect(parameter)) {
            parameter = DEFAULT_STRING;
            ++defaultParametersNumber;
        }
        return parameter;
    }

    protected String getBrand() {
        return getCorrect(brand);
    }

    protected String getModel() {
        return getCorrect(model);
    }

    protected String getProductionCountry() {
        return getCorrect(productionCountry);
    }

    protected int getCorrectProductionYear(int parameter) {
        if (parameter <= 0) {
            parameter = 2_000;
            ++defaultParametersNumber;
        }
        return parameter;
    }

    protected int getProductionYear() {
        return getCorrectProductionYear(productionYear);
    }

    protected String getCorrectColor(String color) {
        if (!DataService.isCorrect(color)) {
            color = "белый";
            ++defaultParametersNumber;
        }
        return color;
    }

    protected String getColor() {
        return getCorrectColor(color);
    }

    protected void setColor(String color) {
        if (DataService.isCorrect(color)) {
            this.color = color;
        } else this.color = getCorrectColor(color);
    }

    protected int getSpeed() {
        return speed;
    }

    protected String getStrSpeed() {
        return speed != 0 ? Integer.toString(speed) + " км/ч" : "не указана";
    }

    protected void setSpeed(int speed) {
        if (speed != 0) {
            this.speed = Math.abs(speed);
        } else ++defaultParametersNumber;
    }

    protected String getStrFuelPercentage() {
        if (fuelPercentage != 0) {
            return String.format("%.2f%%", getFuelPercentage());
        } else return UNKNOWN_INFO;
    }

    protected float getFuelPercentage() {
        return Math.abs(fuelPercentage);
    }

    public void setFuelPercentage(float fuelPercentage) {
        if (fuelPercentage != 0) {
            if (Math.abs(fuelPercentage) > 100) {
                this.fuelPercentage = 100;
            } else this.fuelPercentage = Math.abs(fuelPercentage);
        }
    }

    protected abstract String getFuelType();

    protected abstract void setFuelType(String fuelType);
}