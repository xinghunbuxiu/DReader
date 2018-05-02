package com.duokan.reader.ui.reading;

import android.content.Context;
import android.widget.TextView;
import com.duokan.core.ui.dv;

/* renamed from: com.duokan.reader.ui.reading.b */
class C1448b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ TextView f9814a;
    /* renamed from: b */
    final /* synthetic */ Context f9815b;
    /* renamed from: c */
    final /* synthetic */ C1446a f9816c;

    C1448b(C1446a c1446a, TextView textView, Context context) {
        this.f9816c = c1446a;
        this.f9814a = textView;
        this.f9815b = context;
    }

    public void run() {
        if (this.f9814a.getLineCount() == 1) {
            this.f9814a.setPadding(0, dv.m1932b(this.f9815b, 10.0f), 0, 0);
        }
    }
}
