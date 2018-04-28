package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ui.surfing.al;

class dt implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ TextView f7122a;
    /* renamed from: b */
    final /* synthetic */ dr f7123b;

    dt(dr drVar, TextView textView) {
        this.f7123b = drVar;
        this.f7122a = textView;
    }

    public void onClick(View view) {
        int a = this.f7123b.m10495a(this.f7122a);
        if (this.f7123b.f7104b != a) {
            this.f7123b.m10515a(a);
        } else {
            ((al) AppContext.getAppContext(this.f7123b.getContext()).queryFeature(al.class)).mo2556k();
        }
    }
}
