package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class oo implements OnClickListener {
    final /* synthetic */ on a;

    oo(on onVar) {
        this.a = onVar;
    }

    public void onClick(View view) {
        if (this.a.f.g()) {
            UmengManager.get().onEvent("V2_READING_FLOAT_TOOLBUTTON", "PDF-Reflow");
            this.a.a(new op(this));
            return;
        }
        UmengManager.get().onEvent("V2_READING_FLOAT_TOOLBUTTON", "PDF-Exit-Reflow");
        this.a.a(new oq(this));
    }
}
