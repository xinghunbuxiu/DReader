package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class eq extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3949a;
    /* renamed from: b */
    final /* synthetic */ ep f3950b;
    /* renamed from: c */
    private DkCloudNoteBookInfo[] f3951c = new DkCloudNoteBookInfo[0];
    /* renamed from: d */
    private long f3952d = 0;

    eq(ep epVar, C0657i c0657i, al alVar) {
        this.f3950b = epVar;
        this.f3949a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        ev evVar = new ev(this.f3949a);
        evVar.m5513b();
        this.f3951c = this.f3950b.f3948c.m5144a(evVar);
        this.f3952d = evVar.m5512a().mReadingNoteCount;
    }

    protected void onSessionSucceeded() {
        if (this.f3949a.m3365a(this.f3950b.f3948c.f3626d)) {
            this.f3950b.f3948c.f3627e = this.f3952d;
            this.f3950b.f3948c.m5150d();
            this.f3950b.f3948c.m5142a(this.f3951c);
            this.f3950b.f3946a.mo1159a(this.f3951c, true);
            this.f3950b.f3948c.m5141a(this.f3950b.f3947b, this.f3950b.f3946a);
            return;
        }
        this.f3950b.f3946a.mo1158a("");
    }

    protected void onSessionFailed() {
        if (this.f3949a.m3365a(this.f3950b.f3948c.f3626d)) {
            this.f3950b.f3946a.mo1158a("");
        } else {
            this.f3950b.f3946a.mo1158a("");
        }
    }
}
