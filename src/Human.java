public class Human {

    String name, town, jobTitle;
    int yearOfBirth;

    Human(String name, String town, int yearOfBirth) {
        this.name = name;
        this.town = town;
        this.yearOfBirth = yearOfBirth;
    }

    void sayHello() {
        System.out.printf("%nПривет!%nМеня зовут %s. Я из города %s. Я родился(-лась) в %d году." +
                        "%nЯ работаю в должности «%s».%nБудем знакомы!%n",
                name, town, yearOfBirth, jobTitle);
    }
}
