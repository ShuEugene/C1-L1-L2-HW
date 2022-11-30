import transport.Bus;
import transport.Car;
import transport.Train;

import java.time.LocalDate;
//  Домашние задания 2-го курса

public class Main {

    public static void main(String[] args) {

//        У1.ДЗ: 1.1, 1.2, 2.1, 3.1; У2.ДЗ: 1.1
/*
        Human maxim = new Human("Максим", "Минск", 1988);
        Human anna = new Human("Аня", "Москва", 1993);
        Human katia = new Human("Катя", 1992);
        Human artiom = new Human("Артём", "Москва", 1995);
        Human vladimir = new Human("Владимир", "Казань");
        vladimir.setAge(21);

        maxim.setJobTitle("Бренд-менеджер");
        anna.setJobTitle("Методист образовательных программ");
        katia.setJobTitle("Продукт-менеджер");
        artiom.setJobTitle("Директор по развитию бизнеса");

        maxim.tellAboutYourself();
        anna.tellAboutYourself();
        katia.tellAboutYourself();
        artiom.tellAboutYourself();
        vladimir.tellAboutYourself();
*/

//        У1.ДЗ: 1.3, 2.2. 3.2; У2.ДЗ: 2.1
        Car ladaGranta = new Car("Лада", "Гранта", "жёлтый", "Россия", 2015,
                "Л123ЛГ123", "седан", 1.7f, (byte)5, "механика", false);
        Car audiA8_50L = new Car("Audi", "A8 50 L TDI quattro", "чёрный", "Германия", 2020,
                "A234AL234", "седан", 3.0f, (byte) 5, "автоматика", false);
        Car bmwZ8 = new Car("BMW", "Z8", "чёрный", "Германия", 2021,
                "B345BZ345", "кабриолет", 3.0f, (byte) 0, "механика", false);
        Car kiaSportage = new Car("Kia", "Sportage 4gen", "красный", "Южная Корея", 2018,
                "K", "внедорожник", 2.4f, (byte) 5, "механика", false);
        Car hyundaiAvante = new Car("Hyundai", "Avante", "оранжевый", null, 0,
                "H456HA456", "седан", 1.6f, (byte) 5, "автоматика",false);

//        У2.ДЗ: 3.2
/*        ladaGranta.setKey(ladaGranta.new Key());
        audiA8_50L.setKey(audiA8_50L.new Key(true, true));
        bmwZ8.setKey(bmwZ8.new Key(true, true));
        kiaSportage.setKey(kiaSportage.new Key(true, false));
        hyundaiAvante.setKey(hyundaiAvante.new Key(true, false));
        ladaGranta.setInsurance(ladaGranta.new Insurance(LocalDate.of(2023, 12, 31), 1_500f, "123456789"));
        audiA8_50L.setInsurance(audiA8_50L.new Insurance(LocalDate.of(2023, 10, 15), 2_500f, "234567890"));
        bmwZ8.setInsurance(bmwZ8.new Insurance(LocalDate.of(2035, 12, 31), 5_500f, ""));
        kiaSportage.setInsurance(kiaSportage.new Insurance(LocalDate.of(2033, 12, 31), 3_500f, null));
        hyundaiAvante.setInsurance(hyundaiAvante.new Insurance(LocalDate.of(2023, 11, 1), 1_500f, "345678901"));

        Car[] cars = {ladaGranta, audiA8_50L, bmwZ8, kiaSportage, hyundaiAvante};
        System.out.println("\n\n~ Дополнительные сведения об автомобилях ~");
        char printSeparator = ';';
        for (Car curCar :
                cars) {
            if (curCar == cars[cars.length - 1]) {
                printSeparator = '.';
            }
            if (curCar != null) {
                System.out.printf("\n%s %s (\"%s\")\n%s;\nстраховка %s%c\n",
                        curCar.getBrand(), curCar.getModel(), curCar.getRegNumber(), curCar.getKey(), curCar.getInsurance(), printSeparator);
            }
        }*/

//        У3.ДЗ: 1.2
        Train lastochka = new Train("Ласточка", "B-901", "голубой", "Беларусь", 2011,301,
                "Белорусский вокзал", "Минск-Пассажирский", 3500f, 11);
        Train leningrad = new Train("Ленинград", "D-125", 2019, 270, "Ленинградский вокзал", "Ленинград-Пассажирский",
                1700f, 8);

//        У3.ДЗ: 1.3
        Bus ikarus = new Bus("Ikarus", "260", "жёлтый", "Венгрия", 1971, 66);
        Bus paz = new Bus("ПАЗ", "ПАЗ-32053/54", 2021, 95);
//        У2.ДЗ: 1.2
/*
        Flower rose = new Flower("Роза обыкновенная", "Голландия", 35.59f);
        Flower rose1 = new Flower("Роза обыкновенная", "Голландия", 35.59f);
        Flower chrysanthemum = new Flower("Хризантема", 15.00f, 5);
        Flower peony = new Flower("Пион", "Англия", 15.00f, 1);
        Flower gypsophila = new Flower("Гипсофила", "Турция", 19.5f, 10);
        Flowers.showAssortment();

        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(rose);
        bouquet.addFlower(rose1);
        bouquet.addFlower(gypsophila);
        bouquet.addFlower(gypsophila);
        bouquet.addFlower(peony);
        bouquet.showInfo();
*/
    }
}