package lu.course.model;

public class Word {
    private final int level;
    private final String value;
    private final String translation;

    public Word(int level, String value, String translation) {
        this.level = level;
        this.value = value;
        this.translation = translation;
    }

    public void initialize(){}

    public int getLevel() {
        return level;
    }

    public String getValue() {
        return value;
    }

    public String getTranslation() {
        return translation;
    }
}
