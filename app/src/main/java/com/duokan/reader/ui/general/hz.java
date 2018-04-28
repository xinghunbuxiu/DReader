package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ui.surfing.al;

class hz implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ TextView f7361a;
    /* renamed from: b */
    final /* synthetic */ hu f7362b;

    hz(hu huVar, TextView textView) {
        this.f7362b = huVar;
        this.f7361a = textView;
    }

    public void onClick(View view) {
        int a = this.f7362b.m10753a(this.f7361a);
        if (this.f7362b.f7352c != a) {
            this.f7362b.m10765b(a);
        } else {
            ((al) AppContext.getAppContext(this.f7362b.getContext()).queryFeature(al.class)).mo2556k();
        }
    }
}
