package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class uh implements OnClickListener {
    final /* synthetic */ ud a;

    uh(ud udVar) {
        this.a = udVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Bookmark");
        this.a.a(new ui(this));
    }
}
