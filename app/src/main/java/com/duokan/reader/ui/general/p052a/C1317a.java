package com.duokan.reader.ui.general.p052a;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

/* renamed from: com.duokan.reader.ui.general.a.a */
public class C1317a {
    /* renamed from: a */
    public static void m10196a(View view, long j, Runnable runnable) {
        View view2 = (View) view.getParent();
        view.measure(-2, -2);
        view2.measure(-2, -2);
        Animation c1318b = new C1318b(view, view2.getWidth(), view.getMeasuredWidth());
        c1318b.setDuration(j);
        c1318b.setInterpolator(new DecelerateInterpolator());
        c1318b.setAnimationListener(C1317a.m10192a(view, runnable));
        view.startAnimation(c1318b);
    }

    /* renamed from: b */
    public static void m10197b(View view, long j, Runnable runnable) {
        View view2 = (View) view.getParent();
        view2.measure(-2, -2);
        view.measure(-2, -2);
        Animation c1319c = new C1319c(view, view.getMeasuredWidth(), view2.getWidth());
        c1319c.setDuration(j);
        c1319c.setInterpolator(new AccelerateInterpolator());
        c1319c.setAnimationListener(C1317a.m10192a(view, runnable));
        view.startAnimation(c1319c);
    }

    /* renamed from: a */
    public static void m10194a(View view, float f, float f2, float f3, float f4, long j, Boolean bool, Runnable runnable) {
        Animation translateAnimation = new TranslateAnimation(f, f2, f3, f4);
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(bool.booleanValue());
        translateAnimation.setAnimationListener(C1317a.m10192a(view, runnable));
        view.startAnimation(translateAnimation);
    }

    /* renamed from: a */
    public static void m10195a(View view, int i, float f, float f2, float f3, float f4, long j, Boolean bool, AnimationListener animationListener) {
        Animation translateAnimation = new TranslateAnimation(i, f, i, f2, i, f3, i, f4);
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(bool.booleanValue());
        translateAnimation.setAnimationListener(animationListener);
        view.startAnimation(translateAnimation);
    }

    /* renamed from: a */
    public static Animation m10193a(View view, float f, float f2, long j, Boolean bool, Runnable runnable) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(j);
        alphaAnimation.setFillAfter(bool.booleanValue());
        alphaAnimation.setAnimationListener(C1317a.m10192a(view, runnable));
        view.startAnimation(alphaAnimation);
        return alphaAnimation;
    }

    /* renamed from: a */
    public static AnimationListener m10192a(View view, Runnable runnable) {
        return new C1320d(runnable);
    }
}
