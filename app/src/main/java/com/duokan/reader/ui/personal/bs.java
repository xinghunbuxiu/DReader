package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ui.C0436e;
import com.duokan.reader.ui.general.expandable.ViewMode;

class bs implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ String f8357a;
    /* renamed from: b */
    final /* synthetic */ String f8358b;
    /* renamed from: c */
    final /* synthetic */ br f8359c;

    bs(br brVar, String str, String str2) {
        this.f8359c = brVar;
        this.f8357a = str;
        this.f8358b = str2;
    }

    public void onClick(View view) {
        if (this.f8359c.c.mo1714f() != ViewMode.Edit) {
            IFeature a = AppContext.getAppContext(this.f8359c.f8351f);
            C0436e c0436e = (C0436e) a.queryFeature(C0436e.class);
            this.f8359c.f8356k = new ly(a, this.f8359c.f8352g, new String[]{this.f8357a, this.f8358b});
            c0436e.pushPageSmoothly(this.f8359c.f8356k, null);
        }
    }
}
