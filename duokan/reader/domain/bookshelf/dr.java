package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class dr extends al {
    final /* synthetic */ ab a;
    final /* synthetic */ df b;
    final /* synthetic */ eb c;
    final /* synthetic */ dh d;
    private b e;
    private List f;

    dr(dh dhVar, ab abVar, df dfVar, eb ebVar) {
        this.d = dhVar;
        this.a = abVar;
        this.b = dfVar;
        this.c = ebVar;
    }

    protected void onSessionTry() {
        fj fjVar = new fj(this, this.a);
        List arrayList = new ArrayList(af.a.length);
        long currentTimeMillis = System.currentTimeMillis() - this.b.b;
        for (int i : af.a) {
            fq fqVar = new fq();
            fqVar.a = i;
            fqVar.b = (((int) (currentTimeMillis / 864000000)) * 100) + HttpStatus.SC_OK;
            if (fqVar.b > HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                fqVar.b = HttpStatus.SC_INTERNAL_SERVER_ERROR;
            }
            arrayList.add(fqVar);
        }
        this.e = fjVar.c(arrayList);
        if (this.e.b == 0) {
            this.f = new ArrayList();
            for (fu fuVar : ((HashMap) this.e.a).values()) {
                this.f.addAll(fuVar.b);
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(this.d.c)) {
            this.c.a("");
        } else if (this.e.b == 1) {
            i.f().a(this.a.a, new ds(this));
        } else if (this.e.b != 0) {
            this.c.a(this.e.c);
        } else {
            this.c.a(this.f);
        }
    }

    protected void onSessionFailed() {
        this.c.a(this.d.b.getResources().getString(com.duokan.b.i.general__shared__network_error));
    }
}
