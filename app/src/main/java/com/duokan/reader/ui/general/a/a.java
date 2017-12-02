package com.duokan.reader.ui.general.a;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class a {
    public static void a(View view, long j, Runnable runnable) {
        View view2 = (View) view.getParent();
        view.measure(-2, -2);
        view2.measure(-2, -2);
        Animation bVar = new b(view, view2.getWidth(), view.getMeasuredWidth());
        bVar.setDuration(j);
        bVar.setInterpolator(new DecelerateInterpolator());
        bVar.setAnimationListener(a(view, runnable));
        view.startAnimation(bVar);
    }

    public static void b(View view, long j, Runnable runnable) {
        View view2 = (View) view.getParent();
        view2.measure(-2, -2);
        view.measure(-2, -2);
        Animation cVar = new c(view, view.getMeasuredWidth(), view2.getWidth());
        cVar.setDuration(j);
        cVar.setInterpolator(new AccelerateInterpolator());
        cVar.setAnimationListener(a(view, runnable));
        view.startAnimation(cVar);
    }

    public static void a(View view, float f, float f2, float f3, float f4, long j, Boolean bool, Runnable runnable) {
        Animation translateAnimation = new TranslateAnimation(f, f2, f3, f4);
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(bool.booleanValue());
        translateAnimation.setAnimationListener(a(view, runnable));
        view.startAnimation(translateAnimation);
    }

    public static void a(View view, int i, float f, float f2, float f3, float f4, long j, Boolean bool, AnimationListener animationListener) {
        Animation translateAnimation = new TranslateAnimation(i, f, i, f2, i, f3, i, f4);
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(bool.booleanValue());
        translateAnimation.setAnimationListener(animationListener);
        view.startAnimation(translateAnimation);
    }

    public static Animation a(View view, float f, float f2, float f3, float f4, long j, Boolean bool, AnimationListener animationListener) {
        Animation scaleAnimation = new ScaleAnimation(f, f2, f3, f4, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(j);
        scaleAnimation.setFillAfter(bool.booleanValue());
        scaleAnimation.setAnimationListener(animationListener);
        view.startAnimation(scaleAnimation);
        return scaleAnimation;
    }

    public static Animation a(View view, AnimationListener animationListener) {
        return a(view, 0.4f, 1.0f, 0.4f, 1.0f, 150, Boolean.valueOf(true), animationListener);
    }

    public static Animation b(View view, AnimationListener animationListener) {
        return a(view, 1.0f, 0.4f, 1.0f, 0.4f, 150, Boolean.valueOf(true), animationListener);
    }

    public static Animation a(View view, float f, float f2, long j, Boolean bool, Runnable runnable) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(j);
        alphaAnimation.setFillAfter(bool.booleanValue());
        alphaAnimation.setAnimationListener(a(view, runnable));
        view.startAnimation(alphaAnimation);
        return alphaAnimation;
    }

    public static AnimationListener a(View view, Runnable runnable) {
        return new d(runnable);
    }
}
