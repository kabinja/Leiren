package lu.course.ui.vocabulary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;

import lu.course.R;
import lu.course.ui.LeierenActivity;
import lu.course.ui.animation.OverlayResultAnimation;

public class VocabularyActivity extends LeierenActivity {
    private VocabularyViewModel vocabularyViewModel;
    private OverlayResultAnimation overlayResultAnimation;
    private EditText luxText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        vocabularyViewModel = new ViewModelProvider(this).get(VocabularyViewModel.class);
        luxText = findViewById(R.id.edit_text_luxembourgish);

        final Button validateButton = findViewById(R.id.button_validate);
        validateButton.setOnClickListener(v -> isTranslation());

        final TextView textView = findViewById(R.id.text_to_translate);
        vocabularyViewModel.getText().observe(this, textView::setText);
        luxText.setOnKeyListener(onEnterListener(this::isTranslation));

        final View overlayResult = findViewById(R.id.overlay_result);
        overlayResultAnimation = new OverlayResultAnimation(overlayResult);
    }

    private void isTranslation(){
        boolean isCorrect = vocabularyViewModel.setAnswer(luxText.getText().toString());

        overlayResultAnimation.animateResult(isCorrect);
        vocabularyViewModel.update();
        luxText.setText("");
    }
}
