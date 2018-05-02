package com.duokan.reader.ui.account;

import android.graphics.Bitmap;

import com.duokan.reader.common.webservices.d;
import com.duokan.reader.common.webservices.duokan.r;

class cb extends r {
    Bitmap a = null;
    final /* synthetic */ String b;
    final /* synthetic */ cd c;
    final /* synthetic */ bz d;

    cb(bz bzVar, String str, cd cdVar) {
        this.d = bzVar;
        this.b = str;
        this.c = cdVar;
    }

    protected void onSessionTry() {
        this.a = new d(this).a(this.b);
    }

    protected void onSessionSucceeded() {
        if (!this.d.g) {
            if (this.a != null) {
                this.c.a(this.a, true);
            } else {
                onSessionFailed();
            }
        }
    }

    protected void onSessionFailed() {
        if (!this.d.g) {
            this.c.a();
        }
    }

    protected void onSessionClosed() {
        this.d.g = false;
    }
}
