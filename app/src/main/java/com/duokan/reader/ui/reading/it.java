package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class it implements OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ FixedPageClipView b;

    it(FixedPageClipView fixedPageClipView, View view) {
        this.b = fixedPageClipView;
        this.a = view;
    }

    public void onClick(View view) {
        this.a.setSelected(!this.a.isSelected());
    }
}
