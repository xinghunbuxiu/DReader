package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class cd extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f2938a;
    /* renamed from: b */
    final /* synthetic */ List f2939b;
    /* renamed from: c */
    final /* synthetic */ bs f2940c;
    /* renamed from: d */
    final /* synthetic */ cy f2941d;
    /* renamed from: e */
    final /* synthetic */ bu f2942e;
    /* renamed from: f */
    private C0621a<HashMap<Integer, fn>> f2943f;

    cd(bu buVar, String str, C0657i c0657i, al alVar, List list, bs bsVar, cy cyVar) {
        this.f2942e = buVar;
        this.f2938a = alVar;
        this.f2939b = list;
        this.f2940c = bsVar;
        this.f2941d = cyVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        fd fdVar = new fd(this, this.f2938a);
        HashMap hashMap = new HashMap();
        for (bt btVar : this.f2939b) {
            fj fjVar = (fj) hashMap.get(Integer.valueOf(btVar.f2857a));
            if (fjVar == null) {
                fjVar = new fj();
                fjVar.f3169a = btVar.f2857a;
                fjVar.f3170b = this.f2940c.m4063b(btVar.f2857a);
                fjVar.f3171c = new ArrayList();
                hashMap.put(Integer.valueOf(btVar.f2857a), fjVar);
            }
            fjVar.f3171c.add(btVar);
        }
        this.f2943f = fdVar.m4455a(hashMap.values());
        if (this.f2943f.b == 0) {
            for (fn fnVar : ((HashMap) this.f2943f.f2058a).values()) {
                this.f2940c.m4065b(fnVar.f3180a, fnVar.f3181b);
                this.f2940c.m4061a(fnVar.f3180a, fnVar.f3182c);
            }
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f2938a.m3365a(this.f2942e.f2868c)) {
            this.f2941d.mo996a("");
        } else if (this.f2943f.b == 209) {
            this.f2941d.mo994a();
        } else if (this.f2943f.b != 0) {
            this.f2941d.mo996a(this.f2943f.c);
        } else {
            this.f2941d.mo995a(this.f2940c);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f2941d.mo996a(str);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f2943f.b == 1;
    }

    /* renamed from: a */
    public void mo989a(C0672a c0672a) {
        this.f2942e.f2868c = new al(c0672a);
    }
}
