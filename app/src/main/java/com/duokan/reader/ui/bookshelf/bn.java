package com.duokan.reader.ui.bookshelf;

import com.duokan.c.j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.c;
import com.duokan.reader.ui.general.jq;

import java.util.LinkedList;

class bn extends c {
    final /* synthetic */ com.duokan.reader.domain.bookshelf.c[] a;
    final /* synthetic */ bk b;
    private jq c = null;
    private LinkedList d = new LinkedList();
    private long e = 0;
    private boolean f = false;

    bn(bk bkVar, com.duokan.reader.domain.bookshelf.c[] cVarArr) {
        this.b = bkVar;
        this.a = cVarArr;
    }

    protected void onSessionOpen() {
        this.c = new jq(this.b.getContext());
        this.c.open(new bo(this));
    }

    protected void onSessionTry() {
        for (com.duokan.reader.domain.bookshelf.c cVar : this.a) {
            if (!cVar.ai() && cVar.ak() == null) {
                bm bmVar = new bm(this.b);
                bmVar.a = cVar;
                this.d.add(bmVar);
                this.e += cVar.C();
            }
        }
    }

    protected void onSessionSucceeded() {
        this.c.dismiss();
        if (!this.f && this.d.size() >= 1) {
            ay.b(this.b.getActivity(), this.e, new bp(this));
        }
    }

    protected void onSessionFailed() {
        this.c.dismiss();
        ((ReaderFeature) this.b.getContext().queryFeature(ReaderFeature.class)).prompt(this.b.getString(j.general__shared__network_error));
    }
}
