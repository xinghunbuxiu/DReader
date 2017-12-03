package com.duokan.reader.ui.general;

import android.content.Context;
import android.text.TextUtils;
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
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.j;

public class gq implements dq {
    private final j a;
    private FrameLayout b;
    private LinearLayout c;
    private boolean d = false;

    public gq(j jVar) {
        this.a = jVar;
        Context context = this.a.getContext();
        this.c = new LinearLayout(context);
        this.c.setBackgroundResource(e.general__shared__menu_bg);
        this.c.setOrientation(1);
        this.c.setGravity(80);
        this.b = new FrameLayout(context);
        this.b.setBackgroundColor(context.getResources().getColor(c.general__shared__f7f7f7));
        View frameLayout = new FrameLayout(context);
        frameLayout.addView(this.c, new LayoutParams(-1, -2));
        frameLayout.addView(this.b, new LayoutParams(-1, -2));
        new RelativeLayout.LayoutParams(-1, -2).addRule(12);
        jVar.setContentView(frameLayout);
        jVar.setEnterAnimation(b.general__shared__push_down_in);
        jVar.setExitAnimation(b.general__shared__push_down_out);
        jVar.setGravity(80);
        jVar.setDimAmount(0.75f);
    }

    public void a(boolean z) {
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.d = true;
            View dkLabelView = new DkLabelView(this.a.getContext());
            dkLabelView.setGravity(17);
            dkLabelView.setPadding(0, UTools.closeAnimation(this.a.getContext(), 18.0f), 0, UTools.closeAnimation(this.a.getContext(), 15.0f));
            dkLabelView.setTextColor(this.a.getContext().getResources().getColor(c.general__shared__333333));
            dkLabelView.setTextSize(0, this.a.getContext().getResources().getDimension(d.general_font__shared__b));
            dkLabelView.setText(str);
            this.c.addView(dkLabelView, 0);
        }
    }

    public LinearLayout a() {
        return this.c;
    }

    public ViewGroup b() {
        return this.b;
    }

    public View a(String str, int i, boolean z) {
        View inflate = LayoutInflater.from(this.a.getContext()).inflate(g.general__dk_spirt_menu_item_view, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(f.general__shared_spirt_menu_item_view__text);
        if (i != 0) {
            dkLabelView.setCompoundDrawablesWithIntrinsicBounds(this.a.getContext().getResources().getDrawable(i), null, null, null);
            dkLabelView.setCompoundDrawablePadding(i.a(this.a.getContext(), 10.0f));
        }
        if (!z) {
            inflate.findViewById(f.general__shared_spirt_menu_item_view__top_line).setVisibility(8);
        }
        dkLabelView.setText(str);
        return inflate;
    }

    public int c() {
        if (this.d) {
            return this.c.getChildCount() - 1;
        }
        return this.c.getChildCount();
    }
}
