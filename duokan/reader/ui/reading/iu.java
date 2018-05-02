package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class iu implements OnClickListener {
    final /* synthetic */ FixedPageClipView a;

    iu(FixedPageClipView fixedPageClipView) {
        this.a = fixedPageClipView;
    }

    public void onClick(View view) {
        this.a.g.b();
    }
}
