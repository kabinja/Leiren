package lu.course.model;

public class Noun extends Word {
    public enum Gender {
        MASCULINE, FEMININE
    }

    private final String plural;
    private final Gender gender;

    public Noun(int level, String name, String plural, Gender gender, String translation) {
        super(level, name, translation);

        this.plural = plural;
        this.gender = gender;
    }

    public String getPlural() {
        return plural;
    }

    public Gender getGender() {
        return gender;
    }
}
