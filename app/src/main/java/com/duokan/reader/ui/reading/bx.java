package com.duokan.reader.ui.reading;

import com.duokan.core.sys.af;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0630c;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ee;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class bx extends WebSession {
    /* renamed from: a */
    C0621a<JSONObject> f9907a = null;
    /* renamed from: b */
    private final af<JSONObject> f9908b;
    /* renamed from: c */
    private final al f9909c;
    /* renamed from: d */
    private final ee f9910d;
    /* renamed from: e */
    private final long f9911e;
    /* renamed from: f */
    private final String f9912f;
    /* renamed from: g */
    private final String f9913g;
    /* renamed from: h */
    private WeakReference<bn> f9914h;

    bx(bn bnVar, af<JSONObject> afVar, al alVar, ee eeVar, long j, String str, String str2) {
        super(C0630c.f2119a);
        this.f9914h = new WeakReference(bnVar);
        this.f9908b = afVar;
        this.f9909c = alVar;
        this.f9910d = eeVar;
        this.f9911e = j;
        this.f9912f = str;
        this.f9913g = str2;
    }

    protected void onSessionTry() {
        bn bnVar = (bn) this.f9914h.get();
        if (bnVar != null && bnVar.f9880p == this.f9908b) {
            C0652z c0652z = new C0652z((WebSession) this, this.f9909c);
            if (this.f9910d.m4242o() == BookType.SERIAL) {
                this.f9907a = c0652z.m3059a(this.f9912f, this.f9913g, (int) this.f9911e, bnVar.m13826u().mo2194g(this.f9911e));
                return;
            }
            this.f9907a = c0652z.m3056a(this.f9912f, this.f9910d.m4159L());
        }
    }

    protected void onSessionSucceeded() {
        bn bnVar = (bn) this.f9914h.get();
        if (bnVar != null && !bnVar.b.mo1994K() && bnVar.f9880p == this.f9908b) {
            if (this.f9907a.b == 0) {
                this.f9908b.mo975a(this.f9907a.f2058a);
            } else {
                this.f9908b.mo975a(null);
            }
            bnVar.m13837i();
        }
    }

    protected void onSessionFailed() {
        bn bnVar = (bn) this.f9914h.get();
        if (bnVar != null && !bnVar.b.mo1994K() && bnVar.f9880p == this.f9908b) {
            bnVar.f9880p.mo975a(null);
            bnVar.m13837i();
        }
    }
}
