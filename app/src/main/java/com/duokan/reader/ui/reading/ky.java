package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.ui.general.deprecatedDkTextView;

public class ky extends fz {
    public ky(Context context, gs gsVar, Rect rect, au auVar) {
        super(context, gsVar, rect, auVar);
        if (!TextUtils.isEmpty(auVar.mo1396k().mo1404d()) || !TextUtils.isEmpty(auVar.mo1396k().mo1405e())) {
            View inflate = LayoutInflater.from(getContext()).inflate(C0245g.reading__illustration_tip_view, this, false);
            deprecatedDkTextView deprecateddktextview = (deprecatedDkTextView) inflate.findViewById(C0244f.reading__illustration_view__sub_title);
            ((deprecatedDkTextView) inflate.findViewById(C0244f.reading__illustration_view__main_title)).setText(auVar.mo1396k().mo1404d());
            deprecateddktextview.setText(auVar.mo1396k().mo1405e());
            m14166a(inflate, null);
        }
    }

    /* renamed from: a */
    public gd mo2403a(au auVar) {
        return new kz(getContext(), auVar);
    }

    public float getZoomFactor() {
        return getWatchingView().getZoomFactor() / getWatchingView().getMinZoomFactor();
    }
}
