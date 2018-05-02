package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.HttpStatus;

/* renamed from: com.duokan.reader.domain.bookshelf.do */
class C0803do extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f3043a;
    /* renamed from: b */
    final /* synthetic */ dc f3044b;
    /* renamed from: c */
    final /* synthetic */ dw f3045c;
    /* renamed from: d */
    final /* synthetic */ de f3046d;
    /* renamed from: e */
    private C0621a<HashMap<Integer, fo>> f3047e;
    /* renamed from: f */
    private List<dd> f3048f;

    C0803do(de deVar, String str, C0657i c0657i, al alVar, dc dcVar, dw dwVar) {
        this.f3046d = deVar;
        this.f3043a = alVar;
        this.f3044b = dcVar;
        this.f3045c = dwVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        fd fdVar = new fd(this, this.f3043a);
        List arrayList = new ArrayList(af.f2727a.length);
        long currentTimeMillis = System.currentTimeMillis() - this.f3044b.f3001b;
        for (int i : af.f2727a) {
            fk fkVar = new fk();
            fkVar.f3172a = i;
            fkVar.f3173b = (((int) (currentTimeMillis / 864000000)) * 100) + HttpStatus.SC_OK;
            if (fkVar.f3173b > HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                fkVar.f3173b = HttpStatus.SC_INTERNAL_SERVER_ERROR;
            }
            arrayList.add(fkVar);
        }
        this.f3047e = fdVar.m4459c(arrayList);
        if (this.f3047e.b == 0) {
            this.f3048f = new ArrayList();
            for (fo foVar : ((HashMap) this.f3047e.f2058a).values()) {
                this.f3048f.addAll(foVar.f3184b);
            }
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3043a.m3365a(this.f3046d.f3011c)) {
            this.f3045c.mo982a("");
        } else if (this.f3047e.b != 0) {
            this.f3045c.mo982a(this.f3047e.c);
        } else {
            this.f3045c.mo983a(this.f3048f);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f3045c.mo982a(str);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3047e.b == 1;
    }

    /* renamed from: a */
    public void mo989a(C0672a c0672a) {
        this.f3046d.f3011c = new al(c0672a);
    }
}
