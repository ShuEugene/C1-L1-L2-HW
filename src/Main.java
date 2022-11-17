public class Main {
    public static void main(String[] args) {

        Human maxim = new Human("Максим", "Минск", 1988);
        Human anna = new Human("Аня", "Москва", 1993);
        Human katia = new Human("Катя", "Калининград", 1992);
        Human artiom = new Human("Артём", "Москва", 1995);

        maxim.jobTitle = "Бренд-менеджер";
        anna.jobTitle = "Методист образовательных программ";
        katia.jobTitle = "Продукт-менеджер";
        artiom.jobTitle = "Директор по развитию бизнеса";

        maxim.sayHello();
        anna.sayHello();
        katia.sayHello();
        artiom.sayHello();
    }
}