package lu.course.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WordsProvider {
    private WordsProvider() {}

    private static final Word[] words = new Word[]{
            new Noun(1, "Fro", "Froen", Noun.Gender.FEMININE, "Question"),
            new Noun(1, "Land", "Länner", Noun.Gender.MASCULINE, "Country"),
            new Verb(1, "heeschen", "to be called", "heeschen", "heeschs", "heescht", "heeschen", "heescht", "heeschen"),
            new Noun(1, "Faarf", "Faarwen", Noun.Gender.FEMININE, "Color"),
            new Noun(1, "Fändel", "Fändelen", Noun.Gender.MASCULINE, "Flag"),
            new Noun(1, "Nationalitéit", "Nationalitéiten", Noun.Gender.FEMININE, "Nationality"),
            new Noun(1, "Sprooch", "Sproochen", Noun.Gender.FEMININE, "Language"),
            new Noun(1, "Stad", "Stied", Noun.Gender.FEMININE, "City"),
            new Verb(1, "kommen", "to come", "kommen", "kënns", "kënnt", "kommen", "kommt", "kommen"),
            new Verb(1, "léieren", "to learn", "léieren", "léiers", "léiert", "léieren", "léiert", "léieren"),
            new Verb(1, "schwätzen", "to speak", "schwätzen", "schwätz", "schwätzt", "schwätzen", "schwätzt", "schwätzen"),
            new Word(1, "Vu wou?", "from where?"),
            new Word(1, "Wat?", "what?"),
            new Word(1, "Wéi?", "how?"),
            new Word(1, "Wéini", "when?"),
            new Word(1, "Wéi geet et?", "How are you?"),
            new Word(1, "Wien", "who?"),
            new Word(1, "Wou?", "where"),
            new Word(1, "Wéi schreift een dat?", "how does one write that?"),
            new Word(1, "Entschëllegt", "Excuse me"),
            new Verb(1, "verstoen", "to understand", "verstinn", "verstees", "versteet", "verstinn", "verstitt", "verstinn"),
            new Verb(1, "hëllefen", "to help", "hëllefen", "hëllefs", "hëlleft", "hëllefen", "hëlleft", "hëllefen"),
            new Word(1, "Äddi", "Goodbye (Informal)"),
            new Word(1, "Awar", "Goodbye (Formal)"),
            new Word(1, "Bonjour", "Hello (Formal)"),
            new Word(1, "Gudde Moien", "Good morning"),
            new Word(1, "Gudde Mëtteg", "Good afternoon"),
            new Word(1, "Gudden Owend", "Good evening"),
            new Word(1, "Gutt Nuecht", "Good night"),
            new Word(1, "Moien", "Hello"),
            new Word(1, "Shéine Mëtteg", "Have a nice afternoon"),
            new Word(1, "Shéinen Owen", "Have a nice evening"),
            new Word(1, "Shéinen Dag", "Have a nice day"),
            new Word(1, "schéinen", "beautiful"),
            new Word(1, "Ganz gutt", "very good"),
            new Word(1, "Guer net gutt", "not good at all"),
            new Word(1, "gut", "good"),
            new Word(1, "schlecht", "bad"),
            new Word(1, "tipptopp", "super"),
            new Word(1, "einfach", "easy"),
            new Word(1, "schwéier", "hard"),
            new Noun(1, "Familljennumm", "Familljennimm", Noun.Gender.MASCULINE, "Last name"),
            new Noun(1, "Numm", "Nimm", Noun.Gender.MASCULINE, "Name"),
            new Noun(1, "Virnumm", "Virnimm", Noun.Gender.MASCULINE, "First name"),
            new Verb(1, "buschtawéieren", "to spell", "buschtawéieren", "buschtawéiers", "buschtawéiert", "buschtawéieren", "buschtawéiert", "buschtawéieren"),
            new Verb(1, "duzen", "to address someone informally", "duzen", "duz", "duzt", "duzen", "duzt", "duzen"),
            new Verb(1, "schreiwen", "to write", "schreiwen", "schreifs", "schreift", "schreiwen", "schreift", "schreiwen"),
            new Verb(1, "sinn", "to be", "sinn", "bass", "ass", "sinn", "sidd", "sinn"),
            new Word(1, "Et freet mech", "Pleased to meet you"),
            new Word(1, "Gär geschitt", "You're welcome"),
            new Word(1, "Merci", "Thank you"),
            new Word(1, "Merci gläichfalls", "Thank you, the same to you"),
            new Word(1, "Villmools Merci", "Thanks a lot"),
            new Word(1, "Wann ech gelift", "Please"),
            new Word(1, "an", "and"),
            new Word(1, "oder", "or"),
            new Word(1, "Kee Problem", "No problem"),
    };

    public static <W extends Word> List<W> get(int limit, Class<W> type){
        return shuffledList().stream()
                .filter(w -> type.isAssignableFrom(w.getClass()))
                .map(type::cast)
                .limit(limit)
                .peek(Word::initialize)
                .collect(Collectors.toList());
    }

    private static List<Word> shuffledList(){
        List<Word> wordList = Arrays.asList(words);
        Collections.shuffle(wordList);

        return wordList;
    }
}
