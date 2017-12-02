package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class or implements OnClickListener {
    final /* synthetic */ on a;

    or(on onVar) {
        this.a = onVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "PDF-Crop");
        this.a.a(new os(this));
    }
}
