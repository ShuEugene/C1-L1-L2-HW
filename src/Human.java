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

    public String getName() {
        if (!DataService.isCorrect(name)) return UNKNOWN_INFO;
        return name;
    }

    public void setName(String name) {
        if (DataService.isCorrect(name)) {
            this.name = name;
        }
    }

    public String getTown() {
        if (!DataService.isCorrect(town)) return UNKNOWN_INFO;
        return town;
    }

    public void setTown(String town) {
        if (DataService.isCorrect(town)) {
            this.town = town;
        }
    }

    public int getYearOfBirth() {
        if (!DataService.isCorrect(yearOfBirth)) {
            return Math.abs(yearOfBirth);
        }
        return yearOfBirth;
    }

    public String getStrYearOfBirth() {
        if (!DataService.isCorrect(yearOfBirth)) {
            return UNKNOWN_INFO;
        }
        return Integer.toString(yearOfBirth);
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (!DataService.isCorrect(yearOfBirth)) {
            this.yearOfBirth = Math.abs(yearOfBirth);
            return;
        }
        this.yearOfBirth = yearOfBirth;
    }

    public void setAge(int age) {
        if (DataService.isCorrect(age)) {
            setYearOfBirth(LocalDate.now().getYear() - age);
        }
    }

    public String getJobTitle() {
        if (!DataService.isCorrect(jobTitle)) return UNKNOWN_INFO;
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        if (DataService.isCorrect(jobTitle)) {
            this.jobTitle = jobTitle;
        }
    }

    String tellAbout(TaleSubjects taleSubjects) {
        String sentence;
        switch (taleSubjects) {
            case NAME:
                sentence = DataService.isCorrect(name) ? String.format("Меня зовут %s.", name) : "Я забыл(-а), как меня зовут.";
                break;
            case TOWN:
                sentence = DataService.isCorrect(town) ? String.format("Я из города %s.", town) : "Не помню, откуда я.";
                break;
            case YEAR_OF_BIRTH:
                sentence = DataService.isCorrect(yearOfBirth) ? String.format("Родился(-лась) в %d году.", yearOfBirth) : "Когда родился(-лась) - не помню.";
                break;
            case JOB_TITLE:
                sentence = DataService.isCorrect(jobTitle) ? String.format("Работаю в должности «%s».", jobTitle) : "Пока что не работаю.";
                break;
            default:
                sentence = "Об этом мне нечего рассказать.";
        }
        return sentence;
    }

    void tellAboutYourself() {
        System.out.println("\nПривет!");
        System.out.printf("%s %s %s\n%s\n", tellAbout(TaleSubjects.NAME), tellAbout(TaleSubjects.TOWN),
                tellAbout(TaleSubjects.YEAR_OF_BIRTH), tellAbout(TaleSubjects.JOB_TITLE));
        System.out.println("Будем знакомы!");
    }
}
