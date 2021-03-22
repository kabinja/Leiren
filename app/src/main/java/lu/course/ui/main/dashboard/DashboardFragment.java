package lu.course.ui.main.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import lu.course.R;
import lu.course.ui.gender.GenderActivity;
import lu.course.ui.plural.PluralActivity;
import lu.course.ui.verb.VerbActivity;
import lu.course.ui.vocabulary.VocabularyActivity;

public class DashboardFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        linkToActivity(root, R.id.button_gender, GenderActivity.class);
        linkToActivity(root, R.id.button_plurals, PluralActivity.class);
        linkToActivity(root, R.id.button_vocabulary, VocabularyActivity.class);
        linkToActivity(root, R.id.button_verbs, VerbActivity.class);

        return root;
    }

    private void linkToActivity(View view, int buttonId, Class<? extends AppCompatActivity> activityClass){
        view.findViewById(buttonId).setOnClickListener(v -> startActivity(new Intent(getActivity(), activityClass)));
    }
}
