package com.duokan.reader.ui.general;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.duokan.common.CommonUtils;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.BaseDialog;
import com.duokan.p023b.C0240b;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;

public class fh implements dq {
    /* renamed from: a */
    private final BaseDialog f7219a;
    /* renamed from: b */
    private final View f7220b;
    /* renamed from: c */
    private final DkLabelView f7221c = ((DkLabelView) this.f7220b.findViewById(C0244f.general__spirt_dialog_view__title));
    /* renamed from: d */
    private final LinearLayout f7222d = ((LinearLayout) this.f7220b.findViewById(C0244f.general__spirt_dialog_view__content_items));
    /* renamed from: e */
    private final BoxView f7223e = ((BoxView) this.f7220b.findViewById(C0244f.general__spirt_dialog_view__content));
    /* renamed from: f */
    private final ViewGroup f7224f = ((ViewGroup) this.f7220b.findViewById(C0244f.general__spirt_dialog_view__content_extra));

    public fh(BaseDialog dialog) {
        this.f7219a = dialog;
        Context context = this.f7219a.getContext();
        this.f7220b = LayoutInflater.from(context).inflate(C0245g.general__spirt_dialog_view_at_hd, null);
        int c = CommonUtils.m609c(context);
        int b = CommonUtils.m606b(context);
        if (b >= c) {
            b = c;
        }
        this.f7223e.setMaxHeight(Math.round(((float) b) * 0.7f));
        dialog.setContentView(this.f7220b, new LayoutParams(-2, -2));
        dialog.setEnterAnimation(C0240b.general__shared__scale_center_in);
        dialog.setExitAnimation(C0240b.general__shared__scale_center_out);
        dialog.setGravity(17);
    }

    /* renamed from: a */
    public void mo1785a(boolean z) {
    }

    /* renamed from: a */
    public void mo1784a(String str) {
        this.f7221c.setText(str);
        if (TextUtils.isEmpty(str)) {
            this.f7221c.setVisibility(8);
        } else {
            this.f7221c.setVisibility(0);
        }
    }

    /* renamed from: a */
    public LinearLayout mo1783a() {
        return this.f7222d;
    }

    /* renamed from: b */
    public ViewGroup mo1786b() {
        return this.f7224f;
    }

    /* renamed from: a */
    public View mo1782a(String str, int i, boolean z) {
        View inflate = LayoutInflater.from(this.f7219a.getContext()).inflate(C0245g.general__dk_spirt_menu_item_view_at_hd, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(C0244f.general__shared_spirt_menu_item_view__text);
        if (i != 0) {
            dkLabelView.setCompoundDrawablesWithIntrinsicBounds(this.f7219a.getContext().getResources().getDrawable(i), null, null, null);
            dkLabelView.setCompoundDrawablePadding(CommonUtils.dip2px(this.f7219a.getContext(), 10.0f));
        }
        dkLabelView.setText(str);
        return inflate;
    }

    /* renamed from: c */
    public int mo1787c() {
        return this.f7222d.getChildCount();
    }
}
