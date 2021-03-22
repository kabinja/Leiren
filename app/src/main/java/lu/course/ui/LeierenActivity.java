package lu.course.ui;

import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

public abstract class LeierenActivity extends AppCompatActivity {
    @NotNull
    protected View.OnKeyListener onEnterListener(OnValueCommitListener l) {
        return (v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                l.onCommit();
                return true;
            }

            return false;
        };
    }

    public interface OnValueCommitListener{
        void onCommit();
    }
}
