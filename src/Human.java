import java.time.LocalDate;

public class Human {

    private String name, town, jobTitle;
    private int yearOfBirth;

    static final String UNKNOWN_INFO = "\"Информация не указана\"";

    enum TaleSubjects {NAME, TOWN, YEAR_OF_BIRTH, JOB_TITLE;}

    Human(String name, String town, int yearOfBirth, String jobTitle) {
        setName(name);
        setTown(town);
        setYearOfBirth(yearOfBirth);
        setJobTitle(jobTitle);
    }

    Human(String name, String town, int yearOfBirth) {
        this(name, town, yearOfBirth, null);
    }

    Human(String name, String town) {
        this(name, town, 0, null);
    }

    Human(String name, int yearOfBirth) {
        this(name, null, yearOfBirth, null);
    }

    Human(String name) {
        this(name, null, 0, null);
    }

    boolean isCorrect(String value) {
        return value != null && !value.isBlank() && !value.isEmpty();
    }

    boolean isCorrect(int value) {
        return value > 0;
    }

    public String getName() {
        if (!isCorrect(name)) return UNKNOWN_INFO;
        return name;
    }

    public void setName(String name) {
        if (isCorrect(name)) {
            this.name = name;
        }
    }

    public String getTown() {
        if (!isCorrect(town)) return UNKNOWN_INFO;
        return town;
    }

    public void setTown(String town) {
        if (isCorrect(town)) {
            this.town = town;
        }
    }

    public int getYearOfBirth() {
        if (!isCorrect(yearOfBirth)) {
            return Math.abs(yearOfBirth);
        }
        return yearOfBirth;
    }

    public String getStrYearOfBirth() {
        if (!isCorrect(yearOfBirth)) {
            return UNKNOWN_INFO;
        }
        return Integer.toString(yearOfBirth);
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (!isCorrect(yearOfBirth)) {
            this.yearOfBirth = Math.abs(yearOfBirth);
            return;
        }
        this.yearOfBirth = yearOfBirth;
    }

    public void setAge(int age) {
        if (isCorrect(age)) {
            setYearOfBirth(LocalDate.now().getYear() - age);
        }
    }

    public String getJobTitle() {
        if (!isCorrect(jobTitle)) return UNKNOWN_INFO;
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        if (isCorrect(jobTitle)) {
            this.jobTitle = jobTitle;
        }
    }

    String pronounce(TaleSubjects taleSubjects) {
        String sentence;
        switch (taleSubjects) {
            case NAME:
                sentence = isCorrect(name) ? String.format("Меня зовут %s.", name) : "Я забыл(-а), как меня зовут.";
                break;
            case TOWN:
                sentence = isCorrect(town) ? String.format("Я из города %s.", town) : "Не помню, откуда я.";
                break;
            case YEAR_OF_BIRTH:
                sentence = isCorrect(yearOfBirth) ? String.format("Родился(-лась) в %d году.", yearOfBirth) : "Когда родился(-лась) - не помню.";
                break;
            case JOB_TITLE:
                sentence = isCorrect(jobTitle) ? String.format("Работаю в должности «%s».", jobTitle) : "Пока что не работаю.";
                break;
            default:
                sentence = "Об этом мне нечего рассказать.";
        }
        return sentence;
    }

    void tellAboutYourself() {
        System.out.println("\nПривет!");
        System.out.printf("%s %s %s\n%s\n", pronounce(TaleSubjects.NAME), pronounce(TaleSubjects.TOWN),
                pronounce(TaleSubjects.YEAR_OF_BIRTH), pronounce(TaleSubjects.JOB_TITLE));
        System.out.println("Будем знакомы!");
    }
}
