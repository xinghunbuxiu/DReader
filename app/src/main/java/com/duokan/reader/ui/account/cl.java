package com.duokan.reader.ui.account;

import android.graphics.Bitmap;

import com.duokan.c.j;
import com.duokan.reader.common.webservices.d;
import com.duokan.reader.common.webservices.duokan.r;

class cl extends r {
    Bitmap a = null;
    final /* synthetic */ String b;
    final /* synthetic */ cy c;
    final /* synthetic */ ch d;

    cl(ch chVar, String str, cy cyVar) {
        this.d = chVar;
        this.b = str;
        this.c = cyVar;
    }

    protected void onSessionTry() {
        this.a = new d(this).a(this.b);
    }

    protected void onSessionSucceeded() {
        this.d.m = false;
        if (this.a != null) {
            this.c.a(this.a, true);
        } else {
            onSessionFailed();
        }
    }

    protected void onSessionFailed() {
        this.d.m = false;
        this.c.a(this.d.getContext().getResources().getString(j.gen_bitmap_fail));
    }
}
