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
    /* renamed from: b */
    private final ViewGroup f6860b;
    /* renamed from: c */
    private Drawable f6861c;
    /* renamed from: d */
    private View f6862d;
    /* renamed from: e */
    private int f6863e;
    /* renamed from: f */
    private int f6864f;

    public HangTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6861c = null;
        this.f6862d = null;
        this.f6863e = 0;
        this.f6864f = 0;
        this.f6860b = new dh(this, getContext());
        addView(this.f6860b, new LayoutParams(-2, -2));
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
        this.f6861c = drawable;
        requestLayout();
    }

    public void setTagDrawable(int i) {
        Drawable drawable = getResources().getDrawable(i);
        if (drawable != null) {
            View imageView = new ImageView(getContext());
            imageView.setImageDrawable(drawable);
            m10140a(imageView, null);
        }
    }

    /* renamed from: a */
    public void m10140a(View view, FrameLayout.LayoutParams layoutParams) {
        if (this.f6862d != view) {
            this.f6862d = view;
            this.f6860b.removeAllViews();
        }
        if (this.f6862d != null) {
            LayoutParams layoutParams2;
            ViewGroup viewGroup = this.f6860b;
            View view2 = this.f6862d;
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            }
            viewGroup.addView(view2, layoutParams2);
        }
    }
}
