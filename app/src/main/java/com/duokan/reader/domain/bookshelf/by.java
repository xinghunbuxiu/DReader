package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class by extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f2878a;
    /* renamed from: b */
    final /* synthetic */ bs f2879b;
    /* renamed from: c */
    final /* synthetic */ cv f2880c;
    /* renamed from: d */
    final /* synthetic */ bu f2881d;
    /* renamed from: e */
    private C0621a<HashMap<Integer, fm>> f2882e;
    /* renamed from: f */
    private bs f2883f;
    /* renamed from: g */
    private ArrayList<bt> f2884g;

    by(bu buVar, String str, C0657i c0657i, al alVar, bs bsVar, cv cvVar) {
        this.f2881d = buVar;
        this.f2878a = alVar;
        this.f2879b = bsVar;
        this.f2880c = cvVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        fd fdVar = new fd(this, this.f2878a);
        List arrayList = new ArrayList(af.f2727a.length);
        for (int i : af.f2727a) {
            fi fiVar = new fi();
            fiVar.f3167a = i;
            fiVar.f3168b = this.f2879b.m4060a(i);
            arrayList.add(fiVar);
        }
        this.f2882e = fdVar.m4456a(arrayList);
        if (this.f2882e.b == 0) {
            this.f2883f = new bs();
            this.f2884g = new ArrayList();
            this.f2883f.f2854a = this.f2878a.f2360a;
            for (fm fmVar : ((HashMap) this.f2882e.f2058a).values()) {
                this.f2883f.m4065b(fmVar.f3176a, fmVar.f3179d);
                long a = this.f2879b.m4060a(fmVar.f3176a);
                for (bt btVar : fmVar.f3177b) {
                    if (btVar.f2860d > a) {
                        a = btVar.f2860d;
                    }
                }
                this.f2883f.m4061a(fmVar.f3176a, a);
                this.f2884g.addAll(fmVar.f3177b);
            }
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f2878a.m3365a(this.f2881d.f2868c)) {
            this.f2880c.mo998a("");
        } else if (this.f2882e.b != 0) {
            this.f2880c.mo998a(this.f2882e.c);
        } else {
            this.f2880c.mo997a(this.f2883f, this.f2884g);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f2880c.mo998a(str);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f2882e.b == 1;
    }

    /* renamed from: a */
    public void mo989a(C0672a c0672a) {
        this.f2881d.f2868c = new al(c0672a);
    }
}
