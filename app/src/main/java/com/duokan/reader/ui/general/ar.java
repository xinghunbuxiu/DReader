package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.TabBarView;
import com.duokan.core.ui.UTools;

import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ar extends LinearLayout {
    private final LinearLayout a;
    private View b;
    private BoxView c;
    private TabBarView d;
    private int e;
    private FrameLayout f;
    private List g;
    private at h;

    public ar(Context context) {
        this(context, null);
    }

    public ar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        this.g = new ArrayList();
        this.a = new LinearLayout(getContext());
        this.a.setOrientation(0);
        this.a.setGravity(17);
        this.a.setBackgroundResource(c.general__shared__ffffff);
        this.b = new ImageView(getContext());
        this.b.setVisibility(8);
        this.c = new BoxView(getContext());
        int b = UTools.getMinimumHeight(getContext(), 10.0f);
        this.c.setPadding(b, b, b, b);
        this.d = new TabBarView(getContext());
        this.d.setBackgroundResource(e.general__shared__tabs_bg_2);
        b = getResources().getDimensionPixelSize(d.general__shared__tabs_bg_stoke_size);
        this.d.setPadding(b, b, b, b);
        this.d.setLayoutParams(new LayoutParams(-1, UTools.getMinimumHeight(getContext(), 29.0f), 17));
        this.d.setSelectionChangeListener(new as(this));
        this.f = new FrameLayout(getContext());
        setOrientation(1);
        addView(this.a, new LinearLayout.LayoutParams(-1, -2));
        addView(this.b, -1, 2);
        addView(this.f, new LinearLayout.LayoutParams(-1, -1));
        this.a.addView(this.c, new LinearLayout.LayoutParams(-1, -2));
        this.c.addView(this.d);
        setTitleBottomLineColor(getContext().getResources().getColor(c.general__shared__999999));
    }

    public void setTabEnabled(boolean z) {
        this.d.setTabEnabled(z);
    }

    public View getTitleView() {
        return this.a;
    }

    public BoxView getButtonBox() {
        return this.c;
    }

    public TabBarView getButtonManager() {
        return this.d;
    }

    public void setTitleBottomLineColor(int i) {
        this.b.setVisibility(0);
        this.b.setBackgroundColor(i);
    }

    public void setTitleBottomLineVisibility(int i) {
        this.b.setVisibility(i);
    }

    public void setButtonsString(ArrayList arrayList) {
        a(arrayList, g.general__shared__left_tab_view_2, g.general__shared__right_tab_view_2, g.personal__comment_tab_view_2);
    }

    public void a(ArrayList arrayList, int i, int i2, int i3) {
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            String str = (String) arrayList.get(i4);
            if (i4 == 0) {
                ((TextView) this.d.c(i).findViewById(f.general__shared__tab_view__text)).setText(str);
            } else if (i4 == arrayList.size() - 1) {
                ((TextView) this.d.c(i2).findViewById(f.general__shared__tab_view__text)).setText(str);
            } else {
                ((TextView) this.d.c(i3)).setText(str);
            }
        }
    }

    public void setViews(ArrayList arrayList) {
        this.g = arrayList;
        this.f.removeAllViewsInLayout();
        if (this.g != null && this.g.size() > 0) {
            for (View view : this.g) {
                this.f.addView(view, new LayoutParams(-1, -1));
                view.setVisibility(4);
            }
            this.f.getChildAt(0).setVisibility(0);
        }
    }

    public void setOnSelectChangedListener(at atVar) {
        this.h = atVar;
    }

    public int getSelectIndex() {
        return this.e;
    }

    public void setSelectIndex(int i) {
        this.d.a(i);
        a(i);
    }

    public void a(int i, int i2) {
        ImageView imageView = (ImageView) this.d.b(i).findViewById(f.general__shared__tab_view__num);
        if (i2 == 0) {
            imageView.setVisibility(8);
        } else {
            Drawable background = imageView.getBackground();
            if (background == null || !(background instanceof et)) {
                background = new et(getContext());
                imageView.setBackgroundDrawable(background);
            }
            ((et) background).a("" + i2);
            imageView.setVisibility(0);
        }
        imageView.invalidate();
    }

    private void a(int i) {
        if (this.e != i) {
            this.e = i;
            if (this.h != null) {
                this.h.a(i);
            }
        }
    }

    private void a(int i, int i2, boolean z) {
        int childCount = this.f.getChildCount();
        View childAt = this.f.getChildAt(i2);
        View childAt2 = this.f.getChildAt(i);
        childAt.setVisibility(0);
        childAt2.setVisibility(4);
        if (z) {
            Object obj = i2 > i ? 1 : null;
            Animation translateAnimation = new TranslateAnimation(2, obj != null ? 1.0f : -1.0f, 2, obj != null ? 0.0f : 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            Animation translateAnimation2 = new TranslateAnimation(2, obj != null ? 0.0f : 0.0f, 2, obj != null ? -1.0f : 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
            int abs = ((Math.abs(i2 - i) + 1) * HttpStatus.SC_OK) / childCount;
            translateAnimation.setDuration((long) abs);
            translateAnimation2.setDuration((long) abs);
            childAt.startAnimation(translateAnimation);
            childAt2.startAnimation(translateAnimation2);
        }
    }
}
