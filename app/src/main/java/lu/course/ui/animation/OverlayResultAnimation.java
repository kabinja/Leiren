package lu.course.ui.animation;

import android.animation.Animator;
import android.graphics.Color;
import android.view.View;

public class OverlayResultAnimation {
    private final View overlayResult;

    public OverlayResultAnimation(View overlayResult) {
        this.overlayResult = overlayResult;
        this.overlayResult.setVisibility(View.GONE);
    }

    public void animateResult(boolean isCorrect){
        overlayResult.setBackgroundColor(isCorrect ? Color.GREEN : Color.RED);
        overlayResult.setAlpha(0f);
        overlayResult.setVisibility(View.VISIBLE);

        overlayResult.animate()
                .alpha(1f)
                .setDuration(100)
                .setListener(new OverlayListener())
                .start();
    }

    private class OverlayListener implements Animator.AnimatorListener {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            terminate();
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            terminate();
        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }

        private void terminate(){
            overlayResult.animate()
                    .alpha(0f)
                    .setDuration(100)
                    .setListener(null);

            overlayResult.setVisibility(View.GONE);
        }
    }
}
