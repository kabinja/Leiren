package lu.course.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

public class Verb extends Word {
    public enum Person {
        FIRST_SINGULAR,
        SECOND_SINGULAR,
        THIRD_SINGULAR,
        FIRST_PLURAL,
        SECOND_PLURAL,
        THIRD_PLURAL
    }

    private final Map<Person, String> conjugated = new EnumMap<>(Person.class);

    private Person current;

    public Verb(int level, String value, String translation, String firstSingular, String secondSingular,
                String thirdSingular, String firstPlural, String secondPlural, String thirdPlural) {
        super(level, value, translation);

        initialize();

        conjugated.put(Person.FIRST_SINGULAR, firstSingular);
        conjugated.put(Person.SECOND_SINGULAR, secondSingular);
        conjugated.put(Person.THIRD_SINGULAR, thirdSingular);
        conjugated.put(Person.FIRST_PLURAL, firstPlural);
        conjugated.put(Person.SECOND_PLURAL, secondPlural);
        conjugated.put(Person.THIRD_PLURAL, thirdPlural);
    }

    @Override
    public void initialize() {
        current = Person.values()[new Random().nextInt(Person.values().length)];
    }

    public String getConjugated(Person person) {
        return conjugated.get(person);
    }

    public Person getCurrent(){
        return current;
    }
}
