package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.TabBarView;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0242d;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;

public class ar extends LinearLayout {
    /* renamed from: a */
    private final LinearLayout f6937a;
    /* renamed from: b */
    private View f6938b;
    /* renamed from: c */
    private BoxView f6939c;
    /* renamed from: d */
    private TabBarView f6940d;
    /* renamed from: e */
    private int f6941e;
    /* renamed from: f */
    private FrameLayout f6942f;
    /* renamed from: g */
    private List<View> f6943g;
    /* renamed from: h */
    private at f6944h;

    public ar(Context context) {
        this(context, null);
    }

    public ar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6941e = 0;
        this.f6943g = new ArrayList();
        this.f6937a = new LinearLayout(getContext());
        this.f6937a.setOrientation(0);
        this.f6937a.setGravity(17);
        this.f6937a.setBackgroundResource(C0241c.general__shared__ffffff);
        this.f6938b = new ImageView(getContext());
        this.f6938b.setVisibility(8);
        this.f6939c = new BoxView(getContext());
        int b = dv.m1932b(getContext(), 10.0f);
        this.f6939c.setPadding(b, b, b, b);
        this.f6940d = new TabBarView(getContext());
        this.f6940d.setBackgroundResource(C0243e.general__shared__tabs_bg_2);
        b = getResources().getDimensionPixelSize(C0242d.general__shared__tabs_bg_stoke_size);
        this.f6940d.setPadding(b, b, b, b);
        this.f6940d.setLayoutParams(new LayoutParams(-1, dv.m1932b(getContext(), 29.0f), 17));
        this.f6940d.setSelectionChangeListener(new as(this));
        this.f6942f = new FrameLayout(getContext());
        setOrientation(1);
        addView(this.f6937a, new LinearLayout.LayoutParams(-1, -2));
        addView(this.f6938b, -1, 2);
        addView(this.f6942f, new LinearLayout.LayoutParams(-1, -1));
        this.f6937a.addView(this.f6939c, new LinearLayout.LayoutParams(-1, -2));
        this.f6939c.addView(this.f6940d);
        setTitleBottomLineColor(getContext().getResources().getColor(C0241c.general__shared__999999));
    }

    public void setTabEnabled(boolean z) {
        this.f6940d.setTabEnabled(z);
    }

    public View getTitleView() {
        return this.f6937a;
    }

    public BoxView getButtonBox() {
        return this.f6939c;
    }

    public TabBarView getButtonManager() {
        return this.f6940d;
    }

    public void setTitleBottomLineColor(int i) {
        this.f6938b.setVisibility(0);
        this.f6938b.setBackgroundColor(i);
    }

    public void setTitleBottomLineVisibility(int i) {
        this.f6938b.setVisibility(i);
    }

    public void setButtonsString(ArrayList<String> arrayList) {
        m10235a((ArrayList) arrayList, C0245g.general__shared__left_tab_view_2, C0245g.general__shared__right_tab_view_2, C0245g.personal__comment_tab_view_2);
    }

    /* renamed from: a */
    public void m10235a(ArrayList<String> arrayList, int i, int i2, int i3) {
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            String str = (String) arrayList.get(i4);
            if (i4 == 0) {
                ((TextView) this.f6940d.m1322c(i).findViewById(C0244f.general__shared__tab_view__text)).setText(str);
            } else if (i4 == arrayList.size() - 1) {
                ((TextView) this.f6940d.m1322c(i2).findViewById(C0244f.general__shared__tab_view__text)).setText(str);
            } else {
                ((TextView) this.f6940d.m1322c(i3)).setText(str);
            }
        }
    }

    public void setViews(ArrayList<View> arrayList) {
        this.f6943g = arrayList;
        this.f6942f.removeAllViewsInLayout();
        if (this.f6943g != null && this.f6943g.size() > 0) {
            for (View view : this.f6943g) {
                this.f6942f.addView(view, new LayoutParams(-1, -1));
                view.setVisibility(4);
            }
            this.f6942f.getChildAt(0).setVisibility(0);
        }
    }

    public void setOnSelectChangedListener(at atVar) {
        this.f6944h = atVar;
    }

    public int getSelectIndex() {
        return this.f6941e;
    }

    public void setSelectIndex(int i) {
        this.f6940d.m1319a(i);
        m10230a(i);
    }

    /* renamed from: a */
    public void m10234a(int i, int i2) {
        ImageView imageView = (ImageView) this.f6940d.m1321b(i).findViewById(C0244f.general__shared__tab_view__num);
        if (i2 == 0) {
            imageView.setVisibility(8);
        } else {
            Drawable background = imageView.getBackground();
            if (background == null || !(background instanceof er)) {
                background = new er(getContext());
                imageView.setBackgroundDrawable(background);
            }
            ((er) background).m10570a("" + i2);
            imageView.setVisibility(0);
        }
        imageView.invalidate();
    }

    /* renamed from: a */
    private void m10230a(int i) {
        if (this.f6941e != i) {
            this.f6941e = i;
            if (this.f6944h != null) {
                this.f6944h.mo1893a(i);
            }
        }
    }

    /* renamed from: a */
    private void m10231a(int i, int i2, boolean z) {
        int childCount = this.f6942f.getChildCount();
        View childAt = this.f6942f.getChildAt(i2);
        View childAt2 = this.f6942f.getChildAt(i);
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
