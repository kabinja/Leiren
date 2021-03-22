package lu.course.ui.plural;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;

import lu.course.R;
import lu.course.ui.LeierenActivity;
import lu.course.ui.animation.OverlayResultAnimation;

public class PluralActivity extends LeierenActivity {
    private PluralViewModel pluralViewModel;
    private OverlayResultAnimation overlayResultAnimation;
    private EditText pluralText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plural);

        pluralViewModel = new ViewModelProvider(this).get(PluralViewModel.class);
        pluralText = findViewById(R.id.edit_text_plural);

        final Button validateButton = findViewById(R.id.button_validate);
        validateButton.setOnClickListener(v -> isPlural());

        final TextView textView = findViewById(R.id.text_singular);
        pluralViewModel.getText().observe(this, textView::setText);
        pluralText.setOnKeyListener(onEnterListener(this::isPlural));

        final View overlayResult = findViewById(R.id.overlay_result);
        overlayResultAnimation = new OverlayResultAnimation(overlayResult);
    }

    private void isPlural(){
        boolean isCorrect = pluralViewModel.setAnswer(pluralText.getText().toString());

        overlayResultAnimation.animateResult(isCorrect);
        pluralViewModel.update();
        pluralText.setText("");
    }
}
