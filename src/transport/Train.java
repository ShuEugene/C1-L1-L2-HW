package transport;

import dataService.DataService;

public class Train extends Transport {

    private float tripCost;
    private float tripDuration;

    private String startStation, endStation;

    private int numberOfWagons;

    public Train(String brand, String model, int productionYear, int speed,
                 String startStation, String endStation, float tripCost, int numberOfWagons) {
        this(brand, model, null, null, productionYear, speed, startStation, endStation, tripCost, numberOfWagons);
    }

    public Train(String brand, String model, String color, String productionCountry, int productionYear, int speed,
                 String startStation, String endStation, float tripCost, int numberOfWagons) {
        super(brand, model, color, productionCountry, productionYear, speed);
        setStartStation(startStation);
        setEndStation(endStation);
        setTripCost(tripCost);
        setNumberOfWagons(numberOfWagons);
        if (defaultParametersNumber > 0) {
            System.out.println("\nТранспортное средство «" + getBrand() + "» добавлено c " + defaultParametersNumber
                    + " параметром(-ами) по умолчанию.");
        } else {
            System.out.println("\n" + this + "успешно добавлен.");
        }
    }

    @Override
    public String toString() {
        return String.format("Поезд марки %s %s\n" +
                        "(цвет: %s; страна-производитель: %s; год выпуска: %d),\n" +
                        "идущий c %d вагоном(-ами) по маршруту «%s - %s» со скоростью %s\n" +
                        "(стоимость поездки - %s)\n",
                getBrand(), getModel(), getColor(),getProductionCountry(), getProductionYear(),
                getNumberOfWagons(), getStartStation(), getEndStation(), getStrSpeed(), getStrTripCost());
    }

    public String getStrTripCost() {
        return tripCost != 0 ? String.format("%.2f руб.", getTripCost()) : Transport.UNKNOWN_INFO;
    }

    public float getTripCost() {
        return Math.abs(tripCost);
    }

    public void setTripCost(float tripCost) {
        this.tripCost = Math.abs(tripCost);
    }

    public String getStrTripDuration() {
        return tripDuration != 0 ? String.format("%.1f ч.", getTripDuration()) : Transport.UNKNOWN_INFO;
    }

    public float getTripDuration() {
        return Math.abs(tripDuration);
    }

    public void setTripDuration(float tripDuration) {
        this.tripDuration = Math.abs(tripDuration);
    }

    public String getStartStation() {
        if (DataService.isCorrect(startStation)) {
            return startStation;
        } else {
            return Transport.UNKNOWN_INFO;
        }
    }

    public void setStartStation(String startStation) {
        if (DataService.isCorrect(startStation)) {
            this.startStation = startStation;
        }
    }

    public String getEndStation() {
        if (DataService.isCorrect(endStation)) {
            return endStation;
        } else {
            return Transport.UNKNOWN_INFO;
        }
    }

    public void setEndStation(String endStation) {
        if (DataService.isCorrect(endStation)) {
            this.endStation = endStation;
        }
    }

    public int getNumberOfWagons() {
        return Math.abs(numberOfWagons);
    }

    public void setNumberOfWagons(int numberOfWagons) {
        if (numberOfWagons != 0) {
            this.numberOfWagons = Math.abs(numberOfWagons);
        } else {
            ++defaultParametersNumber;
        }
    }
}
