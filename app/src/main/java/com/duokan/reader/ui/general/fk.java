package com.duokan.reader.ui.general;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.core.app.e;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.dv;
import com.duokan.reader.ui.general.a.a;

public class fk implements dr {
    private final e a;
    private final ViewGroup b = ((ViewGroup) LayoutInflater.from(this.a.getContext()).inflate(g.general__spirt_menu_view_at_hd, null));
    private final BoxView c = ((BoxView) this.b.findViewById(f.general__spirt_mene_view__page));
    private final View d = this.b.findViewById(f.general__spirt_mene_view__dark_bg);
    private final ViewGroup e = ((BoxView) this.b.findViewById(f.general__spirt_mene_view__page));
    private final ViewGroup f = ((ViewGroup) this.b.findViewById(f.general__spirt_mene_view__content_items));
    private final ViewGroup g = ((ViewGroup) this.b.findViewById(f.general__spirt_mene_view__extra_view));

    public fk(e eVar) {
        this.a = eVar;
        this.c.setMaxHeight(Math.round(((float) Math.min(dv.k(this.a.getContext()), dv.j(this.a.getContext()))) * 0.7f));
        this.d.setOnClickListener(new fl(this));
    }

    public ViewGroup a() {
        return this.b;
    }

    public void b(Runnable runnable, Runnable runnable2) {
        a.a(this.d, 0.0f, 1.0f, a.a(this.c, new fm(this, runnable, runnable2)).getDuration(), Boolean.valueOf(true), null);
    }

    public void a(Runnable runnable, Runnable runnable2) {
        a.a(this.d, 1.0f, 0.0f, a.b(this.c, new fn(this, runnable, runnable2)).getDuration(), Boolean.valueOf(true), null);
    }

    public ViewGroup b() {
        return this.f;
    }

    public ViewGroup c() {
        return this.g;
    }

    public View a(String str, int i, boolean z) {
        View inflate = LayoutInflater.from(this.a.getContext()).inflate(g.general__dk_spirt_menu_item_view_at_hd, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(f.general__shared_spirt_menu_item_view__text);
        if (i != 0) {
            dkLabelView.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(i), null, null, null);
            dkLabelView.setCompoundDrawablePadding(i.a(this.a.getContext(), 10.0f));
        }
        dkLabelView.setText(str);
        return inflate;
    }
}
