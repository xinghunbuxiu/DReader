package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.duokan.b.e;
import com.duokan.b.g;
import com.duokan.core.ui.dv;

public class LoadingCircleView extends FrameLayout {
    private final ImageView a;
    private LoadingStyle b;

    public enum LoadingStyle {
        NORMAL,
        COMIC
    }

    public LoadingCircleView(Context context) {
        this(context, null);
    }

    public LoadingCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.a = (ImageView) LayoutInflater.from(getContext()).inflate(g.general__loading_circle_view, this, false);
        addView(this.a);
        setLoadingStyle(LoadingStyle.NORMAL);
    }

    public void setLoadingStyle(LoadingStyle loadingStyle) {
        if (this.b == null || this.b != loadingStyle) {
            Drawable drawable;
            this.a.clearAnimation();
            this.b = loadingStyle;
            if (loadingStyle == LoadingStyle.COMIC) {
                this.a.setBackgroundDrawable(null);
                drawable = (AnimationDrawable) getResources().getDrawable(e.general__shared__comic_loading);
            } else {
                this.a.setBackgroundDrawable(getResources().getDrawable(e.general__shared__loading_circle_background));
                AnimationDrawable animationDrawable = (AnimationDrawable) getResources().getDrawable(e.general__shared__loading_circle);
            }
            this.a.setImageDrawable(drawable);
        }
    }

    public LoadingStyle getLoadingStyle() {
        return this.b;
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.a != null && (this.a.getDrawable() instanceof AnimationDrawable)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.a.getDrawable();
            if (i == 0 && dv.b(view) == 0) {
                animationDrawable.start();
            } else {
                animationDrawable.stop();
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null && (this.a.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.a.getDrawable()).stop();
        }
    }
}
