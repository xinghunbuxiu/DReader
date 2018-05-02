package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class wh implements OnClickListener {
    final /* synthetic */ wg a;

    wh(wg wgVar) {
        this.a = wgVar;
    }

    public void onClick(View view) {
        this.a.a.a(view.isSelected() ? SlideShowEffect.NONE : SlideShowEffect.SIMPLE);
        this.a.a();
    }
}
