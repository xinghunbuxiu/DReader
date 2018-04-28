package com.duokan.reader.ui.bookshelf;

import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.ja;
import java.util.LinkedList;

class bs extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0800c[] f6209a;
    /* renamed from: b */
    final /* synthetic */ bp f6210b;
    /* renamed from: c */
    private ja f6211c = null;
    /* renamed from: d */
    private LinkedList<br> f6212d = new LinkedList();
    /* renamed from: e */
    private long f6213e = 0;
    /* renamed from: f */
    private boolean f6214f = false;

    bs(bp bpVar, C0657i c0657i, C0800c[] c0800cArr) {
        this.f6210b = bpVar;
        this.f6209a = c0800cArr;
        super(c0657i);
    }

    protected void onSessionOpen() {
        this.f6211c = new ja(this.f6210b.getContext());
        this.f6211c.open(new bt(this));
    }

    protected void onSessionTry() {
        for (C0800c c0800c : this.f6209a) {
            if (!c0800c.ak() && c0800c.am() == null) {
                br brVar = new br(this.f6210b);
                brVar.f6207a = c0800c;
                this.f6212d.add(brVar);
                this.f6213e += c0800c.m4151D();
            }
        }
    }

    protected void onSessionSucceeded() {
        this.f6211c.dismiss();
        if (!this.f6214f && this.f6212d.size() >= 1) {
            be.m9189b(this.f6210b.getActivity(), this.f6213e, new bu(this));
        }
    }

    protected void onSessionFailed() {
        this.f6211c.dismiss();
        ((ReaderFeature) this.f6210b.getContext().queryFeature(ReaderFeature.class)).prompt(this.f6210b.getString(C0258j.general__shared__network_error));
    }
}
