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
import com.duokan.common.CommonUtils;
import com.duokan.core.ui.BaseDialog;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0240b;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0242d;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;

public class gk implements dq {
    /* renamed from: a */
    private final BaseDialog f7281a;
    /* renamed from: b */
    private FrameLayout f7282b;
    /* renamed from: c */
    private LinearLayout f7283c;
    /* renamed from: d */
    private boolean f7284d = false;

    public gk(BaseDialog dialog) {
        this.f7281a = dialog;
        Context context = this.f7281a.getContext();
        this.f7283c = new LinearLayout(context);
        this.f7283c.setBackgroundResource(C0243e.general__shared__menu_bg);
        this.f7283c.setOrientation(1);
        this.f7283c.setGravity(80);
        this.f7282b = new FrameLayout(context);
        this.f7282b.setBackgroundColor(context.getResources().getColor(C0241c.general__shared__f7f7f7));
        View frameLayout = new FrameLayout(context);
        frameLayout.addView(this.f7283c, new LayoutParams(-1, -2));
        frameLayout.addView(this.f7282b, new LayoutParams(-1, -2));
        new RelativeLayout.LayoutParams(-1, -2).addRule(12);
        dialog.setContentView(frameLayout);
        dialog.setEnterAnimation(C0240b.general__shared__push_down_in);
        dialog.setExitAnimation(C0240b.general__shared__push_down_out);
        dialog.setGravity(80);
        dialog.setDimAmount(0.75f);
    }

    /* renamed from: a */
    public void mo1785a(boolean z) {
    }

    /* renamed from: a */
    public void mo1784a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f7284d = true;
            View dkLabelView = new DkLabelView(this.f7281a.getContext());
            dkLabelView.setGravity(17);
            dkLabelView.setPadding(0, AnimUtils.m1932b(this.f7281a.getContext(), 18.0f), 0, AnimUtils.m1932b(this.f7281a.getContext(), 15.0f));
            dkLabelView.setTextColor(this.f7281a.getContext().getResources().getColor(C0241c.general__shared__333333));
            dkLabelView.setTextSize(0, this.f7281a.getContext().getResources().getDimension(C0242d.general_font__shared__b));
            dkLabelView.setText(str);
            this.f7283c.addView(dkLabelView, 0);
        }
    }

    /* renamed from: a */
    public LinearLayout mo1783a() {
        return this.f7283c;
    }

    /* renamed from: b */
    public ViewGroup mo1786b() {
        return this.f7282b;
    }

    /* renamed from: a */
    public View mo1782a(String str, int i, boolean z) {
        View inflate = LayoutInflater.from(this.f7281a.getContext()).inflate(C0245g.general__dk_spirt_menu_item_view, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(C0244f.general__shared_spirt_menu_item_view__text);
        if (i != 0) {
            dkLabelView.setCompoundDrawablesWithIntrinsicBounds(this.f7281a.getContext().getResources().getDrawable(i), null, null, null);
            dkLabelView.setCompoundDrawablePadding(CommonUtils.dip2px(this.f7281a.getContext(), 10.0f));
        }
        if (!z) {
            inflate.findViewById(C0244f.general__shared_spirt_menu_item_view__top_line).setVisibility(8);
        }
        dkLabelView.setText(str);
        return inflate;
    }

    /* renamed from: c */
    public int mo1787c() {
        if (this.f7284d) {
            return this.f7283c.getChildCount() - 1;
        }
        return this.f7283c.getChildCount();
    }
}
