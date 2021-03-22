package lu.course.ui.vocabulary;

import lu.course.model.QuestionViewModel;
import lu.course.model.Word;

public class VocabularyViewModel extends QuestionViewModel<Word, String> {
    public VocabularyViewModel(){
        super(Word.class);
    }

    @Override
    protected String getTextToDisplay(){
        return getWord().getTranslation();
    }

    @Override
    protected boolean isCorrect(Word word, String answer) {
        return word.getValue().equalsIgnoreCase(answer.trim());
    }
}
