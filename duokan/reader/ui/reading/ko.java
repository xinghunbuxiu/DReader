package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.ui.general.deprecatedDkTextView;

public class ko extends fu {
    public ko(Context context, gn gnVar, Rect rect, au auVar) {
        super(context, gnVar, rect, auVar);
        if (!TextUtils.isEmpty(auVar.k().d()) || !TextUtils.isEmpty(auVar.k().e())) {
            View inflate = LayoutInflater.from(getContext()).inflate(g.reading__illustration_tip_view, this, false);
            deprecatedDkTextView com_duokan_reader_ui_general_deprecatedDkTextView = (deprecatedDkTextView) inflate.findViewById(f.reading__illustration_view__sub_title);
            ((deprecatedDkTextView) inflate.findViewById(f.reading__illustration_view__main_title)).setText(auVar.k().d());
            com_duokan_reader_ui_general_deprecatedDkTextView.setText(auVar.k().e());
            a(inflate, null);
        }
    }

    public fy a(au auVar) {
        return new kp(getContext(), auVar);
    }

    public float getZoomFactor() {
        return getWatchingView().getZoomFactor() / getWatchingView().getMinZoomFactor();
    }
}
