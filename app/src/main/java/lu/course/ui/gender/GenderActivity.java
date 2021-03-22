package lu.course.ui.gender;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import lu.course.R;
import lu.course.model.Noun;
import lu.course.ui.animation.OverlayResultAnimation;

public class GenderActivity extends AppCompatActivity {
    private GenderViewModel genderViewModel;
    private OverlayResultAnimation overlayResultAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        genderViewModel = new ViewModelProvider(this).get(GenderViewModel.class);

        final Button masculineButton = findViewById(R.id.button_masculine);
        masculineButton.setOnClickListener(v -> isGender(Noun.Gender.MASCULINE));

        final Button feminineButton = findViewById(R.id.button_feminine);
        feminineButton.setOnClickListener(v -> isGender(Noun.Gender.FEMININE));

        final TextView textView = findViewById(R.id.text_gender);
        genderViewModel.getText().observe(this, textView::setText);

        final View overlayResult = findViewById(R.id.overlay_result);
        overlayResultAnimation = new OverlayResultAnimation(overlayResult);
    }

    private void isGender(Noun.Gender gender){
        boolean answer = genderViewModel.setAnswer(gender);
        overlayResultAnimation.animateResult(answer);
        genderViewModel.update();
    }
}