package com.duokan.reader.ui.personal;

import android.content.Context;
import android.widget.TextView;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p022a.C0236a;

class aw extends C0236a {
    /* renamed from: b */
    final /* synthetic */ TextView f8287b;
    /* renamed from: c */
    final /* synthetic */ LinearScrollView f8288c;
    /* renamed from: d */
    final /* synthetic */ av f8289d;

    aw(av avVar, Context context, TextView textView, LinearScrollView linearScrollView) {
        this.f8289d = avVar;
        this.f8287b = textView;
        this.f8288c = linearScrollView;
        super(context);
    }

    protected <T> void onSessionProgressUpdate(T t) {
        if (t instanceof String) {
            this.f8287b.append(t + "\n");
            AnimUtils.m1921a(this.f8288c, new ax(this));
        }
    }

    protected void onSessionSucceeded() {
        WebLog.init().c(LogLevel.EVENT, "DIAGNOSTICS", this.f8287b.getText().toString());
    }
}
