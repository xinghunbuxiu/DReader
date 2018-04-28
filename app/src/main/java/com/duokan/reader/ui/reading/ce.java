package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class ce implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ bz f9931a;

    ce(bz bzVar) {
        this.f9931a = bzVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_MENU", "Comment");
        this.f9931a.m13598a(new cf(this));
    }
}
