package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class qa implements OnClickListener {
    final /* synthetic */ pw a;

    qa(pw pwVar) {
        this.a = pwVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Bookmark");
        this.a.a(new qb(this));
    }
}
