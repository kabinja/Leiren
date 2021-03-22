package lu.course.ui.gender;

import lu.course.model.Noun;
import lu.course.model.QuestionViewModel;

public class GenderViewModel extends QuestionViewModel<Noun, Noun.Gender> {
    public GenderViewModel(){
        super(Noun.class);
    }

    protected boolean isCorrect(Noun noun, Noun.Gender gender){
        return noun.getGender() == gender;
    }
}