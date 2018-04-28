package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.duokan.common.C0267i;
import com.duokan.core.ui.C0342j;
import com.duokan.p023b.C0240b;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;

public class gh implements dq {
    /* renamed from: a */
    private final C0342j f7274a;
    /* renamed from: b */
    private final Context f7275b;
    /* renamed from: c */
    private final RelativeLayout f7276c = new RelativeLayout(this.f7275b);
    /* renamed from: d */
    private final LinearLayout f7277d;

    public gh(bx bxVar) {
        this.f7274a = bxVar;
        this.f7275b = bxVar.getContext();
        this.f7276c.setBackgroundColor(Color.argb(128, 0, 0, 0));
        View frameLayout = new FrameLayout(this.f7275b);
        this.f7277d = new LinearLayout(this.f7275b);
        this.f7277d.setBackgroundColor(this.f7275b.getResources().getColor(C0241c.general__shared__ffffff));
        this.f7277d.setOrientation(1);
        this.f7277d.setGravity(48);
        frameLayout.addView(this.f7277d, new LayoutParams(-1, -2));
        View pageHeaderView = new PageHeaderView(m10691d());
        pageHeaderView.setHasBackButton(false);
        View a = pageHeaderView.m10143a(this.f7275b.getResources().getDrawable(C0243e.general__shared__close));
        a.setContentDescription(this.f7275b.getString(C0247i.general__shared__close));
        a.setOnClickListener(new gi(this, bxVar));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        pageHeaderView.setId(1);
        this.f7276c.addView(pageHeaderView, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, pageHeaderView.getId());
        this.f7276c.addView(frameLayout, layoutParams);
        bxVar.setContentView(this.f7276c);
        bxVar.setEnterAnimation(C0240b.general__shared__push_up_in);
        bxVar.setExitAnimation(C0240b.general__shared__push_up_out);
        bxVar.setGravity(48);
    }

    /* renamed from: a */
    public void mo1785a(boolean z) {
        if (z) {
            this.f7276c.setOnClickListener(new gj(this));
        } else {
            this.f7276c.setOnClickListener(null);
        }
    }

    /* renamed from: a */
    public void mo1784a(String str) {
    }

    /* renamed from: a */
    public LinearLayout mo1783a() {
        return this.f7277d;
    }

    /* renamed from: a */
    public View mo1782a(String str, int i, boolean z) {
        View inflate = LayoutInflater.from(m10691d()).inflate(C0245g.general__dk_spirt_menu_item_view, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(C0244f.general__shared_spirt_menu_item_view__text);
        if (i != 0) {
            dkLabelView.setCompoundDrawablesWithIntrinsicBounds(m10691d().getResources().getDrawable(i), null, null, null);
            dkLabelView.setCompoundDrawablePadding(C0267i.m598a(m10691d(), 10.0f));
        }
        if (!z) {
            inflate.findViewById(C0244f.general__shared_spirt_menu_item_view__top_line).setVisibility(8);
        }
        dkLabelView.setText(str);
        return inflate;
    }

    /* renamed from: b */
    public ViewGroup mo1786b() {
        return null;
    }

    /* renamed from: d */
    private Context m10691d() {
        return this.f7275b;
    }

    /* renamed from: c */
    public int mo1787c() {
        return this.f7277d.getChildCount();
    }
}
