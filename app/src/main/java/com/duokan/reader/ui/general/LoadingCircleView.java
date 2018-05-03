package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0245g;

public class LoadingCircleView extends FrameLayout {
    /* renamed from: a */
    private final ImageView f6875a;
    /* renamed from: b */
    private LoadingStyle f6876b;

    public enum LoadingStyle {
        NORMAL,
        COMIC
    }

    public LoadingCircleView(Context context) {
        this(context, null);
    }

    public LoadingCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6876b = null;
        this.f6875a = (ImageView) LayoutInflater.from(getContext()).inflate(C0245g.general__loading_circle_view, this, false);
        addView(this.f6875a);
        setLoadingStyle(LoadingStyle.NORMAL);
    }

    public void setLoadingStyle(LoadingStyle loadingStyle) {
        if (this.f6876b == null || this.f6876b != loadingStyle) {
            Drawable drawable;
            this.f6875a.clearAnimation();
            this.f6876b = loadingStyle;
            if (loadingStyle == LoadingStyle.COMIC) {
                this.f6875a.setBackgroundDrawable(null);
                drawable = (AnimationDrawable) getResources().getDrawable(C0243e.general__shared__comic_loading);
            } else {
                this.f6875a.setBackgroundDrawable(getResources().getDrawable(C0243e.general__shared__loading_circle_background));
                AnimationDrawable drawable2 = (AnimationDrawable) getResources().getDrawable(C0243e.general__shared__loading_circle);
            }
            this.f6875a.setImageDrawable(drawable2);
        }
    }

    public LoadingStyle getLoadingStyle() {
        return this.f6876b;
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f6875a != null && (this.f6875a.getDrawable() instanceof AnimationDrawable)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f6875a.getDrawable();
            if (i == 0 && AnimUtils.m1933b(view) == 0) {
                animationDrawable.start();
            } else {
                animationDrawable.stop();
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f6875a != null && (this.f6875a.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.f6875a.getDrawable()).stop();
        }
    }
}
