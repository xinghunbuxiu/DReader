package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class dt extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f3062a;
    /* renamed from: b */
    final /* synthetic */ List f3063b;
    /* renamed from: c */
    final /* synthetic */ dx f3064c;
    /* renamed from: d */
    final /* synthetic */ de f3065d;
    /* renamed from: e */
    private C0621a<Void> f3066e;

    dt(de deVar, String str, C0657i c0657i, al alVar, List list, dx dxVar) {
        this.f3065d = deVar;
        this.f3062a = alVar;
        this.f3063b = list;
        this.f3064c = dxVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        fd fdVar = new fd(this, this.f3062a);
        HashMap hashMap = new HashMap();
        for (dd ddVar : this.f3063b) {
            fl flVar = (fl) hashMap.get(Integer.valueOf(ddVar.f3002a));
            if (flVar == null) {
                flVar = new fl();
                flVar.f3174a = ddVar.f3002a;
                flVar.f3175b = new ArrayList();
                hashMap.put(Integer.valueOf(ddVar.f3002a), flVar);
            }
            flVar.f3175b.add(ddVar);
        }
        this.f3066e = fdVar.m4457b(hashMap.values());
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3062a.m3365a(this.f3065d.f3011c)) {
            this.f3064c.mo1007a("");
        } else if (this.f3066e.b != 0) {
            this.f3064c.mo1007a(this.f3066e.c);
        } else {
            this.f3064c.mo1006a();
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f3064c.mo1007a(str);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3066e.b == 1;
    }

    /* renamed from: a */
    public void mo989a(C0672a c0672a) {
        this.f3065d.f3011c = new al(c0672a);
    }
}
