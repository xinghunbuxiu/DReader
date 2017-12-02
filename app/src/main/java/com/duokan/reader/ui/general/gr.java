package com.duokan.reader.ui.general;

import android.graphics.drawable.ClipDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.core.app.e;
import com.duokan.reader.ui.general.a.a;

public class gr implements dr {
    private final e a;
    private final ViewGroup b = ((ViewGroup) LayoutInflater.from(this.a.getContext()).inflate(g.general__spirt_menu_view, null));
    private final ViewGroup c = ((ViewGroup) this.b.findViewById(f.general__spirt_menu_view__page));
    private final ViewGroup d = ((ViewGroup) this.b.findViewById(f.general__spirt_menu_view__menu));
    private final ViewGroup e = ((ViewGroup) this.b.findViewById(f.general__spirt_menu_view__extra));
    private final ViewGroup f;
    private final View g = this.b.findViewById(f.general__spirt_menu_view__dark_bg);
    private final ClipDrawable h;
    private final boolean i;

    public gr(e eVar, boolean z, boolean z2) {
        this.a = eVar;
        this.f = z ? this.c : this.d;
        this.i = z2;
        if (this.i) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) eVar.getActivity().getWindow().getDecorView()).getChildAt(0);
            this.h = new ClipDrawable(new e(viewGroup.getChildAt(viewGroup.getChildCount() - 1)), 80, 2);
            this.b.findViewById(f.general__spirt_menu_view__blur_bg).setBackgroundDrawable(this.h);
            this.g.setOnClickListener(new gs(this));
            return;
        }
        this.h = null;
    }

    public ViewGroup a() {
        return this.b;
    }

    public ViewGroup b() {
        return this.d;
    }

    public ViewGroup c() {
        return this.e;
    }

    public void b(Runnable runnable, Runnable runnable2) {
        a.a(this.f, 1, 0.0f, 0.0f, 1.0f, 0.0f, 200, Boolean.valueOf(true), new gt(this, 0, runnable, runnable2));
        a.a(this.g, 0.0f, 0.5f, 200, Boolean.valueOf(true), null);
    }

    public void a(Runnable runnable, Runnable runnable2) {
        a.a(this.f, 1, 0.0f, 0.0f, 0.0f, 1.0f, 200, Boolean.valueOf(true), new gt(this, 1, runnable, runnable2));
        a.a(this.g, 0.5f, 0.0f, 200, Boolean.valueOf(true), null);
    }

    public View a(String str, int i, boolean z) {
        View inflate = LayoutInflater.from(this.a.getContext()).inflate(g.general__dk_spirt_menu_item_view, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(f.general__shared_spirt_menu_item_view__text);
        if (i != 0) {
            dkLabelView.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(i), null, null, null);
            dkLabelView.setCompoundDrawablePadding(i.a(this.a.getContext(), 10.0f));
        }
        if (!z) {
            inflate.findViewById(f.general__shared_spirt_menu_item_view__top_line).setVisibility(8);
        }
        dkLabelView.setText(str);
        return inflate;
    }
}
