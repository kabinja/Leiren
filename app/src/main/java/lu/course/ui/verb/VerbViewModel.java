package lu.course.ui.verb;

import lu.course.model.QuestionViewModel;
import lu.course.model.Verb;

public class VerbViewModel extends QuestionViewModel<Verb, String> {
    public VerbViewModel(){
        super(Verb.class);
    }

    @Override
    protected String getTextToDisplay(){
        Verb verb = getWord();
        return String.format("%s%n%s ...", verb.getValue(), pretty(verb.getCurrent()));
    }

    @Override
    protected boolean isCorrect(Verb verb, String answer) {
        return verb.getConjugated(verb.getCurrent()).equalsIgnoreCase(answer.trim());
    }

    private String pretty(Verb.Person person){
        switch (person) {
            case FIRST_SINGULAR: return "esch";
            case SECOND_SINGULAR: return "du";
            case THIRD_SINGULAR: return "hien/si/hatt/et";
            case FIRST_PLURAL: return "mir";
            case SECOND_PLURAL: return "dir/Dir";
            case THIRD_PLURAL: return "si (plural)";
        }

        throw new IllegalArgumentException(person.name());
    }
}
