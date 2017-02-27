package com.example.dingchen.youkumenu;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by DIngChen on 2/27/2017.
 */

public class AnimationUtils {

    public static void rotateOutAnim(RelativeLayout layout,long delay) {
        int childCount = layout.getChildCount();
        for (int i=0;i<childCount;i++){
            layout.getChildAt(i).setEnabled(false);
        }
        //做旋转动画
        RotateAnimation ra = new RotateAnimation(0f,-180f,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,1.0f);
        ra.setDuration(500);
        ra.setFillAfter(true);
        ra.setStartOffset(delay);
        ra.setAnimationListener(new MyAnimationListener());
        layout.startAnimation(ra);
    }


    public static void rotateInAnim(RelativeLayout layout,long delay) {
        int childCount = layout.getChildCount();
        for (int i=0;i<childCount;i++){
            layout.getChildAt(i).setEnabled(true);
        }
        RotateAnimation ra = new RotateAnimation(-180f,0f,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,1.0f);
        ra.setDuration(500);
        ra.setFillAfter(true);
        ra.setAnimationListener(new MyAnimationListener());
        ra.setStartOffset(delay);
        layout.startAnimation(ra);
    }
    public static int runningAnimationCount = 0;
    static class MyAnimationListener implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation) {
            runningAnimationCount ++;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            runningAnimationCount--;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

    }

}
