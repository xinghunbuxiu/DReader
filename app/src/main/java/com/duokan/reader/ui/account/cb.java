package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;

class cb extends WebSession {
    /* renamed from: a */
    Bitmap f5914a = null;
    /* renamed from: b */
    final /* synthetic */ String f5915b;
    /* renamed from: c */
    final /* synthetic */ co f5916c;
    /* renamed from: d */
    final /* synthetic */ bx f5917d;

    cb(bx bxVar, C0657i c0657i, String str, co coVar) {
        this.f5917d = bxVar;
        this.f5915b = str;
        this.f5916c = coVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f5914a = new C0237c(this).m545a(this.f5915b);
    }

    protected void onSessionSucceeded() {
        this.f5917d.f5901m = false;
        if (this.f5914a != null) {
            this.f5916c.mo1586a(this.f5914a, true);
        } else {
            onSessionFailed();
        }
    }

    protected void onSessionFailed() {
        this.f5917d.f5901m = false;
        this.f5916c.mo1587a(this.f5917d.getContext().getResources().getString(C0258j.gen_bitmap_fail));
    }
}
