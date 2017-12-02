package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.core.ui.ZoomView;

public class HangTagView extends ZoomView {
    private final ViewGroup b;
    private Drawable c;
    private View d;
    private int e;
    private int f;

    public HangTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.b = new dh(this, getContext());
        addView(this.b, new LayoutParams(-2, -2));
        setHorizontalOverScrollMode(OverScrollMode.NEVER);
        setVerticalOverScrollMode(OverScrollMode.ALWAYS);
        setThumbEnabled(false);
        setClipChildren(false);
        setClipToPadding(false);
    }

    public HangTagView(Context context) {
        this(context, null);
    }

    public void setTagChainDrawable(Drawable drawable) {
        this.c = drawable;
        requestLayout();
    }

    public void setTagDrawable(int i) {
        Drawable drawable = getResources().getDrawable(i);
        if (drawable != null) {
            View imageView = new ImageView(getContext());
            imageView.setImageDrawable(drawable);
            a(imageView, null);
        }
    }

    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        if (this.d != view) {
            this.d = view;
            this.b.removeAllViews();
        }
        if (this.d != null) {
            ViewGroup viewGroup = this.b;
            View view2 = this.d;
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            viewGroup.addView(view2, layoutParams);
        }
    }
}
