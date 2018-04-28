package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class qk implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ qg f10865a;

    qk(qg qgVar) {
        this.f10865a = qgVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Bookmark");
        this.f10865a.m13847a(new ql(this));
    }
}
