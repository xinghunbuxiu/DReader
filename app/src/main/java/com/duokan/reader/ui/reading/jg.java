package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class jg implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ View f10426a;
    /* renamed from: b */
    final /* synthetic */ FixedPageClipView f10427b;

    jg(FixedPageClipView fixedPageClipView, View view) {
        this.f10427b = fixedPageClipView;
        this.f10426a = view;
    }

    public void onClick(View view) {
        this.f10427b.f9094g.mo2395a(this.f10427b.f9089b.m14476a(), !this.f10426a.isSelected());
    }
}
