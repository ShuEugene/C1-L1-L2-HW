public class Human {

    String name, town, jobTitle;
    int yearOfBirth;

    static final String UNKNOWN_INFO = "Информация не указана";

    Human(String name, String town, int yearOfBirth) {
        this.name = name;
        this.town = town;
        if (yearOfBirth > 0) {
            this.yearOfBirth = yearOfBirth;
        } else {
            System.out.println("Значение возраста не может быть отрицательным.\nНа данный момент присвоено значение \"0\".");
            this.yearOfBirth = 0;
        }
    }

    Human(String name, String town) {
        this(name, town, 0);
    }

    Human(String name, int yearOfBirth) {
        this(name, null, yearOfBirth);
    }

    Human(String name) {
        this(name, null, 0);
    }

    public String getName() {
        if (name == null) name = UNKNOWN_INFO;
        return name;
    }

    public String getTown() {
        if (town == null) town = UNKNOWN_INFO;
        return town;
    }

    public String getJobTitle() {
        if (jobTitle == null) jobTitle = UNKNOWN_INFO;
        return jobTitle;
    }

    void sayHello() {
        String name, town, jobTitle;
        name = getName();
        town = getTown();
        jobTitle = getJobTitle();
        if (name.equals(UNKNOWN_INFO) || town.equals(UNKNOWN_INFO) || jobTitle.equals(UNKNOWN_INFO) || yearOfBirth == 0) {
            System.out.println("\n! Часть сведений о человеке отсутствует. Знакомство исключено.");
            return;
        }
        System.out.printf("%nПривет!%nМеня зовут %s. Я из города %s. Я родился(-лась) в %d году." +
                "%nЯ работаю в должности «%s».%nБудем знакомы!%n", name, town, yearOfBirth, jobTitle);
    }
}
