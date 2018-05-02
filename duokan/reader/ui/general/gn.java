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

import com.duokan.b.e;
import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.core.ui.j;

public class gn implements dq {
    private final j a;
    private final Context b;
    private final RelativeLayout c = new RelativeLayout(this.b);
    private final LinearLayout d;

    public gn(bx bxVar) {
        this.a = bxVar;
        this.b = bxVar.getContext();
        this.c.setBackgroundColor(Color.argb(128, 0, 0, 0));
        View frameLayout = new FrameLayout(this.b);
        this.d = new LinearLayout(this.b);
        this.d.setBackgroundColor(this.b.getResources().getColor(c.general__shared__ffffff));
        this.d.setOrientation(1);
        this.d.setGravity(48);
        frameLayout.addView(this.d, new LayoutParams(-1, -2));
        View pageHeaderView = new PageHeaderView(d());
        pageHeaderView.setHasBackButton(false);
        pageHeaderView.a(this.b.getResources().getDrawable(e.general__shared__close)).setOnClickListener(new go(this, bxVar));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        pageHeaderView.setId(1);
        this.c.addView(pageHeaderView, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, pageHeaderView.getId());
        this.c.addView(frameLayout, layoutParams);
        bxVar.setContentView(this.c);
        bxVar.setEnterAnimation(b.general__shared__push_up_in);
        bxVar.setExitAnimation(b.general__shared__push_up_out);
        bxVar.setGravity(48);
    }

    public void a(boolean z) {
        if (z) {
            this.c.setOnClickListener(new gp(this));
        } else {
            this.c.setOnClickListener(null);
        }
    }

    public void a(String str) {
    }

    public LinearLayout a() {
        return this.d;
    }

    public View a(String str, int i, boolean z) {
        View inflate = LayoutInflater.from(d()).inflate(g.general__dk_spirt_menu_item_view, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(f.general__shared_spirt_menu_item_view__text);
        if (i != 0) {
            dkLabelView.setCompoundDrawablesWithIntrinsicBounds(d().getResources().getDrawable(i), null, null, null);
            dkLabelView.setCompoundDrawablePadding(i.a(d(), 10.0f));
        }
        if (!z) {
            inflate.findViewById(f.general__shared_spirt_menu_item_view__top_line).setVisibility(8);
        }
        dkLabelView.setText(str);
        return inflate;
    }

    public ViewGroup b() {
        return null;
    }

    private Context d() {
        return this.b;
    }

    public int c() {
        return this.d.getChildCount();
    }
}
