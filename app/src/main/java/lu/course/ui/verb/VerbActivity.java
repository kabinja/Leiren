package lu.course.ui.verb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;

import lu.course.R;
import lu.course.ui.LeierenActivity;
import lu.course.ui.animation.OverlayResultAnimation;

public class VerbActivity extends LeierenActivity {
    private VerbViewModel verbViewModel;
    private OverlayResultAnimation overlayResultAnimation;
    private EditText conjugatedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbs);

        verbViewModel = new ViewModelProvider(this).get(VerbViewModel.class);
        conjugatedText = findViewById(R.id.edit_verb_conjugated);

        final Button validateButton = findViewById(R.id.button_validate);
        validateButton.setOnClickListener(v -> isTranslation());

        final TextView textView = findViewById(R.id.text_verb);
        verbViewModel.getText().observe(this, textView::setText);
        conjugatedText.setOnKeyListener(onEnterListener(this::isTranslation));

        final View overlayResult = findViewById(R.id.overlay_result);
        overlayResultAnimation = new OverlayResultAnimation(overlayResult);
    }

    private void isTranslation(){
        boolean isCorrect = verbViewModel.setAnswer(conjugatedText.getText().toString());

        overlayResultAnimation.animateResult(isCorrect);
        verbViewModel.update();
        conjugatedText.setText("");
    }
}
