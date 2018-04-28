package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import com.duokan.common.C0267i;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.C0342j;
import com.duokan.core.ui.C0374a;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;

class fg implements dq {
    /* renamed from: a */
    private final C0342j f7213a;
    /* renamed from: b */
    private final C0374a f7214b;
    /* renamed from: c */
    private final View f7215c;
    /* renamed from: d */
    private final LinearLayout f7216d = ((LinearLayout) this.f7215c.findViewById(C0244f.general__spirt_dialog_view__content_items));
    /* renamed from: e */
    private final BoxView f7217e = ((BoxView) this.f7215c.findViewById(C0244f.general__spirt_dialog_view__content));
    /* renamed from: f */
    private final ViewGroup f7218f;

    public fg(C0342j c0342j) {
        this.f7213a = c0342j;
        Context context = this.f7213a.getContext();
        this.f7215c = LayoutInflater.from(context).inflate(C0245g.general__spirt_dialog_view_at_hd, null);
        this.f7217e.setBackgroundDrawable(null);
        this.f7218f = (ViewGroup) this.f7215c.findViewById(C0244f.general__spirt_dialog_view__content_extra);
        this.f7214b = new C0374a(context);
        this.f7214b.setGravity(48);
        this.f7214b.setIndicatorMargin(dv.m1932b(context, 11.0f));
        this.f7214b.setIndicator(C0243e.store__search_hint_view__indicator);
        this.f7214b.setBackgroundDrawable(context.getResources().getDrawable(C0243e.store__search_hint_view__bg));
        this.f7214b.addView(this.f7215c, new LayoutParams(-2, -2));
        c0342j.setDimAmount(0.1f);
    }

    /* renamed from: a */
    public void m10640a(Rect rect) {
        LayoutParams marginLayoutParams = new MarginLayoutParams(dv.m1932b(this.f7213a.getContext(), 240.0f), -2);
        int b = dv.m1932b(this.f7213a.getContext(), 10.0f);
        marginLayoutParams.leftMargin = b;
        marginLayoutParams.rightMargin = b;
        this.f7213a.showBalloon(this.f7214b, rect, marginLayoutParams);
        this.f7213a.show();
    }

    /* renamed from: a */
    public void m10641a(View view) {
        LayoutParams marginLayoutParams = new MarginLayoutParams(dv.m1932b(this.f7213a.getContext(), 240.0f), -2);
        int b = dv.m1932b(this.f7213a.getContext(), 10.0f);
        marginLayoutParams.leftMargin = b;
        marginLayoutParams.rightMargin = b;
        this.f7213a.showBalloon(this.f7214b, view, marginLayoutParams);
        this.f7213a.show();
    }

    /* renamed from: a */
    public void mo1785a(boolean z) {
    }

    /* renamed from: a */
    public void mo1784a(String str) {
    }

    /* renamed from: a */
    public LinearLayout mo1783a() {
        return this.f7216d;
    }

    /* renamed from: a */
    public View mo1782a(String str, int i, boolean z) {
        View inflate = LayoutInflater.from(this.f7213a.getContext()).inflate(C0245g.general__dk_spirt_menu_item_view_at_hd, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(C0244f.general__shared_spirt_menu_item_view__text);
        if (i != 0) {
            dkLabelView.setCompoundDrawablesWithIntrinsicBounds(this.f7213a.getContext().getResources().getDrawable(i), null, null, null);
            dkLabelView.setCompoundDrawablePadding(C0267i.m598a(this.f7213a.getContext(), 10.0f));
        }
        dkLabelView.setText(str);
        return inflate;
    }

    /* renamed from: b */
    public ViewGroup mo1786b() {
        return this.f7218f;
    }

    /* renamed from: c */
    public int mo1787c() {
        return this.f7216d.getChildCount();
    }
}
