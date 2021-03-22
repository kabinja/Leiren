package lu.course.ui.plural;

import lu.course.model.Noun;
import lu.course.model.QuestionViewModel;

public class PluralViewModel extends QuestionViewModel<Noun, String> {
    public PluralViewModel(){
        super(Noun.class);
    }

    @Override
    protected boolean isCorrect(Noun noun, String answer) {
        return noun.getPlural().equalsIgnoreCase(answer.trim());
    }
}
