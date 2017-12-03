package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;

import com.duokan.b.g;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.a;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.j;

class fi implements dq {
    private final j a;
    private final a b;
    private final View c;
    private final LinearLayout d = ((LinearLayout) this.c.findViewById(f.general__spirt_dialog_view__content_items));
    private final BoxView e = ((BoxView) this.c.findViewById(f.general__spirt_dialog_view__content));
    private final ViewGroup f;

    public fi(j jVar) {
        this.a = jVar;
        Context context = this.a.getContext();
        this.c = LayoutInflater.from(context).inflate(g.general__spirt_dialog_view_at_hd, null);
        this.e.setBackgroundDrawable(null);
        this.f = (ViewGroup) this.c.findViewById(f.general__spirt_dialog_view__content_extra);
        this.b = new a(context);
        this.b.setGravity(48);
        this.b.setIndicatorMargin(UTools.closeAnimation(context, 11.0f));
        this.b.setIndicator(e.store__search_hint_view__indicator);
        this.b.setBackgroundDrawable(context.getResources().getDrawable(e.store__search_hint_view__bg));
        this.b.addView(this.c, new LayoutParams(-2, -2));
        jVar.setDimAmount(0.1f);
    }

    public void a(Rect rect) {
        LayoutParams marginLayoutParams = new MarginLayoutParams(UTools.closeAnimation(this.a.getContext(), 240.0f), -2);
        int b = UTools.closeAnimation(this.a.getContext(), 10.0f);
        marginLayoutParams.leftMargin = b;
        marginLayoutParams.rightMargin = b;
        this.a.showBalloon(this.b, rect, marginLayoutParams);
        this.a.show();
    }

    public void a(View view) {
        LayoutParams marginLayoutParams = new MarginLayoutParams(UTools.closeAnimation(this.a.getContext(), 240.0f), -2);
        int b = UTools.closeAnimation(this.a.getContext(), 10.0f);
        marginLayoutParams.leftMargin = b;
        marginLayoutParams.rightMargin = b;
        this.a.showBalloon(this.b, view, marginLayoutParams);
        this.a.show();
    }

    public void a(boolean z) {
    }

    public void a(String str) {
    }

    public LinearLayout a() {
        return this.d;
    }

    public View a(String str, int i, boolean z) {
        View inflate = LayoutInflater.from(this.a.getContext()).inflate(g.general__dk_spirt_menu_item_view_at_hd, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(f.general__shared_spirt_menu_item_view__text);
        if (i != 0) {
            dkLabelView.setCompoundDrawablesWithIntrinsicBounds(this.a.getContext().getResources().getDrawable(i), null, null, null);
            dkLabelView.setCompoundDrawablePadding(i.a(this.a.getContext(), 10.0f));
        }
        dkLabelView.setText(str);
        return inflate;
    }

    public ViewGroup b() {
        return this.f;
    }

    public int c() {
        return this.d.getChildCount();
    }
}
