public class Main {
    public static void main(String[] args) {

//        ДЗ 1.1, 1.2, 2.1, 3.1
        Human maxim = new Human("Максим", "Минск", 1988);
        Human anna = new Human("Аня", "Москва", 1993);
        Human katia = new Human("Катя", 1992);
        Human artiom = new Human("Артём", "Москва", 1995);

        maxim.jobTitle = "Бренд-менеджер";
        anna.jobTitle = "Методист образовательных программ";
        katia.jobTitle = "Продукт-менеджер";
        artiom.jobTitle = "Директор по развитию бизнеса";

        maxim.sayHello();
        anna.sayHello();
        katia.sayHello();
        artiom.sayHello();

//        ДЗ 1.3, 2.2. 3.2
        Car ladaGranta = new Car("Лада", "Гранта", "жёлтый", "Россия", 2015, 1.7f);
        Car audiA8_50L = new Car("Audi", "A8 50 L TDI quattro", "чёрный", "Германия", 2020, 3.0f);
        Car bmwZ8 = new Car("BMW", "Z8", "чёрный", "Германия", 2021, 3.0f);
        Car kiaSportage = new Car("Kia", "Sportage 4gen", "красный", "Южная Корея", 2018, 2.4f);
        Car hyundaiAvante = new Car("Hyundai", "Avante", "оранжевый", null, 0, 1.6f);
    }
}