package com.duokan.reader.ui.general;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.duokan.b.b;
import com.duokan.b.g;
import com.duokan.common.i;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.j;

public class fj implements dq {
    private final j a;
    private final View b;
    private final DkLabelView c = ((DkLabelView) this.b.findViewById(f.general__spirt_dialog_view__title));
    private final LinearLayout d = ((LinearLayout) this.b.findViewById(f.general__spirt_dialog_view__content_items));
    private final BoxView e = ((BoxView) this.b.findViewById(f.general__spirt_dialog_view__content));
    private final ViewGroup f = ((ViewGroup) this.b.findViewById(f.general__spirt_dialog_view__content_extra));

    public fj(j jVar) {
        this.a = jVar;
        Context context = this.a.getContext();
        this.b = LayoutInflater.from(context).inflate(g.general__spirt_dialog_view_at_hd, null);
        int c = i.c(context);
        int b = i.b(context);
        if (b >= c) {
            b = c;
        }
        this.e.setMaxHeight(Math.round(((float) b) * 0.7f));
        jVar.setContentView(this.b, new LayoutParams(-2, -2));
        jVar.setEnterAnimation(b.general__shared__scale_center_in);
        jVar.setExitAnimation(b.general__shared__scale_center_out);
        jVar.setGravity(17);
    }

    public void a(boolean z) {
    }

    public void a(String str) {
        this.c.setText(str);
        if (TextUtils.isEmpty(str)) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
        }
    }

    public LinearLayout a() {
        return this.d;
    }

    public ViewGroup b() {
        return this.f;
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

    public int c() {
        return this.d.getChildCount();
    }
}
