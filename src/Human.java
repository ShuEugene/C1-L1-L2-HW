public class Human {

    String name, town;
    int yearOfBirth;

    Human(String name, String town, int yearOfBirth) {
        this.name = name;
        this.town = town;
        this.yearOfBirth = yearOfBirth;
        sayHello();
    }

    void sayHello() {
        System.out.printf("%nПривет!%nМеня зовут %s. Я из города %s. Я родился(-лась) в %d году.%nБудем знакомы!%n",
                name, town, yearOfBirth);
    }
}
