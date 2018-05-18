package com.duokan.reader.domain.cloud;

import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0636j;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.document.epub.C0936c;

class ad extends WebSession {
    /* renamed from: a */
    C0621a<Void> f3653a;
    /* renamed from: b */
    final /* synthetic */ al f3654b;
    /* renamed from: c */
    final /* synthetic */ C0936c f3655c;
    /* renamed from: d */
    final /* synthetic */ C0800c f3656d;
    /* renamed from: e */
    final /* synthetic */ String f3657e;
    /* renamed from: f */
    final /* synthetic */ String f3658f;
    /* renamed from: g */
    final /* synthetic */ String f3659g;
    /* renamed from: h */
    final /* synthetic */ boolean f3660h;
    /* renamed from: i */
    final /* synthetic */ aj f3661i;
    /* renamed from: j */
    final /* synthetic */ DkCloudStorage f3662j;

    ad(DkCloudStorage dkCloudStorage, al alVar, C0936c c0936c, C0800c c0800c, String str, String str2, String str3, boolean z, aj ajVar) {
        this.f3662j = dkCloudStorage;
        this.f3654b = alVar;
        this.f3655c = c0936c;
        this.f3656d = c0800c;
        this.f3657e = str;
        this.f3658f = str2;
        this.f3659g = str3;
        this.f3660h = z;
        this.f3661i = ajVar;
    }

    protected void onSessionTry() {
        this.f3653a = new C0636j(this, this.f3654b).m2876a(this.f3662j.f3595c.getString(C0247i.app__shared__build_name) + " " + ReaderEnv.get().getVersionName(), this.f3656d.getId(), this.f3656d.ay(), this.f3656d.m4242o() == BookType.SERIAL ? "LianZai" : this.f3656d.m4157J(), String.format("(%d, %d, %d)", new Object[]{Long.valueOf(this.f3655c.m6780g()), Long.valueOf(this.f3655c.m6781h()), Long.valueOf(this.f3655c.m6782i())}), this.f3657e, this.f3658f, this.f3659g, this.f3660h, this.f3654b.f2362c);
    }

    protected void onSessionSucceeded() {
        if (this.f3653a.b == 0) {
            this.f3661i.mo1974a();
        } else {
            this.f3661i.mo1975a(this.f3653a.c);
        }
    }

    protected void onSessionFailed() {
        this.f3661i.mo1975a(this.f3662j.f3595c.getString(C0247i.general__shared__network_error));
    }
}
