package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;

class ca extends WebSession {
    /* renamed from: a */
    Bitmap f5911a = null;
    /* renamed from: b */
    final /* synthetic */ co f5912b;
    /* renamed from: c */
    final /* synthetic */ bx f5913c;

    ca(bx bxVar, C0657i c0657i, co coVar) {
        this.f5913c = bxVar;
        this.f5912b = coVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f5911a = new C0237c(this).m545a(this.f5913c.f5893e.f5801b);
    }

    protected void onSessionSucceeded() {
        this.f5913c.f5901m = false;
        if (this.f5911a != null) {
            this.f5912b.mo1586a(this.f5911a, true);
        } else {
            onSessionFailed();
        }
    }

    protected void onSessionFailed() {
        this.f5913c.f5901m = false;
        this.f5912b.mo1587a(this.f5913c.getContext().getResources().getString(C0258j.gen_bitmap_fail));
    }
}
