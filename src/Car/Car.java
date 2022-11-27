package Car;

import DataService.DataService;

import java.time.LocalDate;

public class Car {

    private final String brand, model, productionCountry, body;
    private final int productionYear;
    private final byte seatsNumber;

    private String color;
    private float engineVolume;
    private String transmission, regNumber;
    private boolean useOfWinterTires;
    private byte defaultParametersNumber = 0;
    private Key key;
    private Insurance insurance;

    static final String DEFAULT_STRING = "default";
    static final String UNKNOWN_INFO = "Информация не указана";

    public class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessAccess;

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }

        public Key() {
            this(false, false);
        }

        @Override
        public String toString() {
            String remoteEngineStart = this.isRemoteEngineStart() ? "есть" : "нет";
            String keylessAccess = this.isKeylessAccess() ? "есть" : "нет";
            return String.format("опции ключа зажигания: удалённый запуск двигателя - %s, безключевой доступ - %s",
                    remoteEngineStart, keylessAccess);
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }

    public class Insurance {
        private final LocalDate validityPeriod;
        private final float cost;
        private final String regNumber;

        public Insurance(LocalDate validityPeriod, float cost, String regNumber) {
            this.validityPeriod = validityPeriod;
            this.cost = Math.abs(cost);
            this.regNumber = regNumber;
        }

        public boolean periodIsValid() {
            if (!validityPeriod.isAfter(LocalDate.now())) {
                System.out.println("\nСтраховка просрочена.");
                return false;
            }
            return true;
        }

        public boolean regNumberIsCorrect() {
            return DataService.isCorrect(regNumber) && regNumber.length() == 9;
        }

        @Override
        public String toString() {
            return Car.this.insuranceIsValid() ? String.format("№%s действительна до %s (оплаченная стоимость - %.2f руб.)",
                    regNumber, validityPeriod, cost) : "отсутствует";
        }

        public LocalDate getValidityPeriod() {
            return validityPeriod;
        }

        public String getStrValidityPeriod() {
            if (validityPeriod == null) {
                return UNKNOWN_INFO;
            }
            return validityPeriod.toString();
        }

        public float getCost() {
            return cost;
        }

        public String getRegNumber() {
            if (!DataService.isCorrect(regNumber)) {
                return UNKNOWN_INFO;
            }
            return regNumber;
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

    public boolean insuranceIsValid() {
        return insurance.periodIsValid() && insurance.regNumberIsCorrect();
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
            regNumber = DEFAULT_STRING;
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
            parameter = DEFAULT_STRING;
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

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        if (insurance != null) {
            this.insurance = insurance;
        }
    }
}