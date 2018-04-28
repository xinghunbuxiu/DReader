package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class jd implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ View f10422a;
    /* renamed from: b */
    final /* synthetic */ FixedPageClipView f10423b;

    jd(FixedPageClipView fixedPageClipView, View view) {
        this.f10423b = fixedPageClipView;
        this.f10422a = view;
    }

    public void onClick(View view) {
        this.f10422a.setSelected(!this.f10422a.isSelected());
    }
}
