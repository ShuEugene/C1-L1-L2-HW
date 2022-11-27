package Car;

import DataService.DataService;

public class Car {

    private final String brand, model, productionCountry, body;
    private final int productionYear;
    private final byte seatsNumber;

    private String color;
    private float engineVolume;
    private String transmission, regNumber;
    private boolean useOfWinterTires;
    private byte defaultParametersNumber = 0;

    static final String defaultString = "default";

    public class Key {
        private final boolean remoteEnginStart;
        private final boolean keylessAccess;

        public Key(boolean remoteEnginStart, boolean keylessAccess) {
            this.remoteEnginStart = remoteEnginStart;
            this.keylessAccess = keylessAccess;
        }

        public boolean isRemoteEnginStart() {
            return remoteEnginStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }

    public Car(String brand, String model, String color, String productionCountry, int productionYear, String regNumber,
               String body, float engineVolume, byte seatsNumber, String transmission, boolean useOfWinterTires) {
        defaultParametersNumber = 0;
        this.brand = getCorrect(brand);
        this.model = getCorrect(model);
        this.color = getCorrectColor(color);
        this.productionCountry = getCorrect(productionCountry);
        this.productionYear = getCorrectProductionYear(productionYear);
        setRegNumber(regNumber);
        this.body = getCorrect(body);
        this.engineVolume = getCorrectEngineVolume(engineVolume);
        this.seatsNumber = getCorrectSeatsNumber(seatsNumber);
        this.transmission = getCorrect(transmission);
        this.useOfWinterTires = useOfWinterTires;
        if (defaultParametersNumber > 0) {
            System.out.println("\nАвтомобиль " + getBrand() + " добавлен c " + defaultParametersNumber + " параметром(-ами) по умолчанию.");
        } else {
            System.out.println("\n" + this + "успешно добавлен.");
        }
    }

    @Override
    public String toString() {
        return String.format("Автомобиль марки %s %s\n" +
                        "(цвет: %s; тип кузова: %s; количество мест: %d; страна-производитель: %s; год выпуска: %d;\n" +
                        "объём двигателя: %.1f л; тип коробки передач: %s; покрышки: %s; регистрационный номер: \"%s\")\n",
                brand, model, color, body, seatsNumber, productionCountry, productionYear,
                engineVolume, transmission, getTiresType(), regNumber);
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

    public String getBody() {
        return getCorrect(body);
    }

    public int getProductionYear() {
        return getCorrectProductionYear(productionYear);
    }

    public byte getSeatsNumber() {
        return getCorrectSeatsNumber(seatsNumber);
    }

    public String getColor() {
        return getCorrectColor(color);
    }

    public void setColor(String color) {
        if (DataService.isCorrect(color)) {
            this.color = color;
        } else this.color = getCorrectColor(color);
    }

    public float getEngineVolume() {
        return getCorrectEngineVolume(engineVolume);
    }

    public void setEngineVolume(float engineVolume) {
        if (engineVolume > 0) {
            this.engineVolume = engineVolume;
        } else this.engineVolume = getCorrectEngineVolume(engineVolume);
    }

    public String getTransmission() {
        return getCorrect(transmission);
    }

    public void setTransmission(String transmission) {
        if (DataService.isCorrect(transmission)) {
            this.transmission = transmission;
        } else this.transmission = getCorrect(transmission);
    }

    boolean isCorrectRegNumber(String regNumber) {
        if (!DataService.isCorrect(regNumber)) return false;
        if (regNumber.length() != 9) return false;
        String rnPart = regNumber.substring(0, 1);
        if (!DataService.isLetters(rnPart)) return false;
        rnPart = regNumber.substring(1, 4);
        if (!rnPart.matches("\\d+")) return false;
        rnPart = regNumber.substring(4, 6);
        if (!DataService.isLetters(rnPart)) return false;
        rnPart = regNumber.substring(6);
        return rnPart.matches("\\d+");
    }

    public String getRegNumber() {
        if (!isCorrectRegNumber(regNumber)) {
            regNumber = defaultString;
            ++defaultParametersNumber;
        }
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        if (isCorrectRegNumber(regNumber)) {
            this.regNumber = regNumber;
        } else this.regNumber = getRegNumber();
    }

    public boolean areWinterTiresUsed() {
        return useOfWinterTires;
    }

    public void setWinterTiresUsed(boolean areUsed) {
        this.useOfWinterTires = areUsed;
    }

    String getTiresType() {
        return areWinterTiresUsed() ? "зимние" : "летние";
    }

    String getCorrect(String parameter) {
        if (!DataService.isCorrect(parameter)) {
            parameter = defaultString;
            ++defaultParametersNumber;
        }
        return parameter;
    }

    float getCorrectEngineVolume(float parameter) {
        if (parameter <= 0) {
            parameter = 1.5f;
            ++defaultParametersNumber;
        }
        return parameter;
    }

    int getCorrectProductionYear(int parameter) {
        if (parameter <= 0) {
            parameter = 2_000;
            ++defaultParametersNumber;
        }
        return parameter;
    }

    byte getCorrectSeatsNumber(byte parameter) {
        if (parameter <= 0) {
            parameter = 2;
            ++defaultParametersNumber;
        }
        return parameter;
    }

    String getCorrectColor(String color) {
        if (!DataService.isCorrect(color)) {
            color = "белый";
            ++defaultParametersNumber;
        }
        return color;
    }
}
