
//  Домашние задания 2-го курса

public class Main {
    public static void main(String[] args) {

//        У1.ДЗ: 1.1, 1.2, 2.1, 3.1; У2.ДЗ: 1.1
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

//        У1.ДЗ: 1.3, 2.2. 3.2
        Car ladaGranta = new Car("Лада", "Гранта", "жёлтый", "Россия", 2015, 1.7f);
        Car audiA8_50L = new Car("Audi", "A8 50 L TDI quattro", "чёрный", "Германия", 2020, 3.0f);
        Car bmwZ8 = new Car("BMW", "Z8", "чёрный", "Германия", 2021, 3.0f);
        Car kiaSportage = new Car("Kia", "Sportage 4gen", "красный", "Южная Корея", 2018, 2.4f);
        Car hyundaiAvante = new Car("Hyundai", "Avante", "оранжевый", null, 0, 1.6f);
    }
}