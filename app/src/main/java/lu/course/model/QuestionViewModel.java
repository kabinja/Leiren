package lu.course.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public abstract class QuestionViewModel<W extends Word, T> extends ViewModel {
    private final MutableLiveData<String> text;
    private final Class<W> type;

    private List<W> wordList;
    private List<T> answers;
    private int position;

    protected QuestionViewModel(Class<W> type) {
        this.type = type;
        text = new MutableLiveData<>();
        reset();
    }

    public boolean setAnswer(T answer){
        answers.set(position, answer);
        return isCorrect(getWord(), answers.get(position));
    }

    public void update(){
        if(this.wordList.isEmpty()){
            text.setValue("Sorry no words were found");
        }
        else if(++position == this.wordList.size()){
            reset();
        }
        else {
            text.setValue(getTextToDisplay());
        }
    }

    public void reset() {
        position = -1;

        wordList = WordsProvider.get(10, type);
        answers = new ArrayList<>(10);
        for (int i = 0; i < wordList.size(); ++i) answers.add(null);

        update();
    }

    public LiveData<String> getText() {
        return text;
    }

    public W getWord() {
        return this.wordList.get(position);
    }

    protected String getTextToDisplay(){
        return getWord().getValue();
    }

    protected abstract boolean isCorrect(W word, T answer);
}
