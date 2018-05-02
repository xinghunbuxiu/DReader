package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class iw implements OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ FixedPageClipView b;

    iw(FixedPageClipView fixedPageClipView, View view) {
        this.b = fixedPageClipView;
        this.a = view;
    }

    public void onClick(View view) {
        this.b.g.a(this.b.b.a(), !this.a.isSelected());
    }
}
