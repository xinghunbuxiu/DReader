package com.duokan.reader.ui.account;

import android.graphics.Bitmap;

import com.duokan.c.j;
import com.duokan.reader.common.webservices.d;
import com.duokan.reader.common.webservices.duokan.r;

class ck extends r {
    Bitmap a = null;
    final /* synthetic */ cy b;
    final /* synthetic */ ch c;

    ck(ch chVar, cy cyVar) {
        this.c = chVar;
        this.b = cyVar;
    }

    protected void onSessionTry() {
        this.a = new d(this).a(this.c.e.b);
    }

    protected void onSessionSucceeded() {
        this.c.m = false;
        if (this.a != null) {
            this.b.a(this.a, true);
        } else {
            onSessionFailed();
        }
    }

    protected void onSessionFailed() {
        this.c.m = false;
        this.b.a(this.c.getContext().getResources().getString(j.gen_bitmap_fail));
    }
}
