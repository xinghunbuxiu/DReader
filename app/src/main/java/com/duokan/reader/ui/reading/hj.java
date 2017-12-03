package com.duokan.reader.ui.reading;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.cloud.bk;
import com.duokan.reader.domain.cloud.bl;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.b;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.document.epub.az;
import com.duokan.reader.domain.document.epub.c;
import com.duokan.reader.domain.document.epub.s;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.n;

import java.util.ArrayList;
import java.util.List;

class hj extends aaj implements it, bl, ho {
    final /* synthetic */ hb a;

    private hj(hb hbVar) {
        this.a = hbVar;
        super(hbVar);
    }

    public boolean g_() {
        if (this.a.f.k()) {
            return super.g_();
        }
        return this.a.f.j();
    }

    public void a(boolean z) {
        if (!this.a.P.isEmpty()) {
            List arrayList = new ArrayList(this.a.P.keySet());
            this.a.P.clear();
            this.a.b(arrayList, null);
        }
        super.a(z);
    }

    public void a(bk bkVar) {
        long j;
        if (this.a.f.k()) {
            j = bkVar.b;
        } else if (this.a.f.k() && this.a.f.l()) {
            j = bkVar.c;
        } else {
            j = bkVar.a;
        }
        if (System.currentTimeMillis() < j) {
            ((fv) this.a.f).a(null);
        }
    }

    public boolean b(ak akVar) {
        if (this.a.f.k()) {
            return super.b(akVar);
        }
        if (akVar.f()) {
            return false;
        }
        long[] a = a(akVar);
        for (long j : a) {
            if (j < 0 || j >= this.a.C().D()) {
                return false;
            }
            fv fvVar = (fv) this.a.f;
            if (fvVar.s() == BookPackageType.EPUB_OPF) {
                av d = this.a.C().d(j);
                if (!(d == null || !d.k() || fvVar.aX())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void d(long j) {
        i.f().a(new hk(this, j));
    }

    public long a() {
        return this.a.C().D();
    }

    public long a(ba baVar) {
        return ((az) baVar).c();
    }

    public long[] a(ak akVar) {
        if (!this.a.h.d((Document_a) akVar) || !akVar.e()) {
            return new long[0];
        }
        if (((c) akVar.g()).g() == ((c) akVar.h()).g()) {
            return new long[]{((c) akVar.g()).g()};
        }
        return new long[]{((c) akVar.g()).g(), ((c) akVar.h()).g()};
    }

    public String a(long j) {
        return this.a.C().f(j);
    }

    public String b(long j) {
        g a = this.a.C().E().a(j);
        return a == null ? "" : a.e();
    }

    public boolean a(as asVar) {
        boolean z = true;
        if (!asVar.G()) {
            return false;
        }
        g b = this.a.C().E().b(asVar.l());
        if (b == null || b.h() > 0) {
            return false;
        }
        if (asVar instanceof az) {
            if (((az) asVar).d() != 0) {
                z = false;
            }
            return z;
        }
        com.duokan.reader.domain.document.epub.i iVar = (com.duokan.reader.domain.document.epub.i) asVar;
        if (iVar.S().d() == 0 || iVar.T().d() == 0) {
            return true;
        }
        return false;
    }

    public boolean e(long j) {
        fv fvVar = (fv) this.a.f;
        Object a = a(j);
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        return TextUtils.equals(this.a.C().g(j), fvVar.x(a).getName());
    }

    public void a(ak akVar, boolean z, ag agVar) {
        if (this.a.f.k()) {
            super.a(akVar, z, agVar);
        } else {
            b(akVar, z, new hl(this, agVar, z));
        }
    }

    public int a(av avVar) {
        Integer num = (Integer) this.a.P.get(avVar);
        return num == null ? 0 : num.intValue();
    }

    public View a(Context context) {
        return null;
    }

    public boolean d() {
        if (this.a.f.t().a("HK") || this.a.f.t().a("TW")) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.a.f.t().a("HK") || this.a.f.t().a("TW")) {
            return true;
        }
        return false;
    }

    public void b(boolean z) {
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return this.a.M;
    }

    public void a(ay ayVar, boolean z) {
        if (!(z || aT())) {
            if (this.a.J != null) {
                ayVar = this.a.J;
            } else if (j()) {
                ayVar = Z();
            } else {
                ayVar = null;
            }
        }
        if (ayVar != null) {
            ay e = AudioPlayer.a().e();
            if (e == null || ayVar == null || !ayVar.a(e)) {
                int d;
                Document_a aVar = (c) ayVar.g();
                Document_a aVar2 = (c) ayVar.h();
                g a = this.a.h.h().a(aVar);
                g a2 = this.a.h.h().a(aVar2);
                List arrayList = new ArrayList();
                if (aVar != null) {
                    d = a.d();
                    AudioPlayer.a().a(this.a.d(d), Integer.valueOf(d), G().aF());
                    arrayList.add(Integer.valueOf(d));
                }
                if (!(a2 == null || a2 == a)) {
                    d = a2.d();
                    AudioPlayer.a().a(this.a.d(d), Integer.valueOf(d), G().aF());
                    arrayList.add(Integer.valueOf(d));
                }
                if (arrayList.size() > 0) {
                    this.a.c.a(16, 0);
                    AudioPlayer.a().a(ayVar, (Integer[]) arrayList.toArray(new Integer[0]));
                    return;
                }
                return;
            }
            this.a.c.a(16, 0);
            AudioPlayer.a().d();
        }
    }

    public void i() {
        AudioPlayer.a().c();
    }

    public boolean j() {
        s sVar = (s) getDocument();
        ak Z = Z();
        if (Z == null || !Z.b()) {
            return false;
        }
        long[] jArr;
        if (((c) Z.g()).g() == ((c) Z.h()).g()) {
            jArr = new long[]{((c) Z.g()).g()};
        } else {
            jArr = new long[]{((c) Z.g()).g(), ((c) Z.h()).g()};
        }
        for (long c : r1) {
            b[] c2 = sVar.c(c);
            if (c2 != null && c2.length > 0) {
                for (b a : c2) {
                    if (Z.b(a.a())) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public bb k() {
        return this.a.J;
    }

    public void a(com.duokan.reader.domain.bookshelf.c cVar) {
        if (this.a.f == cVar && this.a.p && !this.a.q && this.a.f.j() && !this.a.f.V()) {
            a(true);
        }
    }

    public void onItemChanged(an anVar, int i) {
        super.onItemChanged(anVar, i);
        if (anVar == this.a.f) {
            b(new hn(this, i));
        }
    }

    public void b(n nVar, as asVar) {
        super.b(nVar, asVar);
        if (this.a.f.j()) {
            this.a.a((com.duokan.reader.domain.document.epub.as) asVar);
        }
    }
}
