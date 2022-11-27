import Car.Car;
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