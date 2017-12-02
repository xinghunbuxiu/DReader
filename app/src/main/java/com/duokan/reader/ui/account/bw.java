package com.duokan.reader.ui.account;

import com.duokan.c.j;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.ui.general.be;

import java.util.ArrayList;
import java.util.List;

class bw extends r {
    b a = new b();
    List b = new ArrayList();
    final /* synthetic */ bv c;

    bw(bv bvVar) {
        this.c = bvVar;
    }

    protected void onSessionTry() {
        o oVar = new o(this, null);
        int i = 0;
        while (i < this.c.i.length) {
            this.a = oVar.g(this.c.i[i]);
            if (this.a.b == 0) {
                this.b.add(this.a.a);
                i++;
            } else {
                return;
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.c.g) {
            if (this.b.size() != this.c.i.length) {
                CharSequence string = this.c.getString(j.share_failed);
                if (this.c.h != null) {
                    this.c.h.b(string);
                    this.c.h = null;
                    return;
                }
                be.a(this.c.getContext(), string, 0).show();
                return;
            }
            this.c.i = (String[]) this.b.toArray(new String[0]);
            this.c.b();
        }
    }

    protected void onSessionFailed() {
        if (!this.c.g) {
            this.c.e();
            CharSequence string = this.c.getString(j.share_failed);
            if (this.c.h != null) {
                this.c.h.b(string);
                this.c.h = null;
                return;
            }
            be.a(this.c.getContext(), string, 0).show();
        }
    }

    protected void onSessionClosed() {
        this.c.g = false;
    }
}
